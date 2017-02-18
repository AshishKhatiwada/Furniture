/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.furniture.Controller;

import com.mycompany.furniture.SystemDto.Cart.CartData;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author AAA
 */
@WebServlet(name = "UpdateCart", urlPatterns = {"/UpdateCart"})
public class UpdateCart extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int product_id = Integer.parseInt(req.getParameter("product_id"));
       
        CartData cartData = new CartData();
        cartData.editCart(product_id);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/Cart.jsp");
        requestDispatcher.forward(req, resp);
    }
    
}
