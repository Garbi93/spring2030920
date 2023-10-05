-- between 사이의 값을 조회

SELECT * FROM products
WHERE Price >= 10 AND Price <= 13;
SELECT * FROM products
WHERE Price BETWEEN 10 AND 13; -- 비트윈과 앤드는 같이 사용한다 값이 포함된 상태
-- 등호 없이 하고 싶다면
SELECT * FROM products
WHERE Price BETWEEN 10 AND 12.99;

SELECT * FROM products
WHERE Price BETWEEN '10' AND '13';

SELECT * FROM customers
WHERE CustomerName BETWEEN 'a' and 'c';
SELECT * FROM orders
WHERE OrderDate BETWEEN '1996-01-01' AND '1996-12-31';

-- 예) 가격이 30~40(포함) 사이인 상품 조회
SELECT * FROM products
WHERE Price BETWEEN 30 AND 40;
-- 예) 1998년 2월에 주문한 주문 조회
SELECT * FROM orders
WHERE OrderDate BETWEEN '1998-02-01' AND '1998-02-29';
-- 예) 1958년 9월에 태어난 직원 조회
SELECT * FROM employees
WHERE BirthDate BETWEEN '1958-09-01' AND '1958-09-30';
