package com.mycompany.springwebapp.controller;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/ch06")
public class Ch06Controller {
	@RequestMapping("/content")
	public String content() {
		return "ch06/content";
	}
	
	@GetMapping("/forward")
	public String forward(HttpServletRequest request) {
		request.setAttribute("loginStatus", true);
		request.setAttribute("userName", "홍길동");
		return "ch06/forward1";
	}
	
	@GetMapping("/redirect")
	public String redirect(HttpServletRequest request, HttpSession session) throws Exception {
		String userName = "홍길동";
		//request.setAttribute("userName", userName);
		userName = URLEncoder.encode(userName, "UTF-8");
		
		session.setAttribute("userId", "summer");
		
		return "redirect:/ch06/getValue?userName=" + userName;
	}
	
	@GetMapping("/getValue")
	public String getValue(String userName, HttpServletRequest request, HttpSession session) {
		log.info("userName: " + userName);
		log.info("userName: " + request.getParameter("userName"));
		log.info("userId: " + session.getAttribute("userId"));
		return "redirect:/ch06/content";
	}

}
