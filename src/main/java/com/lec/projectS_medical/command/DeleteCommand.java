package com.lec.projectS_medical.command;

import java.util.Map;

import org.springframework.ui.Model;

import com.lec.projectS_medical.beans.BoardDAO;
import com.lec.projectS_medical.board.C;

public class DeleteCommand implements Command {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		int uid = (Integer)map.get("uid");
		
		BoardDAO dao = C.sqlSession.getMapper(BoardDAO.class);	
		model.addAttribute("result", dao.deleteById(uid));
		
	}

}
