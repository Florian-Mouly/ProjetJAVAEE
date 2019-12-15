<%-- 
    Document   : viewStats
    Created on : 10 déc. 2019, 14:00:17
    Author     : damie
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
   <!--Load the AJAX API-->
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <script type="text/javascript">
    
    // Load the Visualization API and the piechart package.
    google.charts.load('current', {'packages':['corechart']});
      
    // Set a callback to run when the Google Visualization API is loaded.
    google.charts.setOnLoadCallback(drawChart);
      // Callback that creates and populates a data table, 
      // instantiates the pie chart, passes in the data and
      // draws it.
       function drawChart() {
                 var jsonData = $.ajax({
                    url: "ChiffreAffaireClientServlet",
                    dataType: "json",
                    async: false
                }).responseText;
                console.log(jsonData);

              
      // Create the data table.
      
      var data = new google.visualization.DataTable(jsonData);
      

      // Set chart options
      var options = {'title':'Chiffre affaire client',
                     'width':400,
                     'height':300};

      // Instantiate and draw our chart, passing in some options.
      var chart = new google.visualization.PieChart(document.getElementById('chart_div'));
      chart.draw(data, options);
      
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
            <form id='codeForm' style="text-align:center;">
                <label for="start">Date debut :<input name="dateDebut" type="date" id="start"></label>
                <label for="fin">Date fin :<input name="dateFin" type="date" id="fin"></label>
                <button type="button" onclick="" >Valider</button>
            </form>
            
            
        </div>
        
            </fieldset>
    </div> 
//Div that will hold the pie chart
    <div id="chart_div" style="width:400; height:300"></div>
  </body>
</html>