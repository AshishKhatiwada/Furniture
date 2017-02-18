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
            Class.forName("org.postgresql.Driver");
            conn =DriverManager.getConnection("postgres://ttbnfcvkbdmugw:dca0dd23f1eba76b36362e66c3c7cdb11e601230e4dc33f5462e16e6f21814ef@ec2-54-225-66-44.compute-1.amazonaws.com:5432/d87uveini62cv5","ttbnfcvkbdmugw","dca0dd23f1eba76b36362e66c3c7cdb11e601230e4dc33f5462e16e6f21814ef");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Dbconn.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Dbconn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
