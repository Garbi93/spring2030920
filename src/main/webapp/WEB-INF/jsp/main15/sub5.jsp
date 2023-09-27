<%--
  Created by IntelliJ IDEA.
  User: seung
  Date: 2023-09-27
  Time: 오전 9:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--model에 넣은 어트리뷰트 뿐만 아니라 세션에 넣은 어트리뷰트도 이렇게 불러올 수 있다.--%>
<h1>${username} 님 반갑습니다.</h1>
<a href="/main15/sub6">다른 페이지로 가기</a>
</body>
</html>
