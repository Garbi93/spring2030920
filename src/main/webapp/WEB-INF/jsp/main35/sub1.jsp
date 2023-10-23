<%--
  Created by IntelliJ IDEA.
  User: seung
  Date: 2023-10-23
  Time: 오후 2:43
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
</div>
<script>
    function ajax1() {
        // https://axios-http.com/docs/req_config
        axios.request({
            url: "/main35/sub2"
        });
    }
</script>

<div>
    <button onclick="ajax2()">button2</button>
    <script>
        function ajax2() {
            axios.request({
                url: "/main35/sub3?address=seoul"
            });
        }
    </script>
</div>

<div>
    <button onclick="ajax3()">button3</button>
    <script>
        function ajax3() {
            axios.request({
                url: "/main35/sub4",
                params : {
                    address: "seoul",
                    name: "son",
                    age: 33,
                    email: "abc@gmail.com"
                }
            });
        }
    </script>
</div>

<div>
    <button onclick="ajax4()">button4</button>
    <script>
        function ajax4() {
            // ajax 요청 코드 작성
            axios.request({
                url: "/main35/sub5",
                params : {
                    city : "seoul",
                    id :3,
                    score : 40,
                    country: "korea"
                }
            });
        }
    </script>
</div>

<div>
    <div>
        <input type="text" id="input1" value="서울">
    </div>
    <div>
        <input type="text" id="input2" value="33">
    </div>
    <div>
        <input type="text" id="input3" value="88.7">
    </div>
    <div>
        <input type="text" id="input4" value="한국">
    </div>
    <div>
        <button onclick="ajax5()">button5</button>
        <script>
            function ajax5() {
                const city = document.querySelector("#input1").value;
                const id = document.querySelector("#input2").value;
                const score = document.querySelector("#input3").value;
                const country = document.querySelector("#input4").value;
                axios.request({
                    url: "/main35/sub5",
                    params : {
                        city: city,
                        id: id,
                        score: score,
                        country: country
                    }
                });
            }
        </script>
    </div>

    <div>
        <input type="text" id="input5" value="서울시 영등포">
    </div>
    <div>
        <input type="text" id="input6" value="홍길동">
    </div>
    <div>
        <input type="text" id="input7" value="31">
    </div>
    <div>
        <input type="text" id="input8" value="abcd@gmail.com">
    </div>
    <div>
        <button onclick="ajax6()">button6</button>
        <script>
            function ajax6() {
                const address = document.querySelector("#input5").value;
                const name = document.querySelector("#input6").value;
                const age = document.querySelector("#input7").value;
                const email = document.querySelector("#input8").value;
                axios.request({
                    url: "/main35/sub4",
                    params : {
                        address: address,
                        name: name,
                        age: age,
                        email // 받아오는 변수랑 파람이랑 이름이 같으면 생략 가능
                    }
                });
            }
        </script>
    </div>


</div>
<div>
    <button onclick="ajax7()">button7</button>
    <script>
        function ajax7() {
            axios.request({
                url: "/main35/sub6",
                params: {
                    id:9,
                    lastName: "손",
                    firstName: "흥민"
                }
            })
        }
    </script>
</div>

<div>
    <button onclick="ajax8()">button8</button>
    <script>
        function ajax8() {
            axios.request({
                url: "/main35/sub7",
                method: "post"
            })
        }
    </script>
</div>

<div>
    <button onclick="ajax9()">button9</button>
    <script>
        function ajax9() {
            axios.post("/main35/sub7");
        }
    </script>
</div>
</body>
</html>
