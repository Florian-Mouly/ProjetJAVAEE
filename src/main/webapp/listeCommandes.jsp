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
        <link rel="stylesheet" href="CssSite.css" />
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script> 
        <title>JSP Page</title>
    </head>
    <body style="background-color: grey;">
        <div class="container-fluid" style="background-color: white;">
			<div class="row" id="navigation">
				<div class ="col">
					<div class ="nav">
                                            		
                                                    <h1 style="text-align:center;"> Vos Commandes </h1>

                                        </div>
                                </div>
                            
			</div>
            
	</div>
        
        <div class="row">
            <div class ="col">
                <table border="1" class="infocommandes" >
                    <thead><tr><td>N° commande</td><td>Saisie</td><td>Envoyé</td><td>Port</td><td>Destinataire</td><td>Adresse de livraison</td><td>Ville Livraison</td><td>Region Livraison</td><td>Code Postal</td><td>Pays</td><td>Remise</td></tr></thead>
                    <c:forEach items="${ list_commande}" var="commande">
                        <tr><td>${commande.getNumero()}</td><td>${commande.getSaisie_le()}</td><td>${commande.getEnvoyee_le()}</td><td>${commande.getPort()}</td><td>${commande.getDestinataire()}</td><td>${commande.getAdresse_livraison()}</td><td>${commande.getVille_livraison()}</td><td>${commande.getRegion_livraison()}</td><td>${commande.getCode_Postal_livrais()}</td><td>${commande.getPays_Livraison()}</td><td>${commande.getRemise()}</td></tr>
                    </c:forEach>
                        
                </table>
                <form>
                    <button type="submit" class="btn" name="action" value="Accueil">Accueil</button>
                    <button type="submit" class="btn" name="action" value="Retour">Retour</button>
                </form>
                
            </div>
            
        </div>
           
        
    </body>
</html>
