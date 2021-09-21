<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Item List</title>
</head>
<body>
<a href="/logout">Wyloguj</a>
<table border="1">
    <thead>
    <th>Name</th>
    <th>Model</th>
    <th>Color</th>
    <th><a href="/items/add">Add new item</a></th>
    </thead>
    <tbody>
    <c:forEach items="${items}" var="item">
        <tr>
            <td><c:out value="${item.name}"/></td>
            <td><c:out value="${item.model}"/></td>
            <td><c:out value="${item.color}"/></td>
            <td><c:out value="${item.description}"/></td>
            <td><a href = "/items/edit/<c:out value="${item.id}"/>">Edit</a></td>
            <td><a href = "/items/delete/<c:out value="${item.id}"/>">Delete</a></td>
            <td><a href = "/items/show/<c:out value="${item.id}"/>">Details</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>