<%--
  Created by IntelliJ IDEA.
  User: seung
  Date: 2023-10-05
  Time: 오후 2:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>조회된 상품들</h3>
<table>
    <tr>
        <th>상품명</th>
    </tr>
    <c:forEach items="${productList}" var="pro">
        <tr>
            <td>${pro.pName}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
