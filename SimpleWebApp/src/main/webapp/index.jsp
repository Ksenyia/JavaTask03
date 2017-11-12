<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
<body>
<hr/>
<form action="ControllerServlet" method = "post">
	<input type = "hidden" name = "command" value = "naming" /><br/>Введите имя:
	<input type = "text" name = "name" value = "" /><br/>Введите фамилию:
	<input type = "text" name = "surname" value = "" /><br/>
	<input type="submit" value="send"/><br/>
</form>
</body>
</html>
