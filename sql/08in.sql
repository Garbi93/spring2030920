-- IN : 하나라도 같으면

SELECT * FROM customers
WHERE Country = 'uk' OR Country='spain' or Country='italy';
SELECT * FROM customers
WHERE Country IN ('uk','spain','italy');

-- 예) 카테고리 3,4에 속한 상품들
SELECT * FROM products
WHERE CategoryID IN (3,4);
-- 예) 1996년 7월 4일,5일에 주문한 주문들
SELECT * FROM orders
WHERE OrderDate IN ('1996-07-04', '1996-07-05');
-- 예) london 이나 madrid, sevilla 있는 고객들
SELECT * FROM customers
WHERE City IN ('london', 'madrid', 'sevilla')

