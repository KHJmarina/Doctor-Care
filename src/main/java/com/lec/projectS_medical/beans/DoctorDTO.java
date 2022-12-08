package com.lec.projectS_medical.beans;

import java.sql.Timestamp;

public class DoctorDTO {
	private int uid;
	private String id;
	private String pw;
	private String name;
	private String gender;
	private String age;
	private String phonenum;
	private String address;
	private String email;
	private Timestamp regdate;
	
	public DoctorDTO() {
		super();
		System.out.println("DoctorDTO() 객체 생성");
	}

	public DoctorDTO(int uid, String id, String pw, String name, String gender, String age, String phonenum,
			String address, String email) {
		super();
		this.uid = uid;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.phonenum = phonenum;
		this.address = address;
		this.email = email;
		System.out.println("DoctorDTO 전체 생성");
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}
	
	public int getMb_uid() {
		return uid;
	}

	public void setMb_uid(int uid) {
		this.uid = uid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Timestamp getRegdate() {
		return regdate;
	}

	public void setRegdate(Timestamp regdate) {
		System.out.println("날짜 호출");
		this.regdate = regdate;
	}
	
	@Override
	public String toString() {
		return "DoctorDTO [uid=" + uid + ", id=" + id + ", pw=" + pw + ", name="
		+ name + ", gender=" + gender + ", age=" + age + ", phonenum=" + phonenum + ", address=" + address
		+ ", email=" + email + ", regdate="	+ regdate + "]";
		
	}	// end toString()

} // end DTO class
