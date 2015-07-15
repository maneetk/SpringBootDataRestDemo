<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Person Details</title>
</head>
<body>
  <h2>Person Details</h2>
  <br/><br/>
  <c:if test="${not empty personList}">
	<table>
  	  <tr>
	  	  <th>Person Id</th>
	  	  <th>First Name</th>
	  	  <th>Last Name</th>
  	  </tr>
	  <c:forEach items="${personList}" var="person">
		  <tr>
		  	<td>${person.id}</td>
		  	<td>${person.firstName}</td>
		  	<td>${person.lastName}</td>
		  </tr>
	  </c:forEach>
	</table>
  </c:if>
</body>
</html>