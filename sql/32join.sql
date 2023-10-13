USE w3schools;

SELECT *
FROM employees e1 JOIN employees e2; -- 같은 테이블 끼리 도 join 이 가능하다.

SELECT e1.LastName, e1.BirthDate, e2.LastName, e2.BirthDate
FROM employees e1 JOIN employees e2
WHERE e1.BirthDate < e2.BirthDate
AND e2.LastName = 'Leverling'; -- 같은 테이블 끼리 사용 하여 생일이 많은 사람을 걸러 내는 예제
-- 같은 테이블 조회를 self join 이라고도 한다.

-- 예) 'Ipoh Coffee' 보다 비싼 상품명 조회
SELECT p1.ProductName, p1.Price, p2.ProductName, p2.Price
FROM products p1 JOIN products p2
WHERE p1.Price < p2.Price
    AND p1.ProductName = 'Ipoh Coffee';