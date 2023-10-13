USE w3schools;

SELECT *
FROM products p JOIN suppliers s
ON p.SupplierID = s.SupplierID;
-- USING
SELECT *
FROM products p JOIN suppliers s USING (SupplierID); -- 위의 코드와 같은 일을 한다.
-- NATURAL JOIN
SELECT *
FROM products p NATURAL JOIN suppliers s; -- 이것도 위의 코드와 같은 일을 한다. 두테이블의 같은 이름의 컬럼을 찾아서 조회한다.
