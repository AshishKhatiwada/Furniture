/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.furniture.SystemDto.Cart.Book;

import com.mycompany.furniture.SystemDto.Cart.CartDetails;

/**
 *
 * @author AAA
 */
public class BookDetails extends CartDetails {
    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
