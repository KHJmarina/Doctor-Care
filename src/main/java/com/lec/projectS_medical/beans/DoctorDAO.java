package com.lec.projectS_medical.beans;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

@MapperScan
public interface DoctorDAO {
	
	public ArrayList<DoctorDTO> select();
		
	// 회원가입 
	public int insert(final DoctorDTO dto);
	public int insert(String id, String pw, String name, String gender, String age, String phonenum, String address,
			String email);
	
	public DoctorDTO login(String id);
		
	// 특정 id의 글 수정
	public int update(String id, @Param("a") DoctorDTO dto);
	
	
	
	
} // end DoctorDAO
