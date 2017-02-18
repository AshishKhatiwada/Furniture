/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.furniture.Dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;





/**
 *
 * @author AAA
 */
public class Dbconn {
    static Connection conn = null;
    
    public static Connection getConnection(){
          
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/furniture","root","");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return conn;
    }
     public void createtables(){
        String sql = "CREATE TABLE `tbl_user_signup` (\n" +
"  `ID` int(11) NOT NULL,\n" +
"  `Full_Name` varchar(255) NOT NULL,\n" +
"  `Address` varchar(255) NOT NULL,\n" +
"  `Email` varchar(255) NOT NULL,\n" +
"  `Contact_no` bigint(20) NOT NULL,\n" +
"  `Password` varchar(50) NOT NULL,\n" +
"  `User_Type` varchar(50) NOT NULL\n" +
")";
        Statement ps;
        try {
            ps = getConnection().createStatement();
            ps.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Dbconn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
