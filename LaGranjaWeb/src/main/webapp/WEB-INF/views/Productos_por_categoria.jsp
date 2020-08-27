<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%><!-- CON ESTO SE HABILITA LA SEGURIDAD PARA LA VISTA -->
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:forEach items="${Productos}" var="RUN">
	<tr>
		<td>${RUN.NOMBRE_PRODUCTO}</td>
		<td>${RUN.PRECIO}</td>
		<td>
			<a href="<c:url value='/AGREGAR_PRODUCTO_A_VENTA/${RUN.ID_PRODUCTO}/${RUN.NOMBRE_PRODUCTO}/${RUN.PRECIO}'/>"><img
			src="<%=request.getContextPath()%>/resources/Icons/Nuevos/Agregar.png"></img></a>
		</td>
	</tr>
</c:forEach>
<!-- 
-->