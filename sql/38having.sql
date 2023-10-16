-- HAVING : 그룹함수 연산결과를 조건으로 줄 수 있는 키워드
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

-- HAVING
SELECT c.CustomerID,c.CustomerName 고객명, SUM(p.price * od.Quantity) `주문 금액`
FROM customers c JOIN orders o
                      ON c.CustomerID = o.CustomerID
                 JOIN orderdetails od
                      ON o.OrderID = od.OrderID
                 JOIN products p
                      ON od.ProductID = p.ProductID
GROUP BY c.CustomerID
HAVING `주문 금액` >= 100000
ORDER BY `주문 금액` DESC;
-- 연산후 다시 필터링 해서 볼 수 있게 해준다.

-- 예) 총 처리 금액이 10만 달러 미만인 직원  조회
-- orders, orderDetails, products, employees
SELECT e.EmployeeID,CONCAT(LastName,' ',FirstName) name ,SUM(p.Price * od.Quantity) `처리 금액`
FROM employees e JOIN orders o
ON e.EmployeeID = o.EmployeeID
JOIN orderdetails od
ON o.OrderID = od.OrderID
JOIN products p
ON od.ProductID = p.ProductID
GROUP BY e.EmployeeID
HAVING `처리 금액` < 100000;