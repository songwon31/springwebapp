package com.mycompany.springwebapp.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Ch12ServicePropertyDi {
	@Value("${file.upload.dir}")
	private String fileUploadDir;
	@Value("${test.prop1}")
	private String prop1;
	private double prop2;
	private boolean prop3;
	private String prop4;
	
	@Value("${test.prop2}")
	public void setProp2(double prop2) {
		this.prop2 = prop2;
	}
	
	public void setProp3(@Value("${test.prop3}") boolean prop3) {
		this.prop3 = prop3;
	}
	
	public void setProp4(String prop4) {
		this.prop4 = prop4;
	}
	
	public void method() {
		log.info("fileUploadDir: " + fileUploadDir);
		log.info("prop1: " + prop1);
		log.info("prop2: " + prop2);
		log.info("prop3: " + prop3);
		log.info("prop4: " + prop4);
	}
}
