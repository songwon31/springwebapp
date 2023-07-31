package com.mycompany.springwebapp.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import com.mycompany.springwebapp.dto.Ch13Member;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Ch13LoginCheckInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		//log.info("실행");
		
		HandlerMethod handlerMethod = (HandlerMethod)handler;
		Login login = handlerMethod.getMethodAnnotation(Login.class);
		
		if (login != null) {
			//@Login이 붙어있다면
			HttpSession session = request.getSession();
			Ch13Member member = (Ch13Member) session.getAttribute("ch13Login");
			//로그인이 되었다면
			if (member != null) {
				return true;
			} else {
				response.sendRedirect(request.getContextPath() + "/ch13/login");
				return false;
			}
		} else {
			//@Login이 붙어있지 않다면
			return true;
		}
		
		//@Login이 붙어있지 않다면
	}
}
