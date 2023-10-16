USE w3schools;

-- ALTER TABLE : 테이블 수정

-- 컬럼 추가, 변경, 삭제(삭제는 잘 안함)

-- 제약 사항 변경
-- NOT NULL, UNIQUE,PRIMARY KEY, DEFAULT,FOREIGN KEY

-- 컬럼 추가
ALTER TABLE products
ADD COLUMN col1 INT;
ALTER TABLE products
ADD COLUMN col2 VARCHAR(10);

DESC products;
-- 중간에 컬럼을 추가
ALTER TABLE products
ADD COLUMN col3 VARCHAR(10) AFTER ProductName;
-- 특별한 이유가 없다면 뒤에 붙여주자
ALTER TABLE products
ADD COLUMN col4 VARCHAR(10) FIRST;

ALTER TABLE products
ADD COLUMN col5 INT NOT NULL DEFAULT 1 REFERENCES employees(EmployeeID);

-- 예) 직원 테이블에 salary 컬럼 마지막에 추가
-- data type 은 dec(10,2), null 허용 안하고, default값은 0.00
ALTER TABLE employees
ADD COLUMN salary DEC(10,2) NOT NULL DEFAULT 0.00;
DESC employees;


-- 컬럼 삭제
ALTER TABLE products
DROP COLUMN col1;
DESC products;

-- 예) products 테이블에서 col2 삭제
ALTER TABLE products
DROP COLUMN col2;
DESC products;

-- 컬럼 변경 (type변경)
ALTER TABLE products
MODIFY COLUMN col3 INT;
DESC products;
-- 변경시 주의 할점은 변경할때에 이미 이전 타입의 데이터가 들어있다면
INSERT INTO products(col4)
VALUE ('pizza');
ALTER TABLE products
MODIFY COLUMN col4 INT; -- 못바꾼다 이미 varchar type의 pizza가 들어있어서
ALTER TABLE products
MODIFY COLUMN col4 VARCHAR(30); -- 늘리는건 가능 하지만 줄이는건 위험하다.
ALTER TABLE products
MODIFY COLUMN col4 VARCHAR(1); -- 줄이는건 위험하다 이미 pizza가 들어있어서
