CREATE TABLE aug07_coffee(
c_name varchar2(10 char)PRIMARY KEY,
c_price number(5)NOT  null
);
SELECT *FROM aug07_coffee;
---------------------------------
CREATE TABLE aug08_company(
c_name varchar2(10 char)PRIMARY KEY,
c_addr varchar2(10 char)NOT null
);

INSERT INTO aug08_company VALUES ('농심','서울');
INSERT INTO aug08_company VALUES ('오리온','인천');
SELECT *FROM aug08_company;

CREATE TABLE aug08_snack(
s_no number(3)PRIMARY KEY,
s_name varchar2(10 char)NOT NULL,
s_price number(5)NOT NULL,
s_maker varchar2(10 char)NOT NULL,
CONSTRAINT snack_maker
FOREIGN KEY (s_maker) REFERENCES aug08_company(c_name)
ON DELETE cascade

);

CREATE SEQUENCE aug08_snack_seq;
INSERT INTO aug08_snack values(aug08_snack_seq.nextval,'새우깡',3000,'농심');
INSERT INTO aug08_snack values(aug08_snack_seq.nextval,'양파링',3000,'농심');
INSERT INTO aug08_snack values(aug08_snack_seq.nextval,'초코파이',3000,'농심');
SELECT *FROM aug08_snack;


CREATE TABLE Member(
m_id varchar2(40 char)PRIMARY KEY,
m_pw varchar2 (90 char)NOT NULL,
m_name varchar2(20 char)NOT NULL,
m_nick varchar2(20 char)NOT NULL,
m_birth DATE NOT NULL,
m_addr varchar2 (90 char)NOT NULL,
m_icon varchar2 (100 char)NOT NULL,
m_leave number(1)NOT null
);
SELECT * FROM MEMBER;
DROP TABLE MEMBER;



CREATE TABLE aug17_snack(
s_name varchar2(10 char)PRIMARY KEY,
s_price number(5)NOT null
);
INSERT INTO aug17_snack values('새우깡',5000);
INSERT INTO aug17_snack values('알칩',5000);
INSERT INTO aug17_snack values('짱구',5000);
CREATE TABLE aug17_company(
c_name varchar2(10 char)PRIMARY KEY,
c_address varchar2(50 char)NOT null
);
INSERT INTO aug17_company values('오리온','인천');
INSERT INTO aug17_compny values('김부각','부산');
DROP TABLE aug17_snack;





CREATE TABLE aug18_photo(
	p_title varchar2(10 char)PRIMARY KEY,
	p_file varchar2(200 char)NOT  null
);

SELECT * FROM aug18_photo;


CREATE TABLE msweb_member(
msm_id varchar2(10 char)PRIMARY KEY,
msm_pw char(60 char)NOT NULL,
msm_name varchar2(10 char)NOT null

);












