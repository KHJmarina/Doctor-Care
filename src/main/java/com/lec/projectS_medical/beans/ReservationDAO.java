package com.lec.projectS_medical.beans;

import java.util.ArrayList;

public interface ReservationDAO {

	public ArrayList<ReservationDTO> select();
	
	// 병원예약
	public int insert(final ReservationDTO dto);
	public int insert(String resDate, String name, String id, String gender, String age, String phonenum, 
			String question1, String question2, String question3, String other);
	
	// 예약기록 조회
	public ArrayList<ReservationDTO> resById(String id);
		
		
		
		
		

}
