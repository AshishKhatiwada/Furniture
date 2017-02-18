/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.furniture.Dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;





/**
 *
 * @author AAA
 */
public class Dbconn {
    static Connection conn = null;
    
    public static Connection getConnection(){
          
        try {
            String dbUrl = System.getenv("JDBC_DATABASE_URL");
            conn =DriverManager.getConnection(dbUrl);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return conn;
    }
  public void createtables(){
           String sql = "CREATE TABLE tbl_user_signup(ID integer PRIMARY KEY,Email varchar(255) NOT NULL,Password varchar(50) NOT NULL)";

        Statement ps;
        try {
            ps = getConnection().createStatement();
            ps.executeUpdate(sql);
        } catch (SQLException ex) {
            
        }
    }
}

