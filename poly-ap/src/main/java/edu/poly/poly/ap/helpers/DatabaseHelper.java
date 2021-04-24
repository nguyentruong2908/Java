/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.poly.poly.ap.helpers;

import java.sql.Connection;
import java.sql.DriverManager;


/**
 *
 * @author thong
 */
public class DatabaseHelper {
    public static Connection opConnection() throws Exception{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionUrl = "jdbc:sqlserver://localhost:49671;database=PolyApp;";
        String dbusername = "sa";
        String password = "123";
        Connection con = DriverManager.getConnection(connectionUrl, dbusername, password);
        return con;
    }
}
