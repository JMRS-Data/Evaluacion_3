<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Persona Form</title>
</head>
<body>
	<form action="PersonaController">
	
		<label>Nombre:</label><br/>
		<input type="text" name="nombre" value="${persona.nombre}"/><br/>
		<label>Edad:</label><br/>
		<input type="text" name="edad" value="${persona.edad}"/><br/>
		<label>Peso:</label><br/>
		<input type="text" name="peso" value="${persona.peso}"/><br/>
		<input type="submit" name="btn_save" value="Save"/>
	</form>
</body>
</html>