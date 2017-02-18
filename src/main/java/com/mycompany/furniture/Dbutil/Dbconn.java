/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.furniture.Dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;





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
}
