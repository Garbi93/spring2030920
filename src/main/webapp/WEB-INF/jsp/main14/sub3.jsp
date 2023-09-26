<%--
  Created by IntelliJ IDEA.
  User: seung
  Date: 2023-09-26
  Time: 오후 3:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>일기장</h1>
<form action="/main14/sub4" method="post">
    <div>
        제목
        <input type="text" name="title">
    </div>
    <div>
        내용
        <textarea name="content" id="" cols="30" rows="10"></textarea>
    </div>
    <button>전송</button>
</form>
</body>
</html>
