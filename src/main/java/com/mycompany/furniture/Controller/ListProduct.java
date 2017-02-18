/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.furniture.Controller;

import com.mycompany.furniture.SystemDto.Product.ProductData;

import java.io.IOException;
import java.util.List;
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
@WebServlet(name = "ListProduct", urlPatterns = {"/ListProduct"})
public class ListProduct extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductData model = new ProductData();
        List<com.mycompany.furniture.SystemDto.Product.ProductDetails> data = model.getData();
        req.setAttribute("data", data);
        
        RequestDispatcher dispatcher = req.getRequestDispatcher("/ProductList.jsp");
        dispatcher.forward(req, resp);
        
    }

   

    
}
