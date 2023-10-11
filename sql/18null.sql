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

-- 피연산자가 NULL 이면 결과는 항상 false
SELECT * FROM products
WHERE Price IS NULL; -- 컬럼의 값이 null인것을 확인하는 것

SELECT * FROM products
WHERE NOT Price IS NULL;
SELECT * FROM products
WHERE Price IS NOT NULL;

-- 가능하면 빈 String으로 라도 넣어두자 null을 넣으면 어려워진다.





