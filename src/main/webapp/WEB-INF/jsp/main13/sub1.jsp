<%--
  Created by IntelliJ IDEA.
  User: seung
  Date: 2023-09-26
  Time: 오전 9:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>input 요소들</h3>
<form action="/main13/sub2">
<%--    div*10>input[name=parma$]--%>
    <div>
        <input type="text" name="parma1">
    </div>
    <div>
        <input type="password" name="parma2">
    </div>
    <div>
        <input type="date" name="parma3">
    </div>
    <div>
        <input type="button" name="parma4" value="어떤 버튼">
    </div>
    <div>
        <input type="number" name="parma5">
    </div>
    <div>
        <input type="submit" name="parma6" value="회원가입">
        <%--    submit 은 form의 action attribute 경로로 이동 되게 한다.    --%>
        <%--    value로 내용을 바꿀 수 있다.    --%>
    </div>
    <div>
        <input type="radio" name="parma7">
        <%--    같은 name 여러개중 하나만 선택하게 하는것    --%>
    </div>
    <div>
        <input type="radio" name="parma7">
    </div>
    <div>
        <input type="checkbox" name="parma9">
        <%--    같은 name 여러개중 여러개를 선택하게 하는것    --%>
    </div>
    <div>
        <input type="checkbox" name="parma9">
    </div>
    <div>
        <input type="hidden" name="param10" value="some value">
        <%--    우리눈 에 보이지 않는다 사용자에게 보이고 싶지 않을때    --%>
    </div>
    <button>전송</button>
</form>

<hr>
<form action="/main13/sub2">
    <div>
        <input type="text" name="param1" value="son">
    </div>
    <div>
        <input type="text" name="param2" placeholder="이름을 입력해주세요">
        <%--    placeholder : 입력할 내용의 힌트    --%>
    </div>
    <div>
        <input type="text" maxlength="5">
        <%--    maxlength : 입력할 값의 수 제한    --%>
    </div>
    <div>
        <input type="text" required>
        <%--   required : 필수로 값을 입력해야     --%>
    </div>
    <div>
        <input type="text" name="param3" readonly value="son">
        <%-- 읽기만 가능 값 변경 불가능  --%>
    </div>
    <div>
        <input type="text" name="param4" value="son" disabled>
    </div>
    <div>
        <input type="text" pattern="\d{3}" name="param5">
        <%--   pattern에 입력한 정규표현식의형식에 맞게 입력 해야한다     --%>
    </div>
<%--    div*2>input:c--%>
    <div>
        <input type="checkbox" name="param6" checked id="">
    </div>
    <div>
        <input type="checkbox" name="param6" id="">
    </div>
<%--    div*2>input:r--%>
    <p>라디오버튼</p>
    <div>
        <input type="radio" name="param7" checked id="">
    </div>
    <div>
        <input type="radio" name="param7" id="">
    </div>
    <div>
        <input type="file" multiple>
    </div>
    <button>전송</button>

</form>
<hr>
<form action="/main13/sub2">
<%--    라벨의 for와 인풋의 id를 동일하게 주면 --%>
    <label for="input1">
        주소
    </label>
    <input id="input1"  type="text">
    <br>

<%--    div>div*3>label[for=check$]>lorem1^input:c#check$--%>
    <div>
        <div>
            <label for="check1">Lorem.</label>
            <input type="checkbox" name="" id="check1">
        </div>
        <div>
            <label for="check2">Quia.</label>
            <input type="checkbox" name="" id="check2">
        </div>
        <div>
            <label for="check3">Expedita.</label>
            <input type="checkbox" name="" id="check3">
        </div>
    </div>
<%--    인풋과 라벨을 짝꿍으로 다닌다.--%>
    <input type="submit">
    <button>전송</button>
<%--    인풋 서브밋과 버튼의 차이 : 하는일을 똑같은데 인풋은 종료태그가 없다,
 버튼은 종료태가가 있다 그래서 버튼 태그 안에 컨텐츠를 넣어줄 수 있다--%>
</form>



</body>
</html>
