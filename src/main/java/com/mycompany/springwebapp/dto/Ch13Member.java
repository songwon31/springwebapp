package com.mycompany.springwebapp.dto;

import java.sql.Blob;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class Ch13Member {
	private String mid;
	private String mname;
	private String mpassword;
	public boolean menabled;
	public String mrole;
	public String memail;
}
