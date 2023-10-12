-- normalization : 정규화
-- sql 책 209

USE mydb1;
-- atomic data (원자적 데이터) sql 책 209쪽
-- 예)이름, 최종학력, 특기
CREATE TABLE my_table21_person (
    name VARCHAR(100) NOT NULL ,
    schools VARCHAR(100) ,
    skill VARCHAR(1000)
);
INSERT INTO my_table21_person (name, schools, skill)
VALUE ('손흥민','대학','축구,노래');
INSERT INTO my_table21_person (name, schools, skill)
    VALUE ('이강인','대학원','야구,농구');
INSERT INTO my_table21_person (name, schools, skill)
    VALUE ('김민재','대학원','배구');
-- skill 은 못생긴 테이블 (노말 하지 않다.)

SELECT * FROM my_table21_person;

--
CREATE TABLE my_table22_person (
    name VARCHAR(20) NOT NULL ,
    schools VARCHAR(100) ,
    skill1 VARCHAR(100),
    skill2 VARCHAR(100),
    skill3 VARCHAR(100)
);
INSERT INTO my_table22_person (name, schools, skill1, skill2, skill3)
VALUE ('흥민','대학교','축구','노래',null);
INSERT INTO my_table22_person (name, schools, skill1, skill2, skill3)
    VALUE ('강인','대학원','야구','농구',null);
INSERT INTO my_table22_person (name, schools, skill1, skill2, skill3)
    VALUE ('민재','대학교','배구',null,null);
SELECT * FROM my_table22_person;
-- 21 과 22 는 노말하지 않다 22에서 따로 작성했더라 하더라도.
-- 규칙1 table21 : 원자적 데이터로 구성된 열은 그열에 같은 타입의 데이터를 갖을수 없다.
-- (규칙2)table22 : 같은 타입의 데이터를 여러열에 가질 수 없다. 책 209쪽 규칙2


-- 원자적이게 데이터를 만드는 법 (아직 노말 하지는 않음) -> 각 테이블에 한타입의 데이터 한개 씩만
CREATE TABLE my_table23_person (
   name VARCHAR(100) NOT NULL ,
   schools VARCHAR(100) ,
   skill VARCHAR(1000)
);
INSERT INTO my_table23_person (name, schools, skill)
VALUE ('흥민', '대학', '축구');
INSERT INTO my_table23_person (name, schools, skill)
    VALUE ('흥민', '대학', '노래');

INSERT INTO my_table23_person (name, schools, skill)
    VALUE ('강인', '대학', '야구');
INSERT INTO my_table23_person (name, schools, skill)
    VALUE ('강인', '대학', '농구');

SELECT * FROM my_table23_person;

-- 노말 -> 컬럼당 하나의 데이터씩, 각행의 고유한 기본 키\

-- KEY : 각 행을 구분하는 컬럼(들)

-- 책 215 정규화
-- 각 행의 데이터들은 원자적 값을 가져야 한다.
-- 각 행은 유일무이한 식별자인 기본키(primary key)를 가지고 있어야 한다.
CREATE TABLE my_table24_person (
    ssn VARCHAR(10) NOT NULL UNIQUE , -- primary key 역할
    name VARCHAR(10) NOT NULL ,
    school VARCHAR(10),
    skill VARCHAR(10)
);

-- 책 216쪽~ 나온다.
-- 기본키(primary key) 조건 :
-- null이 있으면 안된다.
-- 레코드가 삽입될 때 값이 있어야 한다
-- 기본키는 간결해야 한다.
-- 기본키의 값을 변경할 수 없다. -> 이미 사용된 값으로 변경될 위험이 있기 때문에

-- 드디어 노말한 테이블
CREATE TABLE my_table25_person (
    id INT NOT NULL UNIQUE AUTO_INCREMENT, -- auto increment : 우리가 생성해주지 않아도 자동으로 생성해주며 누적번호를 생성 해주는것
    ssn VARCHAR(10) NOT NULL ,
    name VARCHAR(10) NOT NULL ,
    school VARCHAR(10),
    skill VARCHAR(10)
);
-- DROP TABLE my_table25_person;
INSERT INTO my_table25_person (ssn, name, school, skill)
VALUE ('080101','손','대학','축구');
INSERT INTO my_table25_person (ssn, name, school, skill)
    VALUE ('080101','손','대학','노래');
INSERT INTO my_table25_person (ssn, name, school, skill)
    VALUE ('091020','강인','대학원','농구');
INSERT INTO my_table25_person (ssn, name, school, skill)
    VALUE ('091020','강인','대학원','축구');

SELECT * FROM my_table25_person;

CREATE TABLE my_table26_person (
       id INT PRIMARY KEY AUTO_INCREMENT,-- PRIMARY KEY : not null, unique 를 한번에 사용할때 프라이머리 키로 사용 할 수 있다.
       ssn VARCHAR(10) NOT NULL ,
       name VARCHAR(10) NOT NULL ,
       school VARCHAR(10),
       skill VARCHAR(10)
);
DESC my_table25_person;
DESC my_table26_person;