USE w3schools;
SELECT * FROM products;
SELECT * FROM categories;

-- chais 상품의 카테고리 명은?
SELECT CategoryID FROM products
WHERE ProductName = 'chais';

SELECT CategoryName FROM categories
WHERE CategoryID = 1;

-- JOIN : 두개의 테이블 결합
SELECT * FROM categories, products;
SELECT COUNT(*) FROM categories, products;

SELECT * FROM categories JOIN products;
SELECT COUNT(*) FROM categories JOIN products; -- 8 * 77 = 616

SELECT COUNT(*) FROM categories; -- 8
SELECT COUNT(*) FROM products; -- 77

--
CREATE TABLE table_a (
    product_id INT PRIMARY KEY AUTO_INCREMENT,
    product_name VARCHAR(20),
    category_id INT
);
CREATE TABLE table_b(
    category_id INT PRIMARY KEY AUTO_INCREMENT,
    category_name VARCHAR(20)
);
INSERT INTO table_b (category_name)
VALUES ('음료수'),('반찬');
INSERT INTO table_a(product_name, category_id)
VALUE ('콜라',1),
    ('사이다',1),
    ('제육',2),
    ('돈까스',2),
    ('두부',2);
SELECT * FROM table_a JOIN table_b;
-- 두 테이블을 결합하면 조회된 레코드 수는
-- 조회된 레코드 수는 A테이블 row * B테이블 row
-- 컬럼 수는 A테이블과 B테이블의 컬럼 수를 더한것을 보여준다

SELECT * FROM table_a;

SELECT *
FROM table_a JOIN table_b
WHERE table_a.product_name = '콜라' -- 컬럼명이 하나의 테이블에만 있을때 테이블 명 생략 가능하지만 / 같은 컬럼명을 갖은 테이블을 조회할때는 테이블을 명시해 주어야 한다.
AND table_b.category_id = table_a.category_id; -- 여러 테이블에서 컬럼을 조회 할때는 테이블 명을 입력해주고 컬럼을 입력해줘야 조회된다.

SELECT * FROM table_a JOIN table_b
ON table_a.category_id = table_b.category_id -- 조인 조건
WHERE product_name = '콜라'; -- 두 테이블의 컬럼의 값이 같은것만 조회 하기

SELECT ProductID,ProductName,CategoryName FROM products JOIN categories
ON products.CategoryID = categories.CategoryID
WHERE ProductName = 'chais'; -- 조인한 것의 차이즈라는 상품 조회

SELECT ProductID,ProductName,CategoryName
FROM products AS p JOIN categories AS c
ON p.CategoryID = c.CategoryID
WHERE ProductName = 'chais';

-- 예) supplier, products 테이블을 조인 하여 chais 상품의 공급자명, 전화번호 조회
SELECT SupplierName, Phone
FROM suppliers AS sup JOIN products AS pro
ON sup.SupplierID = pro.SupplierID
WHERE ProductName = 'chais';
-- 예) 1996년 7월 4일 에 주문한 고객명 (customer, orders)
SELECT CustomerName
FROM customers JOIN orders
ON customers.CustomerID = orders.CustomerID
WHERE OrderDate = '1996-07-04';
-- 예) 1996년 7월 4일 에 주문을 담당한 직원명 (employees, orders)
SELECT LastName, FirstName
FROM employees JOIN orders
ON employees.EmployeeID = orders.EmployeeID
WHERE OrderDate = '1996-07-04';

SELECT COUNT(*) FROM products; -- 77
SELECT COUNT(*) FROM suppliers; -- 29
SELECT COUNT(*) FROM categories; -- 8
SELECT 77 * 29 * 8;
-- 3개의 테이블 조회
SELECT * FROM products, suppliers, categories; -- 17864

SELECT p.ProductName, s.SupplierName, s.Phone, c.CategoryName
FROM products p
    JOIN suppliers s
        ON p.SupplierID = s.SupplierID
    JOIN categories c
        ON p.CategoryID = c.CategoryID
WHERE ProductName = 'chais'; -- 여러 테이블 join, on 시키는 방법


-- 예) 'chang'상품의 공급자명, 카테고리명을 조회
SELECT p.ProductName, c.CategoryName
FROM products p JOIN categories c
ON p.CategoryID = c.CategoryID
WHERE p.ProductName = 'chang';

-- 예) '1996-07-09'에 주문한고객명과, 처리한 직원명
SELECT c.CustomerName, e.LastName, e.FirstName
FROM orders o JOIN customers c
ON o.CustomerID = c.CustomerID
JOIN employees e
ON o.EmployeeID = e.EmployeeID
WHERE o.OrderDate = '1996-07-09';

-- 예) '1996-07-09'에 주문한 상품명 (orders, orderDetail, products)
SELECT p.ProductName
FROM orders o JOIN orderdetails od
ON o.OrderID = od.OrderID
JOIN products p
ON od.ProductID = p.ProductID
WHERE o.OrderDate = '1996-07-09';


