package com.mycompany.springwebapp.dao;

import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class Ch12DaoByAnnotation3 {
	public Ch12DaoByAnnotation3() {
		log.info("실행");
	}
	
	public void method() {
		log.info("실행");
	}
}
