package com.lec.projectS_medical.command;

import org.springframework.ui.Model;

import com.lec.projectS_medical.beans.TestDAO;
import com.lec.projectS_medical.board.C;

public class HighBP1Command implements Command {

	@Override
	public void execute(Model model) {
		
		TestDAO dao = C.sqlSession.getMapper(TestDAO.class);
		
		model.addAttribute("highBP1", dao.testHighBP1());

	}

}
