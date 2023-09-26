<%--
  Created by IntelliJ IDEA.
  User: seung
  Date: 2023-09-26
  Time: 오후 2:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1> 암호 전송 </h1>
<%--
method->어떻게 get방식으로보냄
action-> 어디로
get 방식 : 주소에 쿼리스트링으로 붙어서 전송
1. 블라우저 주소란에서 볼 수 있음
2. 길이의 제한이 있음

post 방식 : 요청 본문에 붙어서 전송
1. 브라우저 주소란에서 볼 수 없음
2. 길이의 제한이 없다.
파일전송은 항상 post방식으로 한다 (길이 때문에)
--%>
<form action="/main14/sub2" method="get">
    <div>
        id:
        <input type="text" name="id">
    </div>
    <div>
        password :
        <input type="password" name="password">
    </div>
    <button>전송</button>
</form>

<hr>
<h3>post</h3>
<form action="/main14/sub2" method="post">
    <div>
        id:
        <input type="text" name="id">
    </div>
    <div>
        password :
        <input type="password" name="password">
    </div>
    <button>전송</button>
</form>
</body>
</html>
