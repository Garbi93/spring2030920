
-- sql에서 산술 연산이 가능하다
SELECT Price FROM products WHERE ProductID= 1;
SELECT Price + 1 FROM products WHERE ProductID= 1;
SELECT Price - 10.5 FROM products WHERE ProductID= 1;
SELECT Price * 3 FROM products WHERE ProductID= 1;
SELECT Price / 5 FROM products WHERE ProductID= 1;

SELECT ProductName, Price FROM products;
-- 예) 원래가격에서 2곱한값으로 조회
SELECT ProductName, Price * 2 FROM products;

-- 산술연산이 String 타입에도 넣을 수는 있지만 문자열 연결 연산은 불가능 하다
SELECT ProductName + 1,Price FROM products;
-- 문자열 연결은 내장된 함수를 이용해 사용 한다.
SELECT CONCAT(ProductName, 1) , Price FROM products; -- 문자열 연결은 concat을 사용 한다. 마리아DB한정

-- 산술 연산을 날짜형식에도 적용 가능하다.
SELECT LastName, BirthDate FROM employees WHERE EmployeeID = 1; -- 1968-12-08
SELECT LastName, BirthDate + 1 FROM employees WHERE EmployeeID = 1; -- 19681209
SELECT LastName, ADDDATE(BirthDate, INTERVAL 1 DAY )
FROM employees
WHERE EmployeeID = 1; -- 1968-12-09 날짜형식을 1일 더한것으로 출력 하고 싶으면 ADDDATE를 사용 하면 된다. 마리아DB한정

SELECT * FROM employees;
SELECT EmployeeID, LastName, FirstName FROM employees;
SELECT EmployeeID, CONCAT(LastName, FirstName) FROM employees; -- 풀네임으로 출력 하고싶을때
SELECT EmployeeID, CONCAT(LastName,' ', FirstName) FROM employees; -- 퍼스트와 라스트네임에 간격을 주고 싶을때
SELECT EmployeeID,
       CONCAT(LastName,' ', FirstName),
       ADDDATE(BirthDate,INTERVAL -1 YEAR )
FROM employees; -- 풀네임으로 만들고 생일들을 1년 더 감소하여 출력

-- 예) 주문수량(quantity) * 2 결과 조회(orderDetails 테이블)
SELECT  Quantity * 2 FROM orderdetails;
-- 예) "city, country" 고객 테이블 조회
SELECT CONCAT(City, ', ' , Country) FROM customers;