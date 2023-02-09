<%-- 
    Document   : newjsp
    Created on : Jan 19, 2023, 11:56:06 PM
    Author     : 12345
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <c:if test="not null ${sessionScope}">
        
    </c:if>
    <body>
        
        <h1>Hello World!</h1>
    </body>
</html>
