package com.lec.projectS_medical.command;

import java.util.Map;

import org.springframework.ui.Model;

import com.lec.projectS_medical.beans.BoardDTO;
import com.lec.projectS_medical.beans.BoardDAO;
import com.lec.projectS_medical.board.C;

public class ViewCommand implements Command {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		int uid = (Integer)map.get("uid");
		
		BoardDAO dao = C.sqlSession.getMapper(BoardDAO.class);
		dao.incViewCnt(uid); // 조회수 증가
		
		BoardDTO dto = dao.selectById(uid);  // 똑똑하게 BWriteDTO 를 리턴한다.
		model.addAttribute("dto", dto);
			
	}
} // end







