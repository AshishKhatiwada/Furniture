/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.furniture.Controller;



import com.mycompany.furniture.SystemDto.Login.LoginModel;
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
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
  private String username;


   
  

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          
         username = req.getParameter("username");
         
         String password = req.getParameter("password");
         LoginModel model = new LoginModel();   
         UserModel userModel = new UserModel();
         UserData selectIDbyEmail = userModel.selectIDbyEmail(username);
        boolean loginCheck = model.loginCheck(username, password);
        boolean loginCheckAdmin = model.loginCheckAdmin(username, password);
        if(loginCheck){
           
            HttpSession session = req.getSession();
            session.setAttribute("user", username);
            session.setAttribute("user_id", selectIDbyEmail.getId());
            RequestDispatcher dispatcher = req.getRequestDispatcher("/Welcome.jsp");
            dispatcher.forward(req, resp);
            
         
        }
        else if(loginCheckAdmin){
           
            HttpSession session = req.getSession();
            session.setAttribute("user", username);
            session.setAttribute("user_id", selectIDbyEmail.getId());
            RequestDispatcher dispatcher = req.getRequestDispatcher("/AdminPanel.jsp");
            dispatcher.forward(req, resp);
        
        }
        else{
            resp.sendRedirect("login.jsp");
        }
    }

  
   
}
