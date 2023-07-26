package com.mycompany.springwebapp.dao;

import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class Ch12DaoImpl2 implements Ch12DaoI {
	@Override
	public void method() {
		log.info("실행");
	}
}
