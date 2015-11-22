<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table, tr, td{
		border:1px solid brown;
	}
</style>
</head>
<body>
	<table>
		<tr>
			<td>ISBN</td>
			<td>제목</td>
			<td>가격</td>		
		</tr>
		<c:forEach var="books" items="${requestScope.booklist}" varStatus="status">
			<c:if test="${status.count % 2 == 0}">
				<tr style="background:#eeeeff">
			</c:if>
			<c:if test="${status.count % 2 != 0}">
				<tr style="background:#dedede">
			</c:if>
					<td>${books.isbn}</td>
					<td>${books.title}</td>
					<td>${books.price}</td>
				<tr>
		</c:forEach>
		<tr>
			<td><c:out value="${books.isbn}" default="12345"/></td>
		    <td><c:out value="${books.title}" default="초보웹개발자를 위한 스프링 4"/></td>
		    <td><c:out value="${books.price}" default="20.00"/></td>
		</tr>
		<tr>
			<td><c:set value="9838293323847293" var="isbn" />${isbn}</td>
			<td><c:set value="Hello JSP" var="title" />${title}</td>
			<td><c:set value="12.2" var="price" />${price}</td>
		</tr>
		<tr>
			
		</tr>
	</table>
</body>
</html>