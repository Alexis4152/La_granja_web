<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%><!-- CON ESTO SE HABILITA LA SEGURIDAD PARA LA VISTA -->

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
<script lenguaje="JavaScript" type="text/javascript"
	src="<c:url value="/resources/JavaScript/ScriptsBibes.js" />"></script>
<script lenguaje="JavaScript" type="text/javascript"
	src="<c:url value="/resources/JavaScript/ScriptsCancel.js" />"></script>
<script lenguaje="JavaScript" type="text/javascript"
	src="<c:url value="/resources/JavaScript/ScriptsCM.js" />"></script>
<script lenguaje="JavaScript" type="text/javascript"
	src="<c:url value="/resources/JavaScript/ScriptsCore.js" />"></script>
<script lenguaje="JavaScript" type="text/javascript"
	src="<c:url value="/resources/JavaScript/ScriptsIndicador.js" />"></script>
<script lenguaje="JavaScript" type="text/javascript"
	src="<c:url value="/resources/JavaScript/ScriptsTransforma.js" />"></script>
<script lenguaje="JavaScript" type="text/javascript"
	src="<c:url value="/resources/JavaScript/Scripts_status.js" />"></script>
<title>Portal de Aplicativos CP</title>
</head>

<body>
	<div id="contenedor_carga">
		<div id="carga"></div>
	</div>
	<div id="contenedor_loading">
		<div id="loading"></div>
	</div>
	<!-- PARTE DE LA CARGA DEBE DE IR ANTES DEL BODY -->
	<div id="Encabezado">
		<a id="imagenredirect" href="<c:url value='Choices'/>"><img
			src="<%=request.getContextPath()%>/resources/Images/logo.jpg"></img></a>
		<h3>Portal de Aplicativos Complemento Pago</h3>
		<h3> Usuario: <security:authentication property="principal.Username"/></h3>
		<h4>Revision de procesos activos</h4>

	</div>
	<div id="contenido" class="p-3 mb-2 bg-light text-dark">
	<a href="<c:url value='/j_spring_security_logout'/>">Cerrar sesión</a>
		<div id="MainMenu">
		<form action="<c:url value='/Choices'/>">
			<input type="submit" value="Menu principal" class="btn btn-primary"
				id="main" name="nuevo">
		</form></div>
	<security:authorize ifAnyGranted="ROLE_ADMIN">
	<div class="input-group mb-3">
				<div class="input-group-append">
  <select id="opciones" onchange="location = this.value">
  <option disabled selected>Opciones</option>
  <option value="<c:url value='StartAll'/>">Activar todos los aplicativos</option>
  <option value="<c:url value='KillAll'/>">Desactivar todos los aplicativos</option>
					</select><br>
					<br>
				</div>
		</div>
		</security:authorize>
		<br> <br>
		<div id="success_process">
			<div class="alert alert-success" role="alert">Proceso Iniciado.
			</div>
		</div>
		<div id="already_active">
			<div class="alert alert-primary" role="alert">Proceso ya
				activo.</div>
		</div>
		<div id="down_process">
			<div class="alert alert-danger" role="alert">Proceso terminado.
			</div>
		</div>
		<div id="already_down">
			<div class="alert alert-dark" role="alert">Proceso no activo.</div>
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
						<a id="linkindicador" href="<c:url value='IndicadorComplementoPagoFact'/>">Proceso Indicador</a>
					</h5>
				<td><h5>IndicadorComPagoFact-0.0.1.jar</h5></td>
				<c:forEach items="${Indicador}" var="o">
					<c:if test="${Indicador=='Activo'}">
						<td><h7 id="IndicadorResult" style="color:#10E21A">${o}</h7></td>
					</c:if>
					<c:if test="${Indicador=='Inactivo'}">
						<td><h7 id="IndicadorResult" style="color:#F11E1E">${o}</h7></td>
					</c:if>
				</c:forEach>
				<!--  A DEFINIR POR EL BEAN  O EL PROCESO DE LOGS-->
				<security:authorize ifAnyGranted="ROLE_ADMIN"><!-- SE HABILITA LA SEGURIDAD PARA QUE SOLO UN ADMIN PUEDA ACTIVAR O DESACTIVAR UN PROCESO -->
				<td>
				<input type="submit" value="Activar"
					class="btn btn-success" id="ProcesadorIndicadorCPActive"
					onclick='Recargar_o_no()' /></td>
				<td><input type="submit" value="Desactivar"
					class="btn btn-danger" id="ProcesadorIndicadorCPDesactive"
					align=right>
				</td>
					</security:authorize>
			</tr>
			<tr>
				<td id="PICP"><h5>
						<a id="linkbibes" href="<c:url value='TransformaBibes'/>">TransformaBibes</a>
					</h5></td>
				<td><h5>TransformaBibes-0.0.1.jar</h5></td>
				<c:forEach items="${TransBibes}" var="o">
					<c:if test="${TransBibes=='Activo'}">
						<td><h7 id="TransformaBibesResult" style="color:#10E21A">${o}</h7></td>
					</c:if>
					<c:if test="${TransBibes=='Inactivo'}">
						<td><h7 id="TransformaBibesResult" style="color:#F11E1E">${o}</h7></td>
					</c:if>
				</c:forEach>
				<!--  A DEFINIR POR LE BEAN  O EL PROCESO DE LOGS-->
				<security:authorize ifAnyGranted="ROLE_ADMIN"> <!-- ACTIVA LA SEGURIDAD PARA QUE SOLAMENTE EL ADMIN PUEDA ACTIVAR O BAJAR PROCESOS -->
				<td>
				<input type="submit" value="Activar"
					class="btn btn-success" id="TransformaBibesActive" name="nuevo" />
				</td>
				<td><input type="submit" value="Desactivar"
					class="btn btn-danger" id="TransformaBibesDesactive" align=center />

				</td>
				</security:authorize>
			</tr>
			<tr>
				<td id="PICP"><h5>
						<a  id="linktransforma" href="<c:url value='Transforma'/>">Transforma</a>
					</h5></td>
				<td><h5>Transforma-1.0.jar</h5></td>
				<c:forEach items="${Transforma}" var="o">
					<c:if test="${Transforma=='Activo'}">
						<td><h7 id="TransformaResult" style="color:#10E21A">${o}</h7></td>
					</c:if>
					<c:if test="${Transforma=='Inactivo'}">
						<td><h7 id="TransformaResult" style="color:#F11E1E">${o}</h7></td>
					</c:if>
				</c:forEach>
				<!--  A DEFINIR POR LE BEAN  O EL PROCESO DE LOGS-->
				<security:authorize ifAnyGranted="ROLE_ADMIN">
				<td><input type="submit" value="Activar"
					class="btn btn-success" id="TransformaActive" name="nuevo" /></td>
				<td><input type="submit" class="btn btn-danger"
					value="Desactivar" id="TransformaDesactive" align=center /></td>
					</security:authorize>
			</tr>

			<tr>
				<td id="PICP"><h5>
						<a  id="linkcore" href="<c:url value='CoreCPBatch'/>">CoreComPago</a>
					</h5></td>
				<td><h5>CoreCompPagoBatch-1.0.jar</h5></td>
				<c:forEach items="${CoreCP}" var="o">
					<c:if test="${CoreCP=='Activo'}">
						<td><h7 id="CoreCPResult" style="color:#10E21A">${o}</h7></td>
					</c:if>
					<c:if test="${CoreCP=='Inactivo'}">
						<td><h7 id="CoreCPResult" style="color:#F11E1E">${o}</h7></td>
					</c:if>
				</c:forEach>
				<!--  A DEFINIR POR LE BEAN  O EL PROCESO DE LOGS-->
				<security:authorize ifAnyGranted="ROLE_ADMIN">
				<td>
				<input type="submit" value="Activar"
					class="btn btn-success" id="CoreCompagoBatchActive" name="nuevo" />

				</td>
				<td><input type="submit" class="btn btn-danger"
					value="Desactivar" id="CoreCompagoBatchDesactive" align=center />
				</td>
				</security:authorize>
			</tr>
			<tr>
				<td id="PICP"><h5>
						<a  id="linkcmasiva"  href="<c:url value='CargaMasiva'/>">Carga Masiva</a>
					</h5></td>
				<td><h5>CMasivaCompPagoBatch-1.0.jar</h5></td>
				<c:forEach items="${CMasiva}" var="o">
					<c:if test="${CMasiva=='Activo'}">
						<td><h7 id="CMasivaResult" style="color:#10E21A">${o}</h7></td>
					</c:if>
					<c:if test="${CMasiva=='Inactivo'}">
						<td><h7 id="CMasivaResult" style="color:#F11E1E">${o}</h7></td>
					</c:if>
				</c:forEach>
				<!--  A DEFINIR POR LE BEAN  O EL PROCESO DE LOGS-->
				<security:authorize ifAnyGranted="ROLE_ADMIN">
				<td>
					<input type="submit" value="Activar"
					class="btn btn-success" id="CargaMasivaActive" name="nuevo" /></td>
				<td><input type="submit" class="btn btn-danger"
					value="Desactivar" id="CargaMasivaDesactive" align=center /></td>
					</security:authorize>
			</tr>

			<tr>
				<td id="PICP"><h5>
						<a id="linkcancel" href="<c:url value='Cancelaciones'/>">Cancelaciones</a>
					</h5></td>
				<td><h5>CancelacionCompPagoBatch-1.0.jar</h5></td>
				<c:forEach items="${CanceCP}" var="o">
					<c:if test="${CanceCP=='Activo'}">
						<td><h7 id="CancelResult" style="color:#10E21A">${o}</h7></td>
					</c:if>
					<c:if test="${CanceCP=='Inactivo'}">
						<td><h7 id="CancelResult" style="color:#F11E1E">${o}</h7></td>
					</c:if>
				</c:forEach>
				<!--  A DEFINIR POR LE BEAN  O EL PROCESO DE LOGS-->
				<security:authorize ifAnyGranted="ROLE_ADMIN">
				<td><input type="submit" value="Activar"
					class="btn btn-success" id="CancelacionCompPagoBatchActive"
					name="nuevo" /></td>
				<td><input type="submit" value="Desactivar"
					class="btn btn-danger" id="CancelacionCompPagoBatchDesactive"
					align=center /></td>
					</security:authorize>
			</tr>
		</table>
		</div>
	</div>
	<br><br>
	<footer>
		<div id="Pie_de_pagina" align=center class="navbar navbar-fixed-bottom">
		<h4>Complemento Pago portal de Aplicativos. Telcel S.A. de C.V.</h4>
	</div>
	</footer>

</body>
</html>