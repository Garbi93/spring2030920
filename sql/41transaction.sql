-- 업무단위
USE w3schools;

CREATE TABLE bank (
  name VARCHAR(10) PRIMARY KEY ,
  money INT NOT NULL DEFAULT 0
);
INSERT INTO bank (name, money)
VALUES ('son',10000),
       ('kim',10000);

-- 송금 업무 son -> kim 1000원 송금
UPDATE bank
SET money = money -1000
WHERE name = 'son';
UPDATE bank
SET money = money + 1000
WHERE name = 'kim';
-- 송금후 조회
SELECT * FROM bank; -- 내부연결에서는 바로 보이지만 다른연결에서는 transaction이완료 되어야 보여진다.

-- 두가지 이상의 일이 꼭 한번에 완료 시키고 싶을 때 transaction으로 묶어서 사용 한다.
-- tx메뉴 를 auto 에서 manual로 바꿔준다.

-- 완료 시키는 방법 2가지
-- 되돌리기
ROLLBACK ;
-- 반영하기
COMMIT ; -- 원하는 작업들이 완료 되었다면
