/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.furniture.Controller;


import com.mycompany.furniture.SystemDto.Product.ProductData;
import com.mycompany.furniture.SystemDto.Product.ProductDetails;
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
@WebServlet(name = "OrderController", urlPatterns = {"/OrderController"})
public class OrderController extends HttpServlet {
  
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        
        String product_id = req.getParameter("product_id");
        String user_id = req.getParameter("user_id");
        int pid = Integer.parseInt(product_id);
        
        
        
        
        //get by id
        ProductData productData = new ProductData();
        ProductDetails product = productData.getProductById(pid);
        String image_Name = product.getImage_Name();
        String product_Name = product.getProduct_Name();
        String description = product.getDescription();
        int price = product.getPrice();
        
        
       
        req.setAttribute("user_id", user_id);
        req.setAttribute("product_id", product_id);
        req.setAttribute("image_name", image_Name);
        req.setAttribute("product_Name", product_Name);
        req.setAttribute("description", description);
        req.setAttribute("price", price);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/OrderPage.jsp");
        dispatcher.forward(req, resp);
       
    }

   
    

}
