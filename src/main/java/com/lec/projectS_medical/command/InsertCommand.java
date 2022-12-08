package com.lec.projectS_medical.command;

import java.util.Map;

import org.springframework.ui.Model;

import com.lec.projectS_medical.beans.DoctorDAO;
import com.lec.projectS_medical.beans.DoctorDTO;
import com.lec.projectS_medical.board.C;

public class InsertCommand implements Command {

	@Override
	public void execute(Model model) {
		
		Map<String, Object> map = model.asMap();   // Model 안의 attribute 꺼낼때..
		DoctorDTO dto = (DoctorDTO)map.get("dto");
		
		// 유효성 체크
		
		// MyBatis 사용
		DoctorDAO dao = C.sqlSession.getMapper(DoctorDAO.class);
		
		model.addAttribute("result", dao.insert(dto));
		
		System.out.println("생성된 uid는" + dto.getUid());
		

		
	}

}
