<%-- 
    Document   : shoppingList
    Created on : 26-Feb-2023, 5:09:36 PM
    Author     : Densa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>
            Shopping List
        </h1>
        <!-- title -->
        <div>
            Hello, ${username} <a href="action=logout">logout</a>
        </div>
        
        <!-- Input Body -->
        <h2>
            List
        </h2>
        <div>
            <form method="post">
                <h3>
                    Add Item:
                </h3>
                <input type="text" name="item">
                <input type="submit" value="add">
                <input type="hidden" value="add" name="action">
            </form>
        </div>
        <p>
            ${message2}
        </p>
        <!-- Shopping list body -->
        <form method="post">
            <div>
                <c:forEach var="item" items="${items}">
                    <input type="radio" name="itemRadio" value="${item}" > ${item} <br>
                </c:forEach>
            </div>
            <div>
                <cif test="$items.size() > 0>"
                    <input type="submit" value="delete">
                    <input type="hidden" value="delete" name="action">
            </div>
        </form>
    </body>
</html>
