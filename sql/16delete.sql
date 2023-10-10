-- DELETE FROM tableName WHERE 조건
-- !! WHERE 절 꼭 작성 !! --

SELECT * FROM employees
ORDER BY 1 DESC;

-- 확인 후
SELECT * FROM employees WHERE LastName = '손';
-- 지우기
DELETE FROM employees WHERE LastName = '손';

-- 지우기 전 같은 where 절로 지울 레코드인지 확인 하고 지우자!!!!

SELECT * FROM employees WHERE FirstName = '김';  -- 확인
DELETE FROM employees WHERE FirstName = '김';    -- 확인후 삭제

SELECT * FROM employees;
-- DELETE FROM employees -- 이렇게 쓰지말자

-- 예) 직원 테이블에 오늘 입력한 레코드들 지우기
SELECT * FROM employees WHERE LastName = 'son';
DELETE FROM employees WHERE LastName = 'son';

SELECT * FROM employees WHERE LastName = '10000';
DELETE FROM employees WHERE LastName = '10000';

SELECT * FROM employees where EmployeeID = 15;
DELETE FROM employees where EmployeeID = 15;

SELECT * FROM employees where EmployeeID > 9;
DELETE FROM employees where EmployeeID > 9;

-- 예) 상품 테이블에 오늘 입력한 레트드들 지우기
SELECT * FROM products WHERE ProductID > 77;
DELETE FROM products WHERE ProductID > 77;