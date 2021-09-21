<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title> Add Item</title>
</head>
<body>
<a href="/logout">Wyloguj</a>
<form:form method="post"
           modelAttribute="car">
    <label>name</label>
    <form:input path="name" placeholder="Name"/>
    <form:errors path="name"/><br/>
    <label>Model</label>
    <form:input path="model" placeholder="Model"/>
    <form:errors path="model"/><br/>
    <label>Color</label>
    <form:input path="color" placeholder="Color"/>
    <form:errors path="color"/><br/>
    <label>Description</label>
    <form:input path="description" placeholder="Description"/>
    <form:errors path="description"/><br/>
    <label>Photo</label>
    <form:input path="photo" placeholder="Photo"/>
    <form:errors path="photo"/><br/>
    <input type="submit" value="Save">
</form:form>

</body>
</html>


