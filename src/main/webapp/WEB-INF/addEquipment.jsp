<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Equipment add</title>
</head>
<body>

<form:form method="post"
           action="/equipments/saveEquipment"
           modelAttribute="equipment">
    <form:input path="itemId" type="hidden"/>
    <label>name</label>
    <form:input path="name"/>
    <form:errors path="name"/><br/>
    <label>Prize</label>
    <form:input type="number" path="prize"/>
    <form:errors path="prize"/><br/>
    <label>Description</label>
    <form:input path="description"/>
    <form:errors path="description"/><br/>
    <label>Photo</label>
    <form:input path="photo"/>
    <form:errors path="photo"/><br/>
    <input type="submit" value="Save">
</form:form>

</body>
</html>


