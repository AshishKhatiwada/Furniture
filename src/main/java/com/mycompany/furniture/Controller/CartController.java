/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.furniture.Controller;



import com.mycompany.furniture.SystemDto.Cart.CartData;
import com.mycompany.furniture.SystemDto.Cart.CartDetails;
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
@WebServlet(name = "CartController", urlPatterns = {"/CartController"})
public class CartController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int product_id = Integer.parseInt(req.getParameter("product_id"));
        int user_id = Integer.parseInt(req.getParameter("user_id"));
        CartDetails data = new CartDetails();
        data.setProduct_id(product_id);
        data.setUser_id(user_id);
        CartData cartData = new CartData();
        boolean addCartValidator = cartData.addCartValidator(product_id);
        if (addCartValidator) {
            cartData.insertCartData(data);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/Cart.jsp");
            dispatcher.forward(req, resp);
        } else {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/Cart.jsp");
            dispatcher.forward(req, resp);
        }

    }

}
