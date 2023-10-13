USE w3schools;
SELECT DISTINCT CustomerID FROM orders ORDER BY 1;
-- sub쿼리
SELECT CustomerName
FROM  customers
WHERE CustomerID NOT IN (SELECT DISTINCT CustomerID FROM orders ORDER BY 1);

-- 조인
SELECT c.CustomerName
FROM customers c LEFT JOIN orders o
ON c.CustomerID = o.CustomerID
WHERE o.CustomerID IS NULL;-- 주문한적 없는 고객들 조회 하는 방법
-- left join으로 주문한 고객과 안한 고객 들을 불러와서 주문 테이블 에 고객ID 가 null인 상태를 조회 하는 방식으로 사용

SELECT CONCAT(LastName,' ',FirstName) name
FROM employees e LEFT JOIN orders o
ON e.EmployeeID = o.EmployeeID
WHERE o.EmployeeID IS NULL; -- 주문을 처리한적 없는 직원이 없다

SELECT DISTINCT EmployeeID FROM orders ORDER BY 1;
SELECT COUNT(*) FROM employees;

INSERT INTO employees(lastname, firstname, birthdate, photo, notes)
VALUE ('손','흥민','2020-01-01','사진1','축구선수'); -- 주문 처리한적 없는 직원 만들어서 조회해보기