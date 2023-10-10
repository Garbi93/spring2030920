<%--
  Created by IntelliJ IDEA.
  User: seung
  Date: 2023-10-10
  Time: 오전 11:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
    <style>
        table {
            border-collapse: collapse;
        }
        th {
            background-color: skyblue;
        }
        table, tr, td {
            border: 1px solid black;
        }
    </style>
</head>
<body>
<h4>직원조회</h4>
<form action="">
    <div>
        검색 조건
        <select name="t" id="">
            <option value="lname" ${searchType == 'lname' ? 'selected' : ''}>Last Name</option>
            <option value="fname" ${searchType == 'fname' ? 'selected' : ''}>First Name</option>
            <option value="note" ${searchType == 'note' ? 'selected' : ''}>Notes</option>
        </select>
    </div>
    <div>
        검색어
        <input type="text" name="k" value="${inputKey}">
    </div>
    <div>
        <button>조회</button>
    </div>
</form>

<hr>
<table>
    <tr>
        <th>first Name</th>
        <th>Last Name</th>
        <th>Notes</th>
    </tr>
    <c:forEach items="${employeeList}" var="employ">
        <tr>
            <td>${employ.firstName}</td>
            <td>${employ.lastName}</td>
            <td>${employ.notes}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
