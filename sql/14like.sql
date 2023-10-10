SELECT * FROM customers
WHERE CustomerName = 'Alfreds Futterkiste';

-- 중간에 the 가 있는 사람들
SELECT * FROM customers
WHERE CustomerName LIKE '%the%';

-- 중간에 ch가 있는 사람들
SELECT * FROM customers
WHERE CustomerName LIKE '%ch%';

-- LIKE : 검색
-- %,_ 기호와 같이 사용됨

-- ch로 시작하는 문자
SELECT  * FROM customers
WHERE CustomerName LIKE 'ch%'; -- % : 0 개 이상의 문자

-- er로 끝나는 문자
SELECT * FROM customers
WHERE CustomerName LIKE '%er'; -- % : 0개 이상의 문자

-- er 을 포함하고 있는 문자
SELECT * FROM customers
WHERE CustomerName LIKE '%er%';

-- 퍼스트 네임이 5개인 직원 찾기
SELECT * FROM employees
WHERE FirstName LIKE '_____'; -- _ : 1개의 문자 (아무거나)

-- 라스트 네임이 4개인 직원 찾기
SELECT * FROM employees
WHERE LastName LIKE '____';

-- 첫글자 아무거나 한글자이고 2번째 글자가 e인 직원 찾기
SELECT * FROM employees
WHERE LastName LIKE '_e%';





