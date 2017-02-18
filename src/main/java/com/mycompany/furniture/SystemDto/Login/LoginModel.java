/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.furniture.SystemDto.Login;



import com.mycompany.furniture.Dbutil.Dbconn;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author AAA
 */
public class LoginModel {
  
    
    
    public boolean loginCheck(String username,String password){
       
        PreparedStatement ps ;
        LoginData data = new LoginData();
        String sql = "select * from tbl_user_signup where Email=? && Password=?";
        try {
            ps = Dbconn.getConnection().prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                data.setUsername(rs.getString("Email"));
                data.setPassword(rs.getString("Password"));
                data.setUsertype(rs.getString("User_Type"));
            }
           
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(data.getUsername());
        if(data.getUsername()!=null&&data.getPassword()!=null){
            return true;
        }
        
        return false;
    }
    
     public boolean loginCheckAdmin(String username,String password){
       
        PreparedStatement ps = null;
        LoginData data = new LoginData();
        String sql = "select * from tbl_login where UserName=? && Password=?";
        try {
            ps = Dbconn.getConnection().prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                data.setUsername(rs.getString("UserName"));
                data.setPassword(rs.getString("Password"));
                data.setUsertype(rs.getString("User_Type"));
            }
           
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(data.getUsername());
        if(data.getUsername()!=null&&data.getPassword()!=null){
            return true;
        }
        
        return false;
    } 
    
    
    
    
    
   
}
