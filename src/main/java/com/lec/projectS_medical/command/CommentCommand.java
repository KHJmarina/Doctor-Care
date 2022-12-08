package com.lec.projectS_medical.command;

import java.util.Map;

import org.springframework.ui.Model;

import com.lec.projectS_medical.beans.CommentDAO;
import com.lec.projectS_medical.beans.CommentDTO;
import com.lec.projectS_medical.board.C;

public class CommentCommand implements Command {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		int uid = (Integer)map.get("uid");
		
		CommentDAO dao = C.sqlSession.getMapper(CommentDAO.class);
		dao.incViewCnt(uid); // 조회수 증가
		
		CommentDTO dto = dao.selectById(uid);  // 똑똑하게 BWriteDTO 를 리턴한다.
		model.addAttribute("dto", dto);
			
	}
} // end







