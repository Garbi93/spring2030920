<%--
  Created by IntelliJ IDEA.
  User: seung
  Date: 2023-09-26
  Time: 오전 11:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>가입하신 정보</h3>
<p> 아이디 : ${param.userId}</p>
<p> 이메일 : ${param.userEmail}</p>
<p> 생일 : ${param.birthDate}</p>
<p> 취미 : ${param.hobby}</p>

</body>
</html>
