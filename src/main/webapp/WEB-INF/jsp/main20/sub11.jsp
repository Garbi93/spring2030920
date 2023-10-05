<%--
  Created by IntelliJ IDEA.
  User: seung
  Date: 2023-10-05
  Time: 오후 4:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h4>국가별 공급자 목록 조회창</h4>
<table>
    <tr>
        <th>국가</th>
        <th>공급자 ID</th>
        <th>공급자 이름</th>
    </tr>
    <c:forEach items="${supplierList}" var="sup">
        <tr>
            <td>${sup.country}</td>
            <td>${sup.id}</td>
            <td>${sup.name}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
