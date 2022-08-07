<%-- 
    Document   : search
    Created on : May 10, 2020, 4:31:39 PM
    Author     : Mazen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Find your flight</title>
    </head>
    <body>
        <h1>Find your flight!</h1>
        
        <form action="findflight.jsp" method="post">
 
        
        
       <table widt="80%">
           <tr><td>departure</td><td>
      <select name="dep">
<option value="Paris">Paris</option>
<option value="Cairo">Cairo</option>
<option value="Soul">Soul</option>
</select>
               </td></tr>
           
           <tr><td>arrival</td><td>
      <select name="arr">
<option value="Berlin">Berlin</option>
<option value="Emarites">Emarites</option>
<option value="Yemen">Yemen</option>
</select>
               </td></tr>
           
           <tr><td>tickets needed</td><td>
<input type="text" name="tickets" />
<input type="submit" value="Search" />

               </td></tr>
       </table>
        </form>

        
        
        
    </body>
</html>
