<%--
  Created by IntelliJ IDEA.
  User: seung
  Date: 2023-09-25
  Time: 오후 2:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>form 요소</h1>

<form>
    <input type="text" name="param1">
    <br>
    <input type="text" name="param2">
    <br>
    <%-- select(option), textarea --%>
    <button>전송</button>


</form>
<h3>전송버튼 input 예제 😎 </h3>
<form>
<%--
전송버튼 클릭시
?name=lee&age=44&address=seoul&email=abc@gmail.com
  --%>
    <input type="text" name="name">
    <br>
    <input type="text" name="age">
    <br>
    <input type="text" name="address">
    <br>
    <input type="text" name="email">
    <br>
    <button>전송</button>
</form>

<hr>
<h3>action 속성 : request 파라미터들을 어디로 보낼지 결정</h3>
<p>action 속성이 없거나 빈 문자열일 경우 현재경로를 유지한다.</p>
<form action="https://search.naver.com/search.naver">
    <input type="text" name="query">
    <br>
    <button>전송</button>
</form>

<hr>
<h3>구글 검색</h3>
<form action="https://google.com/search">
    <input type="text" name="q">
    <br>
    <button>전송</button>
</form>
<hr>

<h3>다음 검색</h3>
<form action="https://search.daum.net/search">
    <input type="text" name="q">
    <button>전송</button>
</form>
<hr>
<h1>action 속성값 : /로 시작하는경우 (absolute)경로 path가 결정됨</h1>
<form action="/main99/sub2">
    <input type="text" name="email">
    <button>전송</button>
</form>
<hr>

<%--전송 버튼 클릭시 request parameter 가 /main12/sub2 로 전송되도록 --%>
<form action="/main12/sub2">
    <input type="text" name="age">
    <button>전송</button>
</form>

<hr>
<h1>action 속성 값 : /도 아니고 protocol(scheme)이 아니면 현재 페이지의 상대경로</h1>
<h1>path 에서 마지막 / 기준 (현재 경로 기준)</h1>
<form action="main12/sub2">
    <input type="text" name="age">
    <button>전송</button>
</form>

<hr>
<form action="sub3">
    <input type="text" name="address">
    <button>전송</button>
</form>

<%-- .. : 한경로 위 --%>
<form action="..">
    <input type="text" name="age">
    <button>전송</button>
</form>








</body>




</html>
