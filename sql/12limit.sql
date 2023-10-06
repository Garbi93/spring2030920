-- Limit 조회 레코드 (행, row)  제한
SELECT * FROM customers;
SELECT * FROM customers
LIMIT 3;

SELECT * FROM employees
LIMIT 2;

SELECT * FROM employees
ORDER BY BirthDate
LIMIT 2; -- 나이가 많은 2사람만 조회

SELECT * FROM products
ORDER BY Price
LIMIT 10;

-- 예) 가장 어린 3명의 직원 조회
SELECT * FROM employees
ORDER BY BirthDate DESC
LIMIT 3; -- 리미트는 가장 마지막에 쓸 수 있다.

-- 예) 2번 카테고리에서 가장 저렴한 상품 조회
SELECT * FROM products
WHERE CategoryID = 2
ORDER BY Price
LIMIT 1;

-- LIMIT n : n개
-- LIMIT n,m : n부터 m개(n은 0번부터)
SELECT ProductName, Price
FROM products
ORDER BY Price
LIMIT 3;
SELECT ProductName, Price
FROM products
ORDER BY Price
LIMIT 0, 3;
SELECT ProductName, Price
FROM products
ORDER BY Price
LIMIT 1, 3; -- 1번부터 3개
SELECT ProductName, Price
FROM products
ORDER BY Price
LIMIT 2, 3; -- 2번 부터 3개
SELECT ProductName, Price
FROM products
ORDER BY Price
LIMIT 3, 3; -- 3번 부터 3개

-- 페이지 나누기
SELECT CustomerID, CustomerName FROM customers
ORDER BY CustomerID; -- 91 개의 레코드가 존재
SELECT CustomerID, CustomerName FROM customers
ORDER BY CustomerID
LIMIT 0, 10; -- 1페이지 10개
SELECT CustomerID, CustomerName FROM customers
ORDER BY CustomerID
LIMIT 10, 10; -- 2페이지 10개
SELECT CustomerID, CustomerName FROM customers
ORDER BY CustomerID
LIMIT 20, 10; -- 3페이지 10개
SELECT CustomerID, CustomerName FROM customers
ORDER BY CustomerID
LIMIT 90, 10; -- 마지막 페이지 10개 부족하면 있는만큼만 보여준다.



-- 예) 공급자(suppliers)를 한 페이지에 5씩 공급자 번호순으로 보여줄 때
--                3번째 페이지 조회 코드 작성
SELECT *
FROM suppliers
ORDER BY SupplierID
LIMIT 10, 5;

-- 한페이지가 n개의 레코드를 보여주면
-- m번째 페이지 조회는
-- LIMIT (m-1)*n, n 그런데 limit안에는 연산자가 안들어간다.... 그냥 값을 넣어줘야함