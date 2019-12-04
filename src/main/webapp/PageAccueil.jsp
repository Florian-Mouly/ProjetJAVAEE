<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="PagesCSS.css" media="screen" />
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>    



        <title>Projet JavaEE</title>
    </head>
    <body>
        
        <div class="container-fluid">
			<div class="row" id="navigation">
				<div class ="col">
					<div class ="nav">
						<button onclick="Menu()" type="button" id="connexion" class="btn btn-outline-warning"> <a style="text-decoration: none; color: red; "> Connexion </a> </button>
                                                 
                                                        <form id="menuconnexion" action="" method="post" class="form-connexion">
                                                            <div class="form-example">
                                                                <label for="name">Votre login </label>
                                                                <input type="text" name="name" id="name" required>
                                                             </div>

                                                        <div class="form-example">
                                                            <label for="email">Votre mot de passe </label>
                                                             <input type="text" name="email" id="email" required>
                                                        </div>

                                                        <div class="form-example">
                                                            <input type="submit" value="Se connecter !">
                                                        </div>
                                                        </form>
					</div>
				</div>
			</div>
       
            <script type="text/javascript">
                $(document).ready( function Menu() {
                    // On cache les sous-menus :
                 $(".form-connexion").hide(); 
                
    });    

            </script>   

        <p>Email : ${empty email ? '' : email}</p>
        <p>Name : ${empty name ? '' : name}</p>
        <p>${empty message ? '' : message}</p>
    </body>
</html>
    