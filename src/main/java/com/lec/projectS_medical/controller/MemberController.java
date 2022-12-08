package com.lec.projectS_medical.controller;

import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.projectS_medical.beans.DoctorDAO;
import com.lec.projectS_medical.beans.DoctorDTO;
import com.lec.projectS_medical.board.C;
import com.lec.projectS_medical.command.Command;
import com.lec.projectS_medical.command.InsertCommand;
import com.lec.projectS_medical.command.MyInfoCommand;
import com.lec.projectS_medical.command.PWSearchCommand;
import com.lec.projectS_medical.command.UpdateCommand;

@Controller
@RequestMapping("/KHJ")
public class MemberController {

	private Command command;
	private JdbcTemplate template;
	
	// MyBatis
	private SqlSession sqlSession;
	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
		C.sqlSession = sqlSession;
	}

	public MemberController() {
		System.out.println("MemberController 생성");
	}
	
	// 현재 Model 에 뭐가 담겨 있는지 궁금
	public void printModel(Model model) {
		Map<String, Object> map = model.asMap();
		
		Set<String> keySet = map.keySet();
		for(String key : keySet) {
			System.out.println(key + " : " + map.get(key));
		}
	}
	
	
	
	@RequestMapping("/insert.do")
	public String insert(Model model) {
		return "member/insert";
	}
	
	@RequestMapping(value = "/insertOk.do", method = RequestMethod.GET) 
	public String insertOk(DoctorDTO dto, Model model){
		model.addAttribute("dto", dto);  // 커맨드객체를 Model 에 담아서..
		new InsertCommand().execute(model);
		
		printModel(model);
		
		return "member/insertOk";
	}
	
	@RequestMapping("/login.do")
	public String login(Model model) {
		return "member/login";
	}
	
	@RequestMapping(value = "/loginOk.do", method = RequestMethod.POST) 
	public String loginOk(DoctorDTO dto, Model model, HttpSession session){
		String returnUrl = "";
		
		if(session.getAttribute("id") != null) {
			// 기존 id 세션값이 존재한다면 (즉! 로그인 상태라면)
			session.removeAttribute("id");	// 일단 이전 로그인 정보 날림
		}
		
		// 입력한 정보
		String id = dto.getId();
		String pw = dto.getPw();
		
		// DB에서 가져온 id/pw 옮겨두기
		DoctorDTO list = null;
		DoctorDAO dao = C.sqlSession.getMapper(DoctorDAO.class);
		list = dao.login(id);
		
		String dbID = list.getId();
		String dbPW = list.getPw();
		
		System.out.println("로그인창에 입력한 모델 값:" + model);
		System.out.println("입력 정보 : " + id + ", " + pw);
		System.out.println("DB 정보 : " + dbID + ", " + dbPW);
		
		// 회원 DB 검색
		if(dbID.equals(id) && dbPW.equals(pw)) {
			// 로그인 성공
			session.setAttribute("id", id);	// 세션에 로그인 정보 추가
			
			//원래 가고자했던 url이 있었다면
//			String priorUrl = (String)session.getAttribute("url_prior_login");
			if(dbID.equals("admin")) {
				returnUrl = "redirect:/KHJ/mainAdmin.do";
			} 
			
//			else if(priorUrl != null) {
//				returnUrl = "redirect:" + priorUrl;
//				session.removeAttribute("url_prior_login");
//			} 
			
			else {
				// 없었다면 디폴트로 메인으로 이동
				returnUrl = "redirect:/KHJ/mainUser.do";
			} 
		} else {
			returnUrl = "member/logfail";
		}
		
		return returnUrl;
	}
	
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("id");
		return "member/logout";
	}
	
	@RequestMapping("/pwSearch.do")
	public String pwSearch(Model model) {
		return "member/pwSearch";
	}
	
	@RequestMapping(value = "/pwSearchOk.do", method = RequestMethod.POST)
	public String pwSearchOk(DoctorDTO dto, Model model, HttpSession session) {
		
		// 입력한 정보
		String id = dto.getId();
				
		System.out.println("입력 정보 : " + id);
		
		model.addAttribute("id", id);
		new PWSearchCommand().execute(model);
		
		return "member/pwSearchOk";
	}
	
	@RequestMapping("/pwAnswer.do")
	public String pwAnswer(String id, Model model) {
		return "member/pwAnswer";
	}
	
	@RequestMapping(value = "/myInfo.do") 
	public String myInfo(String id, Model model){
		model.addAttribute("id", id);  // 커맨드객체를 Model 에 담아서..
		new MyInfoCommand().execute(model);
		
		printModel(model);
		
		return "member/myInfo";
	}

	@RequestMapping(value = "/update.do")
	public String update(String id, Model model){
		
		model.addAttribute("id", id);  // 커맨드객체를 Model 에 담아서..
		new MyInfoCommand().execute(model);
		
		printModel(model);
		
		return "member/update";
	}
	
	@RequestMapping(value = "/updateOk.do", method = RequestMethod.POST) 
	public String updateOk(DoctorDTO dto, Model model){
		
		model.addAttribute("dto", dto);
		new UpdateCommand().execute(model);
		
		return "member/updateOk";
	}
	

	
} // end Controller


















