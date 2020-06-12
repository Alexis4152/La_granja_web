<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%><!-- CON ESTO SE HABILITA LA SEGURIDAD PARA LA VISTA -->

<c:forEach items="${regionesestatico}" var="verregiones">
				<!-- EN EL CASO CUANDO EL ARREGLO NO ESTÉ VACIO -->
				<tr>
					<!-- <td>${verregiones.ID_PARAMETRO}</td>-->
					<td>${verregiones.CLAVE}</td>
					<td>${verregiones.VALOR}</td>
					<td>${verregiones.APLICATIVO}</td>
					<td>${verregiones.DESCRIPCION}</td>
					<c:if test="${verregiones.ID_PARAMETRO!=5000}">
					<security:authorize ifAnyGranted="ROLE_ADMIN">
					
			 		  <td>	
					  	<!-- SE PROTEGE EL BOTÓN DE SELECCIONAR UN PARAMETRO PARA QUE NO PUEDA SER MANDADO A LA PARTE DE ACTUALIZAR -->
				  <form action="<c:url value='/MandarValorRegionesEjecutar/${verregiones.ID_PARAMETRO}'/>">
			<input type="submit" value="Seleccionar" class="btn btn-outline-success"
				id="Select_value" name="nuevo">
		</form>
			  <form action="<c:url value='/EliminarParametro/${verregiones.ID_PARAMETRO}'/>">
			<input type="submit" value="Eliminar     " class="btn btn-outline-danger"
				id="Select_value" name="nuevo" onclick="confirmacion()">
		</form>
		</td>
		 </security:authorize>
					</c:if>
					<c:if test="${verregiones.ID_PARAMETRO==5000}">
					<security:authorize ifAnyGranted="ROLE_ADMIN">
					<td></td>
					 </security:authorize>
					</c:if>
				</tr>
			</c:forEach>