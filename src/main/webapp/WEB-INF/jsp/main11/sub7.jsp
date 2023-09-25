<%--
  Created by IntelliJ IDEA.
  User: seung
  Date: 2023-09-25
  Time: 오후 2:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<style>
    tr {
        border: 1px solid black;
        background-color: skyblue;
        font-weight: bold;
        text-align: center;
    }
</style>
<h1>데이터 입출력 테스트 </h1>
<%-- /main11/sub7?show=true --%>
<%-- table 형식의 데이터 출력 --%>
<c:if test="${not empty people}">
    <p>파라미터가 잘 들어왔습니다</p>
    <table>
        <tr>
            <td>id</td>
            <td>firstName</td>
            <td>lastName</td>
            <td>className</td>
            <td>phoneNumber</td>
        </tr>
        <c:forEach items="${people}" var="i" varStatus="s">
            <tr>
                <td>${i.id}</td>
                <td>${i.firstName}</td>
                <td>${i.lastName}</td>
                <td>${i.className}</td>
                <td>${i.phoneNumber}</td>
            </tr>
        </c:forEach>
    </table>

</c:if>

<h1>choose 태그 사용</h1>
<c:choose>
    <c:when test="${not empty people}">
        <table>
            <tr>
                <td>id</td>
                <td>firstName</td>
                <td>lastName</td>
                <td>className</td>
                <td>phoneNumber</td>
            </tr>
            <c:forEach items="${people}" var="i" varStatus="s">
                <tr>
                    <td>${i.id}</td>
                    <td>${i.firstName}</td>
                    <td>${i.lastName}</td>
                    <td>${i.className}</td>
                    <td>${i.phoneNumber}</td>
                </tr>
            </c:forEach>
        </table>
    </c:when>
    <c:otherwise>
        <h1>데이터가 없습니다.</h1>
    </c:otherwise>
</c:choose>
<%-- /main11/sub7 --%>
<%-- 파라미터를 입력해주세요 --%>
<c:if test="${empty people}">
    <p>파라미터를 입력해주세요</p>
</c:if>



</body>
</html>
