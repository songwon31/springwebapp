package com.mycompany.springwebapp.dto;

import java.sql.Blob;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class Ch13Board {
	private int bno;
	private String btitle;
	private String bcontent;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date bdate;
	private String mid;
	private String bhitcount;
	private String battachoname;
	private String battachsname;
	private String battachtype;
	private Blob battachdata;
	private MultipartFile battach;
}
