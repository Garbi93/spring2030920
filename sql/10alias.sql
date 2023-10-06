-- 별명 별칭
SELECT * FROM employees;
SELECT EmployeeID,LastName FROM employees;

-- AS : 컬럼명 (테이블명 ) 변경
SELECT
    EmployeeID AS id,
    LastName AS name
FROM employees;

SELECT
    EmployeeID,
    CONCAT(FirstName, ' ', LastName) AS fullname
FROM employees;
