package com.lec.projectS_medical.command;

import java.util.Map;

import org.springframework.ui.Model;

import com.lec.projectS_medical.beans.ReservationDAO;
import com.lec.projectS_medical.beans.ReservationDTO;
import com.lec.projectS_medical.board.C;

public class ResSelectCommand implements Command {

	@Override
	public void execute(Model model) {
		
		Map<String, Object> map = model.asMap();
		String id = (String)map.get("id");
		
		System.out.println("resselect: " + model);
		
		ReservationDAO dao = C.sqlSession.getMapper(ReservationDAO.class);
//		ReservationDTO dto = dao.resById(id);
//		model.addAttribute("resList", dto);
		
		model.addAttribute("resList", dao.resById(id));

	}

}
