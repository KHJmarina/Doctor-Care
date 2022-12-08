package com.lec.projectS_medical.command;

import org.springframework.ui.Model;

import com.lec.projectS_medical.beans.CommentDAO;
import com.lec.projectS_medical.board.C;

public class CmtListCommand implements Command {

	@Override
	public void execute(Model model) {
		
		// MyBatis 사용
		CommentDAO dao = C.sqlSession.getMapper(CommentDAO.class);
		model.addAttribute("listC", dao.select());
		
	}

}













