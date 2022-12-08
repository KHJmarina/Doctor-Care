package com.lec.projectS_medical.controller;

import java.util.Map;
import java.util.Set;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.projectS_medical.beans.CommentDTO;
import com.lec.projectS_medical.beans.DoctorDTO;
import com.lec.projectS_medical.beans.TestDTO;
import com.lec.projectS_medical.board.C;
import com.lec.projectS_medical.command.CmtListCommand;
import com.lec.projectS_medical.command.Command;
import com.lec.projectS_medical.command.CommentCommand;
import com.lec.projectS_medical.command.CommentWriteCommand;
import com.lec.projectS_medical.command.DiseaseBeforeCommand;
import com.lec.projectS_medical.command.DiseaseCommand;
import com.lec.projectS_medical.command.HighBP1Command;
import com.lec.projectS_medical.command.HighBP2Command;
import com.lec.projectS_medical.command.HighBPBeforeCommand;
import com.lec.projectS_medical.command.ListCommand;
import com.lec.projectS_medical.command.MemberInfoCommand;
import com.lec.projectS_medical.command.MyInfoCommand;
import com.lec.projectS_medical.command.ObesityCommand;
import com.lec.projectS_medical.command.TestCommand;
import com.lec.projectS_medical.command.ViewCommand;

@Controller
@RequestMapping("/KHJ")
public class AdminController {

	private Command command;
	//private JdbcTemplate template;
	
	// MyBatis
	private SqlSession sqlSession;
	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
		C.sqlSession = sqlSession;
	}

	public AdminController() {
		System.out.println("AdminController 생성");
	}
	
	// 현재 Model 에 뭐가 담겨 있는지 궁금
	public void printModel(Model model) {
		Map<String, Object> map = model.asMap();
		
		Set<String> keySet = map.keySet();
		for(String key : keySet) {
			System.out.println(key + " : " + map.get(key));
		}
	}
	
	
	
	@RequestMapping("/mainAdmin.do")
	public String mainAdmin(Model model) {
		return "admin/mainAdmin";
	}

	@RequestMapping(value = "/memberInfo.do") 
	public String memberInfo(DoctorDTO dto, Model model){
		model.addAttribute("dto", dto);
		new MemberInfoCommand().execute(model);
		
		printModel(model);
		
		return "admin/memberInfo";
	}
	
	@RequestMapping(value = "/test.do") 
	public String test(int mb_uid, Model model){
		
		model.addAttribute("mb_uid", mb_uid);
		
		printModel(model);
		
		return "admin/test";
	}
	
	@RequestMapping(value = "/testOk.do", method = RequestMethod.GET) 
	public String testOk(TestDTO dto, Model model){
		
		printModel(model);
		System.out.println("testOk dto:" + dto);
		
		model.addAttribute("dto", dto);
		new TestCommand().execute(model);
		
		
		return "admin/testOk";
	}
	
	@RequestMapping(value = "/disease.do") 
	public String disease(Model model){

		new DiseaseCommand().execute(model);
		new DiseaseBeforeCommand().execute(model);
		new ObesityCommand().execute(model);
		new HighBPBeforeCommand().execute(model);
		new HighBP1Command().execute(model);
		new HighBP2Command().execute(model);
		
		return "admin/disease";
	}
	
	
	
	
	
	
	@RequestMapping("/commentWrite.do")
	public String commentWrite(int uid, Model model) {
		model.addAttribute("uid", uid);   // parameter 를 직접 model 에 담을수도 있고, request 를 담아서 줄수도 있다.
		new ViewCommand().execute(model);
		return "main/commentWrite";
	}
	
	@RequestMapping(value = "/commentWriteOk.do", method = RequestMethod.GET) 
	public String commentWriteOk(CommentDTO dto, Model model){
		model.addAttribute("dto", dto);  // 커맨드객체를 Model 에 담아서..
		new CommentWriteCommand().execute(model);
		
		printModel(model);
		
		return "main/commentWriteOk";
	}
	
	@RequestMapping(value = "/comment.do")
	public String comment(int uid, Model model) {
		model.addAttribute("uid", uid);   // parameter 를 직접 model 에 담을수도 있고, request 를 담아서 줄수도 있다.
		new CommentCommand().execute(model);
		return "main/comment";
	}
	
	
	
	

	
} // end Controller


















