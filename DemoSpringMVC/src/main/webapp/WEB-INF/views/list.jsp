<%--
  Created by IntelliJ IDEA.
  User: Linh
  Date: 12/27/2023
  Time: 7:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach var="name" items="${list}">
    <h1>${name}</h1>
</c:forEach>
</body>
</html>
