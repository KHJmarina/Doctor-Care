package com.lec.projectS_medical.command;

import java.util.Map;

import org.springframework.ui.Model;

import com.lec.projectS_medical.beans.TestDAO;
import com.lec.projectS_medical.beans.TestDTO;
import com.lec.projectS_medical.board.C;

public class TestCommand implements Command {

	@Override
	public void execute(Model model) {
		
		Map<String, Object> map = model.asMap();   // Model 안의 attribute 꺼낼때..
		TestDTO dto = (TestDTO)map.get("dto");
		
		System.out.println("dto: " + dto);
		
		TestDAO dao = C.sqlSession.getMapper(TestDAO.class);
		
		model.addAttribute("result", dao.insert(dto));
		
		
	}

}
