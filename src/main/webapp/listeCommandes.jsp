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
        
        <table border="1">
            <tr><td>N° commande</td><td>Effectuée le</td><td>Adresse de livraison</td><td></td></tr>
            <c:forEach items="${ list_commande}" var="commande">
                <tr><td>${commande.getNumero()}</td><td>${commande.getSaisie_le()}</td><td>${commande.getAdresse_livraison()}</td><td></td></tr>
            </c:forEach>
        </table>
        
    </body>
</html>
