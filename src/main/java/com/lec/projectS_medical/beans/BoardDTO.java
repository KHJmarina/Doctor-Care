package com.lec.projectS_medical.beans;

import java.sql.Timestamp;

// test_write 테이블을 표현할 빈 객체 정의
//DTO : Data Transfer Object
public class BoardDTO {
	private int uid;    //  wr_uid
	private String subject;  // wr_subject
	private String subtitle;
	private String content;  // wr_content
	private String name;     // wr_name
	private String phonenum;
	private String email;
	private int viewCnt;  // wr_viewcnt
	private Timestamp regDate;  // wr_regdate
	private int mb_uid;

	// 웹개발시...
	// 가능한, 다음 3가지는 이름을 일치시켜주는게 좋습니다.
	// 클래스 필드명 = DB 필드명 = form의 name명

	// 생성자
	public BoardDTO() {
		super();
		System.out.println("BoardDTO() 객체 생성");
	}

	public BoardDTO(int uid, String subject, String content, String name, int viewCnt) {
		super();
		this.uid = uid;
		this.subject = subject;
		this.content = content;
		this.name = name;
		this.viewCnt = viewCnt;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}
	
	public int getWr_uid() {
		return uid;
	}

	public void setWr_uid(int uid) {
		this.uid = uid;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getPhonenum() {
		return phonenum;
	}

	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}

	public Timestamp getRegDate() {
		return regDate;
	}

	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}
	
	public int getMb_uid() {
		return mb_uid;
	}

	public void setMb_uid(int mb_uid) {
		this.mb_uid = mb_uid;
	}
	
	// 개발할때 Class의 toString()을 오버라이딩 해주면
	// 디버깅이나 테스팅하기 좋다.
	@Override
	public String toString() {
		return String.format("[BWriteDTO %d,%s,%s,%s,%d,%s]", 
				uid, subject, content, name, viewCnt, regDate); 
	} // end toString()
} // end DTO class












