package com.lec.projectS_medical.command;

import org.springframework.ui.Model;

import com.lec.projectS_medical.beans.DoctorDAO;
import com.lec.projectS_medical.board.C;

public class MemberInfoCommand implements Command {

	@Override
	public void execute(Model model) {
		
		DoctorDAO dao = C.sqlSession.getMapper(DoctorDAO.class);
		model.addAttribute("list", dao.select());

	}

}
