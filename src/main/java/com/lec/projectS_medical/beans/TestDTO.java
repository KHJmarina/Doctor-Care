package com.lec.projectS_medical.beans;

import java.sql.Timestamp;

public class TestDTO {
	private String name;
	private int uid;
	private int mb_uid;
	private String height;
	private String weight;
	private String sightR;
	private String sightL;
	private String hearing;
	private String bloodpress;
	private String BMI;
	private String BST;
	private Timestamp regdate;
	
	public TestDTO() {
		super();
		System.out.println("TestDTO() 객체 생성");
	}

	public TestDTO(String name, int uid, int mb_uid, String height, String weight, String sightR, String sightL, String hearing,
			String bloodpress, String bMI, String bST) {
		super();
		this.name = name;
		this.uid = uid;
		this.mb_uid = mb_uid;
		this.height = height;
		this.weight = weight;
		this.sightR = sightR;
		this.sightL = sightL;
		this.hearing = hearing;
		this.bloodpress = bloodpress;
		this.BMI = bMI;
		this.BST = bST;
		System.out.println("TestDTO 전체 생성");
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getMb_name() {
		return name;
	}
	
	public void setMb_name(String name) {
		this.name = name;
	}
	
	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getTest_uid() {
		return uid;
	}

	public void setTest_uid(int uid) {
		this.uid = uid;
	}
	
	public int getMb_uid() {
		return mb_uid;
	}

	public void setMb_uid(int mb_uid) {
		this.mb_uid = mb_uid;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getSightR() {
		return sightR;
	}

	public void setSightR(String sightR) {
		this.sightR = sightR;
	}

	public String getSightL() {
		return sightL;
	}

	public void setSightL(String sightL) {
		this.sightL = sightL;
	}

	public String getHearing() {
		return hearing;
	}

	public void setHearing(String hearing) {
		this.hearing = hearing;
	}

	public String getBloodpress() {
		return bloodpress;
	}

	public void setBloodpress(String bloodpress) {
		this.bloodpress = bloodpress;
	}

	public String getBMI() {
		return BMI;
	}

	public void setBMI(String bMI) {
		BMI = bMI;
	}

	public String getBST() {
		return BST;
	}

	public void setBST(String bST) {
		BST = bST;
	}
	
	public Timestamp getRegdate() {
		return regdate;
	}
	
	public String getRegdate2() {
		return regdate.toString().substring(0, 10);
	}

	public void setRegdate(Timestamp regdate) {
		System.out.println("날짜 호출");
		this.regdate = regdate;
	}
	
	@Override
	public String toString() {
		return "TestDTO [uid=" + uid + ", mb_uid=" + mb_uid + ", name=" + name + ", height=" + height + ", weight=" + weight + ", sightR="
				+ sightR + ", sightL=" + sightL + ", hearing=" + hearing + ", bloodpress=" + bloodpress + ", BMI=" + BMI
				+ ", BST=" + BST + ", regdate="	+ regdate + "]";
	}	// end toString()

}	// TestDTO
