<%-- 
    Document   : listeCommandes
    Created on : 15 déc. 2019, 14:38:44
    Author     : damie
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <c:out value="${ contact }"></c:out> ma variable de session : ${ sessionScope.contact }
    </body>
</html>
