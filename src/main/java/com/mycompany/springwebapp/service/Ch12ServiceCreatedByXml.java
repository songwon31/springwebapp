package com.mycompany.springwebapp.service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Ch12ServiceCreatedByXml {
	public Ch12ServiceCreatedByXml() {
		log.info("실행");
	}
	
	public static Ch12ServiceCreatedByXml getInstance() {
		log.info("실행");
		return new Ch12ServiceCreatedByXml();
	}
	
	public Ch12ServiceCreatedByXml getSelfObject() {
		log.info("실행");
		return new Ch12ServiceCreatedByXml();
	}
	
	public void method1() {
		log.info("실행");
	}
	
	public void method2() {
		log.info("실행");
	}
}
