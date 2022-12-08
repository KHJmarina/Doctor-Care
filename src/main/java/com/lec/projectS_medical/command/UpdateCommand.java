package com.lec.projectS_medical.command;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.lec.projectS_medical.beans.DoctorDAO;
import com.lec.projectS_medical.beans.DoctorDTO;
import com.lec.projectS_medical.board.C;

public class UpdateCommand implements Command {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		DoctorDTO dto = (DoctorDTO)map.get("dto");
		
		System.out.println("dto: " + dto);
		
		// MyBatis 사용
		DoctorDAO dao = C.sqlSession.getMapper(DoctorDAO.class);

		model.addAttribute("result", dao.update(dto.getId(), dto));

	}

}
