SELECT * FROM customers ORDER BY 1 DESC;
INSERT INTO customers (CustomerName)
VALUE ('흥민');
INSERT INTO customers(CustomerName, ContactName)
VALUE ('강인', ''); -- 빈값을 넣으면 빈 String 으로 들어간다.
-- 빈String 과 null 은 다른것이다.
INSERT INTO customers(CustomerName,ContactName)
VALUE ('민재', null);


SELECT ProductID, ProductName, Price FROM products ORDER BY 1 DESC;
INSERT INTO products(ProductName, Price)
VALUE ('피자',0.00);
INSERT INTO products(ProductName, Price)
    VALUE ('햄버거',null); -- 0과 null은 다르다

-- NULL : 값이 없음
SELECT * FROM products
WHERE Price = 0.00
ORDER BY 1 DESC;

SELECT * FROM products
WHERE Price != 0.00
ORDER BY 1 DESC; -- 여기서도 null이 들어간 데이터는 조회가 안된다.

-- 비교 연산시 피연산자가 NULL 이면 결과는 항상 false
SELECT * FROM products
WHERE Price IS NULL; -- 컬럼의 값이 null인것을 확인하는 것

SELECT * FROM products
WHERE NOT Price IS NULL;
SELECT * FROM products
WHERE Price IS NOT NULL;

-- 가능하면 빈 String으로 라도 넣어두자 null을 넣으면 어려워진다.

SELECT ProductName, Price * 100 -- 산술연산시 피연산자가 null이면 결과가 null
FROM products;

SELECT ProductName,Price
FROM products
ORDER BY ProductID DESC;

-- null인값을 조회할때만 0으로 조회하고 싶을때
SELECT ProductName, IFNULL(Price,0.00) -- ifnull을 사용 하여 대채 값을 넣어서 조회시킨다.
FROM products
ORDER BY ProductID DESC;

SELECT * FROM customers ORDER BY 1 DESC;
-- 예) contactName이 null인 고객들 조회
SELECT * FROM customers
WHERE ContactName IS NULL;
-- 예) address가 null인 고객들 조회
SELECT * FROM customers
WHERE Address IS NULL;
-- 예) 고객들을 조회 하는데 (customerName,country 컬럼만), 단 country가 null 이면 '없음'으로 표시되게 조회하라
SELECT CustomerName, IFNULL(Country, '없음') FROM customers
ORDER BY 1 DESC;









