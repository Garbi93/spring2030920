-- 타입은 크게 4가지
-- 수형(정수, 실수)
-- 문자열
-- 날짜 (날짜시간)
-- 마리아 db 기준

--
-- 정수 : int
CREATE TABLE my_table3 (
    col1 int
);
INSERT INTO my_table3(col1)
VALUE (23445);
INSERT INTO my_table3(col1)
    VALUE ('12300');
INSERT INTO my_table3(col1)
    VALUE ('two'); -- 안됨
SELECT * FROM my_table3;

--
-- 실수 : DEC(IMAL)
CREATE TABLE my_table4 (
    col1 DEC
);
INSERT INTO my_table4 (col1)
VALUE (3.14);
SELECT * FROM my_table4;

CREATE TABLE my_table5 (
    col1 DEC(5,3) -- 총길이 5 , 소숫점 이하 길이 3
);
INSERT INTO my_table5(col1)
VALUE (10.123);
INSERT INTO my_table5(col1)
    VALUE (10.1234); -- 표현 길이를 넘으면 잘려서 들어간다.
INSERT INTO my_table5(col1)
VALUE (123.456); -- 단 정수부분이 넘으면 값이 들어가진 못한다.
SELECT * FROM my_table5;

-- 예) my_table6 만들기
-- age 컬럼은 정수타입으로
-- score 컬럼은 총길이 7 소숫점 이하길이 2로 만들어라
CREATE TABLE my_table6(
    age int,
    score DEC(7, 2)
);
INSERT INTO my_table6(age, score)
VALUE (20,'32112.234');
SELECT * FROM my_table6;


--
-- 문자열 : VARCHAR
CREATE TABLE my_table7(
    col1 VARCHAR(1),
    col2 VARCHAR(2),
    col3 VARCHAR(16000)
);

INSERT INTO my_table7 (col1)
VALUE ('a');
INSERT INTO my_table7 (col1)
    VALUE ('가');
INSERT INTO my_table7 (col2)
    VALUE ('a');
INSERT INTO my_table7 (col2)
    VALUE ('ab');
INSERT INTO my_table7 (col2)
    VALUE ('한');
INSERT INTO my_table7 (col2)
    VALUE ('한글');
INSERT INTO my_table7 (col2)
    VALUE ('😎');

SELECT * FROM my_table7;

-- 예) my_table9 만들기
-- name 문자열 최대길이 100 자
-- address 문자열 최대길이 200자
-- phone 문자열 최대길이 100자 로 3개 컬럼을 갖는 테이블 만들어보기
CREATE TABLE my_table9 (
    name VARCHAR(100),
    address VARCHAR(200),
    phone VARCHAR(100)
);
INSERT INTO my_table9 (name, address, phone)
VALUE ('임꺽정', '산속', '010-999');
SELECT * FROM my_table9;

--
-- 날짜 : DATE(yyyy-mm-dd),
CREATE TABLE my_table10 (
  col1 DATE
);
INSERT INTO my_table10 (col1)
VALUE ('1850-02-01');
SELECT * FROM my_table10;

--
-- 날짜,시간 : DATETIME (yyyy-mm-dd hh:mm:ss)
CREATE TABLE my_table11 (
  col1 DATETIME
);
INSERT INTO my_table11 (col1)
VALUE ('2000-01-01 10:15:20');
INSERT INTO my_table11 (col1)
VALUE ('1732-12-20 15:40:20');

SELECT * FROM my_table11;

SELECT NOW(); -- 현재 날짜를 넣을때

INSERT INTO my_table11 (col1)
VALUE (NOW()); -- 현재 날짜 넣기 활용

