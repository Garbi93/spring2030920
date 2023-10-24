<%--
  Created by IntelliJ IDEA.
  User: seung
  Date: 2023-10-24
  Time: 오후 4:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
</head>
<body>
<div>
    <button onclick="ajax1()">button1</button>
    <script>
        function ajax1() {
            axios.get("/main38/sub1");
        }
    </script>
</div>
<div>
    <button onclick="ajax2()">button2</button>
    <script>
        function ajax2() {
            axios.get("/main38/sub2")
                .then(function(response) {
                    console.log("응답 받은 후 해야하는 일");
                    console.log(response.data);
                    console.log(response.status);
                    console.log(response.statusText);
                    console.log(response.headers);
                    console.log(response.config);
                });
        }
    </script>
</div>
<div>
    <button onclick="ajax3()">button3</button>
    <script>
        function ajax3() {
            axios.get("/main38/sub3")
                .then(function (res){
                   console.log(res.data);
                   console.log(res.data.age);
                   console.log(res.data.name);
                });
        }
    </script>
</div>

<div>
    <button onclick="ajax4()">button4</button>
    <script>
        function ajax4() {
            // ajax 요청
            // get/main38/sub4
            // 응답된 json데이터를 js object로 파싱해서
            // "seoul", 3000, "son", "1999-03-01"
            axios.get("/main38/sub4")
                .then(function (res) {
                    const data = res.data;
                    console.log(res.data);
                    console.log(data.city);
                    console.log(data.price);
                    console.log(data.birth);
                    console.log(res.data.List[0]);
                })
        }
    </script>
</div>

<div>
    <input type="text" id="input1">
    <button onclick="ajax5()">button5</button>
    <script>
        function ajax5() {
            const pid = document.querySelector("#input1").value;
            axios.get("/main38/sub5?id=" + pid)
                .then(function (response) {
                    const product = response.data;
                    console.log(product.ProductID);
                    console.log(product.ProductName);
                    console.log(product.Unit);
                    console.log(product.Price);
                })
        }
    </script>
</div>
</body>
</html>
