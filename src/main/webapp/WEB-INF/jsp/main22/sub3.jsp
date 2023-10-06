<%--
  Created by IntelliJ IDEA.
  User: seung
  Date: 2023-10-06
  Time: 오후 2:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
    <style>
        .active {
            background-color: darkblue;
            color: #eeeeee;
        }
    </style>
</head>
<body>
<h3>고객 조회</h3>
<table>
    <tr>
        <th>id</th>
        <th>name</th>
    </tr>
    <c:forEach items="${customerList}" var="customer">
        <tr>
            <td>${customer.id}</td>
            <td>${customer.name}</td>
        </tr>
    </c:forEach>
</table>

<div>
    <c:if test="${frontPageNumber > 0}">
        <a href="/main22/sub3?p=1">◀◀맨앞</a>
    </c:if>
    <c:if test="${frontPageNumber >0 }">
        <a href="/main22/sub3?p=${frontPageNumber}">◀앞</a>|
    </c:if>
    <c:forEach begin="${leftPageNumber}" end="${rightPageNumber}" var="lastNumber">
        <a
            <c:if test="${lastNumber == currentPage}">
            class="active"
            </c:if>
        href="/main22/sub3?p=${lastNumber}">${lastNumber}</a>|
    </c:forEach>
    <c:if test="${lastNumber >= nextPageNumber}">
        <a href="/main22/sub3?p=${nextPageNumber}">뒤▶</a>
    </c:if>
    <c:if test="${lastNumber >= nextPageNumber}">
        <a href="/main22/sub3?p=${lastNumber}">맨뒤▶▶</a>
    </c:if>
</div>

</body>
</html>
