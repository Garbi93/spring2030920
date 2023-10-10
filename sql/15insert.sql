-- INSERT INTO tableName (columnName1, columnName2, ...)
-- VALUES(value1, value2,...)
-- sql에 데이터 집어 넣기

INSERT INTO employees (EmployeeID, LastName, FirstName, BirthDate, Photo, Notes)
VALUE (10, '손', '흥민', '2000-01-01','사진10','epl득점왕');


INSERT INTO employees (employeeid, lastname, firstname, birthdate, photo, notes)
VALUE (11, '이','강인','2000-02-02','사진11','드리블 잘함');

-- 모든 컬럼에 값 너을 때 커럼명 나열 생략 가능
INSERT INTO employees
VALUE (12,'김','민재','2000-03-03','사진12','수비 잘함');

-- 특정 컬럼에만 값을 넣을 때는 컬럼명 생략 하면 안됨
INSERT INTO employees(EmployeeID, LastName, FirstName)
VALUE (13,'박','지성'); -- 나열된 컬럼명과 값의 순서,갯수가 같아야함

INSERT INTO employees(EmployeeID,FirstName,LastName)
VALUE (14,'차','범근'); -- 순서에 유의 하자

INSERT INTO employees(EmployeeID,FirstName,LastName)
    VALUE (15,'김','두식', '하늘을 난다'); -- 갯수도 맞춰줘야 한다

INSERT INTO employees(EmployeeID,FirstName,LastName)
    VALUE (15,'김'); -- 갯수도 맞춰줘야 한다

SELECT * FROM employees ORDER BY EmployeeID DESC ;

