<%--
  Created by IntelliJ IDEA.
  User: Linh
  Date: 12/29/2023
  Time: 2:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="" method="post">
    <input type="text" name="id" placeholder="id" readonly value="${customerEdit.id}">
    <input type="text" name="name" placeholder="name" value="${customerEdit.name}">
    <button>Submit</button>
</form>
</body>
</html>
