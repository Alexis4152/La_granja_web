<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet"
	href="<c:url value="/resources/Css/Procesos.css"/>"
	type="text/css">
<link>
<script lenguaje="JavaScript" type="text/javascript"
	src="<c:url value="/resources/JavaScript/jquery-3.2.1.js" />"></script>
<link rel="stylesheet"
	href="<c:url value="/resources/bootstrap-4.4.1/css/bootstrap.min.css" />"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<script lenguaje="JavaScript" type="text/javascript"src="<c:url value="/resources/JavaScript/Scripts_status.js" />"></script>
</head>
<body>
<!-- PARTE DE LA CARGA DEBE DE IR ANTES DEL BODY -->
<div id="contenedor_carga">
<div id="carga" ></div>
</div>
<div id="contenedor_loading">
<div id="loading" ></div>
</div>
<!-- PARTE DE LA CARGA DEBE DE IR ANTES DEL BODY -->
<!-- Este formulario es para abrir los parametros que se encuentran en la base de datos-->
<!-- Ejemplo en las regiones a ejecutar  -->

<div id = "Encabezado" >
			<h1 color="white">Pollería la granja</h1>
<br>
</div> 
<div id = "Contenido" class="p-3 mb-2 bg-light text-dark">

 <div class="container">
         
    <div class="row">
    
      <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
     
        <div class="card card-signin my-5">
          <img src="<%=request.getContextPath()%>/resources/Icons/png/256 px/190.png" class="rounded" ></img>
 
          <div class="p-3 mb-2 bg-light text-dark"> <!-- FONDO DEL CONTENEDOR DEL LOGIN -->
            <form name="form" action="<c:url value='j_spring_security_check'/>"
                    method="POST">
            <form class="form-signin">
              <div class="form-label-group">
                <input type="text" id="Username" class="form-control" placeholder="Usuario" name='j_username'>
                <br>
              </div>
              <div class="form-label-group">
                <input type="password" id="Pass" class="form-control" placeholder="Contraseña" name='j_password'>
             <br>
              </div>
		    <button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit" id="main">Iniciar sesión</button>
		   </form>
		   <c:if test="${param.error != null}">
  <div class="alert alert-danger">
   <p>Usuario y contraseña incorrectos.</p>
  </div>
</c:if>
              <hr class="my-8">
               </form>
               <h5 id=respuestalogin"></h5>
          </div>
        </div>
      </div>
    </div>
  </div>
<footer>
<div id="Pie_de_pagina" align=center  class="navbar navbar-fixed-bottom">
<td><h4>Pollería la Granja S.A. de C.V.</h4></td>
</div>
</footer>
</body>
</html>