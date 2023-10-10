<%--
  Created by IntelliJ IDEA.
  User: seung
  Date: 2023-10-10
  Time: 오후 2:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h4>내가 입력한 공급자 조회</h4>
<table>
    <tr>
        <th>공급자 이름</th>
        <th>거래명</th>
        <th>주소</th>
    </tr>
    <c:forEach items="${supplierList}" var="sup">
        <tr>
            <td>${sup.supplierName}</td>
            <td>${sup.contactName}</td>
            <td>${sup.address}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
