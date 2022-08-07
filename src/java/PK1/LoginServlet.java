package PK1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import assignment12th.ASSIGNMENT12TH;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Mazen
 */
@WebServlet(urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
              //The servlet needs to get the information from the user and send it to the database
        //It acts as a mediator or a "controller" between the user and the database
        
        //1
    	//get the database object that was created in the jsp using javabeans
        //since the database bean had the scope "application" then we get it from ServletContext
     
        ServletContext app = request.getServletContext();
        assignment12th.ASSIGNMENT12TH database = (ASSIGNMENT12TH)app.getAttribute("db");
        //2
        //get the user object that was created in the jsp using javabeans
        //since the user bean had the scope "session" then we get it from HttpSession
  HttpSession session = request.getSession();
        Loginjava u = (Loginjava) session.getAttribute("user");
        
        //3
        //send the user object to the database and if the db returned true then forward user
        //to success.jsp page
        //else delete the data of the user and forward to index.jsp page again

        boolean result =database.loginuser(u);
        if (result) {
            request.getRequestDispatcher("sucess.jsp").forward(request, response);
        
        }
        else{
            session.removeAttribute("user"); //VERY IMPORTANT ******************************************** 1:14:00
        request.getRequestDispatcher("loginjava.jsp").forward(request, response);
        }
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
