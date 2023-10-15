-- union 합집합
USE w3schools;
SELECT Country FROM customers;
SELECT Country FROM suppliers;

SELECT Country FROM customers UNION
SELECT Country FROM suppliers; -- UNION 중복된것을 제거하고 합집합 시킴

-- 중복 집합 UNION ALL
SELECT Country FROM customers UNION ALL
SELECT Country FROM suppliers;

SELECT CustomerName, Country, City FROM customers
UNION
SELECT SupplierName, Country, City FROM suppliers;

-- 예) 직원의 lastName 과 firstName을 name이라는 하나의 컬럼으로 조회 (직원이 10명인데 20명이 나오도록)
SELECT LastName name FROM employees
UNION
SELECT FirstName FROM employees;

USE mydb1;
-- LEFT OUTER JOIN
SELECT * FROM my_table44_a a LEFT JOIN my_table45_b b
ON a.col1 = b.col1;
-- RIGHT OUTER JOIN
SELECT * FROM my_table44_a a RIGHT JOIN my_table45_b b
ON a.col1 = b.col1;
-- FULL OUTER JOIN
SELECT * FROM my_table44_a a LEFT JOIN my_table45_b b
ON a.col1 = b.col1
UNION
SELECT * FROM my_table44_a a RIGHT JOIN my_table45_b b
ON a.col1 = b.col1;



