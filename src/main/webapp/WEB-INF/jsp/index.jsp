<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css">
<style><%@include file="/WEB-INF/jsp/style.css"%></style>
</head>
<body>

<div class="bloco">
<div class = "bloco-esquerda">
	<h1>RESTAURANTE CAÓTICO</h1>
</div>
<div class = "bloco-direita">
<div class="card">
	<button class="btn"> <a href="/cliente/telaCadastro">Cadastrar um cliente </a></button><br>
	<button class="btn"><a href="/cliente/telaLogin">Fazer Login como cliente</a></button><br>
	<button class="btn"><a href="/adm/telaCadastro">Cadastrar um administrador</a></button><br>
	<button class="btn"><a href="/adm/telaLogin">Fazer Login como administrador</a></button><br>
</div>
</div>	
</div>
	<h2>${msg}</h2>
	
</body>
</html>