<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cancelaciones CP</title>
<link rel="stylesheet"
	href="<c:url value="/resources/Css/Procesos.css"/>" type="text/css">
<link>
<script lenguaje="JavaScript" type="text/javascript"
	src="<c:url value="/resources/JavaScript/jquery-3.2.1.js" />"></script>
<link rel="stylesheet"
	href="<c:url value="/resources/bootstrap-4.4.1/css/bootstrap.min.css" />"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
	<script lenguaje="JavaScript" type="text/javascript"src="<c:url value="/resources/JavaScript/ScriptsBibes.js" />"></script>
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

	<div id="Encabezado" >
			<a id="imagenredirect" href="<c:url value='Choices'/>"><img
			src="<%=request.getContextPath()%>/resources/Images/logo.jpg"></img></a>
		<h1 color="white">Portal de Aplicativos Complemento Pago - Bes</h1>
		 <h1> Usuario: <security:authentication property="principal.Username"/></h1>
		<br>
	</div>
	<div id="contenido" class="p-3 mb-2 bg-light text-dark">
	<a href="<c:url value='/j_spring_security_logout'/>">Cerrar sesión</a>
	<div id="MainMenu">
		<form action="<c:url value='/Choices'/>">
			<input type="submit" value="Menu principal" class="btn btn-primary"
				id="main" name="nuevo">
		</form></div>
		<br> <br> <br>
		<security:authorize ifAnyGranted="ROLE_ADMIN">
			<td><h5>Puedes modificar el proceso ejecutandose actualmente
			en la aplicacion de TransformaBibes con la siguiente lista de
			opciones.</h5></td>
		<div align="center">
		<div class="input-group mb-3">
			<c:url var="UpdateIndicador" value="/UpdateIndicadorProceso"></c:url>
			<form:form action="${UpdateIndicador}" commandName="SubmitIndicadorProceso"
				modelAttribute="indicadorproceso">
				<div class="input-group-append">
					<form:hidden path="CLAVE" />
					<select name="VALOR" background-color="red">
						<option value="1">Pagos</option>
						<option value="2">Reverso de pagos</option>
						<option value="3">Sobre Pagos</option>
						<option value="4" selected="selected">Todos los procesos</option>
					</select><br>
					<br>
					<form:hidden path="ID_PARAMETRO" />
					<input id="update_bibes_execution" type="submit" value="Guardar cambios"
						class="btn btn-success" />
				</div>

			</form:form>
		</div>
	</div>
	</security:authorize>
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
			<tr>
				<!-- TITULOS -->
				<th id="encabezado" class="bg-primary"><h4>Aplicativo</h4></th>
				<th class="bg-primary" id="jarname"><h4>Jar</h4></th>
				<th class="bg-primary" id="estado"><h4>Procesos
						ejecutandose</h4></th>
				<th class="bg-primary" id="estado"><h4>Estado</h4></th>
				<security:authorize ifAnyGranted="ROLE_ADMIN">
				<th class="bg-primary" id="acciones"><h4 align=center>Acciones</h4></th>
				<th class="bg-primary" id="acciones"><h4 aling=center></h4></th>
					</security:authorize>
			</tr>
			<tr>
				<td id="PICP"><h5>TransformaBibes</h5></td>

			<td><h5>TransformaBibes-0.0.1.jar</h5>
			<c:forEach items="${indicadorprocesoestatico}" var="indicador">

					<c:if test="${indicador.VALOR==4}">
						<td>Sobre pagos, Reverso de Pagos, Pagos</td>
					</c:if>
					<c:if test="${indicador.VALOR==3}">
						<td>Sobrepagos</td>
					</c:if>
					<c:if test="${indicador.VALOR==2}">
						<td>Reverso de Pagos</td>
					</c:if>
					<c:if test="${indicador.VALOR==1}">
						<td>Pagos</td>
					</c:if>

				</c:forEach>
				<!--  A DEFINIR POR LE BEAN  O EL PROCESO DE LOGS-->

				<c:forEach items="${Status}" var="o">
					<c:if test="${Status=='Activo'}">
						<td><h7 id="TransformaBibesResult" style="color:#10E21A">${o}</h7></td>
					</c:if>
					<c:if test="${Status=='Inactivo'}">
						<td><h7 id="TransformaBibesResult" style="color:#F11E1E">${o}</h7></td>
					</c:if>
				</c:forEach>
