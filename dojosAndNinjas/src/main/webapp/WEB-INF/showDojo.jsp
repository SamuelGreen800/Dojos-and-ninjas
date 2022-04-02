<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dojo Roster</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
<h1><c:out value="${dojo.name}"/></h1>
	
	
	
	<table class="table table-striped table-light  shadow p-3 mb-5 rounded">
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Age</th>
				<th>Actions</th>
			</tr>
			<tr>
			
			<c:forEach var="ninja" items="${dojo.ninjas}">
			
				<tr>
					<td><c:out value="${ninja.first_name}"/></td>
					<td><c:out value="${ninja.last_name}"/></td>
					<td><c:out value="${ninja.age}"/></td>
					<td><form action="/delete/<c:out value ="${ninja.id}"/>" method="post">
					    <input type="hidden" name="_method" value="delete">
					    <input type="submit" value="Delete" class=" btn btn-sm btn-danger">
					</form></td>
				</tr>
			</c:forEach>
		</table>
	<div class="text-center">
    <a href="/dojos" class="btn shadow btn-primary">Home</a>
    </div>
</body>
</html>