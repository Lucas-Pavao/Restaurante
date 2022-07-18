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
	<h1>${msg2}</h1>
<h1>Menu de ajustes</h1>
<a href="/">Inicio</a><br>
</div>
<div class = "bloco-direita">
<div class="card">

	
	<button class="btn"><a href = "/adm/telaAdms">Visualizar administradores cadastrados</a></button><br>
	<button class="btn"><a href = "/adm/telaPratos">Cadastrar pratos</a></button><br>
	<button class="btn"><a href = "/adm/telaClientes">Visualizar clientes cadastrados</a></button><br>
		<button class="btn"><a href = "/adm/telaPagamentos">Cadastrar formas de pagamento</a></button><br>
	<h1>${msg4}</h1>
	<h1>${msg5}</h1>
	</div>
</div>	
</div>
</body>
</html>