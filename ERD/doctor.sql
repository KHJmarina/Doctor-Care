
/* Drop Tables */

DROP TABLE DC_COMMENT CASCADE CONSTRAINTS;
DROP TABLE DC_BOARD CASCADE CONSTRAINTS;
DROP TABLE DC_RESERVATION CASCADE CONSTRAINTS;
DROP TABLE DC_TEST CASCADE CONSTRAINTS;
DROP TABLE DC_MEMBER CASCADE CONSTRAINTS;
DROP SEQUENCE doctor_SEQ;
DROP SEQUENCE test_SEQ;
DROP SEQUENCE board_SEQ;
DROP SEQUENCE reservation_SEQ;




/* Create Tables */

CREATE TABLE DC_BOARD
(
	wr_uid number NOT NULL,
	wr_subject varchar2(200) NOT NULL,
	wr_subtitle varchar2(50) NOT NULL,
	wr_content clob,
	wr_name varchar2(40) NOT NULL,
	wr_phonenum varchar2(20),
	wr_email varchar2(30),
	wr_viewcnt number default 0,
	wr_regdate date default sysdate,
	mb_uid number NOT NULL,
	PRIMARY KEY (wr_uid)
);


CREATE TABLE DC_COMMENT
(
	cmt_uid number NOT NULL,
	wr_uid number NOT NULL,
	cmt_subject varchar2(50) NOT NULL,
	cmt_content clob,
	cmt_viewcnt number default 0,
	cmt_regdate date default sysdate,
	mb_uid number NOT NULL,
	PRIMARY KEY (cmt_uid)
);


CREATE TABLE DC_MEMBER
(
	mb_uid number NOT NULL,
	mb_id varchar2(20) NOT NULL,
	mb_pw varchar2(20) NOT NULL,
	mb_name varchar2(20) NOT NULL,
	mb_gender varchar2(20),
	mb_age varchar2(20),
	mb_phonenum varchar2(20),
	mb_address varchar2(50),
	mb_email varchar2(30),
	mb_regdate date default sysdate,
	PRIMARY KEY (mb_uid)
);


CREATE TABLE DC_RESERVATION
(
	res_uid number NOT NULL,
	mb_uid number NOT NULL,
	res_date varchar2(20) NOT NULL,
	res_name varchar2(20) NOT NULL,
	res_id varchar2(20) NOT NULL,
	res_gender varchar2(20) NOT NULL,
	res_age varchar2(20) NOT NULL,
	res_phonenum varchar2(20) NOT NULL,
	res_q1 varchar2(50),
	res_q2 varchar2(50),
	res_q3 varchar2(50),
	res_other clob,
	PRIMARY KEY (res_uid)
);


CREATE TABLE DC_TEST
(
	-- 건강검진
	test_uid number NOT NULL,
	mb_uid number NOT NULL,
	test_height number NOT NULL,
	test_weight number NOT NULL,
	-- 시력(오른쪽)
	test_sightR number NOT NULL,
	-- 시력(왼쪽)
	test_sightL number NOT NULL,
	-- 청력
	test_hearing varchar2(20) NOT NULL,
	-- 혈압
	test_bloodpress number NOT NULL,
	-- 체지방, 체질량, 콜레스테롤
	test_BMI number NOT NULL,
	-- 혈당수치
	test_BST number NOT NULL,
	test_regdate date default sysdate,
	PRIMARY KEY (test_uid)
);



/* Create Foreign Keys */

ALTER TABLE DC_COMMENT
	ADD FOREIGN KEY (wr_uid)
	REFERENCES DC_BOARD (wr_uid)
;


ALTER TABLE DC_BOARD
	ADD FOREIGN KEY (mb_uid)
	REFERENCES DC_MEMBER (mb_uid)
;


ALTER TABLE DC_RESERVATION
	ADD FOREIGN KEY (mb_uid)
	REFERENCES DC_MEMBER (mb_uid)
;


ALTER TABLE DC_TEST
	ADD FOREIGN KEY (mb_uid)
	REFERENCES DC_MEMBER (mb_uid)
