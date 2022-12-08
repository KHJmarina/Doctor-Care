package com.lec.projectS_medical.beans;

import java.sql.Timestamp;

// test_write 테이블을 표현할 빈 객체 정의
//DTO : Data Transfer Object
public class CommentDTO {
	private int uid;    //  wr_uid
	private int wr_uid;
	private String subject;
	private String content;  // wr_content
	private int viewCnt;  // wr_viewcnt
	private Timestamp regDate;  // wr_regdate
	private int mb_uid;
	
	public CommentDTO() {
		super();
		System.out.println("CommentDTO() 생성");
	}

	public CommentDTO(int uid, int wr_uid, String subject, String content, int viewCnt, Timestamp regDate) {
		super();
		this.uid = uid;
		this.wr_uid = wr_uid;
		this.subject = subject;
		this.content = content;
		this.viewCnt = viewCnt;
		this.regDate = regDate;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}
	
	public int getCmt_uid() {
		return uid;
	}

	public void setCmt_uid(int uid) {
		this.uid = uid;
	}

	public int getWr_uid() {
		return wr_uid;
	}

	public void setWr_uid(int wr_uid) {
		this.wr_uid = wr_uid;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

	@Override
	public String toString() {
		return "CommentDTO [uid=" + uid + ", wr_uid=" + wr_uid + ", subject=" + subject + ", content=" + content
				 + ", viewCnt=" + viewCnt + ", regdate=" + regDate + ", mb_uid=" + mb_uid + "]";
	}
	
	
} // end DTO class












