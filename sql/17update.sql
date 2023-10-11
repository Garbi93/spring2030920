-- UPDATE table_name
-- SET column1 = value1, column2 = value2, ...
-- WHERE condition;

-- update

SELECT * FROM products;
SELECT * FROM products WHERE ProductID = 2; -- 변경할 레코드를 조회하고

UPDATE products
SET ProductName = '창',
    Unit = '24 - 12 온즈 병들',
    Price = 36.00
WHERE ProductID = 2; -- 레코드 업데이트 할때 꼭 where절 사용

-- UPDATE products
-- SET ProductName = '두부김치'; -- where 꼭 쓸것!!!!

-- 예) 2번 고객의 이름 수정하기
SELECT * FROM customers WHERE CustomerID = 2;
UPDATE customers
SET CustomerName = '만복이',
    City = '강원도'
WHERE CustomerID = 2;
-- 예) 5번 직원의 notes 변경하기
SELECT * FROM employees WHERE EmployeeID = 5;
UPDATE employees
SET Notes = '이 사람은 스티븐 입니다. 55년생이죠.'
WHERE EmployeeID = 5;
-- 예) 1번 공급자의 전화번호, 주소 변경하기
SELECT * FROM suppliers WHERE SupplierID = 1;
UPDATE suppliers
SET Phone = '(02)1234-5678',
    Address = '49번길 어느 지역',
    City = '런던'
WHERE SupplierID = 1;


--
SELECT * FROM products
WHERE CategoryID = 1;

UPDATE products
SET Price = Price * 2
WHERE CategoryID = 1; -- 1 번 카테고리 제품들의 가격을 2배 올리기

SELECT * FROM shippers;
SELECT * FROM employees;