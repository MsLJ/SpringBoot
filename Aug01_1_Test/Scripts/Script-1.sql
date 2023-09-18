
CREATE TABLE Member(
m_id varchar2(40 char)PRIMARY KEY,
m_pw varchar2 (90 char)NOT NULL,
m_name varchar2(20 char)NOT NULL,
m_nick varchar2(20 char)NOT NULL,
m_birth DATE NOT NULL,
m_addr varchar2 (90 char)NOT NULL,
m_icon varchar2 (100 char)NOT NULL,
m_point number(5)NOT NULL,
m_leave number(1)NOT null
);
SELECT * FROM MEMBER;
DELETE 
UPDATE FROM MEMBER WHERE m_id=''
UPDATE member
SET
m_leave =0
WHERE
m_id ='dlwmsgk21@gmail.com'
CREATE TABLE User_Authorities (
    authority_id NUMBER PRIMARY KEY,
    authority_name VARCHAR2(50) NOT NULL
);

CREATE SEQUENCE authority_sequence;

CREATE TABLE member_log(
ml_logno number(6) PRIMARY key,
ml_m_id varchar2(40 char)NOT NULL,
ml_m_date DATE default sysdate,
CONSTRAINT log_id
	FOREIGN KEY (ml_m_id) REFERENCES Member_Writer(mw_m_id)
	ON DELETE cascade
);
SELECT* FROM member_log;
CREATE SEQUENCE member_log_seq;



CREATE SEQUENCE report_seq;



DROP TABLE MEMBER;
DELETE FROM MEMBER  WHERE M_ID ='dlwmsgk21@naver.com'

CREATE TABLE Member_Writer(
	mw_m_id varchar2(40 char) PRIMARY KEY,
	mw_m_nick varchar2(20 char) NOT NULL,
	mw_m_icon varchar2(100 char) NOT NULL,
	CONSTRAINT writer_id
	FOREIGN KEY (mw_m_id) REFERENCES Member(m_id)
	
);
SELECT *FROM MEMBER_writer;
INSERT INTO MEMBER_WRITER  values('dlwmsgk21@gmail.com','qwer','icon/logo.png')
DROP TABLE MEMBER_WRITER;
DROP TABLE MEMBER_point;
DELETE FROM MEMBER_WRITER   WHERE Mw_m_ID ='dlwmsgk21@naver.com'

CREATE TABLE member_point(
mp_id varchar2(40 char)PRIMARY KEY,
mp_p number(5)NOT NULL
)


CREATE TABLE onetoone_board (
    ob_no number(6) PRIMARY KEY,
    ob_writer varchar2(40 char) NOT null,
    ob_title varchar2(150 char) NOT NULL,
    ob_category varchar2(30 char) NOT NULL,
    ob_contents varchar2(2000 char) NOT NULL,
    ob_answer varchar2(2000 char),
    ob_answerdate DATE ,
    ob_date DATE NOT NULL,
    ob_status number(1) NOT NULL,
    CONSTRAINT ob_writer
        FOREIGN KEY (ob_writer) REFERENCES Member_writer(mw_m_id) 
        ON DELETE CASCADE
);
SELECT*FROM onetoone_board;
CREATE SEQUENCE ob_no_seq;
DROP TABLE onetoone_board;

CREATE TABLE REPORT(
r_no number(6) PRIMARY KEY,
r_reporter varchar2(40 char) NOT NULL,
r_b_no number(6),
r_b_r_no number(6),
r_b_rr_no number(6),
r_b_reason varchar2 (150 char),
r_cate varchar2(20 char),
r_cate2 varchar2(10 char) NOT NULL,
CONSTRAINT r_reporter
FOREIGN KEY (r_reporter) REFERENCES Member_writer(mw_m_id)
ON DELETE CASCADE

);




