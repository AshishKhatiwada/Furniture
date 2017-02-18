/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.furniture.Controller;


import com.mycompany.furniture.SystemDto.User.UserData;
import com.mycompany.furniture.SystemDto.User.UserModel;
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
@WebServlet(name = "UpdateController", urlPatterns = {"/UpdateController"})
public class UpdateController extends HttpServlet {

String emailLogin;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        emailLogin = req.getParameter("email");
        UserModel model = new UserModel();
        UserData data = model.selectIDbyEmail(emailLogin);
        req.setAttribute("name", data.getName());
        req.setAttribute("address", data.getAddress());
        req.setAttribute("email", data.getEmail());
        req.setAttribute("phone", data.getPhone());
        req.setAttribute("password", data.getPassword());
        req.setAttribute("id", data.getId());
        RequestDispatcher rd = req.getRequestDispatcher("/UpdateUser.jsp");
        rd.forward(req, resp);
        
        
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String name = req.getParameter("name");
            String address = req.getParameter("address");
            String email = req.getParameter("email");
            String phone = req.getParameter("phone");
            String password = req.getParameter("password");
            int id = Integer.parseInt(req.getParameter("id"));
            UserData data = new UserData();
            data.setId(id);
            data.setName(name);
            data.setAddress(address);
            data.setEmail(email);
            data.setPhone(phone);
            data.setPassword(password);
            UserModel module = new UserModel();
            String emailchange = module.updateUser(data);
            System.out.println("logged in email" +emailLogin);
            System.out.println("updated in email" +emailchange);
           
            if(!emailLogin.equalsIgnoreCase(emailchange)){
               RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
               rd.forward(req, resp); 
            }
            else{
                doGet(req, resp);
            }
    }

   
}
