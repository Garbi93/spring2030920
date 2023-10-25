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

<div>
    <button onclick="ajax6()">button6</button>
    <script>
        function ajax6() {
            axios.get("/main38/sub2")
                .then(function () {
                    console.log("응답완료후 실행");
                })
                .then(function (){
                    console.log("그 다음 실행");
                })
                .then(function (){
                    console.log("또 그 다음 실행");
                });
        }
    </script>
</div>

<div>
    <button onclick="ajax7()">button7</button>
    <script>
        function ajax7() {
            axios.get("/main38/sub2")
                .then(function (){
                    console.log('첫 함수')
                    return "abcd";
                })
                .then(function (param){ // 직전 함수에서 리턴한 것("abcd")을 받아와서 실행 한다.
                    console.log('두번째 함수')
                    console.log(param)
                    return 345;
                })
                .then(function (param) {
                    console.log(param);
                })
        }
    </script>
</div>

<div>
    <button onclick="ajax8()">button8</button>
    <script>
        function ajax8(){
            axios.get("/main38/sub2")
                .then(function (param){
                    console.log('첫 함수 일함')
                    return param.data; // 받은 데이터를 그대로 리턴 하기 때문에
                })
                .then(function (param){ // 두번째 함수에서 그대로 받아서 사용 가능
                    console.log('두번째 함수 일함')
                    console.log(param);
                })
        }
    </script>
</div>

<div>
    <button onclick="ajax9()">button9</button>
    <script>
        function ajax9() {
            axios.get("/main38/sub2")
                .then(response => response.data)
                .then(data => console.log(data));
        }
    </script>
</div>

<div>
    <button onclick="ajax10()">button10</button>
    <script>
        function ajax10() {
            // 선생님이 작성하신 코드를 화살표 함수로 변경하기
            axios.get("/main38/sub4")
                .then(response => response.data)
                .then(data => console.log(data.list[0]))
        }
    </script>
</div>

<div>
    <button onclick="ajax11()">button11</button>
    <script>
        function ajax11() {
            axios.get("/main38/sub4")
                .then(response => response.data)
                // .then(data => console.log(data.price)); // 3000 -> 이것을 구조분해할당으로 바꾸자면
                .then(({price, birth,list,city}) => console.log(price)); // 이런식으로 구조분해할당 형식으로 받아 사용 가능하다.
        }
    </script>
</div>

<div>
    <button onclick="ajax12()">button12</button>
    <script>
        function ajax12() {
            axios.get("/main38/sub4")
                .then(({data})=> console.log(data.price));
        }
    </script>
</div>

<div>
    <button onclick="ajax13()">button13</button>
    <script>
        function ajax13() {
            axios.get("/main38/sub4")
                .then(response => response.data)
                .then(({price, city, country = "korea"}) => {
                    console.log(price); // 3000
                    console.log(city); // seoul
                    console.log(country); //korea
                })
        }
    </script>
</div>

<script>
    // 구조 분해 할당
    // Destructuring assignment
    let a = {
        name : "son",
        age : 30
    };
    console.log(a.name);
    console.log(a.age);
    //

    // 다른값으로 받아 오는것을 할당!! 이라고 한다
    let myName = a.name;
    let myAge = a.age;
    console.log(myName);
    console.log(myAge);

    let {name, age} = a; // 이게 구조분해 할당 destructuring assignment
    console.log(name); // son
    console.log(age); // 30


    let b = {
        city: "seoul",
        country: "korea"
    };
    // console.log(b.city);
    // console.log(b.country);
    let {city, country} = b // 구조분해 할당 을 이용하여 값 지정
    console.log(city);
    console.log(country);

    let c = {
        email : "abc@gmail.com",
        price : 300
    };
    // let{email, price} = c;
    let { email } = c; // 분해한 일부분만 할당 하여 사용도 가능하다.

    let d = {
        name2 : "lee",
        address: "paris",
        age: 77
    }
    let {name2, address} = d; // 일 부분만 할당.

    let e = {
        city2: "seoul",
        country2: "korea"
    }
    let {city2, country2, category} = e; // 초과 할당 하였을때는 설정 되어 있지 않은것은 undefiend
    console.log(city2); // seoul
    console.log(country2); // korea
    console.log(category); // undefined


    let f = {
        name3 : "kim",
        city3 : "busan"
    }
    let {name3, city3="서울", address3 = "신촌"} = f; // 초과 할당 한 값에 undefined 가 아닌 값을 주고 싶을때는 이처럼 사용 하면 된다.
    // 값이 있는 경우에는 기본값이 안들어 가고 넣으려는 값이 들어간다.
    console.log(name3);
    console.log(city3);
    console.log(address3);

    // 배열에서도 구조분해할당 가능
    let g = [30,40,50];
    let [h, i, j] =g; // 구조분해할당
    console.log(h);
    console.log(i);
    console.log(j);

    let [k, l] = g; // 배열도 마찬가지로 다 할당할 필요없다,
    console.log(k);
    console.log(l);

    let [m, ...n] = g; // ...n n에 배열 나머지 모든것을 넣은 배열을 만든다.
    console.log(m);
    console.log(n); // [40, 50]

    let [...o] = g;
    console.log(o); // [30, 40, 50]
</script>


</body>
</html>
