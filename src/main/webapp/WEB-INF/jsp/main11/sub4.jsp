<%--
  Created by IntelliJ IDEA.
  User: seung
  Date: 2023-09-25
  Time: 오후 12:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="e" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%-- 요청 age --%>
<%-- age가 20보다 크거나 같으면  --%>
<h1>투표 가능 여부 구하기 😎</h1>
<c:if test="${not empty param.age}">
    <e:if test="${param.age >= 20}" var="able">
        <p>${param.age} 이므로 투표가 가능합니다. 😀</p>
    </e:if>

    <%-- 그렇지 않으면 --%>
    <e:if test="${not able}">
        <p>${20 - param.age}살 만큼 덜 나이 먹어서 투표 불가능 합니다. 😣</p>
    </e:if>

</c:if>
<c:if test="${empty param.age}">
    <p>age값을 입력해주세요.</p>
</c:if>

</body>
</html>
