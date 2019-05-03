<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
<head>
	<meta http-equiv="Content-Type" content="text/html charset=ISO-8859-1">
	<title>Ajouter catégorie</title>
     
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
 <style>
  body {
      font: 20px Montserrat, sans-serif;
      line-height: 1.8;
      color: #649B88;
  }
  p {font-size: 18px;}
  .margin {margin-bottom: 48px;}
  
  
  
  .bg-1 { 
  
      background-color: #FEFDF0; /* 1abc9cGreen */
      color: #4E3D28;
      
      
  }
 input  { 
      color: black; /* Green */
      
  } 
  
  select  { 
      color: black; /* Green */
      
  } 
  .bg-2 { 
      background-color: #FEFEFE; /* Dark Blue */
      color: #4E3D28;
  }
  .bg-3 { 
      background-color: #1abc9c; /* White */
      color: #555555;
  }
  .bg-4 { 
      background-color: #2f2f2f; /* Black Gray */
      color: #fff;
  }
  .container-fluid {
      padding-top:    100px;
       padding-bottom: 100px;
  }
  .navbar {
      padding-top: 10px;
      padding-bottom: 0px;
      border: 0;
      border-radius: 0;
      margin-bottom: 0;
      font-size: 12px;
      letter-spacing: 5px;
      color: #FEFDF0;
  }
  .navbar-nav  li a:hover {
      color: #FEFDF0;
  }
  
  
  div#list_de_trucs{
margin:10px auto;
width:100%;
min-width:500px;
max-width:700px;
}
div#list_de_trucs table{
margin:0px;
width:100%;
}

  </style>
</head>

<body><nav class="navbar navbar-default">
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#">Home</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav navbar-right">
        <li ><a  href="<c:url value='/categorie' />">CATEGORIE</a></li>
        <li><a href="<c:url value='/entree'/>">ENTREES</a></li>
        <li><a href="<c:url value='/fournisseur'/>">FOURNISSEUR</a></li>
        <!-- <li><a href="<c:url value='/gestionnaire'/>">GESTIONNAIRE</a></li>-->
        <li><a href= "<c:url value='/produit' />">PRODUIT</a></li>
        <li><a href= "<c:url value='/listeProduit' />">STOCK</a></li>
        <li><a href= "<c:url value='/sortie' />">SORTIE</a></li>
        
      </ul>
    </div>
  </div>
</nav>
<div class="container-fluid bg-1 text-center">
 <center><h2 class="margin">Nouvelle catégorie</h2></center>
        <!--  <form method="POST" modelAttribute="categorie" class="form-horizontal">
		<input type="hidden" path="id" id="id" />
                
                    <div  class="form-group">
                        <label for="c" class="control-label col-sm-3">Libellé: </label>
                         <div class="col-sm-2"> 
                            <input type= "text" class="forn-control" path="nom" name="libelle"/>
                        </div>   
                  
                   
                <label for="date_ca" class="control-label col-sm-2">Date  </label> 
                     <div class="col-sm-2">  
			<input class="forn-control" type="Date" path="date_ca" name="date_ca"/> 
                      <br/>
                      </div>
                     </div>
                      <div class="col-sm-12">
			 <br/>
                        <input class="btn btn-success" type="submit" value="Enregistrer"/>
				
						</div>
						
		 <br/>
	</form>
	</div>-->


<div class="container">
  <form method="POST" modelAttribute="categorie">
    <div class="form-group row">
      <label for="libelle" class="col-sm-2 col-form-label">Libellé</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" path="libelle" placeholder="libellé" name="libelle">
      </div>
    </div>
    <br/>
    <div class="form-group row">
      <label for="date_ca" class="col-sm-2 col-form-label">Date</label>
      <div class="col-sm-10">
        <input type = "date" class = "form-control" path = "date_ca" placeholder = "date" name="date_ca">
      </div>
    </div>
    <br/>
   <div class="form-group row">
      <div class="offset-sm-2 col-sm-10">
      <center>  <button type="submit" class="btn btn-primary"> Enregistrer </button></center>
      </div>
    </div>
  </form>
  <!-- <br> Go back to <a href="<c:url value='/Entree/allEntree' />">Liste des Catégories</a></center>-->
  
</div>
</body>
</html>