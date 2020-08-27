<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script type="text/javascript">

</script>
<link rel="stylesheet"
	href="<c:url value="/resources/Css/DiseñoPrincipal.css"/>"
	type="text/css">
<link>


<link rel="stylesheet"
	href="<c:url value="/resources/bootstrap-4.4.1/css/bootstrap.min.css" />"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">

<script lenguaje="JavaScript" type="text/javascript"
	src="<c:url value="/resources/JavaScript/jquery-3.2.1.js" />"></script>


<script type="text/javascript" lenguaje="JavaScript"  src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>

<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css"><link>

	<script lenguaje="JavaScript" type="text/javascript"
	src="<c:url value="/resources/JavaScript/ListaVentasRealizadas.js" />"></script>
	 

<!-- 
<script lenguaje="JavaScript" type="text/javascript"
	src="<c:url value="/resources/JavaScript/jquery-3.2.1.js" />"></script>
	
<script lenguaje="JavaScript" type="text/javascript"
	src="<c:url value="/resources/JavaScript/jquery.dataTables.min.js"/>"></script>
<link rel="stylesheet"
	href="<c:url value="/resources/Css/jquery.dataTables.min.css"/>"
	type="text/css">
<link>
 -->
	
	
<title>Ventas realizadas.</title>
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
<label>Lista de ventas</label>
	<!-- INICIA TABLA DE VENTA ACTUAL -->
	<div ><!-- id="Tabla_ventas_actuales" -->
	<div>
	
	</div>
	</div><!-- TERMINA TABLA DE VENTA ACTUAL -->
	
	

	</div>
	<table  id="VENTAS_REALIZADAS"><!-- class="table w-auto table-hover table-responsive-sm" -->
		<thead>
		<tr>
			<th>VENTA</th>
			<th>SUBTOTAL</th>
			<th>DESCUENTO</th>
			<th>TOTAL</th>
			<th>PAGO</th>
			<th>CAMBIO</th>
			<th>FECHA</th>
			<th>OPCIONES</th>
		</tr>
		</thead>
		<tbody>
		</tbody>
	</table>
	<!-- MENU ENCABEZADO -->

<!-- FIN DEL MODAL DE PRODUCTOS-->
</body>
</html>