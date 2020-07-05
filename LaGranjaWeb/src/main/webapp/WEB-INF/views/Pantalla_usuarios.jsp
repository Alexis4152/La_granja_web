<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pantalla usuarios.</title>
</head>
<body>
	<table>
		<thead>
			<th>ID_USUARIO</th>
			<th>USUARIO</th>
			<th>CONTRASEÑA</th>
			<th>ROL DE USUARIO</th>
			<th>¿ESTÁ DISPONIBLE?</th>
		</thead>
		<tbody>
			<c:forEach items="${LISTA_USUARIOS}" var="RUN">
			<tr>
			<td>${RUN.ID_USER}</td>
			<td>${RUN.USERNAME}</td>
			<td>${RUN.PASSWORD}</td>
			<td>${RUN.ROLE_USER}</td>
			<td>${RUN.HABILITADO}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>