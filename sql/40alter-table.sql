USE mydb1;

CREATE TABLE my_table46(
    col1 INT,
    col2 INT,
    col3 INT,
    col4 INT,
    col5 INT
);

-- NOT NULL 제약사항 추가
ALTER TABLE my_table46
MODIFY col1 INT NOT NULL;
DESC my_table46;

-- NOT NULL 제약사항 삭제
ALTER TABLE my_table46
MODIFY col1 INT NULL;

-- 예) col2에 not null 제약사항 추가
ALTER TABLE my_table46
MODIFY col2 INT NOT NULL;
DESC my_table46;

-- 예) col2에 not null 제약사항 삭제
ALTER TABLE my_table46
MODIFY col2 INT NULL;


-- DEFAULT 제약사항 추가
ALTER TABLE my_table46
ALTER col3 SET DEFAULT 100;
DESC my_table46;

-- DEFAULT 제약사항 삭제
ALTER TABLE my_table46
ALTER col3 DROP DEFAULT ;

-- 예) col4 에 기본값 0 제약사항 추가
ALTER TABLE my_table46
ALTER col4 SET DEFAULT 0;

DESC my_table46;
-- 예) col4 에 기본값 0 제약사항 삭제
ALTER TABLE my_table46
ALTER col4 DROP DEFAULT ;


-- UNIQUE 제약사항 추가
ALTER TABLE my_table46
ADD UNIQUE (col5);

-- UNIQUE 제약사항 삭제
SHOW CREATE TABLE my_table46;
# CREATE TABLE `my_table46` (
#                               `col1` int(11) DEFAULT NULL,
#                               `col2` int(11) DEFAULT NULL,
#                               `col3` int(11),
#                               `col4` int(11),
#                               `col5` int(11) DEFAULT NULL,
#                               UNIQUE KEY `col5` (`col5`)
# ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci

ALTER TABLE my_table46
DROP INDEX col5; -- 위에 조회한 코드에 uniqu key 옆에 따옴표한 이름을 지워주면 된다.

-- PRIMARY KEY 제약사항 추가
ALTER TABLE my_table46
ADD PRIMARY KEY (col1);

-- PRIMARY KEY 제약사항 삭제
ALTER TABLE my_table46
DROP PRIMARY KEY ; -- not null 이 남는다
ALTER TABLE my_table46
MODIFY col1 INT NULL ; -- null 허용 까지 해야 풀린다.




CREATE TABLE my_table47 (
    id INT AUTO_INCREMENT PRIMARY KEY ,
    name VARCHAR(10)
);

-- FOREIGN KEY 제약사항 추가
ALTER TABLE my_table46
ADD FOREIGN KEY (col5) REFERENCES my_table47(id);


-- FOREING KEY 제약사항 삭제
SHOW CREATE TABLE my_table46;
# CREATE TABLE `my_table46` (
#                               `col1` int(11) DEFAULT NULL,
#                               `col2` int(11) DEFAULT NULL,
#                               `col3` int(11),
#                               `col4` int(11),
#                               `col5` int(11) DEFAULT NULL,
#                               KEY `col5` (`col5`),
#                               CONSTRAINT `my_table46_ibfk_1` FOREIGN KEY (`col5`) REFERENCES `my_table47` (`id`)
# ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci

ALTER TABLE my_table46
DROP FOREIGN KEY my_table46_ibfk_1; -- 외래키삭제 후

ALTER TABLE my_table46
DROP INDEX col5; -- key도 삭제해 줘야 한다.


DESC my_table46;
