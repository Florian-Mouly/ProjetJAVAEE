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
        <link rel="stylesheet" href="CssSite.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body style="background-color: grey;">
        <div class="container-fluid" style="background-color: white;">
			<div class="row" id="navigation">
				<div class ="col">
					<div class ="nav">
                                            		<button type="submit" class="btn" name="action" value="Accueil" id="accueilback">Accueil</button>
                                                    <h1 style="text-align:center;"> Vos Commandes </h1>

                                        </div>
                                </div>
                            
			</div>
            
	</div>
        
        <div class="row">
            <div class ="col">
                <table border="1" class="infocommandes" >
                    <thead><tr><td>N° commande</td><td>Effectuée le</td><td>Adresse de livraison</td></tr></thead>
                    <c:forEach items="${ list_commande}" var="commande">
                        <tr><td>${commande.getNumero()}</td><td>${commande.getSaisie_le()}</td><td>${commande.getAdresse_livraison()}</td></tr>
                    </c:forEach>
                </table>
            </div>
        </div>
           
        
    </body>
</html>
