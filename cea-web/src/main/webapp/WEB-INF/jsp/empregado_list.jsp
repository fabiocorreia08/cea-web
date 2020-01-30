<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>EFAD</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	
</head>
<body class="d-flex flex-column h-100">

<header>
     
      <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
        <a class="navbar-brand" href="#">EFAD</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarCollapse">
          <ul class="navbar-nav mr-auto">
            <li class="nav-item ">              
              <s:url value="/" var="indexURL"/>
			  <a class="nav-link" href="${indexURL }" role="button">Home <span class="sr-only">(atual)</span></a> 
            </li>
            <li class="nav-item active">            
            	<s:url value="/empregado/list/" var="listURL"/>
				<a class="nav-link" href="${listURL }" role="button">Empregado</a>              
            </li>  
                                   
          </ul> 
          
          <form class="form-inline mt-2 mt-md-0">
           		<s:url value="/logout" var="logoutURL"/>
				<a class="nav-link" href="${logoutURL }" role="button">Sair</a>  
          </form>       
        </div>
      </nav>
    </header>
    
    <main role="main" class="flex-shrink-0">
      <div class="container">
       <br></br>
      <br></br>
      	<h2>Empregados</h2>
      	<br></br>
      	<form class="form-inline">
		  <div class="form-group mb-2">
		    <label for="nome" class="sr-only">Matricula</label>
		    <input type="text" readonly class="form-control-plaintext" id="matricula" value="Matrícula do Usuário">
		  </div>
		  <div class="form-group mx-sm-3 mb-2">
		    <label for="matricula" class="sr-only">Matricula</label>
		    <input type="text" class="form-control" id="matricula" placeholder="Matricula">
		  </div>
		  <button type="submit" class="btn btn-primary mb-2">Buscar</button>
		</form>      	
		<br></br>		
		<table class="table table-striped">
			<thead>
				<th scope="raw">Matrícula</th>
				<th scope="raw">Nome</th>				
				<th scope="raw">Início Férias</th>
				<th scope="raw">Fim Férias</th>
				<th scope="raw">UpDate</th>
				<th scope="raw">Delete</th>
			</thead>
			<tbody>
				<c:forEach items="${empregadoList}" var="empregado">
					<tr>
						<td>${empregado.matricula }</td>
						<td>${empregado.nome }</td>						
						<td>${empregado.inicioFerias }</td>
						<td>${empregado.fimFerias }</td>
						<td>
							<s:url value="/empregado/update/${empregado.id }" var="updateURL"/>
							<a class="btn btn-primary" href="${updateURL }" role="button">Update</a>
						</td>
						<td>
							<s:url value="/empregado/delete/${empregado.id }" var="deleteURL"/>
							<a class="btn btn-primary" href="${deleteURL }" role="button">Delete</a>
						</td>
					</tr>				
				</c:forEach>
			</tbody>
		</table>
		<s:url value="/empregado/add/" var="addURL"/>
		<a class="btn btn-primary" href="${addURL }" role="button">Novo Empregado ERP</a>		
      </div>
    </main>

	
</body>
</html>