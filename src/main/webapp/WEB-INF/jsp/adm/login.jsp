<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style><%@include file="/WEB-INF/jsp/style.css"%></style>
<title>Insert title here</title>
</head>
<body>

		<div class="bloco">
<div class = "bloco-esquerda">
	<h1>Login de Administradores</h1>
	<a href="/">Inicio</a>
</div>
<div class = "bloco-direita">
<div class="card">

	<form method="post" action="/adm/login">
	<div class="textformfield">
		<label for="Email">E-mail</label>
		<input type="text" name="email"/>
		</div>
		<div class="textformfield">
		<label for="Senha">Senha</label>
		<input type="password" name="senha"/>		
		</div>
		<input class="btn" type = "submit" value="Entrar"/><br>
	
		<h1>${msg3}</h1>
	
	</form>
	</div>
</div>	
</div>
</body>
</html>