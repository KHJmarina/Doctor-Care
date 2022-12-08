package com.lec.projectS_medical.command;

import java.util.Map;

import org.springframework.ui.Model;

import com.lec.projectS_medical.beans.DoctorDAO;
import com.lec.projectS_medical.beans.DoctorDTO;
import com.lec.projectS_medical.board.C;

public class PWSearchCommand implements Command {

	@Override
	public void execute(Model model) {
		
		Map<String, Object> map = model.asMap();
		String id = (String)map.get("id");
		
		// DB에서 가져온 id/pw 옮겨두기
		DoctorDAO dao = C.sqlSession.getMapper(DoctorDAO.class);
		DoctorDTO dto = dao.login(id);
		
		model.addAttribute("result", dto);
		
		System.out.println("DB 정보 : " + model);

	}

}
