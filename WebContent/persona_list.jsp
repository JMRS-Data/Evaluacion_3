<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Persona List</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>
			<form action="PersonaController">
				<input type="submit" name="btn_new" value="New"/>
			</form>
			<a href="PersonaReport">Imprimir Reporte</a>
			</th>
			<th>Id</th>
			<th>Nombre</th>
			<th>Edad</th>
			<th>Peso</th>
		</tr>
		<c:forEach var="persona" items="${personas}">
			<tr>
				<td>
					<form action="PersonaController">
						<input type="hidden" name="id" value="${persona.id}"/>
						<input type="submit" name="btn_edit" value="Edit"/>
						<input type="submit" name="btn_delete" value="Delete"/>
					</form>
				</td>
			
			<td>${persona.id}</td>
			<td>${persona.nombre}</td>
			<td>${persona.edad}</td>
			<td>${persona.peso}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>