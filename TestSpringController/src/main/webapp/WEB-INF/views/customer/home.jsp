<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Linh
  Date: 12/29/2023
  Time: 11:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/customers/showFormCreate">Create Customer</a>
<c:forEach items="${list}" var="customer">
    <h1>Id : ${customer.id} - Name: ${customer.name} - <a href="/customers/edit/${customer.id}">Edit</a></h1>
</c:forEach>
</body>
</html>
