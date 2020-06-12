<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Indicador CP</title>
<link rel="stylesheet"href="<c:url value="/resources/Css/Procesos.css"/>"type="text/css"><link>
<script lenguaje="JavaScript" type="text/javascript"
	src="<c:url value="/resources/JavaScript/jquery-3.2.1.js" />"></script>
<link rel="stylesheet"
	href="<c:url value="/resources/bootstrap-4.4.1/css/bootstrap.min.css" />"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<script lenguaje="JavaScript" type="text/javascript"src="<c:url value="/resources/JavaScript/ScriptsIndicador.js" />"></script>
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
	<a id="imagenredirect" href="<c:url value='Choices'/>"><img
			src="<%=request.getContextPath()%>/resources/Images/logo.jpg"></img></a>
<h1 color="white">Portal de Aplicativos Complemento Pago - Indicador</h1>
 <h1> Usuario: <security:authentication property="principal.Username"/></h1>
<br>
</div> 
<div id = "contenido" class="p-3 mb-2 bg-light text-dark">
<a href="<c:url value='/j_spring_security_logout'/>">Cerrar sesión</a>
	<div id="MainMenu">
		<form action="<c:url value='/Choices'/>">
			<input type="submit" value="Menu principal" class="btn btn-primary"
				id="main" name="nuevo">
		</form></div>
<br>
<br>
<br>
<div id="success_process">
<div class="alert alert-success" role="alert">
  Proceso Iniciado.
</div>
</div>
<div id="already_active">
<div class="alert alert-primary" role="alert">
  Proceso ya activo.
</div>
</div>
<div id="down_process">
<div class="alert alert-danger" role="alert">
  Proceso terminado.
</div>
</div>
<div id="already_down">
<div class="alert alert-dark" role="alert">
  Proceso no activo.
</div>
</div>

	<div class="table-responsive text-nowrap">
	<table class="table table-striped">
			<tr>
				<!-- TITULOS -->
				<th id="encabezado" class="bg-primary"><h4>Aplicativo</h4></th>
				<th class="bg-primary" id="jarname"><h4>Jar</h4></th>
				<th class="bg-primary" id="estado"><h4>Estado</h4></th>
				<security:authorize ifAnyGranted="ROLE_ADMIN">
				<th class="bg-primary" id="acciones"><h4 text-aling=center>Acciones</h4></th>
				<th class="bg-primary" id="acciones"><h4 aling=center></h4></th>
				</security:authorize>
			</tr>
			<tr>
				<td id="PICP"><h5>
						Proceso Indicador
					</h5>
				<td><h5>IndicadorComPagoFact-0.0.1.jar</h5></td>
				<c:forEach items="${Status}" var="o">
					<c:if test="${Status=='Activo'}">
						<td><h7 id="IndicadorResult" style="color:#10E21A">${o}</h7></td>
					</c:if>
					<c:if test="${Status=='Inactivo'}">
						<td><h7 id="IndicadorResult" style="color:#F11E1E">${o}</h7></td>
					</c:if>
				</c:forEach>
				<!--  A DEFINIR POR EL BEAN  O EL PROCESO DE LOGS-->
				<security:authorize ifAnyGranted="ROLE_ADMIN">
				<td><input type="submit" value="Activar"
					class="btn btn-success" id="ProcesadorIndicadorCPActive"
					onclick='Recargar_o_no()' /></td>
				<td><input type="submit" value="Desactivar"
					class="btn btn-danger" id="ProcesadorIndicadorCPDesactive"
					align=right></td>
					</security:authorize>
			</tr>
		</table>
		</div><br><br><br><br><br><br><br><br><br><br><br>
</div>
<footer>
	<div id="Pie_de_pagina" align=center  class="navbar navbar-fixed-bottom">
		<td><h4>Complemento Pago portal de Aplicativos. Telcel S.A. de
				C.V.</h4></td>
	</div>
</footer>
</body>
</html>