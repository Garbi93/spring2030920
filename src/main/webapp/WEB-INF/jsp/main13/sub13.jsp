<%--
  Created by IntelliJ IDEA.
  User: seung
  Date: 2023-09-26
  Time: 오후 2:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>select 요소</h1>
<form action="/main13/sub14">
<%--    select>option[value]*3--%>
    <div>
        <select name="hobby" id="">
            <option value="soccer">축구</option>
            <option value="baxeball">야구</option>
            <option value="basketball">농구</option>
        </select>

    </div>
    <div>
<%--        select[name=food][multiple]>option[value]*5--%>
<%--    여러개--%>
    <select name="food" id="" multiple="">
        <option value="pizza">피자</option>
        <option value="coffee">커피</option>
        <option value="burger">버거</option>
        <option value="milk">우유</option>
        <option value="tanghuru">탕후루</option>
    </select>
    </div>

    <button>전송</button>
</form>
</body>
</html>
