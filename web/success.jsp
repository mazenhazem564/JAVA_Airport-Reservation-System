<%-- 
    Document   : success
    Created on : Apr 20, 2020, 5:18:21 PM
    Author     : Mazen
--%>

<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
    <html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update data</title>
    </head>
    <body>
<%
    Connection c;
int id = Integer.parseInt(request.getParameter("id"));
int tickets = Integer.parseInt(request.getParameter("tickets"));
try
{
    Class.forName("org.apache.derby.jdbc.ClientDriver");
    c = DriverManager.getConnection("jdbc:derby://localhost:1527/Fly", "fly", "fly1");
    Statement s = c.createStatement();
    s.executeUpdate("update flight  set no_seats = no_seats-"+tickets+"  where flight_id = "+id+"");
    s.executeUpdate("update users set no_tickets = no_tickets+"+tickets+"  where id = "+session.getAttribute("id")+"");
        out.println("<h3>Data updated</h3>");
}
catch(Exception ex)
{

}
%>
        
    </body>
    </html>
