<%--
  Created by IntelliJ IDEA.
  User: seung
  Date: 2023-09-25
  Time: 오전 11:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>jstl if tag</h1>
<c:if test="true">
    <p>출력😀</p>
</c:if>

<c:if test="false">
    <p>출력 안됨 😒</p>
</c:if>



</body>
</html>
