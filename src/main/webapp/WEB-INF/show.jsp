<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Item List</title>
</head>
<a href="/logout">Wyloguj</a>
<body>
<th>Name:  </th>
${item.name}
<br>
<th>Model: </th>
${item.model}
<br>
<th>Color:  </th>
${item.color}
<br>
<th>Description:  </th>
${item.description}
<br>
<img src="${item.photo}"/>
<br>
<a href="/items/edit/${item.id}">Edytuj</a>
<br>
<a href="/items/delete/${item.id}">Usuń</a>

<ul><c:forEach items="${equipments}" var="equipment">
    <li>${equipment.name} ${equipment.prize} ${equipment.description}
    <a href="/equipments/edit/${equipment.id}">Edytuj</a>
        <a href="/equipments/delete/${equipment.id}">Usuń</a>
        <a href="/equipments/show/${equipment.id}">Szczegóły</a>
    </li>
</c:forEach>
    <li><a href = "/equipments/add/${item.id}">dodaj</a></li>
</ul>
</body>
</html>