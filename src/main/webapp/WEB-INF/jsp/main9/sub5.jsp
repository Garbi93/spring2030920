<%--
  Created by IntelliJ IDEA.
  User: seung
  Date: 2023-09-22
  Time: 오전 10:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>main9 sub5 호출</h1>

<h3>${caps.korea} : seoul</h3>
<h3>${caps["korea"]} : seoul</h3>
<h3>${caps[korea]} : ny</h3>
<h3>${caps["us"]} : ny</h3>
<h3>${caps[us]} : 아무것도 안나옴</h3>
<hr>
<h3>${phones.phone1}</h3>
<h3>${phones["phone2"]}</h3>
<h3>${caps.korea}</h3>
<h3>${caps.us}</h3>
<h3>${foods["1st"]}</h3>
<h3>${foods["2nd"]}</h3>
</body>
</html>
