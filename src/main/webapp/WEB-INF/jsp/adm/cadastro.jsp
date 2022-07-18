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
		<div class="bloco-esquerda">
			<h1>Cadastro de Administradores</h1>
			<a href="/">Inicio</a>
		</div>
		<div class="bloco-direita">
			<div class="card">
				<form method="post" action="/adm/cadastro">
					<div class="textformfield">
						<label for="cpf">CPF</label>
						<input type="text" name="cpf" placeholder="CPF" /> 
					</div>
					<div class="textformfield">
						<label for="Nome">Nome</label>
						<input type="text"name="nome" placeholder="Nome"/> 
					</div>
					<div class="textformfield">	
						<label for="Telefone">Telefone</label>
						<input type="text" name="telefone" placeholder="Telefone"/>
					</div>
					<div class="textformfield">
						<label for="E-mail">E-mail</label>
						<input type="text" name="email" placeholder="E-mail"/> 
					</div>
					<div class="textformfield">
						<label for="Senha">Senha</label>
						<input type="password" name="senha" placeholder="Senha"/> 
					</div>
					<input class="btn" type="submit" value="cadastrar" />
				</form>
			</div>
		</div>
	</div>
</body>
</html>