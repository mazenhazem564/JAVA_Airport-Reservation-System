<%-- 
    Document   : Welcome
    Created on : Apr 20, 2020, 5:18:36 PM
    Author     : Mazen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <h2>Login page</h2>
        <form action="Controllerlogin.jsp" method="post">
            ID:  <input type="text" name="id"/><br/>
            Password:<input type="password" name="pass"/><br/>
            <input type="submit" value="Login"/>
            <input type="reset" value="Clear"/><br/>

            Not Yet Registered!! <a href=Register.jsp>Register here</a> 
        </form> 
    </body>
</html>
