package com.lec.projectS_medical.command;

import org.springframework.ui.Model;

import com.lec.projectS_medical.beans.TestDAO;
import com.lec.projectS_medical.board.C;

public class HighBPBeforeCommand implements Command {

	@Override
	public void execute(Model model) {
		
		TestDAO dao = C.sqlSession.getMapper(TestDAO.class);
		
		model.addAttribute("highBPBefore", dao.testHighBPBefore());

	}

}
