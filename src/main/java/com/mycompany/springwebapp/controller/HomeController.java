package com.mycompany.springwebapp.controller;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	
	public HomeController() {
		log.info("실행");
	}
	
	@PostConstruct
	public void method1() {
		log.info("실행");
	}
	
	@PostConstruct
	public void method2() {
		log.info("실행");
	}
	
	@PreDestroy
	public void method3() {
		log.info("실행");
	}
	
	//http://localhost:8080/springwebapp/
	@RequestMapping("/")
	public String index() {
		log.info("실행");
		return "index";
	}
}
