<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="modelo.Usuario" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% Usuario usuario= (Usuario) request.getAttribute("Usuario");
		
	%>
<body> <form  action="" method="post" >
		<label>ID</label> 
		<input type="hidden" name="id" placeholder="id" value="<%= usuario.getId() %>"> <%= usuario.getId() %>
		<br>
		<label>Nombre</label>
		<input type="text"  name="nombre" placeholder="nombre" value="<%= usuario.getNombre() %>">
		<input type="submit" value="Modificar">
		</form>
		<form action="EMV">
			<input type="submit" value="Volver">
		</form>
		
		<p>una vez modifique vuelva a la pagina anterior con el boton volver para que se actualize el usuario</p>
</body>
</html>