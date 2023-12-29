<%--
  Created by IntelliJ IDEA.
  User: Linh
  Date: 12/29/2023
  Time: 7:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Form Edit</h1>
<form action="/customers/edit/${customer.id}" method="post">
    <input type="text" placeholder="id" name="id" value="${customer.id}" readonly>
    <input type="text" placeholder="name" name="name" value="${customer.name}">
    <button>Nhap em di</button>
</form>
</body>
</html>
