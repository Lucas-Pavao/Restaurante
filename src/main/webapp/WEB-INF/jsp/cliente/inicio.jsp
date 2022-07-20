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
	
<h1>${msg2}</h1>
<h1>Menu do restaurante</h1>
	<a href="/">Inicio</a>
</div>
<div class = "bloco-direita">
<div class="card">
<table border="1">
		
		<tr><th>id</th><th>nome</th><th>descricao</th><th>preco<th><th>operações<th></tr>
	
		<c:forEach items="${prato}" var="item">
			<tr>
				<td>${item.id_prato}</td>
				<td>${item.nome}</td>
				<td>${item.descricao}</td>
				<td>${item.preco}</td>
			</tr>
		</c:forEach>
		
	</table>
</div>
</div>	
</div>
</body>
</html>