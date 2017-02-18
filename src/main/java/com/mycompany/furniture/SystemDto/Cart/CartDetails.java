/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.furniture.SystemDto.Cart;

import com.mycompany.furniture.SystemDto.Product.ProductDetails;



/**
 *
 * @author AAA
 */
public class CartDetails extends ProductDetails {
    private int Cart_id;
    private int product_id;
    private int user_id;

    public int getCart_id() {
        return Cart_id;
    }

    public void setCart_id(int Cart_id) {
        this.Cart_id = Cart_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    
}
