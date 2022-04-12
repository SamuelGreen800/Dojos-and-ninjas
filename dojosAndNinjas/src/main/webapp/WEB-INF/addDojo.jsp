<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Dojo</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
<h1 class="text-center text-primary fw-bold">New Dojo:</h1>
	
	<div class="container col-6 shadow my-4 mx-auto border border-secondary p-4 bg-light">
	
	<form:form action="/dojos" method="post" modelAttribute="dojo">

    <p>
        <form:errors path="name" class="text-danger"/>
        <form:label path="name">Location</form:label>
        <form:input type="text" path="name"/>
    </p>
    
    <input type="submit" value="Submit"/>
    
</form:form>    

		<table class="table table-striped table-light  shadow p-3 mb-5 rounded">
			<tr>
				<th>Location</th>
				
				
				<th>Actions</th>
			</tr>
			
			<c:forEach var="eachDojo" items="${dojos}">
			
				<tr>
					<td><c:out value="${eachDojo.name}"/></td>
					<td><a href="/dojos/<c:out value="${eachDojo.id}"/>" class="btn btn-sm btn-success">See students</a> 
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
		<div class=" container col-12 text-center">
		<a href="/ninjas" class="btn text-center btn-primary">Create a Ninja</a>
		</div>


</body>
</html>