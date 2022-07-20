<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<h1>Pedidos cadastrados</h1>
	<a href = "/">home</a>
</div>
<div class = "bloco-direita">

	<div class="card">	
	<table border="1">
		
		<tr><th>id</th><th>data/Hora</th><th>Descricao</th><th>Preco<th></tr>
	
		<c:forEach items="${pedido}" var="item">
			<tr>
				<td>${item.id}</td>
				<td>${item.datahora}</td>
				<td>${item.observacao}</td>
				<td>${item.preco}</td>
				<td>${item.id_cliente}</td>
				<td>${item.id_prato}</td>
				<td>${item.id_pagamento}</td>
				</tr>
		</c:forEach>
		
	</table>
		</div>
</div>	
</div>
</body>
</html>