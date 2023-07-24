package com.mycompany.springwebapp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.mycompany.springwebapp.dto.Ch08Item;
import com.mycompany.springwebapp.dto.Ch08Member;
import com.mycompany.springwebapp.interceptor.Login;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/ch08")
public class Ch08Controller {
	@RequestMapping("/content")
	public String content() {
		return "/ch08/content";
	}
	
	@PostMapping("/login")
	public String login(Ch08Member member, HttpSession session) {
		if (member.getMpassword().equals("12345")) {
			member.setMname("하여름");
			member.setMtel("010-1234-5678");
			member.setMaddress("서울시 종로구 혜화동");
			session.setAttribute("login", member);
		}
		return "redirect:/ch08/content";
	}
	
	@GetMapping("/logout")
	@Login
	public String logout(HttpSession session) {
		session.removeAttribute("login");
		return "redirect:/ch08/content";
	}
	
	@PostMapping("/addCart")
	@Login
	public String addCart(Ch08Item item, HttpSession session, @SessionAttribute(value="cart", required=false) List<Ch08Item> cart) {
		//세션에서 카트 가져오기
		//List<Ch08Item> cart = (List<Ch08Item>)session.getAttribute("cart");
		
		//세션에 카트가 없을 경우, 새로 생성해서 세션에 저장
		if (cart==null) {
			cart = new ArrayList<Ch08Item>();
			session.setAttribute("cart", cart);
		}
		
		//카트에 해당 아이템이 있는지 조사
		boolean exist = false;
		for (Ch08Item cartItem : cart) {
			if (cartItem.getName().equals(item.getName())) {
				//카트에 기존 아이템이 있을 경우, 양만 수정
				cartItem.setAmount(cartItem.getAmount() + item.getAmount());
				exist = true;
			}
		}
		
		//카트에 없는 새로운 아이템일 경우
		if (exist == false) {
			cart.add(item);
		}
		
		return "redirect:/ch08/content";
	}
	
	@GetMapping("/clearCart")
	@Login
	public String clearCart(HttpSession session) {
		//카트를 삭제
		//방법1: 세션에 저장된 객체를 삭제
		session.removeAttribute("cart");
		
		//방법2: 세션 자체를 무효화(세션에 저장된 모든 정보가 없어짐
		//현재 HttpSession 객체를 삭제하고, 다음 요청 때 새로 생성시킴
		//session.invalidate();
		
		return "redirect:/ch08/content";
	}
	
}
