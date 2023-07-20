package com.mycompany.springwebapp.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import com.mycompany.springwebapp.interceptor.Auth.Role;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Ch02InterceptorB implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		log.info("실행");
		
		//요청 처리 메서드에 @Auth가 붙어 있는지 확인
		HandlerMethod handlerMethod = (HandlerMethod)handler;
		Auth auth = handlerMethod.getMethodAnnotation(Auth.class);
		if (auth == null) {
			//@Auth가 안 붙어있을 경우
			return true;
		} else {
			//@Auth가 붙어 있을 경우
			if (auth.value() == Role.ADMIN) {
				//로그인 사용자가 관리자 권한을 가지고 있는지 검사
				boolean isAdmin = false;
				if (isAdmin) {
					return true;
				} else {
					log.info("관리자 권한이 필요함");
					response.sendRedirect(request.getContextPath());
				}
			} else {
				return true;
			}
		}
		
		return true;
	}
}
