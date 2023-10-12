-- 1 : n

--
-- 1 : 1 관계
-- 책기준 347쪽
USE mydb1;
CREATE TABLE my_table37_employee (
    id INT AUTO_INCREMENT PRIMARY KEY ,
    name VARCHAR(20),
    birth DATE,
    salary INT,
    address VARCHAR(20)
);
-- 민감한 정보를 따로 관리하고 싶을때 사용
CREATE TABLE my_table38_employee_info (
    id INT REFERENCES my_table37_employee(id),
    salay INT,
    address VARCHAR(20)
);

--
-- n : m (다대다)
-- 책기준 350쪽
-- 1:n + 1:m 을 연결하는 중간테이블을 넣어줘서 만든다.
CREATE TABLE my_table_39_person (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(20)
);
CREATE TABLE my_table40_skill (
    id INT PRIMARY KEY AUTO_INCREMENT,
    skill_name VARCHAR(20)
);
CREATE TABLE my_table41_person_skill (
    person_id INT REFERENCES my_table_39_person(id),
    skill_id INT REFERENCES my_table40_skill(id),
    PRIMARY KEY (person_id, skill_id)
);







