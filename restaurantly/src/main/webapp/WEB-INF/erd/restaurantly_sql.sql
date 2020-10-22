/* 고객 */
DROP TABLE customer 
	CASCADE CONSTRAINTS;

/* 판매자 */
DROP TABLE owner 
	CASCADE CONSTRAINTS;

/* 식당 */
DROP TABLE restaurant 
	CASCADE CONSTRAINTS;

/* 예약 */
DROP TABLE booking 
	CASCADE CONSTRAINTS;

/* 식당메뉴 */
DROP TABLE menu 
	CASCADE CONSTRAINTS;

/* 리뷰 */
DROP TABLE review 
	CASCADE CONSTRAINTS;

/* 고객 */
CREATE TABLE customer (
	customer_id VARCHAR2(20) NOT NULL, /* 고객ID */
	customer_pw VARCHAR2(100) NOT NULL, /* 비밀번호 */
	customer_name VARCHAR2(50) NOT NULL, /* 이름 */
	customer_email VARCHAR2(40), /* 이메일 */
	customer_phone VARCHAR2(30), /* 전화번호 */
	customer_birthdate DATE, /* 생년월일 */
	customer_joindate DATE, /* 가입일 */
	customer_image_path VARCHAR2(200), /* 사진경로 */
	customer_state VARCHAR2(20) /* 탈퇴유무 */
);

ALTER TABLE customer
	ADD
		CONSTRAINT PK_customer
		PRIMARY KEY (
			customer_id
		);

/* 판매자 */
CREATE TABLE owner (
	owner_id VARCHAR2(20) NOT NULL, /* 판매자ID */
	owner_pw VARCHAR2(100) NOT NULL, /* 비밀번호 */
	owner_name VARCHAR2(50) NOT NULL, /* 이름 */
	owner_phone VARCHAR2(30), /* 전화번호 */
	owner_email VARCHAR2(40), /* 이메일 */
	owner_joindate DATE /* 가입일 */
);

ALTER TABLE owner
	ADD
		CONSTRAINT PK_owner
		PRIMARY KEY (
			owner_id
		);

/* 식당 */
CREATE TABLE restaurant (
	restaurant_license VARCHAR2(50) NOT NULL, /* 사업자등록번호 */
	owner_id VARCHAR2(20) NOT NULL, /* 판매자ID */
	restaurant_name VARCHAR2(50), /* 상호명 */
	restaurant_phone VARCHAR2(30), /* 전화번호 */
	restaurant_representative VARCHAR2(50), /* 대표자명 */
	restaurant_detail VARCHAR2(50), /* 상세주소 */
	restaurant_item VARCHAR2(10), /* 종목 */
	restaurant_introduction VARCHAR2(1000), /* 소개글 */
	restaurant_image_path VARCHAR2(200) /* 사진경로 */
);

ALTER TABLE restaurant
	ADD
		CONSTRAINT PK_restaurant
		PRIMARY KEY (
			restaurant_license
		);

/* 예약 */
CREATE TABLE booking (
	booking_id VARCHAR2(13) NOT NULL, /* 예약번호 */
	customer_id VARCHAR2(20), /* 고객ID */
	restaurant_license VARCHAR2(50), /* 사업자등록번호 */
	booking_datetime DATE, /* 예약시간 */
	booking_count INTEGER /* 예약인원 */
);

ALTER TABLE booking
	ADD
		CONSTRAINT PK_booking
		PRIMARY KEY (
			booking_id
		);

/* 식당메뉴 */
CREATE TABLE menu (
	menu_id VARCHAR2(20) NOT NULL, /* 메뉴ID */
	restaurant_license VARCHAR2(50) NOT NULL, /* 사업자등록번호 */
	menu_name VARCHAR2(50), /* 메뉴명 */
	menu_category VARCHAR2(50) NOT NULL, /* 메뉴분류 */
	menu_price INTEGER, /* 가격 */
	menu_image_path VARCHAR2(200) /* 사진경로 */
);

ALTER TABLE menu
	ADD
		CONSTRAINT PK_menu
		PRIMARY KEY (
			menu_id
		);

/* 리뷰 */
CREATE TABLE review (
	review_id VARCHAR2(20) NOT NULL, /* 리뷰ID */
	restaurant_license VARCHAR2(50), /* 사업자등록번호 */
	customer_id VARCHAR2(20), /* 고객ID */
	review_score INTEGER, /* 별점 */
	review_content VARCHAR2(1000), /* 내용 */
	review_writedate DATE, /* 작성일자 */
	review_image_path VARCHAR2(200) /* 사진경로 */
);

ALTER TABLE review
	ADD
		CONSTRAINT PK_review
		PRIMARY KEY (
			review_id
		);

ALTER TABLE restaurant
	ADD
		CONSTRAINT FK_owner_TO_restaurant
		FOREIGN KEY (
			owner_id
		)
		REFERENCES owner (
			owner_id
		);

ALTER TABLE booking
	ADD
		CONSTRAINT FK_customer_TO_booking
		FOREIGN KEY (
			customer_id
		)
		REFERENCES customer (
			customer_id
		);

ALTER TABLE booking
	ADD
		CONSTRAINT FK_restaurant_TO_booking
		FOREIGN KEY (
			restaurant_license
		)
		REFERENCES restaurant (
			restaurant_license
		);

ALTER TABLE menu
	ADD
		CONSTRAINT FK_restaurant_TO_menu
		FOREIGN KEY (
			restaurant_license
		)
		REFERENCES restaurant (
			restaurant_license
		);

ALTER TABLE review
	ADD
		CONSTRAINT FK_restaurant_TO_review
		FOREIGN KEY (
			restaurant_license
		)
		REFERENCES restaurant (
			restaurant_license
		);

ALTER TABLE review
	ADD
		CONSTRAINT FK_customer_TO_review
		FOREIGN KEY (
			customer_id
		)
		REFERENCES customer (
			customer_id
		);