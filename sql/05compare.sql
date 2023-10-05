-- < 작다, > 크다, >= 크거나 같다, <=작거나 같다

-- 10보다 작은 가격만 조회
SELECT * FROM products
WHERE Price < 10.00;

SELECT * FROM products
WHERE Price > 10.00;

SELECT * FROM products
WHERE Price >= 10.00;

SELECT * FROM products
WHERE Price <= 10.00;

SELECT * FROM products
WHERE Price = 10.00;

-- 10.00이 아닌경우 는 not도 가능 하지만 <>도 가능 하다
SELECT * FROM products
WHERE Price <> 10.00; -- 같지 않다
SELECT * FROM products
WHERE NOT Price = 10.00; -- 같지 않다
SELECT * FROM products
WHERE Price != 10.00; -- 같지 않다

SELECT * FROM customers
WHERE CustomerID < 3;

SELECT * FROM customers
WHERE CustomerID < '3';

SELECT * FROM customers
WHERE CustomerName = 'Alfreds Futterkiste';

SELECT * FROM customers
WHERE CustomerName < 'B';   --  사전 순서대로 a가 가장 작은 z가 제일 크다


