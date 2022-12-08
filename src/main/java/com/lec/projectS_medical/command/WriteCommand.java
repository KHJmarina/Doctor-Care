package com.lec.projectS_medical.command;

import java.util.Map;

import org.springframework.ui.Model;

import com.lec.projectS_medical.beans.BoardDTO;
import com.lec.projectS_medical.beans.BoardDAO;
import com.lec.projectS_medical.board.C;

public class WriteCommand implements Command {

	@Override
	public void execute(Model model) {
		// Model 안에 담겨 있는 값 꺼내기
		Map<String, Object> map = model.asMap();   // Model 안의 attribute 꺼낼때..
		BoardDTO dto = (BoardDTO)map.get("dto");

		// MyBatis 사용
		BoardDAO dao = C.sqlSession.getMapper(BoardDAO.class);
		
		model.addAttribute("result", dao.insert(dto));
		System.out.println("생성된 uid는 " + dto.getUid());
		
	}

}














