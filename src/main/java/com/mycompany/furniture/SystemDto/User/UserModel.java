/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.furniture.SystemDto.User;

import com.mycompany.furniture.Dbutil.Dbconn;
import com.mycompany.furniture.SystemDto.Login.LoginData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AAA
 */
public class UserModel {

    private int id;
    
    public boolean insertUser(UserData user){
        boolean flag;
        int executeUpdate =0;
        try {
            String query = "insert into tbl_user_signup(Full_Name,Address,Email,Contact_no,Password,User_Type) values(?,?,?,?,?,?)";
            PreparedStatement ps;
            ps = Dbconn.getConnection().prepareStatement(query);
            ps.setString(1, user.getName());
            ps.setString(2, user.getAddress());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPhone().toString());
            ps.setString(5, user.getPassword());
            ps.setString(6, user.getUsertype());
            executeUpdate = ps.executeUpdate();
            System.out.println("dfsdfdsfdfdsfdsf"+executeUpdate);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        if(executeUpdate==1){
            flag = true;
        }else{
            flag = false;
        }
        
       return flag;  
    }
    
    public String updateUser(UserData data){
        boolean flag;
        String query = "update tbl_user_signup set Full_Name=?,Address=?,Email=?,Contact_no=?,Password=? where ID=?";
        PreparedStatement ps;
       
        try {
            ps=Dbconn.getConnection().prepareStatement(query);
            ps.setString(1, data.getName());
            ps.setString(2, data.getAddress());
            ps.setString(3, data.getEmail());
            ps.setString(4, data.getPhone());
            ps.setString(5, data.getPassword());
            ps.setInt(6, data.getId());
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    return data.getEmail();
    }
    
    public UserData selectIDbyEmail(String email){
        String query="select * from tbl_user_signup where Email=?";
        PreparedStatement ps;
        UserData data = new UserData();
        try {
            ps = Dbconn.getConnection().prepareStatement(query);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                data.setId(rs.getInt("ID"));
                data.setAddress(rs.getString("Address"));
                data.setName(rs.getString("Full_Name"));
                data.setEmail(rs.getString("Email"));
                data.setPhone(rs.getString("Contact_no"));
                data.setPassword(rs.getString("Password"));
                                 
                
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
       return data; 
    }
    
    public boolean emailCheck(String email){
       
        PreparedStatement ps = null;
        LoginData data = new LoginData();
        String sql = "select * from tbl_user_signup where Email=?";
        try {
            ps = Dbconn.getConnection().prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                data.setUsername(rs.getString("Email"));
                
            }
           
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        if(data.getUsername()==null){
            return true;
        }
        return false;
    }
    
    public List<UserData> getData(){
        List<UserData> list = new ArrayList<UserData>();
        String query = "select * from tbl_user_signup";
        PreparedStatement ps;
        try {
            ps=Dbconn.getConnection().prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                UserData data = new UserData();
                data.setName(rs.getString("Full_Name"));
                data.setAddress(rs.getString("Address"));
                data.setEmail(rs.getString("Email"));
                data.setPhone(rs.getString("Contact_no"));
                data.setPassword(rs.getString("Password"));
                list.add(data);
            }
        } catch (SQLException ex) {
           ex.getMessage();
        }
      
        
        return list;
    }
}

