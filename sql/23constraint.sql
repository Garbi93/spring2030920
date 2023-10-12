-- NULL 허용 여부
-- 유일한 값 여부
-- 기본값 지정
-- 값 체크

USE mydb1;

CREATE TABLE my_table13 (
  col1 INT NULL, -- null 허용
  col2 INT NOT NULL  -- null 허용 안함
);

INSERT INTO my_table13 (col1, col2)
VALUE (33,34); -- ok

INSERT INTO my_table13 (col2)
VALUE (55); -- ok

INSERT INTO my_table13 (col1)
VALUE (66); -- not ok

SELECT * FROM my_table13;

--
-- UNIQUE : 해당 컬럼에 유일한값을 허용할지 안 할지
CREATE TABLE my_table14 (
    col1 INT,
    col2 INT UNIQUE  -- 이 컬럼에 중복된 값을 넣을 수 없음
);
INSERT INTO my_table14 (col1, col2)
VALUE (11,22); -- ok
INSERT INTO my_table14 (col1, col2)
VALUE (11,34); -- ok
INSERT INTO my_table14 (col1, col2)
VALUE (11, 34); -- not ok 이미 위에서 col2에 34 를 넣어서
INSERT INTO my_table14 (col1)
VALUE (11); -- 이때 col2에 는 null 이지만 null은 unique 이라도 중복 입력이 가능하다.

SELECT * FROM my_table14;


--
-- 그렇다면 null 도 중복불가능 하게 하려면 not null을 쓰자
CREATE TABLE my_table15 (
    col1 INT,
    col2 INT NOT NULL ,
    col3 INT UNIQUE ,
    col4 INT NOT NULL UNIQUE
);
INSERT INTO my_table15 (col1, col2, col3, col4)
VALUE (11,22,33,44); -- ok
INSERT INTO my_table15 (col1, col2, col3, col4)
    VALUE (11,22,33,44); -- not ok col3, col4가 중복이 허용이 아니기 때문
INSERT INTO my_table15 (col1, col2, col3, col4)
VALUE (11,22,44,NULL); -- not ok col4가 null을 허용을 안 하기 때문에
INSERT INTO my_table15 (col1, col2, col3, col4)
    VALUE (11,22,44,55); -- ok

-- 예) my_table16 지금까지 배운 제약 사항을 사용 해서 연습해보자
CREATE TABLE my_table16(
    colName VARCHAR(10) NOT NULL,
    colAge INT ,
    colPhone VARCHAR(15) NOT NULL UNIQUE ,
    colAddress VARCHAR(30),
    colNotes VARCHAR(100)
);
INSERT INTO my_table16 (colName, colAge, colPhone, colAddress, colNotes)
VALUE ('홍길동',30,'010',null,null); -- ok
INSERT INTO my_table16 (colName, colPhone)
    VALUE ('홍길동','010'); -- not ok
INSERT INTO my_table16 (colName, colPhone)
    VALUE ('임꺽정','010-1'); -- ok
INSERT INTO my_table16 (colName, colAge, colPhone, colAddress, colNotes)
VALUE ('이강인' ,20 , '0000','123ㅂㅈㄷ','ㅁㄴㅇ'); --  ok
SELECT * FROM my_table16;

--
-- DEFAULT : 기본값
CREATE TABLE my_table17 (
    col1 INT,
    col2 INT DEFAULT 100, -- 값을 넣지 않으면 100
    col3 VARCHAR(10) DEFAULT 'empty', -- 값을 넣지 않으면 'empty'라는 스트링을 넣는다
    col4 DATETIME DEFAULT NOW() -- 값을 넣지 않으면 현재 일시로 넣는다.
);
INSERT INTO my_table17 (col1, col2, col3, col4)
VALUE (22, 33, 'son','2023-11-11 12:30:21');
INSERT INTO my_table17 (col1)
    VALUE (222); -- col1 만 넣으면 나머지 들은 우리가 정해준 기본값이 들어간 것을 볼 수 있다.
INSERT INTO my_table17 (col1, col2, col3, col4)
    VALUE (22, null, null,null); -- 기본값이 설정 되어있을뿐 null을 사용 할 수도 있다.

SELECT * FROM my_table17;

CREATE TABLE my_table18 (
    col1 INT,
    col2 INT DEFAULT 300,
    col3 INT NOT NULL DEFAULT 500
);
INSERT INTO my_table18 (col1, col2, col3)
VALUE (3, NULL, NULL); -- not ok
INSERT INTO my_table18 (col1, col3)
    VALUE (3, 222); -- ok
INSERT INTO my_table18 (col1)
VALUE (4); -- ok
SELECT * FROM my_table18;


CREATE TABLE my_table19 (
    col1 INT NOT NULL UNIQUE DEFAULT 100
);

SELECT * FROM my_table19;

--
-- 테이블의 각 컬럼의 타입, 제약사항 등을 확인
-- DESCRIBE, DESC
DESC my_table18;
DESC my_table15; -- UNI는 UNIQUE / PRI는 NOT NULL과 UNIQUE를 같이 사용할때 KEY 에 보인다.

--
-- TABLE 생성 쿼리 확인
SHOW CREATE TABLE my_table15;
# CREATE TABLE `my_table15` (
#                               `col1` int(11) DEFAULT NULL,
#                               `col2` int(11) NOT NULL,
#                               `col3` int(11) DEFAULT NULL,
#                               `col4` int(11) NOT NULL,
#                               UNIQUE KEY `col4` (`col4`),
#                               UNIQUE KEY `col3` (`col3`)
# ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci

-- CHECK : 값의 유효범위 체크
CREATE TABLE my_table20 (
    col1 INT,
    col2 INT CHECK ( col2 > 100 ),
    col3 INT CHECK ( col3 > 1000 AND col3 < 2000)
);
DESC my_table20; -- check 는 제약 사항이 안보인다 인텔리 제이에서 보도록 하자
SHOW CREATE TABLE my_table20;
# CREATE TABLE `my_table20` (
#                               `col1` int(11) DEFAULT NULL,
#                               `col2` int(11) DEFAULT NULL CHECK (`col2` > 100),
#                               `col3` int(11) DEFAULT NULL CHECK (`col3` > 1000 and `col3` < 2000)
# ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci

INSERT INTO my_table20(col1, col2, col3)
VALUE (1000, 50, -10); -- not ok
INSERT INTO my_table20(col1, col2, col3)
    VALUE (1000, 150, 1500); -- ok

SELECT * FROM my_table20;


