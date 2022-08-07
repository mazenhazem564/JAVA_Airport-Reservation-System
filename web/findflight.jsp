<%-- 
    Document   : findflight
    Created on : May 10, 2020, 5:00:45 PM
    Author     : Mazen
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*,java.util.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Find flight</title>
    </head>
    <body>
        <h1>Find your flight!</h1>
        

<form action='success.jsp' method='post'>
    

<%
int tickets = Integer.parseInt(request.getParameter("tickets"));
String dep = request.getParameter("dep");
String arr = request.getParameter("arr");

try
{
    Class.forName("org.apache.derby.jdbc.ClientDriver");
     Connection c;
   c = DriverManager.getConnection("jdbc:derby://localhost:1527/Fly", "fly", "fly1");
    Statement stmt = c.createStatement();
    ResultSet result;
    result = stmt.executeQuery("select * from flight  where depparture = '"+dep+"' and arrival = '"+arr+"' and no_seats >= 0 ");

  while (result.next()){
   out.println("<br /><input type='radio' name='id' value='"+result.getInt("flight_id")+"'> flight id: "+result.getInt("flight_id") + " date and time: "+result.getString("date") + " ("+result.getString("time") + ") <br /><br />");
  }
  
  if (result.next() == false) 
{
         out.println("we did not find any flights");
        }
    out.print("<input type='hidden' value='"+tickets+"' name='tickets' /><input type='submit' value='Select this flight' />");

      }
catch(Exception ex)
{
         out.println("Error");

}
%> 

</form>
        
        
    </body>
</html>
