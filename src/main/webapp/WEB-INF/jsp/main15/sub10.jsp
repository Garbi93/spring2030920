<%--
  Created by IntelliJ IDEA.
  User: seung
  Date: 2023-09-27
  Time: 오전 10:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--// el에서 attribute에 접근하면 좁은 영역에서부터 찾는다--%>
<%--//page < request(model) < session < application--%>
<h1>\${modelAttr1} : ${modelAttr1}</h1>
<h1>\${sessionAttr1} : ${sessionAttr1}</h1>
<hr>
<h1>\${attr1} : ${attr1}</h1>
<%--모델과 같은 이름인세션에 있는것을 정확히 꺼내고 싶다면 --%>
<h1>\${sessionScope.attr1} : ${sessionScope.attr1}</h1>
</body>
</html>
