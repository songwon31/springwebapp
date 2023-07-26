package com.mycompany.springwebapp.service;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mycompany.springwebapp.dao.Ch12DaoByAnnotation1;
import com.mycompany.springwebapp.dao.Ch12DaoByAnnotation2;
import com.mycompany.springwebapp.dao.Ch12DaoByAnnotation3;
import com.mycompany.springwebapp.dao.Ch12DaoI;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class Ch12ServiceDiByAnnotation {
	//필드
	@Autowired	//@Resource
	private Ch12DaoByAnnotation1 daoAnnotation1;
	private Ch12DaoByAnnotation2 daoAnnotation2;
	private Ch12DaoByAnnotation3 daoAnnotation3;
	
	@Autowired @Qualifier("ch12DaoImpl1")
	private Ch12DaoI ch12DaoI1;
	
	@Resource(name="ch12DaoImpl2")
	private Ch12DaoI ch12DaoI2;
	
	//생성자
	/*public Ch12ServiceDiByAnnotation() {
		log.info("실행1");
	}*/
	
	//생성자
	//@Autowired
	public Ch12ServiceDiByAnnotation(Ch12DaoByAnnotation1 daoByAnnotation1) {
		log.info("실행2");
		this.daoAnnotation1 = daoByAnnotation1;
	}
	
	//Setter
	public void setCh12DaoByAnnotation1(Ch12DaoByAnnotation1 daoByAnnotation1) {
		log.info("실행");
		this.daoAnnotation1 = daoByAnnotation1;
	}

	@Autowired	//@Resource
	public void setCh12DaoByAnnotation2(Ch12DaoByAnnotation2 daoByAnnotation2) {
		log.info("실행");
		this.daoAnnotation2 = daoByAnnotation2;
	}
	
	@Autowired	//@Resource
	public void setCh12DaoByAnnotation3(Ch12DaoByAnnotation3 daoByAnnotation3) {
		log.info("실행");
		this.daoAnnotation3 = daoByAnnotation3;
	}
	
	public void setCollection1(List<String> list) {
		log.info("실행");
		for (String item : list) {
			log.info(item);
		}
	}
	
	public void setCollection2(Set set) {
		log.info("실행");
		log.info("아이템 수: " + set.size());
	}
	
	public void setCollection3(Map<String, Object> map) {
		log.info("실행");
		log.info("아이템 수: " + map.size());
	}
	
	public void setCollection4(Properties prop) {
		log.info("실행");
		log.info("아이템 수: " + prop.size());
	}
	
	//인스턴스 메서드
	public void method() {
		daoAnnotation1.method();
		daoAnnotation2.method();
		daoAnnotation3.method();
		ch12DaoI1.method();
		ch12DaoI2.method();
	}
	
}
