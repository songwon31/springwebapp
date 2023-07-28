package com.mycompany.springwebapp.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.springwebapp.service.Ch12ServiceDiByAnnotation;
import com.mycompany.springwebapp.service.Ch12ServiceDiByXml;
import com.mycompany.springwebapp.service.Ch12ServicePropertyDi;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/ch12")
public class Ch12Controller {
	@Autowired
	private Ch12ServiceDiByXml serviceDiByXml;
	
	@Autowired
	private Ch12ServiceDiByAnnotation serviceDiByAnnotation;
	
	@Resource
	private Ch12ServicePropertyDi servicePropertDi;
	
	@RequestMapping("/content")
	public String content() {
		serviceDiByXml.method();
		serviceDiByAnnotation.method();
		servicePropertDi.method();
		return "/ch12/content";
	}
	
}
