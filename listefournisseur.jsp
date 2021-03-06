<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
</body>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html charset=ISO-8859-1">
	<title>Ajouter fournisseur</title>
     
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
  body {
      font: 20px Montserrat, sans-serif;
      line-height: 1.8;
      color: #4E3D28;
  }
  p {font-size: 16px;}
  .margin {margin-bottom: 45px;}
  
  
  
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
      border:0;
      border-radius: 0;
      margin-bottom: 0;
      font-size: 12px;
      letter-spacing: 5px;
  }
  .navbar-nav  li a:hover {
      color: #4E3D28 !important;
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
         <li><a href="<c:url value='/categorie'/>">CATEGORIE</a></li>
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
<div class="container-fluid bg-2 text-center">
  
	<!--<br> Go back to <a href="<c:url value='/Entree/allEntree' />">Liste des entrees</a>-->
				<div id="list_de_trucs">
								 <c:choose>
								 
								 	<c:when test="${not empty listent }"> 
								
				                
				<table class="table table-bordered">
							<caption>Liste des fourniseurs</caption>
								<thead>
									<tr>
									<th >Nom</th>
									<th > Produit</th>
									<th > Contact</th>
									<th > Email</th>
									<th >Quantit&eacute</th>
									<th> Suppression </th>
									</tr>
								</thead>
								<tbody>
						
			             <c:forEach var="affich" items="${listent }">
			             	<form method="post" action="listeFournisseur">
			                   <tr scope="row">
			              		<td>   <c:out value="${affich.nom}"></c:out> </td>
			              		<td>   <c:out value="${affich.produit}"></c:out> </td>
			              		<td>   <c:out value="${affich.contact}"></c:out> </td>
			              		<td>   <c:out value="${affich.email}"></c:out> </td>
			              		<input type="hidden" name="nom" value= "${affich.nom}" />
			              		<td>  <c:out value="${affich.id}"></c:out> </td>
			               		<td><input type="submit" value="supprimer" class="btn-danger"></td>
			               </tr>
			             </form>
			             </c:forEach>
			             </tbody>
						</table></div></div></c:when>
						<c:when test="${ empty listent }"> <c:out value= "La liste est vide"></c:out></c:when>
						
						</c:choose>
						
						
</body>
</html>
