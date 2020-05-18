<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品一覧</title>
<style>
td,th {
	border:1px solid gray;
	padding:0.2em 0.5em;
}
table {
	border-collapse: collapse;
}

</style>
</head>
<body>
<h1>商品一覧</h1>

<table>
<tr><th>商品ID</th><th>商品名</th><th>単価</th></tr>
<c:forEach var="shouhin" items="${list}">
	<tr>
		<td>${shouhin.sid}</td>
		<td>${shouhin.sname}</td>
		<td>${shouhin.tanka}</td>
	</tr>
</c:forEach>
</table>

</body>
</html>