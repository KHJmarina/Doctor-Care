package com.lec.projectS_medical.beans;

public class ReservationDTO {
	private int uid;
	private int mb_uid;
	private String resDate;
	private String name;
	private String id;
	private String gender;
	private String age;
	private String phonenum;
	private String question1;
	private String question2;
	private String question3;
	private String other;
	
	public ReservationDTO() {
		super();
		System.out.println("ReservationDTO() 객체 생성");
	}

	public ReservationDTO(int uid, int mb_uid, String resDate, String name, String gender, String age, String phonenum,
			String question1, String question2, String question3, String other) {
		super();
		this.uid = uid;
		this.mb_uid = mb_uid;
		this.resDate = resDate;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.phonenum = phonenum;
		this.question1 = question1;
		this.question2 = question2;
		this.question3 = question3;
		this.other = other;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getMb_uid() {
		return mb_uid;
	}

	public void setMb_uid(int mb_uid) {
		this.mb_uid = mb_uid;
	}

	public String getResDate() {
		return resDate;
	}

	public void setResDate(String resDate) {
		this.resDate = resDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getPhonenum() {
		return phonenum;
	}

	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}

	public String getQuestion1() {
		return question1;
	}

	public void setQuestion1(String question1) {
		this.question1 = question1;
	}

	public String getQuestion2() {
		return question2;
	}

	public void setQuestion2(String question2) {
		this.question2 = question2;
	}

	public String getQuestion3() {
		return question3;
	}

	public void setQuestion3(String question3) {
		this.question3 = question3;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}
	
	@Override
	public String toString() {
		return "ReservationDTO [uid=" + uid + ", resDate=" + resDate + ", name=" + name + ", gender=" + gender + ", age=" + age
				+ ", phonenum=" + phonenum + ", Q1=" + question1 + ", Q2=" + question2 + ", Q3=" + question3
				+ ", other="	+ other + "]";
	}	// end toString()
	
	
	
	
	
	

}	// TestDTO
