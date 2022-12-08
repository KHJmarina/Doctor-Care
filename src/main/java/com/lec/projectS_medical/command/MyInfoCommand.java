package com.lec.projectS_medical.command;

import java.util.Map;

import org.springframework.ui.Model;

import com.lec.projectS_medical.beans.DoctorDAO;
import com.lec.projectS_medical.beans.DoctorDTO;
import com.lec.projectS_medical.board.C;

public class MyInfoCommand implements Command {

	@Override
	public void execute(Model model) {
		
		Map<String, Object> map = model.asMap();
		String id = (String)map.get("id");
				
		DoctorDAO dao = C.sqlSession.getMapper(DoctorDAO.class);
		DoctorDTO dto = dao.login(id);
		model.addAttribute("result", dto);
		

	}

}
