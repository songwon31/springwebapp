package com.mycompany.springwebapp.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class Ch07Board {
	private int bno;
	private String btitle;
	private String bcontent;
	private String bwriter;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date bdate;
	
}
