<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/css/materialize.min.css">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body class="flow-text">
	<h2>Añadir</h2>
	
	<hr />
	
	<form action="Insertar" method="post">
		<div>Mail: <input type="email" name="mail" /></div>
		<div>Categoria: 
		<select name="categoria">
			<option selected="selected">Seleccionar</option>
			<option value="1">Actualidad</option>
			<option value="2">Tecnologia</option>
			<option value="3">Deportes</option>
			<option value="4">Teatro</option>
			<option value="5">Informatica</option>
		</select>
		</div>
		<div>Titulo: <input type="text" name="titulo" /></div>
		<div>Contenido: <textarea name="contenido"></textarea></div>
		<div><input class="btn btn-floating btn-large cyan pulse" type="submit" value="Publicar" /></div>
	</form>
	
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/js/materialize.min.js"></script>
	<script type="text/javascript">
	$(document).ready(function() {
	    $('select').material_select();
	  });
	</script>
</body>
</html>