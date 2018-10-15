<%@page
	import="com.nissan.training.advancedjava.assignment.RegistrationBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration success</title>
<style>
	.heading {
		background-color: #293333;
	    color: #fff;
	    padding: 3px 6px;
    }
</style>
</head>
<body>
	<p class='heading'>You have successfully registered!</p>
	<%
		RegistrationBean bean = (RegistrationBean) request.getAttribute("user");
	%>
	<p>Welcome <%= bean.getFname() %> <%= bean.getLname() %></p>
	<p>Email: <%= bean.getEmail() %></p>
	<p>Mobile: <%= bean.getMobile() %>
</body>
</html>