;



/* Comments */

COMMENT ON COLUMN DC_TEST.test_uid IS '건강검진';
COMMENT ON COLUMN DC_TEST.test_sightR IS '시력(오른쪽)';
COMMENT ON COLUMN DC_TEST.test_sightL IS '시력(왼쪽)';
COMMENT ON COLUMN DC_TEST.test_hearing IS '청력';
COMMENT ON COLUMN DC_TEST.test_bloodpress IS '혈압';
COMMENT ON COLUMN DC_TEST.test_BMI IS '체지방, 체질량, 콜레스테롤';
COMMENT ON COLUMN DC_TEST.test_BST IS '혈당수치';




/* 시퀀스 작성 */
CREATE SEQUENCE doctor_SEQ;
CREATE SEQUENCE test_SEQ;
CREATE SEQUENCE board_SEQ;
CREATE SEQUENCE reservation_SEQ;





-- 로그인 정보
INSERT INTO DC_MEMBER VALUES
(doctor_SEQ.nextval, 'admin', '1234', '관리자', '', '', '', '', '', sysdate);
INSERT INTO DC_MEMBER VALUES
(doctor_SEQ.nextval, 'khj0611', 'khj0611', '강혜정', 'woman', '30', '010-8147-0551', '서울', 'khj0551.it@gmail.com', sysdate);
INSERT INTO DC_MEMBER VALUES
(doctor_SEQ.nextval, 'before', 'whdlstnr', '당뇨 전단계', 'man', '51', '010-0000-0000', '서울', '', sysdate);
INSERT INTO DC_MEMBER VALUES
(doctor_SEQ.nextval, 'BST', '1234', '종합병동', 'woman', '17', '000-1111-2222', '미국', '11111@naver.com', sysdate);
INSERT INTO DC_MEMBER VALUES
(doctor_SEQ.nextval, 'BMI', '1234', '비만 환자', 'man', '36', '000-1111-2222', '캐나다', '11111@daum.net', sysdate);
INSERT INTO DC_MEMBER VALUES
(doctor_SEQ.nextval, 'BP', '1234', '고혈압 환자', 'woman', '41', '000-1111-2222', '영국', '11111@gmail.com', sysdate);
INSERT INTO DC_MEMBER VALUES
(doctor_SEQ.nextval, 'ekdsy', 'ekdsy', '당뇨환자', 'man', '26', '010-2345-6789', '캐나다', '1115@gmail.com', sysdate);
INSERT INTO DC_MEMBER VALUES
(doctor_SEQ.nextval, 'rhgufdkq', 'rhgufdkq', '고혈압 1단계', 'man', '22', '010-2345-6789', '스위스', '0409@gmail.com', sysdate);
INSERT INTO DC_MEMBER VALUES
(doctor_SEQ.nextval, 'rhgufdkqwjs', 'rhgufdkqwjs', '고혈압 전단계', 'man', '28', '010-2345-6789', '멕시코', '0113@gmail.com', sysdate);
INSERT INTO DC_MEMBER VALUES
(doctor_SEQ.nextval, 'leg', 'qnwntkdrhf', '부주상골', 'woman', '30', '010-2345-6789', '서울', '0113@gmail.com', sysdate);
INSERT INTO DC_MEMBER VALUES
(doctor_SEQ.nextval, 'hand', 'xjsjfwmdgnrns', '터널증후군', 'man', '28', '010-2345-6789', '부산', '0113@gmail.com', sysdate);


