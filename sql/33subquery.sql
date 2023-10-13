USE w3schools;

SELECT Price FROM products WHERE ProductName = 'ipoh coffee';
SELECT ProductName, Price FROM products
WHERE Price > 46.00;
SELECT ProductName, Price FROM products
WHERE Price > (SELECT Price FROM products WHERE ProductName = 'ipoh coffee'); -- 쿼리에 쿼리가 포함된것을 sub쿼리 라고 한다,

SELECT BirthDate FROM employees
WHERE LastName = 'leverling';
SELECT LastName,FirstName,BirthDate FROM employees
WHERE BirthDate < '1963-08-30';
SELECT LastName,FirstName,BirthDate FROM employees
WHERE BirthDate < (SELECT BirthDate FROM employees
                   WHERE LastName = 'leverling'); -- 초보자일 때는 sub 쿼리가 쉽다.

-- subquery
-- 행 1개 열1개
SELECT BirthDate FROM employees
WHERE LastName = 'Leverling';

-- 행 여러개 열 1개
SELECT ShipperID FROM orders WHERE OrderDate = '1996-07-08';
SELECT CustomerName FROM customers WHERE Country = 'mexico';

-- 행 여러개 열 여러개
SELECT CustomerID, CustomerName FROM customers WHERE Country = 'mexico';

-- 행 1개 열 1개 예제
-- 'Tofu' 상품을 공급하는 공급자명
SELECT SupplierID FROM products WHERE ProductName = 'tofu';
SELECT SupplierName FROM suppliers
WHERE SupplierID = (SELECT SupplierID FROM products WHERE ProductName = 'tofu');

SELECT s.SupplierID,s.SupplierName FROM suppliers s JOIN products p
ON s.SupplierID = p.SupplierID
WHERE p.ProductName = 'tofu';

--  여러행 1열 예제
-- 멕시코 고객이 주문한 일자 조회
SELECT CustomerID FROM customers WHERE Country = 'mexico';
SELECT OrderDate FROM orders WHERE CustomerID IN (SELECT CustomerID FROM customers WHERE Country = 'mexico');
SELECT OrderDate FROM orders
WHERE CustomerID IN (SELECT CustomerID FROM customers WHERE Country = 'mexico');

-- 예) 1번 카테고리에 있는 상품이 주문된 주문번호 (orderDetails, products사용)
SELECT ProductID FROM products WHERE CategoryID = 1;
SELECT OrderID FROM orderdetails
WHERE ProductID IN (SELECT ProductID FROM products WHERE CategoryID = 1);
-- 예) 1번 카테고리에 있는 상품이 주문된 날짜
SELECT OrderDate FROM orders
WHERE OrderID IN (SELECT OrderID FROM orderdetails
                  WHERE ProductID IN (SELECT ProductID FROM products WHERE CategoryID = 1));
SELECT DISTINCT o.OrderID, o.OrderDate
FROM orders o JOIN orderdetails od
ON o.OrderID = od.OrderID
JOIN products p
ON p.ProductID = od.ProductID
WHERE p.CategoryID =1;

-- 예) 주문한 적 없는 고객들
SELECT CustomerID FROM orders;

SELECT * FROM customers WHERE CustomerID NOT IN (SELECT CustomerID FROM orders);

-- 행여러개 열 여러개
SELECT * FROM customers;

SELECT SupplierName,Address,Country FROM suppliers; -- 여러개 행 여러개 열인 공급자를
INSERT INTO customers (CustomerName,Country, Address)
(SELECT SupplierName,Address,Country FROM suppliers); -- 여러개 행 여러개 열인 소비자 테이블에 들어갈 수 있다
-- 단 열의 갯수, 열의 데이터 타입이 같아야 한다. 테이블 명은 달라도 들어갈수 있긴하다.

SELECT * FROM customers
WHERE (City, Country)
IN (SELECT City, Country FROM suppliers);

CREATE TABLE table_c
SELECT CustomerName, City, Country FROM customers; -- 소비자 테이블로 새로운 테이블을 만들겠다고 설정한것

SELECT * FROM table_c;
DESC table_c; -- 테이블 제약사항 조회

-- 예) 1번 카테고리에 있는 상품들로 새 테이블을 만드는데
--    새로운 테이블(table_d)은 productName, categoryName, price 컬럼이 존재하도록 생성해 주어라
SELECT * FROM products;

SELECT p.ProductName, c.CategoryName, p.Price
FROM products p JOIN categories c
ON p.CategoryID = c.CategoryID
WHERE c.CategoryID = 1;

CREATE TABLE table_d -- 테이블d생성
SELECT p.ProductName, c.CategoryName, p.Price
FROM products p JOIN categories c
                     ON p.CategoryID = c.CategoryID
WHERE c.CategoryID = 1;

SELECT * FROM table_d;

