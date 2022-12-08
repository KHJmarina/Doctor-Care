package com.lec.projectS_medical.beans;

import java.util.ArrayList;

public interface TestDAO {

	// 회원정보 전체 select
	public ArrayList<TestDTO> select();
	
	// DTO 세트를 미리 옮겨둠. 회원 uid 읽고 검진정보 등록
	public int insert(TestDTO dto);

	// 새글 작성
	public int insert(int mb_uid, String height, String weight, String sightR, String sightL, String hearing, String bloodpress,
			String BMI, String BST);
	
	// 건강검진조회로 id 회원 전체정보 담기.
	public ArrayList<TestDTO> testById(String id);
	
	
	// 회원 uid 읽고 검진정보 조회
	public TestDTO testByUid(int uid);
		
	
	// 당뇨병 이전단계 환자 테이블
	public ArrayList<TestDTO> testDiabetesBefore();
	// 당뇨병 환자 테이블
	public ArrayList<TestDTO> testDiabetes();
	
	// 비만 환자 테이블
	public ArrayList<TestDTO> testObesity();
	
	// 고혈압 환자 테이블
	public ArrayList<TestDTO> testHighBPBefore();
	// 고혈압 환자 테이블
	public ArrayList<TestDTO> testHighBP1();
	// 고혈압 환자 테이블
	public ArrayList<TestDTO> testHighBP2();

		
		
		
		
		
		

}