-- 검진 정보 등록
INSERT INTO DC_TEST VALUES
(test_SEQ.nextval, 2, 160, 48, 1.5, 1.2, '정상', 100, 20, 89, sysdate);	-- 정상
INSERT INTO DC_TEST VALUES
(test_SEQ.nextval, 6, 176, 51, 0.7, 0.5, '경도 난청', 162, 24, 95, sysdate);	-- 고혈압
INSERT INTO DC_TEST VALUES
(test_SEQ.nextval, 4, 181, 51, 0.1, 0.2, '중도 난청', 158, 28, 131, sysdate);	-- 종합병동
INSERT INTO DC_TEST VALUES
(test_SEQ.nextval, 5, 169, 91, 1.0, 1.2, '정상', 121, 30, 125, sysdate);	-- 비만
INSERT INTO DC_TEST VALUES
(test_SEQ.nextval, 3, 159, 51, 1.0, 0.9, '정상', 106, 22, 111, sysdate);	-- 당뇨 전단계
INSERT INTO DC_TEST VALUES
(test_SEQ.nextval, 11, 123, 123, 123, 123, '정상', 123, 123, 123, sysdate);







-- 게시글 등록
INSERT INTO DC_BOARD VALUES
(board_SEQ.nextval, 'DDC', 'other', '건강한 라이프 스타일을 추구합니다', '관리자', '', '', 11, sysdate, 1);
INSERT INTO DC_BOARD VALUES
(board_SEQ.nextval, '병원방문 후기', 'ENT', 
'삶의 행복과 성공의 진정한 의미를 전하고, 유쾌하고 흥미진진한 우화를 통해 단순하지만 명확한 성공의 원칙을 제시한다.
국내에서만도 300만 독자의 사랑을 받은 바 있는 책으로 공경희 번역가의 손에서 다시 탄생했다.
역자는 가장 단순한 원칙을 가장 쉽게 알려주고 싶어 했던 저자의 취지에 맞게 담백한 방법으로 번역했으며, 쓸데없는 미사여구를 첨가하지 않고, 분량을 늘리기 위해 덧붙이지 않았다.', 
'고혈압 1단계', '010-2345-6789', '0409@gmail.com', 1, sysdate, 8);
INSERT INTO DC_BOARD VALUES
(board_SEQ.nextval, '수술 후기', 'knee', 
'성공의 마시멜로를 찾아 떠난 아서와 조나단의 감동 스토리는 오늘 무엇을 할 것인지에 따라 내일의 행복이 결정된다는 점을 일깨워 줄 뿐만 아니라,
적당한 ‘만족’과 ‘타협’이 가져다주는 은밀한 유혹에 빠져 하루하루를 살아가고 있는 사람들에게 평범한 ‘오늘’을 특별한 ‘내일’로 만드는 소중한 지혜를 전해 주기에도 여전히 유효하다.', 
'종합병동', '000-1111-2222', '11111@naver.com', 7, sysdate, 4);
INSERT INTO DC_BOARD VALUES
(board_SEQ.nextval, '손목이아파요', 'hand', '통증이 계속 있는데 어떻게 해야하나요', '터널증후군', '010-2345-6789', '0113@gmail.com', 2, sysdate, 11);
INSERT INTO DC_BOARD VALUES
(board_SEQ.nextval, '부주상골 치료', 'other', '냉찜질 온찜질 어느걸로 해야하나요', '부주상골', '010-2345-6789', '0113@gmail.com', 1, sysdate, 10);
INSERT INTO DC_BOARD VALUES
(board_SEQ.nextval, '식단 질문이 있습니다', 'other', '식단 질문이 있습니다. 당수치를 좀 낮추고 싶은데 식단 어떤 식으로 짜야할까요', '당뇨환자', '010-2345-6789', '0115@gmail.com', 3, sysdate, 7);


INSERT INTO DC_COMMENT VALUES
(board_SEQ.nextval, 5, '문의 감사합니다', 
'부주상골 상태로 보아 1-3단계로 나누어집니다. 
내원하시면 CT 촬영을 통해 뼈의 모양을 확인 후 치료 또는 수술 진단이 내려집니다. 
예약 후 내원 부탁드립니다. 감사합니다.', 
0, sysdate, 10);


CREATE VIEW v_DC_BOARD_row
AS
	SELECT 
		ROWNUM AS RNUM,
		T.*
	FROM (
		SELECT 
			wr_uid,
			wr_subject subject,
			wr_content content,
			wr_name name,
			wr_viewcnt viewcnt,
			wr_regdate regDate
		FROM
			DC_BOARD
		ORDER BY
			wr_uid DESC
	) T;

