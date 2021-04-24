/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.poly.poly.ap.dao;

import edu.poly.poly.ap.helpers.DatabaseHelper;
import edu.poly.poly.ap.model.NguoiDung;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author thong
 */
public class NguoiDungDao {
    public NguoiDung checkLogin(String tenDangNhap, String matKhau) throws Exception{
        String sql = "select tenDangNhap, matKhau, vaitro from nguoidung "
                + " where tendangnhap=? and matKhau = ?";
        try(
                Connection con = DatabaseHelper.opConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
            ){
            pstmt.setString(1, tenDangNhap);
            pstmt.setString(2, matKhau);
            
            try(ResultSet rs = pstmt.executeQuery();){
                if (rs.next()){
                    NguoiDung nd = new NguoiDung();
                    nd.setTenDangNhap(tenDangNhap);
                    nd.setVaiTro(rs.getString("vaitro"));
                    return nd;
                }
            }
        }
        return null;
    }
}
