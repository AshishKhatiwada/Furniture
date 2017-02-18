/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.furniture.Controller;

import com.mycompany.furniture.SystemDto.Product.ProductData;
import com.mycompany.furniture.SystemDto.Product.ProductDetails;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author AAA
 */
@WebServlet(name = "ProductController", urlPatterns = {"/ProductController"})
@MultipartConfig
public class ProductController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final String SAVE_DIR = "/web/images/";
    private static final String Save_Path = "C:/Users/AAA/Documents/NetBeansProjects/";
    String fileName;

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        ProductData productData = new ProductData();
        ProductDetails data = new ProductDetails();

        String product_name = request.getParameter("product_name");
        String description = request.getParameter("description");
        int product_stock = Integer.parseInt(request.getParameter("product_stock"));
        int price = Integer.parseInt(request.getParameter("price"));
        String appPath = request.getServletContext().getContextPath();
        String savePath = Save_Path + appPath + SAVE_DIR;
        System.out.println("path is" + savePath);
        File fileSaveDir = new File(savePath);

        System.out.println("path of app is " + appPath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }

        for (Part part : request.getParts()) {
            fileName = extractFileName(part);
            try {
                part.write(savePath + fileName);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            System.out.println("path of app is " + fileName);
        }

        data.setProduct_Name(product_name);
        data.setImage_Name(fileName);
        data.setDescription(description);
        data.setPrice(price);
        data.setProductStock(product_stock);
        boolean validateImage = productData.validateImage(fileName);
        //validating duplicate image
        if (validateImage) {
            PrintWriter out = response.getWriter();
            out.print("File already Exist");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/AddProduct.jsp");
            dispatcher.forward(request, response);
        } else {
            productData.insertProduct(data);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/AddProduct.jsp");
            dispatcher.forward(request, response);
        }
    }

    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("file")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }
}