<security:authorize ifAnyGranted="ROLE_ADMIN">
				<td><input type="submit" value="Activar"
					class="btn btn-success" id="TransformaBibesActive" name="nuevo" />
				</td>
				<td><input type="submit" value="Desactivar"
					class="btn btn-danger" id="TransformaBibesDesactive" align=center />
				</td>
</security:authorize>
			</tr>
		</table>	</div>
		<div class="table-responsive text-nowrap">
        <table class="table table-striped">

        <th id="encabezado" class="bg-primary"><h4>Subprocesos ejecutandose</h4></th>
				<th class="bg-primary" id="jarname"><h4></h4></th>
				<tr>
			<td id="PICP"><h5>Pagos</h5></td>

<c:forEach items="${indicadorprocesoestatico}" var="indicador">
<c:choose>
  <c:when test="${indicador.VALOR==1}">
  <td><img src="<%=request.getContextPath()%>/resources/Icons/png/64 px/74.png"></img></td>
  </c:when>
  <c:when test="${indicador.VALOR==4}">
   <td> <img src="<%=request.getContextPath()%>/resources/Icons/png/64 px/74.png"></img></td>
  </c:when>
  <c:otherwise>
 <td><img src="<%=request.getContextPath()%>/resources/Icons/png/64 px/75.png"></img></td>
  </c:otherwise>
</c:choose>
				</c:forEach>
				<!--  A DEFINIR POR LE BEAN  O EL PROCESO DE LOGS-->
				</tr>
				<tr>
			<td id="PICP"><h5>Reverso de pagos</h5></td>
			<c:forEach items="${indicadorprocesoestatico}" var="indicador">
			<c:choose>
  <c:when test="${indicador.VALOR==2}">
  <td><img src="<%=request.getContextPath()%>/resources/Icons/png/64 px/74.png"></img></td>
  </c:when>
  <c:when test="${indicador.VALOR==4}">
   <td> <img src="<%=request.getContextPath()%>/resources/Icons/png/64 px/74.png"></img></td>
  </c:when>
  <c:otherwise>
 <td><img src="<%=request.getContextPath()%>/resources/Icons/png/64 px/75.png"></img></td>
  </c:otherwise>
</c:choose>			

				</c:forEach>
							</tr>
				<tr>
			<td id="PICP"><h5>Sobre pagos</h5></td>

			<c:forEach items="${indicadorprocesoestatico}" var="indicador">

						<c:choose>
  <c:when test="${indicador.VALOR==3}">
  <td><img src="<%=request.getContextPath()%>/resources/Icons/png/64 px/74.png"></img></td>
  </c:when>
  <c:when test="${indicador.VALOR==4}">
   <td> <img src="<%=request.getContextPath()%>/resources/Icons/png/64 px/74.png"></img></td>
  </c:when>
  <c:otherwise>
 <td><img src="<%=request.getContextPath()%>/resources/Icons/png/64 px/75.png"></img></td>
  </c:otherwise>
</c:choose>
				</c:forEach>
				<!--  A DEFINIR POR LE BEAN  O EL PROCESO DE LOGS-->
</tr>
        </table>
        </div><br><br><br><br><br><br><br><br><br><br><br>
		
		</div>
	</div>
<footer>
	<div id="Pie_de_pagina" align=center  class="navbar navbar-fixed-bottom">
		<td><h4>Complemento Pago portal de Aplicativos. Telcel S.A. de
				C.V.</h4></td>
	</div>
</footer>
</body>
</html>