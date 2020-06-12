<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<!DOCTYPE html>
<html>
<head>
<head>
<%@ page isELIgnored="false"%>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="<c:url value="/resources/Css/DiseñoPrincipal.css"/>"
	type="text/css">
<link>
<script lenguaje="JavaScript" type="text/javascript"
	src="<c:url value="/resources/JavaScript/jquery-3.2.1.js" />"></script>
<link rel="stylesheet"
	href="<c:url value="/resources/bootstrap-4.4.1/css/bootstrap.min.css" />"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<script lenguaje="JavaScript" type="text/javascript"src="<c:url value="/resources/JavaScript/Scripts_status.js" />"></script>
<title>Memoria del servidor</title>
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
	<div id="Encabezado">
			<a id="imagenredirect" href="<c:url value='Choices'/>"><img
			src="<%=request.getContextPath()%>/resources/Images/logo.jpg"></img></a>
<h3>Portal de Aplicativos Complemento Pago</h3>
 <h3> Usuario: <security:authentication property="principal.Username"/></h3>
		<h4>Acerca de la memoria</h4>
	
		<br>
	</div>
	<div id="contenido" class="p-3 mb-2 bg-light text-dark">
		<a href="<c:url value='/j_spring_security_logout'/>">Cerrar sesión</a>
	<div id="MainMenu">
		<form action="<c:url value='/Choices'/>">
			<input type="submit" value="Menu principal" class="btn btn-primary"
				id="main" name="nuevo">
		</form></div>
	<h5>Memoria del servidor:</h5>
		<c:forEach items="${TOTAL}" var="o">
			<h7>Total: ${o}<h7>
		</c:forEach>
		<BR>
		<c:forEach items="${USE}" var="o">
			<h7>En uso: ${o}<h7>
		</c:forEach>
		<BR>
		<c:forEach items="${FREE}" var="o">
			<h7>Libre: ${o}<h7>
		</c:forEach>
		<BR>
		<c:forEach items="${SHARE}" var="o">
			<h7>Compartida: ${o}<h7>
		</c:forEach>
		<BR>
		<c:forEach items="${BUFF}" var="o">
			<h7>Buff/Cache: ${o}<h7>
		</c:forEach>
		<BR>
		<c:forEach items="${AVAILABLE}" var="o">
			<h7>Disponible: ${o}<h7>
		</c:forEach>
	</div><br><br><br><br><br><br><br><br><br><br><br>
<footer>
	<div id="Pie_de_pagina" align=center  class="navbar navbar-fixed-bottom">
		<td><h4>Complemento Pago portal de Aplicativos. Telcel S.A. de
				C.V.</h4></td>
	</div>
</footer>
</body>
</html>