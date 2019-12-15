<%-- 
    Document   : viewStats
    Created on : 10 déc. 2019, 14:00:17
    Author     : damie
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
       <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
   <!-- On charge l'API Google -->
	<script type="text/javascript" src="https://www.google.com/jsapi"></script>
	<script type="text/javascript">
    
    // Load the Visualization API and the piechart package.
   google.load("visualization", "1", {packages: ["corechart"]});
      
    // Set a callback to run when the Google Visualization API is loaded.
    google.setOnLoadCallback(doAjax);
    google.setOnLoadCallback(doAjax2);
    google.setOnLoadCallback(doAjax3);

      // Callback that creates and populates a data table, 
      // instantiates the pie chart, passes in the data and
      // draws it.
      
      function drawChart(dataArray) {
	var data = google.visualization.arrayToDataTable(dataArray);
	var options = {
		title: 'Ventes par nom',
		is3D: true,
                width:400,
                height:400
                                
                           
            };
	var chart = new google.visualization.PieChart(document.getElementById('chart_div'));
	chart.draw(data, options);
        console.log(data);
    }
                
      function doAjax() {
	$.ajax({
            url: "ChiffreAffaireClientServlet",
            
            dataType: "json",
            success: // La fonction qui traite les résultats
		function (resultat) {
		// On reformate le résultat comme un tableau
                    var chartData = [];
		// On met le descriptif des données
                    chartData.push(["Nom", "Ventes"]);
                    for(var client in resultat.records) {
			chartData.push([client,resultat.records[client]]);
                    }
		// On dessine le graphique
                    drawChart(chartData);
                    },
                   error: showError
			});
		}
		
        function drawChart2(dataArray) {
	var data = google.visualization.arrayToDataTable(dataArray);
	var options = {
		title: 'Ventes par catégories',
		is3D: true,
                width:400,
                height:400
                                
                           
            };
	var chart = new google.visualization.PieChart(document.getElementById('chart_div2'));
	chart.draw(data, options);
        console.log(data);
    }
                
      function doAjax2() {
	$.ajax({
            url: "GraphiqueCommandeServlet",
            dataType: "json",
            success: // La fonction qui traite les résultats
		function (resultat) {
		// On reformate le résultat comme un tableau
                    var chartData = [];
		// On met le descriptif des données
                    chartData.push(["Catégorie", "Ventes"]);
                    for(var client in resultat.records) {
			chartData.push([client,resultat.records[client]]);
                    }
		// On dessine le graphique
                    drawChart(chartData);
                    },
                   error: showError
			});
		}
                
                
        function drawChart3(dataArray) {
	var data = google.visualization.arrayToDataTable(dataArray);
	var options = {
		title: 'Ventes par pays',
		is3D: true,
                width:400,
                height:400
                                
                           
            };
	var chart = new google.visualization.PieChart(document.getElementById('chart_div3'));
	chart.draw(data, options);
        console.log(data);
    }
                
      function doAjax3() {
	$.ajax({
            url: "GraphiqueLocalisationServlet",
            
            dataType: "json",
            success: // La fonction qui traite les résultats
		function (resultat) {
		// On reformate le résultat comme un tableau
                    var chartData = [];
		// On met le descriptif des données
                    chartData.push(["Pays", "Ventes"]);
                    for(var client in resultat.records) {
			chartData.push([client,resultat.records[client]]);
                    }
		// On dessine le graphique
                    drawChart(chartData);
                    },
                   error: showError
			});
		}
                
		// Fonction qui traite les erreurs de la requête
		function showError(xhr, status, message) {
			alert("Erreur: " + status + " : " + message);
		}

    
    
    </script>
  </head>

  <body>
       <body>
        <div style="background-color:lightgray ;padding:5px;text-align:center">
        
        <h1> ADMINISTRATEUR </h1>
    </div>
    <div class="navbar" style="width: 100%;background-color: #555;overflow:auto;" >
        <button type="button" class="btn btn-primary"><a  style="text-decoration:none;color: black;"  href="#" name="home"> Acceuil</a></button>
        <div class="dropdown" >
            <div class="dropdown-content">
                <button type="button" class="btn btn-light"><a style="text-decoration:none; color: black;" href="#">Graphiques</a></button>
            </div>
            
        </div>
        
         <fieldset id="graphique" title="Graphiques" style="color:white;font-family:Arial;">
        <legend>Graphiques de chiffre d'affaires</legend>
        <div>
            <label><input name="g" type="radio" onclick="doClientAjax()" checked />Par Client</label>
        </div>
        <div>
            <form id="idgraph" action="CiffreAffaireClientServlet" method="POST" id="graph">   
                Date debut :<input name="dateDeb" type="date" id="start">
                Date fin :<input name="dateFin" type="date" id="fin">
                <button type="button" onclick="" >Valider</button>
                  
                
            </form>
            
           
            
            
        </div>
        
            </fieldset>
    </div> 

                <form action="ChiffreAffaireClientServlet" method="POST" id="graph">   
             Date Début : <input type="date" name="dateDebut" ></br>
             Date fin : <input type="date" name="datefin"></br>
            <!-- Le graphique apparaît ici -->
            <div id="chart_div" style="width: 400px; height: 400px; display: inline-block;"></div>
            <div id="chart_div2" style="width: 400px; height: 400px; display: inline-block;"></div>
            <div id="chart_div3" style="width: 400px; height: 400px; display: inline-block;"></div>


                   
                </form>
  </body>
</html>