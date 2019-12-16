<%-- 
    Document   : viewPanier
    Created on : 10 déc. 2019, 13:59:41
    Author     : damie
--%>

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
    
    <body style="background-color: #313131">
        <div class="row" style="margin:auto; width:90vh; margin-top:80px; margin-bottom:80px; padding:15px; border: 2px solid #E1E1E1; background-color: #A6A7CA;">
            <div class="col">
                
            <form>
                <div class="form-row">
                    <div class="form-group col-md-6" >
                        
                        <label  for="nom">Nom</label>
                        <input  name="Nom" type="text" class="form-control" id="modif">
                     </div> 
                    <div class="form-group col-md-6">
                        <label for="fournisseur">Fournisseur</label>
                        <input name="Fournisseur" type="text" class="form-control" id="modif2">
                    </div>
                </div>
                <div class="form-group">
                    <label for="categorie">Categorie</label>
                    <input name="Categorie" type="text" class="form-control" id="modif3">
                </div>
              <div class="form-row">
                <div class="form-group col-md-4">
                    <label for="quantite_par_unite">Quantité par unité</label>
                    <input name="Quantite_par_unite" id="modif4" type="text" class="form-control">
                </div>
                    <div class="form-group col-md-4">
                    <label for="prix_unitaire">Prix unitaire</label>
                    <input name="Prix_unitaire" id="modif5" type="text" class="form-control">
                    </div>
               </div>
            <div class="form-row" style="margin:auto; width:80vh;">
                <div class="form-group col-md-4">
                    <label for="unite_en_stock">Unité en stock</label>
                    <input name="Unite_en_stock" id="modif6" type="text" class="form-control">
                </div>
                <div class="form-group col-md-3">
                    <label for="unites_commandees">Unites_commandees</label>
                    <input name="Unites_commandees" id="modif8" type="text" class="form-control">
                </div>
                <div class="form-group col-md-6">
                    <label for="niveau_de_reapprovi">Niveau de reapprovisionnement</label>
                    <input name="Niveau_de_reapprovi" id="modif9" type="text" class="form-control">
                </div>
                
                <div class="form-group col-md-4">
                    <label for="indisponible">Indisponible</label>
                    <input name="Indisponible" id="modif7" type="text" class="form-control" value="${clientCourant.getCode_Postal()}">
                </div>
            </div>
                <!--<button type="button" class="btn btn-dark" ><a onclick='enrformtest()'>Enregistrer</a></button>
                <button type="button" class="btn btn-outline-dark" onclick="modifformtest()" >Modifier</button> -->
                <button type="submit" class="btn" name="action" value="Save">Enregistrer</button>
            </form>
            </div>
        </div>
    </body>
</html>
