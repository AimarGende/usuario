<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Getsion Usuarios</title>
<style type="text/css">

	.Tabla{
		margin:0 auto;
		width:25vw;
		display: flex;
		flex-direction:column;
  	  	justify-content: space-evenly;
    	align-items: center;
	}
	.Tabla form{
		margin-top:6px;
		margin-bottom:6px;
	}

</style>
</head>
<body>
<div class="Tabla">
	<form action="CrearUsuario">
	<input type="submit" value="Crear Usuario">
	</form>
	<form action="EMV">
	<input type="submit" value="Eliminar/Modificar/Ver Usuarios">
	</form>
</div>
</body>
</html>