<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<a href="/register">Zarejestruj</a>
<form:form method="post"
           modelAttribute="user">
    <label>Login</label>
    <form:input path="login" placeholder="Login or Email"/>
    <form:errors path="login"/><br/>
    <label>Password</label>
    <form:input type="password" path="password" placeholder="Password"/>
    <form:errors path="password"/><br/>
    ${error}
    <input type="submit" value="Login">
</form:form>

</body>
</html>


