<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Linh
  Date: 12/29/2023
  Time: 7:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/customers/showFormCreate"> Tạo mới </a>
<c:forEach items="${list}" var="item">
    <h1>Id: ${item.id} - Name: ${item.name} - <a href="/customers/showFormEdit/${item.id}">Edit</a></h1>
</c:forEach>
</body>
</html>
