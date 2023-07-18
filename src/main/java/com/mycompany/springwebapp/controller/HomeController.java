package com.mycompany.springwebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	//http://localhost:8080/springwebapp/
	@RequestMapping("/")
	public String index() {
		log.info("실행1");
		log.info("실행2");
		log.info("실행3");
		log.info("실행4");
		log.info("실행5");
		return "index";
	}
}
