<%-- 
    Document   : ControllerLogin
    Created on : Apr 20, 2020, 5:17:57 PM
    Author     : Mazen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*,java.util.*"%>
<%
    //String name = request.getParameter("fname")+" "+request.getParameter("lname");
    int id = Integer.parseInt(request.getParameter("id"));
    String pass = request.getParameter("pass");
    Connection c;

    try
    {
    Class.forName("org.apache.derby.jdbc.ClientDriver");
    c = DriverManager.getConnection("jdbc:derby://localhost:1527/Fly", "fly","fly1");
    Statement stmt = c.createStatement();
    ResultSet result;
    result = stmt.executeQuery("select * from users where id = " + id);
    

        if (result.next() == false) 
        {
            response.sendRedirect("Register.jsp");
    } 
    else
    {
       if(result.getString(4).equals(pass) == false)
        {
   response.sendRedirect("index.jsp");
       }
        else
        {
              session.setAttribute("id", id);
           response.sendRedirect("search.jsp");
      }
    }
    
    }
    catch(Exception ex){
  ex.printStackTrace();
      
    }


%>