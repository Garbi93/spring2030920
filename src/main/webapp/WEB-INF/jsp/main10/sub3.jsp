<%--
  Created by IntelliJ IDEA.
  User: seung
  Date: 2023-09-22
  Time: 오후 2:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>main10 sub3호출 </h1>
<hr>
<h3>${person1.name}</h3>
<h3>${person1.id}</h3>
<h3>${person1.foods[0]}</h3>
<h3>${person1.foods[1]}</h3>
<h3>${person1.foods[2]}</h3>

<hr>

<h3>${person1.cars[0]}</h3>
<h3>${person1.cars[1]}</h3>
<h3>${person1.cars[2]}</h3>

<hr>

<%--jstl을 이용해서 반복해서 값을 불러오기--%>
<c:forEach items="${person1.cars}" var="car">
    <h3>${car}</h3>
</c:forEach>

<c:forEach items="${person1.foods}" var="food">
    <h3>${food}</h3>
</c:forEach>

</body>
</html>
