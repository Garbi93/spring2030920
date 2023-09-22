<%--
  Created by IntelliJ IDEA.
  User: seung
  Date: 2023-09-22
  Time: 오후 2:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>forEach tag</h1>
<p>내부의 콘텐츠를 반복 출력</p>
<p>주요 attribute : begin, end, var, items, varStatus</p>
<c:forEach begin="1" end="3">
    <%--begin과 end를 포함해서 반복
        end는 begin보다 커야한다
        begin은 0이상 이어야한다
    --%>
    <li>Lorem ipsum.</li>
</c:forEach>

<hr>

<%--var는 값에 begin의 인덱스를 넣어서 출력--%>
<C:forEach begin="0" end="2" var="num">
    <li>num : ${ num }</li>
</C:forEach>

<hr>
<c:forEach begin="0" end="2" var="num">
    <li>car : ${myList[num]}</li>
</c:forEach>
</body>
</html>
