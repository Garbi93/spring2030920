-- 사용방법에 따라

-- 비상관쿼리 : 외부쿼리의 컬럼이 내부쿼리에 사용되지 않을 때




-- 상관쿼리 : 외부쿼리의 컬림이 내부쿼리에 사용될 때
-- 각 공급자가 있는 나라의 고객 수는?
SELECT * FROM suppliers;

SELECT COUNT(*) FROM customers WHERE Country = 'UK'; -- 상관쿼리
SELECT COUNT(*) FROM customers WHERE Country = (SELECT Country FROM suppliers WHERE SupplierID = 1); -- 비 상관쿼리
SELECT COUNT(*) FROM customers WHERE Country = (SELECT Country FROM suppliers WHERE SupplierID = 2); -- 비 상관쿼리
SELECT COUNT(*) FROM customers WHERE Country = (SELECT Country FROM suppliers WHERE SupplierID = 3); -- 비 상관쿼리
-- 비상관 쿼리는 외부쿼리가 내부에 영항을 하나도 안주고 한번만 사용 된 것?


-- 상관서브쿼리를 사용하면
SELECT s.SupplierID,s.Country,
    (SELECT COUNT(*) FROM customers WHERE customers.Country = s.Country) AS `Number Of Customers`
FROM suppliers s; -- from의 외부쿼리가 select 내부쿼리에 들어가 순회 하면서 값을 조회한다.

-- 예) 각 직원보다 나이가 많은 직원의 수를 구해보자 (lastName, NumberOfEmp)
SELECT * FROM employees;
SELECT e.lastName, (SELECT COUNT(*) FROM employees WHERE employees.BirthDate < (e.BirthDate)) AS `Number Of Emp`
FROM employees e





