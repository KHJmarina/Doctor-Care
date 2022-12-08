package com.lec.projectS_medical.command;

import org.springframework.ui.Model;

import com.lec.projectS_medical.beans.BoardDAO;
import com.lec.projectS_medical.board.C;

public class ListCommand implements Command {

	@Override
	public void execute(Model model) {
//		BWriteDAO dao = new BWriteDAO();
//		ArrayList<BWriteDTO> list = dao.select();
//		model.addAttribute("list", list);
		
		// MyBatis 사용
		BoardDAO dao = C.sqlSession.getMapper(BoardDAO.class);
		model.addAttribute("list", dao.select());
		
	}

}













