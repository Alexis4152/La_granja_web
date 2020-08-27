<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet"
	href="<c:url value="/resources/Css/DiseñoPrincipal.css"/>"
	type="text/css">
<link>

<link rel="stylesheet"
	href="<c:url value="/resources/Css/jquery.dataTables.min.css"/>"
	type="text/css">
<link>

<script lenguaje="JavaScript" type="text/javascript"
	src="<c:url value="/resources/JavaScript/jquery-3.2.1.js" />"></script>
	
<script lenguaje="JavaScript" type="text/javascript"
	src="<c:url value="/resources/JavaScript/jquery.dataTables.min.js"/>"></script>
	
<link rel="stylesheet"
	href="<c:url value="/resources/bootstrap-4.4.1/css/bootstrap.min.css" />"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
	
	<script lenguaje="JavaScript" type="text/javascript"
	src="<c:url value="/resources/JavaScript/Venta.js" />"></script>

	
<title>Venta.</title>
</head>
<body>
<!-- MENU ENCABEZADO -->
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
				   
				   
					<li class="nav-item active"><a class="nav-link" href="<c:url value='Venta'/>">Ventas</a></li>
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
			<!-- INICIA UNIÓN TABLA VENTA Y BOTONES PARA ABRIR LOS MODALES -->
	<br><br>
	<div id="Tabla_ventas_y_Botones_productos">
	<!-- BOTONES PARA ABRIR LOS TIPOS DE PRODUCTOS -->
	<div id="Botones_tipos_de_productos">
	<button class="btn btn-primary" id="Boton_crudo">Crudo</button>
	<button class="btn btn-primary" id="Boton_cocido">Cocido</button>
	<button class="btn btn-primary" id="Boton_adicionales">Acompañantes</button>
	</div>
	<!-- BOTONES PARA ABRIR LOS TIPOS DE PRODUCTOS -->
	
	<!-- INICIA TABLA DE VENTA ACTUAL -->
	<div id="Tabla_ventas_actuales">
	<div class="table-responsive text-nowrap"><!--   table-wrapper-scroll-y my-custom-scrollbar-->
	<table class="table table-striped w-auto"><!--  table w-auto table-hover-->
		<thead>
		<tr>
			<th>PRODUCTO</th>
			<th>CANTIDAD</th>
			<th>PRECIO</th>
			<th>IMPORTE</th>
			<th>ACCIÓN</th>
		</tr>
		</thead>
		<tbody>
			<c:forEach items="${Productos_en_venta}" var="RUN">
			<tr>
			<td>${RUN.NOMBRE_PRODUCTO}</td>
			<td>${RUN.CANTIDAD}</td>
			<td>${RUN.PRECIO}</td>
			<td>${RUN.IMPORTE}</td>
			<td>
			<a href="<c:url value='ELIMINAR_PRODUCTO_DE_VENTA/${RUN.ID_PRODUCTO}'/>"><img
			src="<%=request.getContextPath()%>/resources/Icons/Nuevos/Delete.png"></img></a>
			</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
	
	<div id="Opciones_de_venta">
	<form action="<c:url value='/LIMPIAR_TODA_LA_VENTA'/>"><!-- BOTÓN PARA LIMPIAR TODA LA VENTA -->
		<input type="submit" value="Limpiar venta"
					class="btn btn-outline-danger">
	</form> 
	</div>
	<c:url var="AGREGAR_VENTA" value="/PAGAR_VENTA" ></c:url>
	<div id="Totales_de_venta"><!-- INICIA GRUPO DE TOTALES DE VENTA -->
<form:form action="${AGREGAR_VENTA}" commandName="Ventacommand"
						modelAttribute="Venta">
	<div class="input-group mb-3"><!-- INICIA DATOS DEL SUBTOTAL -->
  <div class="input-group-prepend">
 <span class="input-group-text" id="inputGroup-sizing-default">Subotal</span>
</div>
  <form:input path="SUBTOTAL"  value="${Total}" class="form-control" readonly="true" disable="true" id="Monto_del_subtotal"/><!--  -->
</div><!-- TERMINA DATOS DEL SUBTOTAL -->
	<div class="input-group mb-3"><!-- INICIA DATOS DEL DESCUENTO -->
	 <div class="input-group-prepend">
 <span class="input-group-text" id="inputGroup-sizing-default">Descuento</span>
</div>
    <form:input path="DESCUENTO" class="form-control"  id="Monto_del_descuento"/>
</div><!-- TERMINA DATOS DEL DESCUENTO -->
<div class="input-group mb-3"><!-- INICIA DATOS DEL TOTAL -->
  <div class="input-group-prepend">
 <span class="input-group-text" id="inputGroup-sizing-default">Total</span>
</div>
  <form:input path="TOTAL" value="${Total}" class="form-control"  readonly="true" disable="true" id="Monto_del_total"/>
</div><!-- TERMINA DATOS DEL TOTAL -->
	<div class="input-group mb-3"><!-- INICIA DATOS DEL PAGO -->
  <div class="input-group-prepend">
    <button class="btn btn-outline-primary" type="submit" id="Pagar_venta">Pagar venta</button>
  </div>
  <form:input path="PAGO" class="form-control" id="Monto_del_pago"/>
</div><!-- TERMINA DATOS DEL PAGO -->
	<div class="input-group mb-3"><!-- INICIA DATOS DEL CAMBIO -->
  <div class="input-group-prepend">
 <span class="input-group-text" id="inputGroup-sizing-default">Cambio</span>
</divZ>
<form:input path="CAMBIO" class="form-control" readonly="true" disable="true" id="Monto_del_cambio"/></div><!-- TERMINA DATOS DEL CAMBIO -->
</form:form>
	</div><!-- TERMINA GRUPO DE TOTALES DE VENTA -->
	</div><!-- TERMINA TABLA DE VENTA ACTUAL -->
	</div><!-- TERMINA UNIÓN TABLA VENTA Y BOTONES PARA ABRIR LOS MODALES -->
	
	
<!-- MODAL PARA MOSTRAR PRODUCTOS -->
<c:url var="NuevoParametro" value="/NuevoParametro" ></c:url>
<!-- INICIO DEL MODAL DE PRODUCTOS-->
<div class="modal" tabindex="-1" role="dialog" id="mod" aria-labelledby="mod" aria-hidden="true">
  <div class="modal-dialog modal-dialog-scrollable" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Crudo</h5>
      </div>
      <div class="modal-body">
    
     <div class="table-wrapper-scroll-y my-custom-scrollbar">
	   <table class="table table-striped table-bordered table-sm">
		<thead>
		<tr>
			<th>NOMBRE</th>
			<th>PRECIO</th>
			<th>AGREGAR A VENTA</th>
		</tr>
		</thead>
		<tbody id="Products_body">
			 <jsp:include page ="Productos_por_categoria.jsp"/>
		</tbody>
	   </table>
	     </div>
      </div>
      
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal" id="Boton_cerrar" onclick="document.getElementById('mod').style.display='none'">Cerrar</button>
      </div>
    </div>
  </div>
</div>
	</div>
	<!-- MENU ENCABEZADO -->

<!-- FIN DEL MODAL DE PRODUCTOS-->
</body>
</html>