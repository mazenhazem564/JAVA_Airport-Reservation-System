<%-- 
    Document   : Register
    Created on : Apr 20, 2020, 4:15:48 PM
    Author     : Mazen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        <form action="ControllerRegister.jsp" method="post">
            First name: <input type="text" name="fname" /><br>
            Last  name: <input type="text" name="lname" /><br>
            E-mail    : <input type="text" name="e-mail"/><br>
            Password  : <input type="password" name="pass"  /><br>
            <input type="submit" value="Register" />
            <input type="reset"  value="Clear"/>
        </form>
    </body>
</html>
