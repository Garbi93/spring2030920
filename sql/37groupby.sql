-- GROUP BY : 그룹함수 사용 시 그룹함수의 범위(그룹) 지정

SELECT COUNT(DISTINCT CategoryID) FROM products;


SELECT MAX(Price) FROM  products;

SELECT CategoryID, MAX(Price)
FROM products
GROUP BY CategoryID; -- 카테고리별 최고값
-- 그룹 함수를 사용했을때는 집계함수와 달리 바로 사용 가능하다.

SELECT CategoryID, MAX(Price), MIN(Price) FROM products
GROUP BY CategoryID; -- 카테고리별 최고값, 최저값,

SELECT CategoryID, MAX(Price) maxPrice, MIN(Price) minPrice
FROM products
GROUP BY CategoryID
ORDER BY maxPrice DESC; -- 최고값 순으로 정렬하여 조회

-- 일별 매출액 구하기
SELECT o.OrderDate, SUM(p.Price * od.Quantity) AS 매출액
FROM products p JOIN orderdetails od
ON p.ProductID = od.ProductID
JOIN orders o
ON od.OrderID = o.OrderID
GROUP BY o.OrderDate;

-- 예) 직원별 총 주문 처리 금액 조회
-- 직원명, 직원별 주문 처리액
SELECT CONCAT(e.LastName, ' ', FirstName) 직원명, SUM(p.Price * od.Quantity) `처리 금액`
FROM employees e JOIN orders o
ON e.EmployeeID = o.EmployeeID
JOIN orderdetails od
ON o.OrderID = od.OrderID
JOIN products p
ON od.ProductID = p.ProductID
GROUP BY e.EmployeeID;


-- 예) 고객별 총 주문 금액 조회
-- 고객명 , 고객별 주문 금액
SELECT c.CustomerName 고객명, SUM(p.price * od.Quantity) `주문 금액`
FROM customers c JOIN orders o
ON c.CustomerID = o.CustomerID
JOIN orderdetails od
ON o.OrderID = od.OrderID
JOIN products p
ON od.ProductID = p.ProductID
GROUP BY c.CustomerID;
