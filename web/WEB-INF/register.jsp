<%-- 
    Document   : register
    Created on : 26-Feb-2023, 5:09:18 PM
    Author     : Densa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        <h1>
            Shopping List
        </h1>
        <form method="post">
        Username: <input type="text" name="username">
        <input type="submit" value="register username">
        <input type="hidden" value="register" name="action">
        </form>
        <p>
            ${message}
        </p>
    </body>
</html>
