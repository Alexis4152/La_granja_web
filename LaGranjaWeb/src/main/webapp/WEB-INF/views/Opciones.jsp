<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menu principal</title>
<link rel="stylesheet"
	href="<c:url value="/resources/Css/Procesos.css"/>" type="text/css">
<link>
<script lenguaje="JavaScript" type="text/javascript"
	src="<c:url value="/resources/JavaScript/jquery-3.2.1.js" />"></script>
<link rel="stylesheet"
	href="<c:url value="/resources/bootstrap-4.4.1/css/bootstrap.min.css" />"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<script lenguaje="JavaScript" type="text/javascript"
	src="<c:url value="/resources/bootstrap-4.4.1/js/bootstrap.min.js" />"></script>

<script lenguaje="JavaScript" type="text/javascript"
	src="<c:url value="/resources/JavaScript/ScriptsCM.js" />"></script>
<script lenguaje="JavaScript" type="text/javascript"
	src="<c:url value="/resources/JavaScript/Scripts_status.js" />"></script>

</head>
<body>
	<!-- PARTE DE LA CARGA DEBE DE IR ANTES DEL BODY -->
	<!-- Este formulario es para abrir los parametros que se encuentran en la base de datos-->
	<!-- Ejemplo en las regiones a ejecutar  -->

	<!--  	<img src="<%=request.getContextPath()%>/resources/Images/logo.jpg"></img>-->


	<div class="container">
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
			<a class="navbar-brand">Polleria La Granja </a>
			<button class="navbar-toggler" data-target="#menu"
				data-toggle="collapse" type="button">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="menu">
				<ul class="navbar-nav mr-auto">
				
					<li class="nav-item dropdown"><a class="nav-link dropdown-toggle active" data-toggle="dropdown"
						data-target="desplegable">Productos</a><!-- <------- MENU -->
						
						<div class="dropdown-menu">
						     <a class="dropdown-item">Agregar producto</a><!-- <------- SUBMENU -->
							 <a class="dropdown-item">Agregar producto externo</a><!-- <------- SUBMENU -->
						</div>
				   </li>
				   
				   
					<li class="nav-item active"><a class="nav-link">Ventas</a></li>
					<li class="nav-item active"><a class="nav-link">Gastos</a></li>
					<li class="nav-item active"><a class="nav-link" href="<c:url value='Memoria'/>">Corte de caja</a></li>
					<li class="nav-item active"></li>
					<li class="nav-item dropdown"><a class="nav-link dropdown-toggle active" data-toggle="dropdown"
						data-target="desplegable"> <security:authentication
								property="principal.Username" /></a><!-- <---- NOMBRE DEL USUARIO / MENU-->
						<div class="dropdown-menu">
							<a class="dropdown-item" 
								href="<c:url value='/j_spring_security_logout'/>">Cerrar
								sesión</a><!-- SUBMENU -->
						</div>
				   </li>
				</ul>
			</div>
		</nav>
	</div>


</body>
</html>