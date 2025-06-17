--샘플 확인용 테이블 시퀀스.

CREATE SEQUENCE member501_seq
START WITH 1
INCREMENT BY 1;

--샘플 확인용 테이블 만들기

create table member501 (
    id number PRIMARY KEY,
    name varchar2(100),
    password varchar2(100),
    email varchar2(100),
    reg_date varchar2(50)
);

--샘플 데이터 하나 넣기.
insert into member501 (id, name, password, email, reg_date) values (member501_seq.sequence.NEXTVAL, '이상록', '1234', 'lsr@naver.com', '2025년06월16일12시09분');


SELECT sequence_name FROM user_sequences WHERE sequence_name = 'MEMBER501_SEQ';

select * from member501;