-- 생성된 view 테스트
SELECT * FROM v_DC_BOARD_row;
















SELECT * FROM DC_MEMBER;
SELECT * FROM DC_TEST;
SELECT * FROM DC_BOARD;
SELECT * FROM DC_RESERVATION;
SELECT * FROM DC_COMMENT;

SELECT * FROM DC_BOARD WHERE wr_name='강혜정';

UPDATE DC_BOARD SET wr_viewcnt = 0 WHERE wr_name='강혜정';


SELECT mb_uid, mb_id, mb_pw, mb_name, mb_gender, mb_age, mb_phonenum, mb_address, mb_email, mb_regdate 
FROM DC_MEMBER WHERE mb_id='khj0551';

SELECT * FROM DC_RESERVATION WHERE res_id='khj0611';


SELECT 
	res_uid, mb_uid, res_date resDate, 
	res_name name, res_id id, res_gender gender, res_age age, res_phonenum phonenum,
	res_q1 question1, res_q2 question2, res_q3 question3, res_other other
FROM DC_RESERVATION
WHERE res_id='khj0611';


SELECT * FROM DC_MEMBER WHERE mb_id = 'khj0551';
SELECT * FROM DC_TEST WHERE mb_uid = 2;

-- uid에 해당되는 환자 정보와 이름 동시 출력
SELECT * FROM 
	(SELECT mb_name FROM DC_MEMBER WHERE mb_uid = 2), DC_TEST 
WHERE mb_uid = 2;


-- 검진정보 등록한 환자 전체 리스트
SELECT * FROM DC_MEMBER m, DC_TEST t WHERE m.mb_uid = t.mb_uid;

-- id로 환자 전체정보
SELECT * FROM DC_MEMBER m, DC_TEST t WHERE m.mb_uid = t.mb_uid AND m.mb_id = 'khj0551';


-- 고혈압 전단계
SELECT * FROM DC_TEST WHERE test_bloodpress BETWEEN 120 AND 139;
-- 고혈압 1단계
SELECT * FROM DC_TEST WHERE test_bloodpress BETWEEN 140 AND 159;
-- 고혈압 2단계
SELECT * FROM DC_TEST WHERE test_bloodpress >= 160;
-- 비만 : 체질량
SELECT * FROM DC_TEST WHERE test_BMI > 25;
-- 당뇨병 전단계 : 혈당수치
SELECT * FROM DC_TEST WHERE test_BST BETWEEN 100 AND 125;
-- 당뇨병 1단계 : 혈당수치
SELECT * FROM DC_TEST WHERE test_BST > 125;





-- 당뇨 전단계 리스트
SELECT * FROM
	(SELECT mb_uid, mb_name FROM DC_MEMBER) m, DC_TEST t
WHERE t.test_BST BETWEEN 100 AND 125
AND m.mb_uid IN (SELECT mb_uid FROM DC_TEST WHERE test_BST BETWEEN 100 AND 125)
AND m.mb_uid = t.mb_uid;
-- 당뇨병에 해당되는 사람 이름 출력
SELECT * FROM
	(SELECT mb_uid, mb_name FROM DC_MEMBER) m, DC_TEST t
WHERE t.test_BST > 125
AND m.mb_uid = t.mb_uid;


-- 비만
SELECT * FROM
	(SELECT mb_uid, mb_name FROM DC_MEMBER) m, DC_TEST t
WHERE test_BMI > 25
AND m.mb_uid = t.mb_uid;


-- 고혈압 전단계
SELECT * FROM
	(SELECT mb_uid, mb_name FROM DC_MEMBER) m, DC_TEST t
WHERE t.test_bloodpress BETWEEN 120 AND 139
AND m.mb_uid = t.mb_uid;
-- 고혈압 1단계
SELECT * FROM
	(SELECT mb_uid, mb_name FROM DC_MEMBER) m, DC_TEST t
WHERE t.test_bloodpress BETWEEN 140 AND 159
AND m.mb_uid = t.mb_uid;
-- 고혈압 2단계
SELECT * FROM
	(SELECT mb_uid, mb_name FROM DC_MEMBER) m, DC_TEST t
