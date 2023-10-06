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
SELECT
    EmployeeID,
    CONCAT(FirstName, ' ', LastName) fullname
FROM employees; -- AS를 안써도 별칭이 적용이 가능하다.
SELECT
    EmployeeID,
    CONCAT(FirstName, ' ', LastName) `full name`
FROM employees; -- 띄어쓰기나 키워드를 넣고싶으면 ``안에 넣어 사용 하면 된다

-- 예) 공급자의 이름(suppliersName), 주소(address, city, country)연결
-- 전화번호(phone -> phone number)
-- supplierName, address, `phone number`
SELECT
    SupplierName,
    CONCAT(Address, ' ',City, ' ', Country) address,
    Phone `phone number`
FROM suppliers;

SELECT * FROM products;
SELECT * FROM categories;

-- 두개의 테이블을 결합하여 보여주기
SELECT products.ProductName,
       categories.CategoryName
FROM products JOIN categories
    ON products.CategoryID = categories.CategoryID;

SELECT p.ProductName,
       c.CategoryName
FROM products AS p JOIN categories AS c
    ON p.CategoryID = c.CategoryID; -- 별칭을 사용하여 위 코드를 줄일 수 있다.