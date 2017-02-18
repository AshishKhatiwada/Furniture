/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.furniture.Controller;

import com.mycompany.furniture.SystemDto.Cart.Book.BookData;
import com.mycompany.furniture.SystemDto.Cart.Book.BookDetails;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author AAA
 */
@WebServlet(name = "BookController", urlPatterns = {"/BookController"})
public class BookController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       int user_id = Integer.parseInt(req.getParameter("user_id"));
       int product_id = Integer.parseInt(req.getParameter("product_id"));
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/DD HH:mm:ss");
        Date date = new Date();
        String format = dateFormat.format(date);
        BookDetails details = new BookDetails();
        details.setProduct_id(product_id);
        details.setUser_id(user_id);
        details.setDate(format);
        BookData data = new BookData();
        data.insertIntoBook(details);
       
    }

}
