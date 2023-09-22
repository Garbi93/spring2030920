<%--
  Created by IntelliJ IDEA.
  User: seung
  Date: 2023-09-22
  Time: 오후 3:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>main10 sub6 호출😀</h1>
<style>
   table{
       border-collapse: collapse;
       border: 1px solid black;
       width: 100%;
   }
   th {
       background-color: #eee;
   }
   th, td {
       padding: 5px;
   }
</style>

<table>
    <tr>
        <th>id</th>
        <th>firstName</th>
        <th>lastName</th>
        <th>class</th>
        <th>phone</th>
    </tr>
    <c:forEach items="${people}" var="i" varStatus="s">
        <tr>
            <td>${i.id}</td>
            <td>${i.firstName}</td>
            <td>${i.lastName}</td>
            <td>${i.className}</td>
            <td>${i.phoneNumber}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
