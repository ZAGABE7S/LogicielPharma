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
	<title>Ajouter entrée</title>
     
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
      border: 0;
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
        <!--<li><a href="<c:url value='/gestionnaire'/>">GESTIONNAIRE</a></li>-->
        <li><a href= "<c:url value='/produit' />">PRODUIT</a></li>
        <li><a href= "<c:url value='/listeProduit' />">STOCK</a></li>
        <li><a href= "<c:url value='/sortie' />">SORTIE</a></li>
        
      </ul>
    </div>
  </div>
</nav>
<div class="container-fluid bg-2 text-center" class="form-group row">
  <h3 class="margin">Nouveau Fournisseur</h3>
        <!--<form method="POST" modelAttribute="entree" class="form-horizontal">
		<form:input type="hidden" path="id" id="id" />
                
                    <div  class="form-group">
                        <label for="produit" class="col-sm-2 col-form-label">Produit: </label>
                        <div class="col-sm-2"> 
                           <select name="produit" class="selectpicker" type="text">
                              <c:forEach items="${listeproduit}" var="produit">
                                <option >${produit}</option>
                              </c:forEach>
                        </select>
                        </div>   
                    
                       	<label for="nom" class="control-label col-sm-2" >Nom: </label>
                        <div class="col-sm-2"> 
                            <input type= "int" class="forn-control" path="nom" name="nom"/>
                        </div>   
                    </div>
                    <br/>
                    <div class="form-group" >
                        <label for="contact" class="control-label col-sm-2">Contact: </label> 
                        <div class="col-sm-2"> 
                            <input class="forn-control" path="user_name" name="contact"/>
                        </div>                                   
                        <label for="email" class="control-label col-sm-2">Email </label> 
                     <div class="col-sm-2">  
			<input class="forn-control" type="text" path="email" name="email"/> 
                     </div>
                    </div>
                                    
                      <br/>
                      <div class="col-sm-8">
			
                        <input class="btn btn-success" type="submit" value="Enregistrer"/>
				
						</div>
		
	</form>

	<br> Go back to <a href="<c:url value='/listeFournisseur' />">Liste des fournisseurs</a>
				<!--<div id="list_de_trucs">			<table class="table table-bordered">
							<caption>Liste des entrées</caption>
								<thead>
									<tr>
									<th >Produit</th>
									<th > date</th>
									<th > quantite</th>
									<th > user_name</th>
									</tr>
								</thead>
								<tbody>
			             <c:forEach var="affich" items="${listent }">
			             	
			              <tr scope="row">
			              		<td>   <c:out value="${affich.nom_produit}"></c:out> </td>
			              		<td>   <c:out value="${affich.date}"></c:out> </td>
			              		<td>   <c:out value="${affich.quantite}"></c:out> </td>
			              		<td>   <c:out value="${affich.user_name}"></c:out> </td>
			              
			               </tr>
			             </c:forEach>
			             </tbody>
						</table></div>-->
						<div class="container" >
  <form method="POST" modelAttribute="entree">
    <div class="form-group row">
      <label for="produit" class="col-sm-2 col-form-label">Produit</label>
      <div class="col-sm-10">
        <select name="produit" class="selectpicker" type="text" path="produit">
             <c:forEach items="${listeproduit}" var="produit">
                  <option >${produit}</option>
             </c:forEach>
        </select>
      </div>
    </div>
    
    <div class="form-group row">
      <label for="quantite" class="col-sm-2 col-form-label">Nom</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" name="nom" placeholder="nom fournisseur">
      </div>
    </div>
    
    <div class="form-group row">
      <label for="contact" class="col-sm-2 col-form-label">Contact</label>
      <div class="col-sm-10">
        <input type="int" class="form-control" name="contact" placeholder="contact fournisseur">
      </div>
    </div>
    
    <div class="form-group row">
      <label for="email" class="col-sm-2 col-form-label">Email</label>
      <div class="col-sm-10">
        <input type="email" class="form-control" path="date_entree" placeholder="email fournisseur" name="email">
      </div>
    </div>
    
    <div class="form-group row">
      <div class="offset-sm-4 col-sm-10">
        <center>  <button type="submit" class="btn btn-primary">Enregistrer</button></center>
      </div>
    </div>
  </form>

</div>
	<br> Go back to <a href="<c:url value='/listeFournisseur' />">Liste des fournisseurs</a>					
</body>
</html>
