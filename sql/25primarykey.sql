USE mydb1;
-- PRIMARY KEY (주키 , 기본키, pk)
CREATE TABLE my_table27 (
    id INT PRIMARY KEY ,
    name VARCHAR(20)
);
CREATE TABLE my_table28 (
    id INT,
    name VARCHAR(10),
    PRIMARY KEY (id)
);
CREATE TABLE my_table29 (
    name VARCHAR(10),
    birth DATE,
    PRIMARY KEY (name, birth)
); -- 이렇게도 사용가능한데 가능하면 프라이머리 키는 하나만 사용 한다.

CREATE TABLE  my_table30(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(10)
); -- 주로 이런식으로 쓴다 하지만 꼭 이렇게 쓸필요는 없다

INSERT INTO my_table30 (name)
VALUE ('son');
INSERT INTO my_table30 (name)
    VALUE ('lee');
INSERT INTO my_table30 (name)
    VALUE ('kim');
SELECT * FROM my_table30;

DELETE FROM my_table30
WHERE id = 4;
-- 중간에 id 를 삭제 하여 지나간 것은 채워두려고 하지 마라 나중에 다시 원복 할 수도 있기 때문에

