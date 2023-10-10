<%--
  Created by IntelliJ IDEA.
  User: seung
  Date: 2023-10-10
  Time: 오전 11:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h4>공급자 조회</h4>
<form>
    찾고싶은 공급자의 주소를 입력해주세요
    <input type="text">
    <button>조회</button>
</form>

<hr>

<table>
    <tr>
        <th>city</th>
        <th>supplierID</th>
        <th>address</th>
    </tr>
    <c:forEach items="${supplierList}" var="sup">
        <tr>
            <td>${sup.city}</td>
            <td>${sup.supplierID}</td>
            <td>${sup.address}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
