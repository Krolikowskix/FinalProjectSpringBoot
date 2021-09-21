<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>UserRegister</title>
</head>
<body>

<form:form method="post"
           modelAttribute="user">
    <label>Name</label>
    <form:input path="name" placeholder="Name"/>
    <form:errors path="name"/><br/>
    <label>Surname</label>
    <form:input path="surname" placeholder="surname"/>
    <form:errors path="surname"/><br/>
    <label>Login</label>
    <form:input path="login" placeholder="login"/>
    <form:errors path="login"/><br/>
    <label>Email</label>
    <form:input path="email" placeholder="email"/>
    <form:errors path="email"/><br/>
    <label>Password</label>
    <form:input path="password" placeholder="password"/>
    <form:errors path="password"/><br/>
    <input type="submit" value="Register">
</form:form>

</body>
</html>

