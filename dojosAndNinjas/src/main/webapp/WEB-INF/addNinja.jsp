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
<title>New Ninja</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

	<h1 class="text-center text-primary fw-bold">New Ninja:</h1>
	
	<div class="container col-6 shadow my-4 mx-auto border border-secondary p-4 bg-light">
	
	<form:form action="/ninjas" method="post" modelAttribute="ninja">
		

    <p>
        <form:errors class="text-danger" path="first_name"/>
        <form:label path="first_name">First Name</form:label>
        <form:input type="text" path="first_name"/>
    </p>
    
    <p>
        <form:errors class="text-danger" path="last_name"/>
        <form:label path="last_name">Last Name</form:label>
        <form:input type="text" path="last_name"/>
    </p>
    
    <p>
        <form:errors class="text-danger" path="age"/>
        <form:label path="age">Age</form:label>
        <form:input type="number" path="age"/>
    </p>
    
    <p>
        <form:errors class="text-danger" path="dojo"/>
        <form:label path="dojo">Dojo</form:label>
        <form:select  path="dojo">
        		<c:forEach var="eachDojo" items = "${dojos}">
        			<form:option value="${eachDojo.id}"><c:out value="${eachDojo.name}"/></form:option>        		
        		</c:forEach>
        	</form:select>
    </p>
    <input type="submit" class="btn shadow btn-primary" value="Submit"/>
    </form:form>    
    
    
</div><div class="text-center">
    <a href="/dojos" class="btn shadow btn-primary">Home</a>
    </div>
</body>
</html>