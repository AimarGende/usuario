<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<body> <form  action="ModificarUsuario" method="get">
		<label>ID</label> 
		<input type="hidden" name="id" placeholder="id" value="${usuario.id}"> ${usuario.id} 
		<br>
		<label>Nombre</label>
		<input type="text"  name="nombre" placeholder="nombre" value="${usuario.nombre}">
		<br>
		<label>Contraseña</label>
		<input type="text"  name="contrasena" placeholder="contraseña" value="${usuario.contrasena}">
		<br>
		<label>Fecha-login</label>
		<input type="date"  name="fecha" placeholder="fecha" value="${usuario.fecha_login}">
		<br>
		<select name="rol">
			<c:forEach items="${roles}" var="rol">
				<c:choose>
					<c:when test="${usuario.rol.id==rol.id}">
						<option selected value="${rol.nombre}">${rol.nombre}</option>
					</c:when>
					<c:when test="${usuario.rol.id!=rol.id}">
						<option value="${rol.nombre}">${rol.nombre}</option>
					</c:when>
				</c:choose>
				
			</c:forEach>
		</select>
		<input type="submit" value="Modificar">
		</form>
		
		<form action="Principal">
			<input type="submit" value="Volver" class="btn btn-secondary">
		</form>
	
</body>
</html>