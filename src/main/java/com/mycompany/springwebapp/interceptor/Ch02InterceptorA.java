package com.mycompany.springwebapp.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Ch02InterceptorA implements HandlerInterceptor {
	//Servlet에서 Controller로 데이터를 보내기 전
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		log.info("실행");
		return true;
	}
	
	//Controller에서 Servlet으로 리턴을 보내기 전
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		//log.info("실행");
	}
	
	//JSP->HTML 까지 끝내고 Servlet에서 응답을 보내기 전
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		//log.info("실행");
	}
}
