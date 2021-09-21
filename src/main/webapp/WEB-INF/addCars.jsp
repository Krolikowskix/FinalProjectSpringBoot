<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Car add</title>
</head>
<body>

<form:form method="post"
           modelAttribute="car">
    <label>name</label>
    <form:input path="name"/>
    <form:errors path="name"/><br/>
    <label>Model</label>
    <form:input path="model"/>
    <form:errors path="model"/><br/>
    <label>Color</label>
    <form:input path="color"/>
    <form:errors path="color"/><br/>
    <label>Description</label>
    <form:input path="description"/>
    <form:errors path="description"/><br/>
    <input type="submit" value="Save">
</form:form>

</body>
</html>