WHERE t.test_bloodpress >= 160
AND m.mb_uid = t.mb_uid;





-- 문장으로
SELECT
	m.mb_name || '의 혈당수치는 ' || t.test_BST || '입니다' "당뇨 관리 환자"
FROM
	DC_MEMBER m, DC_TEST t
WHERE t.test_BST > 125
AND m.mb_uid = (SELECT mb_uid FROM DC_TEST WHERE test_BST > 125);



-- 비만에 해당되는 사람 이름 출력
SELECT
	t.mb_uid "환자 고유번호", m.mb_name "환자명", t.test_BMI "체질량"
FROM
	DC_MEMBER m, DC_TEST t
WHERE t.test_BMI > 25
AND m.mb_uid IN (SELECT mb_uid FROM DC_TEST WHERE test_BMI > 25)
AND t.mb_uid = m.mb_uid;




-- 고혈압 2단계에 해당되는 사람 이름 출력
SELECT
	t.mb_uid "환자 고유번호", m.mb_name "환자명", t.test_bloodpress "혈압"
FROM
	DC_MEMBER m, DC_TEST t
WHERE test_bloodpress >= 160
AND m.mb_uid = (SELECT mb_uid FROM DC_TEST WHERE test_bloodpress >= 160);




SELECT 
test_uid, m.mb_uid, test_height height, test_weight weight, 
test_sightR sightR, test_sightL sightL, test_hearing hearing, 
test_bloodpress bloodpress, test_BMI BMI, test_BST BST, 
test_regdate regdate 
FROM DC_MEMBER m, DC_TEST t
WHERE m.mb_uid = t.mb_uid AND m.mb_id = 'khj0551';





SELECT 
mb_uid, mb_id id, mb_pw pw, mb_name name,
mb_gender gender, mb_age age, mb_phonenum phonenum,
mb_address address, mb_email email, mb_regdate regdate 
FROM DC_MEMBER ORDER BY mb_uid DESC;



	
	
SELECT 
test_uid, m.mb_uid, test_height height, test_weight weight, 
test_sightR sightR, test_sightL sightL, test_hearing hearing, 
test_bloodpress bloodpress, test_BMI BMI, test_BST BST, 
to_char(test_regdate, 'YYYY-MM-DD') regdate 
FROM DC_MEMBER m, DC_TEST t
WHERE m.mb_uid = t.mb_uid AND m.mb_id = 'khj0551';



SELECT 
test_uid, m.mb_uid, test_height height, test_weight weight, 
test_sightR sightR, test_sightL sightL, test_hearing hearing, 
test_bloodpress bloodpress, test_BMI BMI, test_BST BST, 
test_regdate regdate 
FROM DC_MEMBER m, DC_TEST t
WHERE m.mb_uid = t.mb_uid;











SELECT 
			test_uid, m.mb_name, test_height height, test_weight weight, 
			test_sightR sightR, test_sightL sightL, test_hearing hearing, 
			test_bloodpress bloodpress, test_BMI BMI, test_BST BST, 
			test_regdate regdate 
		FROM (SELECT mb_uid, mb_name FROM DC_MEMBER) m, DC_TEST t 
		WHERE t.test_BST > 125 
		AND m.mb_uid = t.mb_uid;
		
	
	
	
	
INSERT INTO DC_TEST 
	(test_uid, mb_uid, test_height, test_weight, test_sightR, test_sightL, 
	test_hearing, test_bloodpress, test_BMI, test_BST, test_regdate) 
VALUES 
	(doctor_seq.nextval, 2, 1, 1, 1, 1, '정상', 1, 1, 1, SYSDATE);




SELECT wr_uid, wr_subject subject, wr_subtitle subtitle, wr_content content, 
wr_name name, wr_phonenum phonenum, wr_email email,
wr_viewcnt viewcnt, wr_regdate regDate, MB_UID FROM DC_BOARD ORDER BY wr_uid DESC;