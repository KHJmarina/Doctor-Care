package com.lec.projectS_medical.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

// shift + alt + S + V
public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// 뷰 response 후
		System.out.println("[afterCompletion]");
		super.afterCompletion(request, response, handler, ex);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// 컨트롤러 실행후, view 직전
		System.out.println("[postHandle]");
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 컨트롤러 실행전
		System.out.println("[preHandle]");
		
		// session 객체 가져오기
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");	// 로그인한 id가 있는지. 로그인 상태인지
		
		if(id == null) {
			// 만약 로그인이 되어 있지 않다면, 로그인 페이지로 redirect;
			// 직전 요청 url을 세션에 기록
//			String urlPrior = request.getRequestURI().toString() + "?" + request.getQueryString();
			
//			session.setAttribute("url_prior_login", urlPrior);
			response.sendRedirect(request.getContextPath() + "/KHJ/login.do");
			return false;	// ★★★ 더이상 컨트롤러로 연동되면 안 됨
		}
		
		return true;	// ★★★ 컨트롤러 핸들러 진행
	}

}














