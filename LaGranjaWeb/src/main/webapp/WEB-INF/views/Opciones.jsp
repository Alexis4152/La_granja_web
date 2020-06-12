<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menu principal</title>
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
<script lenguaje="JavaScript" type="text/javascript"src="<c:url value="/resources/JavaScript/ScriptsCM.js" />"></script>
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
	<img src="<%=request.getContextPath()%>/resources/Images/logo.jpg"></img>
			<h1 color="white">Portal de Aplicativos Complemento Pago - Menu principal</h1>
			 <h1> Usuario: <security:authentication property="principal.Username"/></h1>
<br>
</div> 
<div id = "Contenido" class="p-3 mb-2 bg-light text-dark">
<div id ="Nombre_usuario">
  <a href="<c:url value='/j_spring_security_logout'/>">Cerrar sesión</a>
  </div>

<br>
   <div id="success_process">
<div class="alert alert-success" role="alert">
  Bienvenido.
</div>
</div>
<div id="down_process">
<div class="alert alert-danger" role="alert">
  Datos de acceso incorrectos.
</div>
</div>

<h2>Elige una opción.</h2>
<br><br>
<div id="container">
<div id="Aplicativos">
<a id="appsredirect" href="<c:url value='Aplicativos'/>"><img src="<%=request.getContextPath()%>/resources/Icons/png/256 px/21.png"></img></a>
<h5>Aplicativos</h5>
</div>
<div id="ParametrosLink">
<a id="dataredirect" href="<c:url value='ParametrosVista'/>"><img src="<%=request.getContextPath()%>/resources/Icons/png/256 px/11.png"></img></a>
<h5>Parametros</h5>
</div>
</div>
<div id="MemoriaLink">
<a id="memoryredirect" href="<c:url value='Memoria'/>"><img src="<%=request.getContextPath()%>/resources/Icons/png/256 px/33.png"></img></a>
<h5>Memoria</h5>
</div>

		<br><br><br><br><br><br><br><br><br><br><br>
<br>
<br>
<br>
<br>
<br>
<br>


</div>

<footer>
<div id="Pie_de_pagina" align=center  class="navbar navbar-fixed-bottom">
<td><h4>Complemento Pago portal de Aplicativos. Telcel S.A. de C.V.</h4></td>
</div>
</footer>
</body>
</html>