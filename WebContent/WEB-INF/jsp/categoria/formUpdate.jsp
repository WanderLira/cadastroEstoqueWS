<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- para estruturas de controle e repeti��o e setar vari�veis -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- para formata��es -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!-- para fun��es -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Categoria</title>
</head>
<body>
	<c:url var="url" value="/categoria/update" />

	<br />
	<form:form method="post" action="${url}" modelAttribute="categoria">
		<form:hidden path="id" />
		<table>

			<tr>
				<td>Nome</td>
				<td><form:input path="nome" /></td>
			</tr>

			<tr>
				<td><input type='submit' value='Atualizar' /></td>
				<td></td>
			</tr>

		</table>

	</form:form>
</body>
</html>