<%--
  Created by IntelliJ IDEA.
  User: seung
  Date: 2023-09-26
  Time: 오후 12:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>회원정보</h2>
<form action="/main13/sub8">
    <div>
        <label for="input1">회원번호</label>
        <input type="number" id="input1" name="id">
    </div>
    <div>
        <label for="input2">이름</label>
        <input type="text" id="input2" name="name">
    </div>
    <div>
        <label for="input3">주소</label>
        <input type="text" id="input3" name="address">
    </div>
    <div>
        <label for="input4">약속 일자</label>
        <input type="datetime-local" id="input4" name="schedule">
    </div>
    <h4>할일목록</h4>
    <div>
        <label for="input5">방청소</label>
        <input type="checkbox" id="input5" name="todos" value="clean">
    </div>
    <div>
        <label for="input6">공부</label>
        <input type="checkbox" id="input6" name="todos" value="study">
    </div>
    <button>전송</button>
</form>
</body>
</html>
