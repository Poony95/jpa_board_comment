package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dao.MemberDAO;
import com.example.demo.entity.Member;

import jakarta.servlet.http.HttpSession;
import lombok.Setter;

@Controller
@Setter
public class MemberController {
	@Autowired
	private MemberDAO dao;
	
	@PostMapping("/member/login")
	public String loginOK(String id, String pwd, 
			HttpSession session) {
		System.out.println("id:"+id);
		System.out.println("pwd:"+pwd);
		String view = "redirect:/board/list";
		Member m= dao.isMember(id, pwd);
		System.out.println("m:"+m);
		if(m == null) {
			view = "redirect:/member/login.html";
			System.out.println("로그인 실패");
		}else {
			session.setAttribute("id", id);
			System.out.println("로그인 성공");
		}
		return view;		
	}
}












