<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Equipment show</title>
</head>
<body>

${equipment.name}
<br>
${equipment.prize}
<br>
${equipment.description}
<br>
<img src="${equipment.photo}"/>
<br>
<a href="/equipments/edit/${equipment.id}">Edytuj</a>
<br>
<a href="/equipments/delete/${equipment.id}">Usuń</a>


</body>
</html>


