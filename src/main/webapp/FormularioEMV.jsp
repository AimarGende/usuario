<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="modelo.Usuario" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Ver/Eliminar/Modificar usuarios</title>

<style >
.botones{
	display: flex; 
	gap: 20px;
}

form{
	display:inline-block;
}
</style>

</head>
<body>
	<table class="table ">
		<tr>
			<th scope="row">ID</th>
			<th scope="row">NOMBRE</th>
			<th scope="row">CONTRASEÑA</th>
			<th scope="row">MODIFICAR</th>
			<th scope="row">ELIMINAR</th>
		</tr>
		<%
		ArrayList<Usuario> usuarios= (ArrayList<Usuario>) request.getAttribute("usuarios");
		for(Usuario usu: usuarios){
			%><tr>
				<td scope="row"><%out.println(usu.getId()); %></a></td>
				<td><%out.println(usu.getNombre()); %></td>	
				<td><%= usu.getContrasena() %></td>
				<td ><a href="ModificarUsuarioForm?id=<%out.println(usu.getId());%>"> <img alt="" src="https://static.vecteezy.com/system/resources/previews/019/896/650/non_2x/pencil-drawing-doodle-sketch-line-png.png" width="50"> </a></td>		
				<td><a href="EliminarUsuario?id=<%out.println(usu.getId());%>"> <img alt="" src="https://cdn.pixabay.com/photo/2023/03/12/10/36/forbidden-7846398_640.png" width="50"> </a></td>	
			</tr>  <%
			
		}
		%>
	</table>
	<div class="botones">
		<form action="Principal">
		<input type="submit" value="Volver" class="btn btn-secondary">
	</form>
	
	<form action="VerUsuario">
		<input type="submit" value="Ver" class="btn btn-secondary">
	</form>
	
	</div>

</body>
</html>