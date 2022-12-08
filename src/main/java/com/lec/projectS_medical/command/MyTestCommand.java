package com.lec.projectS_medical.command;

import java.util.Map;

import org.springframework.ui.Model;

import com.lec.projectS_medical.beans.TestDAO;
import com.lec.projectS_medical.board.C;

public class MyTestCommand implements Command {

	@Override
	public void execute(Model model) {
		
		Map<String, Object> map = model.asMap();
		String id = (String)map.get("id");
		
		TestDAO dao = C.sqlSession.getMapper(TestDAO.class);
//		TestDTO dto = dao.testById(id);
		model.addAttribute("result", dao.testById(id));

	}

}
