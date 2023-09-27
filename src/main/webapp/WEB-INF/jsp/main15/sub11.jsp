<%--
  Created by IntelliJ IDEA.
  User: seung
  Date: 2023-09-27
  Time: 오전 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>음식을 먹을 사람들 </h1>
    <p>사람들 이름 : (모델)${items}</p>
<c:forEach items="${items}" var="i">
    <p>${i}</p>
</c:forEach>
    <p>음식 종류 : (세션)${sessionScope.items}</p>
<c:forEach items="${sessionScope.items}" var="i">
    <p>${i}</p>
</c:forEach>
</body>
</html>
