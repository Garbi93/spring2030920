-- 정규화 NORMALIZATION

-- 첫번째 정규화 (FIRST NORMAL FORM) 1NF
-- 원자적 데이터를 가진 테이블, PK 컬럼이 있어야함

-- 책 (369쪽)
-- 두번째 정규화 (SECOND NOMAL FORM) 2NF
-- 1NF를 충족하고, 부분적 함수 의존이 없어야함

-- 부분적함수 의존(partial funtional dependency)
-- 키가 아닌 컬럼의 값이 키 컬럼 일부에 종속되지 않아야 한다.
-- 키의 일부가 변경되면 키가 아닌 컬럼이 변경 되어야 한면 부분적 함수 의존이 생긴다.

-- 책(374쪽)
-- 세번째 정규화 (THIRD NORMAL FORM) 3NF
-- 2NF 까지 충족하고, 이행적 종속이 없어야 한다.

-- 애행적 종속 (trnasitive dependency) :
-- 키가 아닌 컬럼이 키가 아닌 다른 컬럼에 의존
-- 키가 아닌 컬럼이 변경되면 다른 키가 아닌 컬럼이 변경되어야 할때

-- 입사 지원자
-- id, 이름, 최종학교, 학교주소
CREATE TABLE my_table31(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(10) NOT NULL ,
    school VARCHAR(20),
    school_address VARCHAR(50)
);
INSERT INTO my_table31 (name, school, school_address)
VALUES ('흥민','서울대','관악'),
       ('강인','고려대','안암'),
       ('민재','연세대','신촌'),
       ('지성','고려대','안암'),
       ('범근','연세대','신촌');

SELECT * FROM my_table31;

CREATE TABLE my_table31_person(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(10),
    school VARCHAR(10)
);
CREATE TABLE my_table_school (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(10),
    address VARCHAR(10)
);

INSERT INTO my_table31_person (name, school)
VALUES ('흥민','서울대'),
       ('강인','고려대'),
       ('민재','연세대'),
       ('지성','고려대'),
       ('범근','연세대');
INSERT INTO my_table_school (name, address)
VALUES ('서울대','관악'),
       ('고려대','안암'),
       ('연세대','신촌');

SELECT * FROM my_table31_person;
SELECT * FROM my_table_school;

CREATE TABLE my_table32_person(
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(10),
  school_id INT -- 한테이블의 컬럼이 다른 테이블을 참조(reference)하면 pk를 사용해야함
);
CREATE TABLE my_table32_school (
 id INT PRIMARY KEY AUTO_INCREMENT,
 name VARCHAR(10),
 address VARCHAR(10)
);
INSERT INTO my_table32_person (name, school_id)
VALUES ('흥민',1),
 ('강인',2),
 ('민재',1);
INSERT INTO my_table32_school(name, address)
VALUES ('서울대','관악'),
       ('연세대','신촌'),
       ('고려대','안암');

INSERT INTO my_table32_person(name, school_id)
VALUE ('지성',4); -- 학교 번호가 3번까지 있는데 4번이 들어가는 상황이 생긴다.

SELECT * FROM my_table32_person;
SELECT * FROM my_table32_school;



--
-- 제약사항을 걸어둬야 한다.
CREATE TABLE my_table33_person(
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(10),
  school_id INT REFERENCES my_table33_school(id) -- 제약사항을 걸어둬야 한다(PK)로 만들어야 한다
  -- 그리고 제약사항을 참조 한 상태라면 제약사항이 있는 테이블을 먼저 생성해야한다
  -- 외래키 (foreign key) 제약사항
);
CREATE TABLE my_table33_school (
   id INT PRIMARY KEY AUTO_INCREMENT,
   name VARCHAR(10),
   address VARCHAR(10)
);

INSERT INTO my_table33_person (name, school_id)
VALUES ('흥민',1),
       ('강인',2),
       ('민재',1);
INSERT INTO my_table33_school(name, address)
VALUES ('서울대','관악'),
       ('연세대','신촌'),
       ('고려대','안암');

INSERT INTO my_table33_person(name, school_id)
    VALUE ('지성',4);

DELETE FROM my_table33_school WHERE id = 1;

DESC my_table33_person;
SHOW CREATE TABLE my_table33_person;
# CREATE TABLE `my_table33_person` (
#                                      `id` int(11) NOT NULL AUTO_INCREMENT,
#                                      `name` varchar(10) DEFAULT NULL,
#                                      `school_id` int(11) DEFAULT NULL,
#                                      PRIMARY KEY (`id`),
#                                      KEY `school_id` (`school_id`),
#                                      CONSTRAINT `my_table33_person_ibfk_1` FOREIGN KEY (`school_id`) REFERENCES `my_table32_school` (`id`)
# ) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci

SELECT * FROM my_table33_person;
SELECT * FROM my_table33_school;

-- 외래키, 참조키, FK(foreign key)

