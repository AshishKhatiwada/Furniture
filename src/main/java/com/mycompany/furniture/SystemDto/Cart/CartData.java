/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.furniture.SystemDto.Cart;

import com.mycompany.furniture.Dbutil.Dbconn;
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
public class CartData {

    public void insertCartData(CartDetails data) {
        String query = "insert into tbl_cart(product_id,user_id) values (?,?)";
        PreparedStatement ps;
        try {
            ps = Dbconn.getConnection().prepareStatement(query);
            ps.setInt(1, data.getProduct_id());
            ps.setInt(2, data.getUser_id());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CartData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<CartDetails> selectCartByUser(int user_id) {
        List<CartDetails> list = new ArrayList<CartDetails>();
        String query = "SELECT * FROM tbl_cart c, tbl_product p WHERE c.product_id = p.product_id and user_id=?";
        PreparedStatement ps;
        try {
            ps = Dbconn.getConnection().prepareStatement(query);
            ps.setInt(1, user_id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CartDetails data = new CartDetails();
                data.setCart_id(rs.getInt("cart_id"));
                data.setUser_id(rs.getInt("user_id"));
                data.setProduct_id(rs.getInt("product_id"));
                data.setImage_Name(rs.getString("product_image_name"));
                data.setPrice(rs.getInt("Price"));
                list.add(data);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CartData.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public int countCartData(int user_id) {
        String query = "SELECT COUNT(*) FROM `tbl_cart` WHERE user_id=?";
        PreparedStatement ps;
        int count = 0;
        try {
            ps = Dbconn.getConnection().prepareStatement(query);
            ps.setInt(1, user_id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CartData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }

    public boolean addCartValidator(int product_id) {
        boolean flag = false;
        String query = "select product_id from tbl_cart where product_id=?";
        PreparedStatement ps;
        CartDetails details = new CartDetails();
        try {
            ps = Dbconn.getConnection().prepareStatement(query);
            ps.setInt(1, product_id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                details.setProduct_id(rs.getInt("product_id"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CartData.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (details.getProduct_id() == 0) {
            flag = true;

        } else {
            flag = false;
        }
        System.out.println(details.getProduct_id());

        return flag;
    }

    public void editCart(int cart_id) {
        String query = "delete from tbl_cart where cart_id =?";
        PreparedStatement ps;
        try {
            ps = Dbconn.getConnection().prepareStatement(query);
            ps.setInt(1, cart_id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CartData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void removeAllCart(int user_id) {
        String query = "delete from tbl_cart where user_id =?";
        PreparedStatement ps;
        try {
            ps = Dbconn.getConnection().prepareStatement(query);
            ps.setInt(1, user_id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CartData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
