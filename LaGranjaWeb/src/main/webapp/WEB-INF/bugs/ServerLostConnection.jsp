<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Conexión perdida</title>
<link rel="stylesheet"href="<c:url value="/resources/Css/Procesos.css"/>"type="text/css"><link>
<script lenguaje="JavaScript" type="text/javascript"
	src="<c:url value="/resources/JavaScript/jquery-3.2.1.js" />"></script>
<link rel="stylesheet"
	href="<c:url value="/resources/bootstrap-4.4.1/css/bootstrap.min.css" />"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
	<script lenguaje="JavaScript" type="text/javascript"src="<c:url value="/resources/JavaScript/Scripts_status.js" />"></script></head>
<body>
<!-- Este formulario es para abrir los parametros que se encuentran en la base de datos-->
<!-- Ejemplo en las regiones a ejecutar  -->

<div id = "Encabezado" >
<a id="imagenredirect" href="<c:url value='inicio'/>"><img src="<%= request.getContextPath() %>/resources/Images/logo.jpg"></img></a>
<h1 color="white">Error de conexión</h1>

</div> 
<br>

	<div id="contenedor_carga">
		<div id="carga"></div>
	</div>
	<div id="contenedor_loading">
		<div id="loading"></div>
	</div>

<div id = "Contenido" class="p-3 mb-2 bg-light text-dark">

<br>
<br>
<br>

<h2>Por el momento no es posible establecer una conexión con el servidor.</h2>
<h2>Verifique su conexión a internet o valide el servidor</h2>




<br>
<br>
<br>
<br>
<br>
<br>

<form action="<c:url value='/Choices'/>">
<input type="submit" 
value="Menu principal" 
class="btn btn-primary"
id="main"
name="nuevo">
</form>
</div>
<br><br><br><br><br><br><br><br><br><br><br>
	<footer>
		<div id="Pie_de_pagina" align=center class="navbar navbar-fixed-bottom">
		<h4>Complemento Pago portal de procesos. Telcel S.A. de C.V.</h4>
	</div>
	</footer>
</body>
</html>