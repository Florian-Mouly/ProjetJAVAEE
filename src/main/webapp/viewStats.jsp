<%-- 
    Document   : viewStats
    Created on : 10 déc. 2019, 14:00:17
    Author     : damie
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
   <!-- On charge l'API Google -->
	<script type="text/javascript" src="https://www.google.com/jsapi"></script>
	<script type="text/javascript">
         crossorigin="anonymous">
    
         // Load the Visualization API and the piechart package.
        google.load("visualization", "1", {packages: ["corechart"]});
      
    // Set a callback to run when the Google Visualization API is loaded.
//        google.setOnLoadCallback(doAjax);
        google.setOnLoadCallback(doAjax2);
        google.setOnLoadCallback(doAjax3);

      // Callback that creates and populates a data table, 
      // instantiates the pie chart, passes in the data and
      // draws it.
      
//   function drawChart(dataArray) {
//            var data = new google.visualization.DataTable();
//            data.addColumn("string", "Pays");
//            data.addColumn("number", "Nb vente");
//            data.addRows(dataArray);
//            var options = {
//		title: 'Ventes par Pays',
//		is3D: true,
//                width:600,
//                height:600
//                                
//                           
//            };
//            
//	var chart = new google.visualization.BarChart(document.getElementById('chart_div'));
//	chart.draw(data, options);
//    }
//        function doAjax() {
//                $.ajax({
//                        url: "GrapheParClient",
//                        dataType: "json",
//                        
//                        success: // La fonction qui traite les résultats
//                                function (result) {
//                                    
//                                        //console.log(result);
//                                        // On reformate le résultat comme un tableau
//                                        var chartData = [];
//                                        // On met le descriptif des données
//                                        
//                                        for(var client in result) {
//                                                chartData.push([client, result[client]]);
//                                        }
//                                        // On dessine le graphique
//                                        drawChart2(chartData);
//                                },
//                        error: showError
//                });
//        }
        
    function drawChart2(dataArray) {
            var data = new google.visualization.DataTable();
            data.addColumn("string", "Pays");
            data.addColumn("number", "Nb vente");
            data.addRows(dataArray);
            var options = {
		title: 'Ventes par Pays',
		is3D: true,
                width:600,
                height:600
                                
                           
            };
            
	var chart = new google.visualization.PieChart(document.getElementById('chart_div2'));
	chart.draw(data, options);
    }
    
        function doAjax2() {
                $.ajax({
                        url: "GraphiqueLocalisationServlet",
                        dataType: "json",
                        
                        success: // La fonction qui traite les résultats
                                function (result) {
                                    
                                        //console.log(result);
                                        // On reformate le résultat comme un tableau
                                        var chartData = [];
                                        // On met le descriptif des données
                                        
                                        for(var client in result) {
                                                chartData.push([client, result[client]]);
                                        }
                                        // On dessine le graphique
                                        drawChart2(chartData);
                                },
                        error: showError
                });
        }
                
 function drawChart3(dataArray) {
            var data = new google.visualization.DataTable();
            data.addColumn("string", "Categorie");
            data.addColumn("number", "Nb vente");
            data.addRows(dataArray);
            var options = {
		title: 'Ventes par catégorie',
		is3D: true,
                width:600,
                height:600
                                
                           
            };
            
	var chart = new google.visualization.PieChart(document.getElementById('chart_div3'));
	chart.draw(data, options);
    }
        function doAjax3() {
                $.ajax({
                        url: "GraphiqueCommandeServlet",
                        dataType: "json",
                        
                        success: // La fonction qui traite les résultats
                                function (result) {
                                    
                                        //console.log(result);
                                        // On reformate le résultat comme un tableau
                                        var chartData = [];
                                        // On met le descriptif des données
                                        
                                        for(var client in result) {
                                                chartData.push([client, result[client]]);
                                        }
                                        // On dessine le graphique
                                        drawChart3(chartData);
                                },
                        error: showError
                });
        }

		// Fonction qui traite les erreurs de la requête
		function showError(xhr, status, message) {
			alert("Erreur: " + status + " : " + message);
		}

    
    
    </script> -->
  </head>

  <body>
        <div style="background-color:lightgray ;padding:5px;text-align:center">
        
        <h1> ADMINISTRATEUR </h1>
    </div>
    <div class="navbar" style="width: 100%;background-color: #555;overflow:auto;" >
        <form>
        <button type="submit" class="btn" name="action" value="Accueil">Accueil</button>
        <button type="submit" class="btn" name="action" value="Produits">Tous les produits</button>
        
        </form>
        
       
        <div class="dropdown" >
         
            
        </div>

           
           <div class="row">
               <div class="col" style="margin-left:180px;">

            <!-- Le graphique apparaît ici -->
            <div id="chart_div" style="width: 600px; height: 600px; display: inline-block;"></div>
            <div id="chart_div2" style="width: 600px; height: 600px; display: inline-block;"></div>
           <div id="chart_div3" style="width: 600px; height: 600px; display: inline-block;"></div> 

           
        </div>
        </div>

  </body>
</html>