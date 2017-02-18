/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.furniture.SystemDto.Order;


import com.mycompany.furniture.Dbutil.Dbconn;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AAA
 */
public class OrderData {

    public void insertData(OrderDetails details) {
        String query = "insert into tbl_order(User_id,Product_id,Order_Date) values (?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = Dbconn.getConnection().prepareStatement(query);
            ps.setInt(1, details.getUser_id());
            ps.setInt(2, details.getProduct_id());
            ps.setString(3, details.getOrderdate());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(OrderData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
