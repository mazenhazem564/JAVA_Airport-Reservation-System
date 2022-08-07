<%-- 
    Document   : ControllerRegister
    Created on : Apr 20, 2020, 4:46:38 PM
    Author     : Mazen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*,java.util.*"%>
<%
    String name = request.getParameter("fname")+" "+request.getParameter("lname");
    String email = request.getParameter("e-mail");
    String pass = request.getParameter("pass");
    Connection c;

    try
    {
    Class.forName("org.apache.derby.jdbc.ClientDriver");
    c = DriverManager.getConnection("jdbc:derby://localhost:1527/Fly", "fly","fly1");
    Statement stmt = c.createStatement();
    ResultSet result;
    result = stmt.executeQuery("select * from users where email = '"+email+"'");


        if (result.next() == false) 
        {
    stmt.executeUpdate("INSERT INTO USERS (name, email, password, no_tickets) values ( '"+name+"', '"+email+"','"+pass+"',  0)");
    response.sendRedirect("search.jsp");
    } 
    else
    {
if(result.getString(3).equals(email))
            out.print("this email is registered");
    }
    
    }
    catch(Exception ex){
  ex.printStackTrace();
      
    }


%>