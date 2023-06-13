<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body align="center">
<h1><%= "Authorization" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
<form action="hello-servlet" method="post" align="center">
    <label>username</label><br>
    <input type="text" name="username" required><br><br>
    <label>password</label><br>
    <input type="password" name="password" required><br><br>
    <input type="submit" value="Sing in">
</form>
</body>
</html>