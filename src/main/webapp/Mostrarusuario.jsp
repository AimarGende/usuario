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
	<%Usuario usuario= (Usuario) request.getAttribute("usuario"); %>
	<table class="table ">
		<tr>
			<th scope="row">ID</th>
			<th scope="row">NOMBRE</th>
			<th scope="row">CONTRASEÑA</th>
			<th scope="row">MODIFICAR</th>
			<th scope="row">ELIMINAR</th>
		</tr>
		<tr>
				<td scope="row"><%out.println(usuario.getId()); %></a></td>
				<td><%out.println(usuario.getNombre()); %></td>	
				<td><%= usuario.getContrasena() %></td>
				<td ><a href="ModificarUsuarioForm?id=<%out.println(usuario.getId());%>"> <img alt="" src="https://static.vecteezy.com/system/resources/previews/019/896/650/non_2x/pencil-drawing-doodle-sketch-line-png.png" width="50"> </a></td>		
				<td><a href="EliminarUsuario?id=<%out.println(usuario.getId());%>"> <img alt="" src="https://cdn.pixabay.com/photo/2023/03/12/10/36/forbidden-7846398_640.png" width="50"> </a></td>	
		</tr>  
	</table>
	
	<div class="botones">
		<form action="Principal">
		<input type="submit" value="Volver" class="btn btn-secondary">
		</form>
	</div>
</body>
</html>