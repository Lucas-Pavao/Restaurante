<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
	<h1>Cliente de cpf ${cliente.cpf}</h1>
	<a href = "/">home</a><br>
	<a href = "/adm/telaClientes">Clientes cadastrados</a><br>
</div>
<div class = "bloco-direita">
<div class="card">


	<div class="textformfield">
	<label>Nome: ${cliente.nome}</label><br>
	<label>Telefone: ${cliente.telefone}</label><br>
	<label>E-mail: ${cliente.email}</label><br>
	</div>
	
	</div></div></div>
</body>
</html>