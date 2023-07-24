package com.mycompany.springwebapp.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.springwebapp.dto.Ch07Board;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/ch07")
public class Ch07Controller {
	@RequestMapping("/content")
	public String content() {
		return "ch07/content";
	}
	
	@GetMapping("/useRequest1")
	public String useRequest1(HttpServletRequest request) {
		List<Ch07Board> boards = new ArrayList<>();
		for (int i=1; i<=5; ++i) {
			Ch07Board board = new Ch07Board();
			board.setBno(i);
			board.setBtitle("제목" + i);
			board.setBcontent("내용" + i);
			board.setBwriter("글쓴이" + i);
			board.setBdate(new Date());
			boards.add(board);
		}
		
		request.setAttribute("boardList", boards);
		
		return "ch07/request";
	}
	
	@GetMapping("/useRequest2")
	public ModelAndView useRequest2(HttpServletRequest request) {
		List<Ch07Board> boards = new ArrayList<>();
		for (int i=1; i<=5; ++i) {
			Ch07Board board = new Ch07Board();
			board.setBno(i);
			board.setBtitle("제목" + i);
			board.setBcontent("내용" + i);
			board.setBwriter("글쓴이" + i);
			board.setBdate(new Date());
			boards.add(board);
		}
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("boardList", boards);
		modelAndView.setViewName("ch07/request");
		
		return modelAndView;
	}

	@GetMapping("/useRequest3")
	public String useRequest3(Model model) {
		List<Ch07Board> boards = new ArrayList<>();
		for (int i=1; i<=5; ++i) {
			Ch07Board board = new Ch07Board();
			board.setBno(i);
			board.setBtitle("제목" + i);
			board.setBcontent("내용" + i);
			board.setBwriter("글쓴이" + i);
			board.setBdate(new Date());
			boards.add(board);
		}
		
		//request 저장하는 것과 동일
		model.addAttribute("boardList", boards);
		
		return "ch07/request";
	}

	@GetMapping("/useRequest4")
	public String useRequest4(Ch07Board board) {
		//request.setAttribute("ch07Board");
		log.info(board.toString());
		
		return "ch07/request";
	}
	
	@GetMapping("/useRequest5")
	public String useRequest5(@ModelAttribute("newBoard") Ch07Board board) {
		//request.setAttribute("newBoard");
		log.info(board.toString());
		
		return "ch07/request";
	}

}
