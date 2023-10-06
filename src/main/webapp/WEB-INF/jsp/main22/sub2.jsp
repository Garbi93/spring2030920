<%--
  Created by IntelliJ IDEA.
  User: seung
  Date: 2023-10-06
  Time: 오전 11:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
    <style>
        table {
            border-collapse: collapse;
            border: 1px solid black;
        }

        tr, td {
            border: 1px solid black;
            text-align: center;
        }
    </style>
</head>
<body>
<table>
    <tr>
        <th>공급자 번호</th>
        <th>공급자 이름</th>
    </tr>
    <c:forEach items="${supplierList}" var="ss">
        <tr>
            <td>${ss.id}</td>
            <td>${ss.name}</td>
        </tr>
    </c:forEach>
</table>

<div>
    <c:forEach begin="1" end="${lastPageNumber}" var="pageNumber">
        <a href="/main22/sub2?p=${pageNumber}">${pageNumber}</a>
        |
    </c:forEach>
</div>
</body>
</html>
