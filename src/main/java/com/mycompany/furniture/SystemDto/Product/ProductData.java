/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.furniture.SystemDto.Product;


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
public class ProductData {

    public void insertProduct(ProductDetails data) {
        String query = "insert into tbl_product(product_name,product_image_name,description,Price,Product_Stock) values (?,?,?,?,?)";
        PreparedStatement preparedStatement;

        try {
            preparedStatement = Dbconn.getConnection().prepareStatement(query);
            preparedStatement.setString(1, data.getProduct_Name());
            preparedStatement.setString(2, data.getImage_Name());
            preparedStatement.setString(3, data.getDescription());
            preparedStatement.setInt(4, data.getPrice());
            preparedStatement.setInt(5, data.getProductStock());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public List<ProductDetails> getData() {
        List<ProductDetails> list = new ArrayList<ProductDetails>();
        String query = "select * from tbl_product";
        PreparedStatement ps;
        try {
            ps = Dbconn.getConnection().prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ProductDetails data = new ProductDetails();
                data.setId(rs.getInt("product_id"));
                data.setProduct_Name(rs.getString("product_name"));
                data.setImage_Name(rs.getString("product_image_name"));
                data.setDescription(rs.getString("description"));
                data.setPrice(rs.getInt("Price"));
                list.add(data);
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }

        return list;
    }

    public ProductDetails getProductById(int id) {
        String query = "select * from tbl_product where product_id=?";
        PreparedStatement ps;
        ProductDetails data = new ProductDetails();
        try {

            ps = Dbconn.getConnection().prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                data.setImage_Name(rs.getString("product_image_name"));
                data.setProduct_Name(rs.getString("product_name"));
                data.setDescription(rs.getString("description"));
                data.setPrice(rs.getInt("Price"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

    public boolean validateImage(String imageName) {
        ProductDetails data = new ProductDetails();
        boolean flag;
        String query = "select * from tbl_product where product_image_name=?";
        PreparedStatement ps;
        try {
            ps = Dbconn.getConnection().prepareStatement(query);
            ps.setString(1, imageName);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                data.setImage_Name(rs.getString("product_image_name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductData.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (data.getImage_Name() != null) {
            flag = true;
        } else {
            flag = false;
        }
       return flag;
    }
}
