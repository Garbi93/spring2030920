USE w3schools;
-- aggregate-function : (집계함수, 집합함수, 그룹함수)
-- MAX, MIN, COUNT, SUM, AVG

SELECT  * FROM products;

-- MAX 최대값
SELECT MAX(Price) FROM products;
SELECT * FROM products ORDER BY Price DESC; -- 제일비싼 상품은 Côte de Blaye 인데
SELECT ProductName, MAX(Price) FROM products; -- name으로 부르면 charis가 나온다 집계함수는 테이블의 로우 값만 뽑아 오기 때문에
-- 같은 줄을 불러오지 않는다. 따라서 지정한 값 과 연동 된 줄을 불러 올 수 없다.

SELECT * FROM products
WHERE Price = (SELECT MAX(Price) FROM products); -- 서브쿼리를 사용한다면 불러올 수 있다.

-- MIN 최솟값
SELECT MIN(Price) FROM products;
SELECT * FROM products
WHERE Price = (SELECT MIN(Price) FROM products); -- 최소 가격을 갖은 제품의 정보를 불러오기.

-- 예) 가장 어린 직원 명 조회
SELECT MAX(BirthDate) FROM employees;
SELECT CONCAT(LastName, ' ',FirstName) Name FROM employees
WHERE BirthDate = (SELECT MAX(BirthDate) FROM employees);
-- 예) 가장 나이 많은 직원명 조회
SELECT CONCAT(LastName, ' ',FirstName) Name FROM employees
WHERE BirthDate = (SELECT MIN(BirthDate) FROM employees);

-- COUNT : 갯수
SELECT * FROM employees;
SELECT COUNT(EmployeeID) FROM employees;
SELECT COUNT(LastName) FROM employees;
SELECT COUNT(FirstName) FROM employees;

-- null은 포함하지 않는다.
INSERT INTO employees (LastName)
VALUE ('흥민');
SELECT COUNT(EmployeeID) FROM employees; -- 10 id는 자동 증가라서 들어가있고
SELECT COUNT(FirstName) FROM employees; -- 9 흥민이 null이기 때문에 9 개
SELECT COUNT(LastName) FROM employees; -- 10 흥민이 들어 있어서 10개

SELECT MIN(BirthDate) FROM employees; -- null은 집계함수에 잡히지 않기때문에 최소 최대 값에 속할 수 없다.
SELECT MAX(BirthDate) FROM employees;

INSERT INTO products (ProductName)
VALUE ('커피');
SELECT * FROM products ORDER BY 1 DESC;
SELECT MIN(Price) FROM products; -- null 은 고려대상이 아니다
-- 하지만 null이면 0으로 계산 하고 싶을때
-- IFNULL 을 사용하면 된다.
SELECT MIN(IFNULL(Price, 0)) FROM products;
SELECT * FROM products
WHERE IFNULL(Price,0) = (SELECT MIN(IFNULL(Price, 0)) FROM products); -- 서브쿼리에서 부르고싶으면 where에 비교대상도 ifnull을 사용해야 한다.



