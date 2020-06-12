<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
<h2></h2>
<html>
<body>
<h2></h2>
<!-- ESTE METODO SOLO REDIRECCIONAD A LA PAGINA DE INICIO.JSP NUNCA ENTRA A  ESTA PAGINA --> 
<form action="<c:redirect url = "Login"/>" method="get">
	<input type="submit" value="ABRE FORM"/>
</form>
</body>
</html>

</body>
</html>
