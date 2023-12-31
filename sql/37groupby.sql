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
SELECT e.EmployeeID,CONCAT(e.LastName, ' ', FirstName) 직원명, SUM(p.Price * od.Quantity) `처리 금액`
FROM employees e JOIN orders o
ON e.EmployeeID = o.EmployeeID
JOIN orderdetails od
ON o.OrderID = od.OrderID
JOIN products p
ON od.ProductID = p.ProductID
WHERE o.OrderDate >='1996-08-01' AND o.OrderDate < '1996-09-01'
GROUP BY e.EmployeeID
ORDER BY `처리 금액` DESC; -- 96년 8월 영업왕 조회


-- 예) 고객별 총 주문 금액 조회
-- 고객명 , 고객별 주문 금액
SELECT c.CustomerID,c.CustomerName 고객명, SUM(p.price * od.Quantity) `주문 금액`
FROM customers c JOIN orders o
ON c.CustomerID = o.CustomerID
JOIN orderdetails od
ON o.OrderID = od.OrderID
JOIN products p
ON od.ProductID = p.ProductID
GROUP BY c.CustomerID
ORDER BY `주문 금액` DESC; -- vip 조회하기

-- 10만 달러 이상 소비한 고객 조회
SELECT * FROM
                       (SELECT c.CustomerID,c.CustomerName 고객명, SUM(p.price * od.Quantity) `주문 금액`
FROM customers c JOIN orders o
                      ON c.CustomerID = o.CustomerID
                 JOIN orderdetails od
                      ON o.OrderID = od.OrderID
                 JOIN products p
                      ON od.ProductID = p.ProductID
GROUP BY c.CustomerID) t1
WHERE t1.`주문 금액` >= 100000;
