<%-- 
    Document   : personalData
    Created on : 10 déc. 2019, 14:01:03
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
    <body style="background-color: #313131">
        
        <!--<script>
            function enrformtest(){
                var nomod = document.getElementById("modif");
                var nomod2 = document.getElementById("modif2");
                var nomod3= document.getElementById("modif3");
                var nomod4 = document.getElementById("modif4");
                var nomod5 = document.getElementById("modif5");
                var nomod6= document.getElementById("modif6");
                var nomod7= document.getElementById("modif7");
                var nomod8= document.getElementById("modif8");
                var nomod9= document.getElementById("modif9");
                var nomod10= document.getElementById("modif10");
                

                nomod.setAttribute("disabled","disabled");
                nomod2.setAttribute("disabled","disabled");
                nomod3.setAttribute("disabled","disabled");
                nomod4.setAttribute("disabled","disabled");
                nomod5.setAttribute("disabled","disabled");
                nomod6.setAttribute("disabled","disabled");
                nomod7.setAttribute("disabled","disabled");
                nomod8.setAttribute("disabled","disabled");
                nomod9.setAttribute("disabled","disabled");
                nomod10.setAttribute("disabled","disabled");
                
               }
               
           function modifformtest(){
                var nomod = document.getElementById("modif");
                var nomod2 = document.getElementById("modif2");
                var nomod3= document.getElementById("modif3");
                var nomod4 = document.getElementById("modif4");
                var nomod5 = document.getElementById("modif5");
                var nomod6= document.getElementById("modif6");
                var nomod7= document.getElementById("modif7");
                var nomod8= document.getElementById("modif8");
                var nomod9= document.getElementById("modif9");
                var nomod10= document.getElementById("modif10");

                nomod.removeAttribute("disabled");
                nomod2.removeAttribute("disabled");
                nomod3.removeAttribute("disabled");
                nomod4.removeAttribute("disabled");
                nomod5.removeAttribute("disabled");
                nomod6.removeAttribute("disabled");
                nomod7.removeAttribute("disabled");
                nomod8.removeAttribute("disabled");
                nomod9.removeAttribute("disabled");
                nomod10.removeAttribute("disabled");
               }
        </script> -->
        
          <div class="container-fluid" style="background-color: #D6D4D4;">
			<div class="row" id="navigation" style="height:75px">
                            <div class ="col">
                                
                            </div>
                        </div>
          </div>
        <div class="row" style="margin:auto; width:90vh; margin-top:80px; margin-bottom:80px; padding:15px; border: 2px solid #E1E1E1; background-color: #A6A7CA;">
            <div class="col">
            <form>
                <div class="form-row">
                    <div class="form-group col-md-6" >
                        
                        <label  for="inputEmail4">Contact</label>
                        <input  name="Contact" type="text" class="form-control" id="modif" value="${clientCourant.getContact()}">
                     </div> 
                    <div class="form-group col-md-6">
                        <label for="inputPassword4">Société</label>
                        <input name="Societe" type="text" class="form-control" id="modif2" value="${clientCourant.getSociete()}">
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputFonction">Fonction</label>
                    <input name="Fonction" type="text" class="form-control" id="modif3" value="${clientCourant.getFonction()}">
                </div>
              <div class="form-row">
                <div class="form-group col-md-4">
                    <label for="inputAddress">Adresse</label>
                    <input name="Adresse" id="modif4" type="text" class="form-control"  value="${clientCourant.getAdresse()}">
                </div>
                    <div class="form-group col-md-4">
                    <label for="inputCity">Ville</label>
                    <input name="Ville" id="modif5" type="text" class="form-control" value="${clientCourant.getVille()}">
                    </div>
               </div>
            <div class="form-row" style="margin:auto; width:80vh;">
                <div class="form-group col-md-4">
                    <label for="inputRegion">Region</label>
                    <input name="Region" id="modif6" type="text" class="form-control" value="${clientCourant.getRegion()}">
                </div>
                <div class="form-group col-md-4">
                    <label for="inputCP">Code Postal</label>
                    <input name="Code_Postal" id="modif7" type="text" class="form-control" value="${clientCourant.getCode_Postal()}">
                </div>
                <div class="form-group col-md-3">
                    <label for="inputPays">Pays</label>
                    <input name="Pays" id="modif8" type="text" class="form-control" value="${clientCourant.getPays()}">
                </div>
                <div class="form-group col-md-4">
                    <label for="inputTelephone">Telephone</label>
                    <input name="Telephone" id="modif9" type="text" class="form-control" value="${clientCourant.getTelephone()}">
                </div>
                <div class="form-group col-md-4">
                    <label for="inputFax">FAX</label>
                    <input name="Fax" id="modif10" type="text" class="form-control" value="${clientCourant.getFax()}">
                </div>
            </div>
                <!--<button type="button" class="btn btn-dark" ><a onclick='enrformtest()'>Enregistrer</a></button>
                <button type="button" class="btn btn-outline-dark" onclick="modifformtest()" >Modifier</button> -->
                <button type="submit" class="btn" name="action" value="Envoyer">Envoyer</button>
                <button type="submit" class="btn" name="action" value="Voir">Vos Commandes</button>
            </form>
            </div>
        </div>
    </body>
</html>
