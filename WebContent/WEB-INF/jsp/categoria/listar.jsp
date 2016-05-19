<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- para estruturas de controle e repetição e setar variáveis -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %> <!-- para formatações -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  <!-- para funções -->
 	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listagem de Categoria</title>
</head>
<body>
	<c:url var="url" value="/categoria/form" />
	<a href='${url}'>Novo</a>


	<br />
	<br />
	<br />
	<table>
		<tr>
			<td>Nome</td>
			<td>Ações</td>
		</tr>

		<c:forEach var="categoria" items="${categorias}">

			<tr>
				<td>${categoria.nome}</td>
				<td>
					<!--<a href='remove?id=${categoria.id}'>Remover</a> --> 
					<a href='<c:url value="/categoria/${categoria.id}/remove" />'>remover</a>
					<a href='<c:url value="/categoria/${categoria.id}/form" />'>Editar</a>
			</tr>
		</c:forEach>

	</table>


</body>
</html>