package com.mycompany.springwebapp.controller;

import java.io.File;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycompany.springwebapp.dto.Ch09FileUpload;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/ch09")
public class Ch09Controller {
	@RequestMapping("/content")
	public String content() {
		return "/ch09/content";
	}
	
	/*@PostMapping("/fileupload")
	public String fileupload(String title, String desc, MultipartFile attach) throws Exception {
		log.info("title: " + title);
		log.info("desc: " + desc);
		log.info("file originalFilename: " + attach.getOriginalFilename());
		log.info("file contentType: " + attach.getContentType());
		log.info("file size: " + attach.getSize());
		
		// 받은 파일을 영구적으로 저장하기
		String saveFilename = new Date().getTime() + "-" + attach.getOriginalFilename();
		String saveFilepath = "C:/oti-2/uploadfiles/" + saveFilename;
		File file = new File(saveFilepath);
		attach.transferTo(file);
		
		return "redirect:/ch09/content";
	}*/
	
	@PostMapping("/fileupload")
	public String fileupload(Ch09FileUpload fileUpload, HttpSession session) throws Exception {
		log.info("title: " + fileUpload.getTitle());
		log.info("desc: " + fileUpload.getDesc());
		log.info("file originalFilename: " + fileUpload.getAttach().getOriginalFilename());
		log.info("file contentType: " + fileUpload.getAttach().getContentType());
		log.info("file size: " + fileUpload.getAttach().getSize());
		
		// 받은 파일을 영구적으로 저장하기
		String saveFilename = new Date().getTime() + "-" + fileUpload.getAttach().getOriginalFilename();
		String saveFilepath = "C:/oti-2/uploadfiles/" + saveFilename;
		File file = new File(saveFilepath);
		fileUpload.getAttach().transferTo(file);
		
		session.setAttribute("saveFilename", saveFilename);
		
		return "redirect:/ch09/content";
	}
	
	@PostMapping(value="/fileuploadAjax", produces="application/json; charset=UTF-8")
	@ResponseBody
	public String fileuploadAjax(Ch09FileUpload fileUpload) throws Exception {
		log.info("title: " + fileUpload.getTitle());
		log.info("desc: " + fileUpload.getDesc());	
		log.info("file originalFilename: " + fileUpload.getAttach().getOriginalFilename());
		log.info("file contentType: " + fileUpload.getAttach().getContentType());
		log.info("file size: " + fileUpload.getAttach().getSize());
		
		// 받은 파일을 영구적으로 저장하기
		String saveFilename = new Date().getTime() + "-" + fileUpload.getAttach().getOriginalFilename();
		String saveFilepath = "C:/oti-2/uploadfiles/" + saveFilename;
		File file = new File(saveFilepath);
		fileUpload.getAttach().transferTo(file);
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("result", "success");
		jsonObject.put("saveFilename", saveFilename);
		String json = jsonObject.toString();
		
		return json;
	}
	
	@GetMapping("/filedownload")
	public void filedownload(String saveFilename, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String fileName = saveFilename;
		String filePath = "C:/oti-2/uploadfiles/" + fileName;
				
		//응답 헤드에 Content-Type 추가
		String mimeType = request.getServletContext().getMimeType(filePath);
		response.setContentType(mimeType);
		
		//응답 헤드에 한글 이름의 파일명을 ISO-8859-1 문자셋으로 인코딩해서 추가
		String userAgent = request.getHeader("User-Agent");
		if(userAgent.contains("Trident") || userAgent.contains("MSIE")) {
			//IE
			fileName = URLEncoder.encode(fileName, "UTF-8");
		} else {
			//Chrome, Edge, FireFox, Safari
			fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
		}
		response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
		
		//응답 본문에 파일 데이터 싣기
		OutputStream os = response.getOutputStream();
		Path path = Paths.get(filePath);
		Files.copy(path, os);
		os.flush();
		os.close();
	}
	
}
