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
import javax.servlet.http.HttpSession;

/**
 *
 * @author AAA
 */
@WebServlet(name = "SignUpController", urlPatterns = {"/SignUpController"})
public class SignUpController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String name = request.getParameter("name");
            String address = request.getParameter("address");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            String password = request.getParameter("password");
            String usertype = request.getParameter("usertype");
            UserData data = new UserData();
            data.setName(name);
            data.setAddress(address);
            data.setEmail(email);
            data.setPhone(phone.toString());
            data.setPassword(password);
            data.setUsertype(usertype);
            UserModel model =  new UserModel();
            boolean insertData = model.insertUser(data);
           if(insertData){
               HttpSession session = request.getSession();
               session.setAttribute("name", name);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
            dispatcher.forward(request, response);
           }else{
           RequestDispatcher dispatcher = request.getRequestDispatcher("/Signup.jsp");
           dispatcher.include(request, response); 
       }
            
            
            
        } catch (NumberFormatException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    
    }
    

  
}
