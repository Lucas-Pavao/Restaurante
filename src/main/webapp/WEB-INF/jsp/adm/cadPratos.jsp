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
<h1>Cadastro de pratos</h1>
	<a href="/">Inicio</a>

</div>
<div class = "bloco-direita">
<div class="card">

	<form method="post" action="/adm/cadPratos">
	<div class="textformfield">
		<label for="nome">Nome</label>
		<input type="text" name="nome"/>
		</div>
		<div class="textformfield">
		<label for="descricao">Descrição</label>
		<input type="text" name="descricao"/>
		</div>
		<div class="textformfield">
		<label for="preco">Preço</label>
		<input type="text" name="preco"/>
		</div>
		<input class="btn" type = "submit" value="cadastrar"/>
	
	</form>
	</div>
</div>	
</div>
</body>
</html>