<%-- 
    Document   : listeProduitsAdmin
    Created on : 16 déc. 2019, 18:25:45
    Author     : Flo pc
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
                                            		
                                                    <h1 style="text-align:center;">Liste des tous les produits</h1>

                                        </div>
                                </div>
                            
			</div>
            
	</div>
        <form>
            <button type="submit" class="btn" name="action" value="Edit" >Edition de produit</button>
        </form>
        <div class="row">
            <div class ="col">
                <table border="1" class="infocommandes" >
                    <thead><tr><td>Nom</td><td>Fournisseur</td><td>Categorie</td><td>Quantite/Unite</td><td>Prix Unitaire</td><td>Unite en stock</td><td>Unites commandees</td><td>Niveau de reapprovisionnement</td><td>Indisponible</br> 1 -> Oui 0 -> Non</td></tr></thead>
                    <c:forEach items="${listProduit}" var="prod">
                        <tr><td>${prod.getNom()}</td><td>${prod.getFournisseur()}</td><td>${prod.getCategorie()}</td><td>${prod.getQuantite_par_unite()}</td><td>${prod.getPrix_unitaire()}</td><td>${prod.getUnite_en_stock()}</td><td>${prod.getUnites_commandees()}</td><td>${prod.getNiveau_de_reapprovi()}</td><td>${prod.getIndisponible()}</td><td><form><button type="submit" class="btn" name="action" value="${prod.reference}">Supprimer</button></form></td></tr>
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
