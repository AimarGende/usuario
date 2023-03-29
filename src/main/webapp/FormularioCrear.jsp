<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Crear Usuario</title>
</head>
<body> <form action="" method="POST">
		<input type="text"  name="nombre" placeholder="nombre">
		<br>
		<br>
		<input type="text"  name="contrasena" placeholder="contraseña"><p>la contraseña tiene que tener 8 digitos, entre ellos un numero</p>
		<br>
		<br>
		<input type="date" name="fecha" placeholder="fecha">
		<br>
		<br>
		<select name="rol">
			<c:forEach items="${roles}" var="rol">
				<option value="${rol.nombre}">${rol.nombre}</option>
			</c:forEach>
		</select>
		<br>
		<br>
		<input type="submit" value="Crear">
		</form>
		<br>
		<form action="Principal">
			<input type="submit" value="Volver">
		</form>
		
</body>
</html>