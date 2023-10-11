-- 새로운 테이블을 생성하는 명령어
-- 테이블을 작성하려면 테이블을 작성할 만한 공간을 마련해줘야한다
-- DATABASE, SCHEMA : 테이블들이 있는 공간


-- DATABASE 만들기
CREATE DATABASE mydb1;
CREATE SCHEMA mydb2; -- 마리아 디비에서는 데이타베이스나 스키마다 같은 명령어다.

-- SELECT * FROM mydb1.table_name;
SELECT * FROM w3schools.customers;
SELECT * FROM w3schools.products;

-- database 옮기기
USE mydb1;
USE w3schools;

-- 다른 database의 table을 사용 하려면 database 명을 붙여야 한다.
SELECT * FROM w3schools.products;

-- database 지우기
DROP DATABASE mydb2;
DROP DATABASE mydb1; -- 현재 위치한 데이터베이스도 지울수 있다.
-- 데이타 베이스는 함부로 지우면 안돼니깐 없다 싶이 써라.

CREATE DATABASE mydb1;

