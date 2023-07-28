package com.mycompany.springwebapp.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.springwebapp.dto.Ch13Board;
import com.mycompany.springwebapp.dto.Ch13Pager;
import com.mycompany.springwebapp.service.Ch13BoardService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/ch13")
public class Ch13Controller {
	@Resource
	private Ch13BoardService boardService;
	
	@RequestMapping("/content")
	public String content() {
		return "/ch13/content";
	}
	
	@GetMapping("/insertBoard")
	public String insertBoard() {
		log.info("실행");
	
		Ch13Board board = new Ch13Board();
		board.setBtitle("행복해");
		board.setBcontent("고생한 만큼, 실력을 향상시켜서 연봉 10억을 받을거야.");
		board.setMid("user");
			
		boardService.write(board);
			
		//실제로 저장된 bno
		log.info("저장된 bno: " + board.getBno());
		
		return "redirect:/ch13/content";
	}
	
	@GetMapping("/getBoardList")
	public String getBoardList() {
		int totalRows = boardService.getTotalBoardNum();
		Ch13Pager pager = new Ch13Pager(10, 5, totalRows, 1);
		
		List<Ch13Board> list = boardService.getList(pager);
		for (Ch13Board board : list) {
			log.info(board.toString());
		}
		return "redirect:/ch13/content";
	}
	
	@GetMapping("/updateBoard")
	public String updateBoard() {
		Ch13Board board = boardService.getBoard(10001);
		board.setBtitle("오늘은 금요일");
		board.setBcontent("아침부터 안되네, 열심히 고쳐보자");
		
		boardService.modify(board);
		return "redirect:/ch13/content";
	}
	
	@GetMapping("/deleteBoard")
	public String deleteBoard() {
		int bno = 10001;
		boardService.remove(bno);
		return "redirect:/ch13/content";
	}
}
