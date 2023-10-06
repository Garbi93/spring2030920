-- 정렬
SELECT * FROM employees;
SELECT *
FROM employees
ORDER BY BirthDate;

SELECT *
FROM employees
ORDER BY 4; -- 컬럼의 순서로 정렬도 가능하다

-- 생일 순 조회를 아래의 2가지 방법으로 볼 수 있다.
SELECT EmployeeID, LastName,BirthDate
FROM employees
ORDER BY BirthDate;
SELECT EmployeeID, LastName,BirthDate
FROM employees
ORDER BY 3;

SELECT * FROM products;
SELECT * FROM products
ORDER BY CategoryID; -- 카테고리 아이디 별로 보기
SELECT * FROM products
ORDER BY CategoryID, Price; -- 카테고리 아이디 별로 보고 그안에서 가격순으로 조회하기
-- 물론 숫자로도 가능
SELECT * FROM products
ORDER BY 4; -- 카테고리 아이디 별로 보기
SELECT * FROM products
ORDER BY 4, 6; -- 카테고리 아이디 별로 보고 그안에서 가격순으로 조회하기

-- 기본적으로 오름차순이라 내림차순 하려면 DESC를 입력하면 된다.
SELECT * FROM products
ORDER BY CategoryID DESC; -- 내림차순

SELECT * FROM products
ORDER BY CategoryID DESC , Price; -- 내림차순 오름차순 을 섞어서 사용 가능
SELECT * FROM products
ORDER BY CategoryID, Price DESC;

-- 예) 고객을 국가명 오름차순으로 조회
SELECT * FROM customers
ORDER BY Country;
-- 예) 가격이 비싼 상품이 먼저 조회되도록 코드 작성
SELECT * FROM products
ORDER BY Price DESC;
-- 예) 가장 어린 직원이 먼저 조회되도록 코드 작성
SELECT * FROM employees
ORDER BY BirthDate DESC;





