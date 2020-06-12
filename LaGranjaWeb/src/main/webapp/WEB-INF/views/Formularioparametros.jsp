<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PARAMETROS</title>
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
	src="<c:url value="/resources/JavaScript/Scripts_status.js" />"></script>
	<script lenguaje="JavaScript" type="text/javascript"
	src="<c:url value="/resources/JavaScript/Parametros.js" />"></script>
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

    <div id="Encabezado">

		<img
			src="<%=request.getContextPath()%>/resources/Images/logo.jpg"></img>
		<h3>Portal de Aplicativos Complemento Pago </h3>
		
     <h3> Usuario: <security:authentication property="principal.Username"/></h3>
     
		<h4>Tabla de PARAMETROS</h4>
	</div>
<!-- CUERPO GENERAL DE LA PAGINA -->

	<div id="Contenido" class="p-3 mb-2 bg-light text-dark">
	<a href="<c:url value='/j_spring_security_logout'/>">Cerrar sesión</a>

<div id="MainMenu">
		<form action="<c:url value='/Choices'/>">
			<input type="submit" value="Menu principal" class="btn btn-primary"
				id="main" name="nuevo">
		</form>
		
		</div>
		<br> <br> <br>
		<div><h5 id="info"></h5></div>
		<div id="update_and_look">
		<security:authorize ifAnyGranted="ROLE_ADMIN"><!-- OCULTANDO LA PARTE DE ACTUALIZAR -->
			<div id="dato_para_update">
				<td><h5>Dato seleccionado</h5></td>
				<div class="input-group input-group-lg">
				
    <c:url var="Update" value="/UpdateRegionesEjecutar"></c:url>
					<form:form action="${Update}" commandName="regionescommand"
						modelAttribute="regiones">
						
						<div class="input-group-append">
							<form:hidden path="CLAVE" />
							<form:input path="VALOR" class="form-control" id="InputUpdate" type="text"/>
							<form:hidden path="ID_PARAMETRO" class="form-control" id="ID"/>
							<input type="submit" value="Actualizar"
								class="btn btn-success" id="UpdateRegiones" />
						</div>
					</form:form>
				</div>
			</div>
			
			</security:authorize>
		

			<div id="dato_para_buscar">
				<h5>Buscador</h5>
				<input class="form-control" id="search">
			</div>
				
		</div>
		
	
		<br> <br> <br> <br><br>

<div class="table-responsive text-nowrap">

<security:authorize ifAnyGranted="ROLE_ADMIN"> <!-- CON ESTO NO HABILITA DICHA FUNCION A MENOS QUE TENGAS LOS PRIVILEGIOS SUFICIENTES -->
			<button class="btn btn-primary" onclick="document.getElementById('mod').style.display='block'" style="width:auto;">Nuevo parametro</button>
		 </security:authorize>
		 
	<table class="table table-striped w-auto" >
			<tr>
				<!-- TITULOS -->
				<th class="bg-primary" id="id_parametro"><h4>CLAVE</h4></th>
				<th class="bg-primary" id="clave"><h4>VALOR</h4></th>
				<th class="bg-primary" id="clave"><h4>APLICATIVO</h4></th>
				<th class="bg-primary" id="clave"><h4>DESCRIPCIÓN</h4></th>
				<security:authorize ifAnyGranted="ROLE_ADMIN">
				<th class="bg-primary" id="valor"><h4>ACCIÓN</h4></th>
				</security:authorize>
			</tr>
			<!-- DATOS -->
			<tbody id="cuerpo">
			
		    <jsp:include page ="Parametros.jsp"/> <!-- HACE REFERENCIA A OTRA PAGINA QUE TIENE LA TABLA CON EL CONTENIDO QUE DEBERIA IR AQUI-->
			</tbody>
		</table>
</div><br><br><br><br><br><br><br><br><br><br><br>
	</div>
<!-- MODAL PARA AGREGAR -->
<c:url var="NuevoParametro" value="/NuevoParametro" ></c:url>
<div class="modal" tabindex="-1" role="dialog" id="mod">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Registro de nuevo parametro</h5>
      </div>
        	<form:form action="${NuevoParametro}" commandName="regionescommand"
						modelAttribute="regiones">
      <div class="modal-body">
    
      <form:input path="CLAVE" id="CLAVE_ADDING" class="form-control" placeholder="CLAVE"/>
      <h5 id="NO_SE_PUEDE_GUARDAR_CLAVE"></h5>
	  <br><form:textarea path="VALOR" class="form-control"  placeholder="VALOR" id="VALOR_ADDING"/>
	  <h5 id="NO_SE_PUEDE_GUARDAR_VALOR"></h5>
	  <br>
	  <select name="APLICATIVO" background-color="red">
	  <option disabled selected>Opciones</option>
						<option value="TransformaBibes-0.0.1.jar">Transforma Bes</option>
						<option value="Transforma-1.0.jar">Transforma</option>
						<option value="CoreCompPagoBatch-1.0.jar">Core Compago Batch</option>
						<option value="CancelacionCompPagoBatch-1.0.jar" selected="selected">Cancelaciones Batch</option>
						<option value="CMasivaCompPagoBatch-1.0.jar" selected="selected">Carga Masiva</option>
				   <option value="ReingenieriaCompPagoBatch-1.0.jar" selected="selected">Reingenieria</option>
                   <option value="ContabilidadElectronica" selected="selected">Contabilidad electronica</option>  
            	   </select>
	   <h5 id="NO_SE_PUEDE_GUARDAR_APLICATIVO"></h5>
	  <br><form:textarea path="DESCRIPCION" class="form-control"  placeholder="DESCRIPCION" id="DESCRIPCION_ADDING"/>
	   <h5 id="NO_SE_PUEDE_GUARDAR_DESCRIPCION"></h5>
	   <form:hidden path="ID_PARAMETRO" class="form-control" id="ID"/>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal" id="Boton_cerrar" onclick="document.getElementById('mod').style.display='none'">Cerrar</button>
        <button type="submit" class="btn btn-primary" id="Boton_guardar">Guardar Parametro</button>
      </div>
            </form:form>
    </div>
  </div>
</div>
<!-- MODAL PARA AGREGAR -->
	<footer>
		<div id="Pie_de_pagina" align=center class="navbar navbar-fixed-bottom">
		<td><h4>Complemento Pago portal de Aplicativos. Telcel S.A. de
				C.V.</h4></td>
	</div>
	</footer>
<!-- CUERPO GENERAL DE LA PAGINA -->
</body>
</html>