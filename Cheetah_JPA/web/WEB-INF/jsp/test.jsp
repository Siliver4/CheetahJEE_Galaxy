<%--
  Created by IntelliJ IDEA.
  User: AlexM
  Date: 19/04/2019
  Time: 17:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>Test</title>
</head>
<body>
<form method="post" action="Test">

    <c:if test="${ !empty error }"><p style="color:red;"><c:out value="${ error }" /></p></c:if>
    <p>
        <label for="surname">Prénom : </label>
        <input type="text" name="surname" id="surname" />
    </p>
    <p>
        <label for="name">Nom : </label>
        <input type="text" name="name" id="name" />
    </p>

    <input type="submit" />
</form>

<ul>
    <c:forEach var="client" items="${ clients }">
        <li><c:out value="${ client.surname }" /> <c:out value="${ client.name }" /></li>
    </c:forEach>
</ul>
</body>
</html>