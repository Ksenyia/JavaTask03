<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <jsp:useBean id = "naming" class="by.tc.task03.modal.Person"
  type = "java.lang.Object" scope = "request"/>
  <c:if test="${request.Scope.naming==null}">
  	<p>Name not found<p>
  </c:if>
	<table border="1">
  <tr border="1">
    <td>name</td>
    <td>surname</td>
    <td>phone number</td>
    <td>e-mail</td>
  </tr border="1">
    <tr>
    <td><jsp:getProperty property="name" name="naming"/></td>
    <td><jsp:getProperty property="surname" name="naming"/></td>
    <td><jsp:getProperty property="phoneNumber" name="naming"/></td>
    <td><jsp:getProperty property="email" name="naming"/></td>
  </tr>
</table>
</body>
</html>