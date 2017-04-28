<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shop Baby Products</title>
</head>
<body>
<form action="ProductController" method="post">
	Search Baby Products:*enter multiple names with , separate
	</br>
	<input type="text" name="prodname"/>
	<input type="submit" name="Serch" value = "Search"/>
</form>

<%
	String result = request.getParameter("result"); 
	if(result!=null){
%>

Search result:<%= result %>
<%	} %>
<%= result %>
</body>
</html>