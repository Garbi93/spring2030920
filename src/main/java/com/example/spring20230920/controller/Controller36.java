package com.example.spring20230920.controller;

import com.example.spring20230920.dao.MyDao7;
import com.example.spring20230920.domain.MyDto39;
import com.example.spring20230920.domain.MyDto40;
import com.example.spring20230920.domain.MyDto41;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Map;

@Controller
@RequestMapping("main36")
@RequiredArgsConstructor
public class Controller36 {

    private final MyDao7 dao;

    @GetMapping("sub1")
    public void method1() {

    }

    // axios.get("/main36/sub2", {params: {id: 5}})
    // /main36/sub2?id=5
    @GetMapping("sub2")
    public void method2(Integer id) {
        Map<String, Object> data = dao.selectByCustomerId(id);
        System.out.println("data = " + data);
    }

    // /js 코드? : axios.get("/main36/sub3", {params: {id: 2}})
    // axios.request({
    //          url:"/main36/sub3",
    //          method: "get",
    //          params: {id: 2}
    //          })
    // /main36/sub3?id=2
    @GetMapping("sub3")
    public void method3(Integer id) {
        Map<String, Object> data = dao.selectByEmployeeId(id);
        System.out.println("data = " + data);
    }


    /*
    axios.post("/main36/sub4",{
        lastName: "손",
        firstName: "흥민",
        birthDate: "2020-02-02"
    },{
        headers: {
            "content-type": "application/x-www-form-urlencoded"
        }
    })
     */
    // post /main36/sub4
    // lastName=손&firstName=흥민&birthDate=2020-02-02
    @PostMapping("sub4")
    public void method4(String lastName,
                        String firstName,
                        LocalDate birthDate) {
        int i = dao.insertEmployee(lastName, firstName, birthDate);
        System.out.println(i+"개 데이터가 잘 입력되었습니다.");
    }


    // 브라우저 개발자 도구 콘솔에 axios 코드 작성 후 실행
    // post /main36/sub5
    // name=라면&price=150.00&category=3
    /*
    axios.post("/main36/sub5",{
            name: "라면",
            price: 150.00,
            category: 3
        },{
        headers: {
            "content-type": "application/x-www-form-urlencoded"
        }
    })
     */
    @PostMapping("sub5")
    public void method5(String name,
                        Double price,
                        Integer category) {
        int r = dao.insertProduct(name, price, category);
        System.out.println(r+"개 행이 입력됨");
    }




    /*
    axios.delete("/main36/sub6")
     */
    // @RequestMapping(method = RequestMethod.DELETE, value = "sub6")
    @DeleteMapping("sub6") // 윗줄과 같은 일을함
    public void method6() {
        System.out.println("Controller36.method6");
    }


    /*
    js 코드 작성후 브라우저 콘솔에 실행
    axios.delete("/main36/sub7")
     */
    @DeleteMapping("sub7")
    public void method7() {
        System.out.println("Controller36.method7");
    }

    /*
    axios.delete("/main36/sub8?name=son") // 이렇게도 가능하고, 아래로 도 가능하다.
    axios.delete("/main36/sub8", {
        params: {
            name: "son"
        }
    })
     */
    @DeleteMapping("sub8")
    public void method8(String name) {
        System.out.println("name = " + name);
    }


    /*
    axios.delete("/main36/sub9/son")
    axios.delete("/main36/sub9/lee")
     */
    // PathVariable : 경로에 포함된 데이터
    @DeleteMapping("sub9/{name}")
    public void method9(@PathVariable("name") String n) { // pathvariable
        System.out.println("n = " + n);
    }

    /*
    axios.delete("/main36/sub10/3")
    axios.delete("/main36/sub10/5")
    axios.delete("/main36/sub10/7")
     */
    // delete /main36/sub10
    @DeleteMapping("sub10/{number}")
    public void method10(@PathVariable("number") Integer num) {
        System.out.println("num = " + num);
    }


    /*
    axios.delete("/main36/sub11/79")
     */
    @DeleteMapping("sub11/{pid}")
    public void method11(@PathVariable Integer pid) {
        int c = dao.deleteByProductId(pid);
        System.out.println(c+"개 데이터 삭제됨");
    }

    /*
    axios.delete("/main36/sub12/1")
    axios.delete("/main36/sub12/3")
    axios.delete("/main36/sub12/5")
    // 고객 id 에 맞게 지워지도록 하기
     */
    @DeleteMapping("sub12/{cid}")
    public void mehthod12(@PathVariable Integer cid) {
        int cRow = dao.deleteByCustomerId(cid);
        System.out.println(cRow + "만큼 고객이 지워졌습니다.");
    }


    // put 요청은 업데이트 할때에 주로 요청 된다.
    // url은 꼭 작성 되어 있어야 한다.
    /*
    axios.put("/main36/sub13")
    put /main36/sub13
     */
//    @RequestMapping(method = RequestMethod.PUT, value = "sub13")
    @PutMapping("sub13") // putMapping으로 간단하게 작성 가능하다.
    public void method13() {
        System.out.println("Controller36.method13");
    }



    /*
    axios.put("/main36/sub14", {
            name: "son",
            address: "korea"
    }, {
        headers : {
            "content-type": "application/x-www-form-urlencoded"
        }
    })
     */
    // put /main36/sub14
    // name=son*&address=korea
    @PutMapping("sub14")
    public void method14(String name, String address) {
        System.out.println("name = " + name);
        System.out.println("address = " + address);
    }


    /*
    axios.put("/main36/sub15", {
        city: "seoul",
        age: 78,
        score: 3.14
    }, {
        headers: {
            "content-type": "application/x-www-form-urlencoded"
        }
    })
     */
    @PutMapping("sub15")
    public void method15(MyDto39 dto) {
        System.out.println("city = " + dto.getCity());
        System.out.println("age = " + dto.getAge());
        System.out.println("score = " + dto.getScore());
    }



    /*
    axios.put("/main36/sub16", {
        id: 3,
        name: "햄버거",
        category: 2,
        price: 5000.00
    },{
        headers: {
            "content-type": "application/x-www-form-urlencoded"
        }
    })
     */
    @PutMapping("sub16")
    public void method16(MyDto40 dto) {
        int row = dao.updateProduct(dto);
        System.out.println(row + "개 데이터 수정됨");
    }


    /*
    axios.put("/main36/sub17", {
        lastName: "lee",
        firstName: "kangin",
        birthDate: "2020-01-01",
        id: 5
    },{
        headers: {
            "content-type": "application/x-www-form-urlencoded"
        }
    })
     */
    @PutMapping("sub17")
    public void method17(MyDto41 dto) {
        int eRow = dao.updateByEmployeeId(dto);
        System.out.println(eRow + "만큼 변경됨");
    }





}
