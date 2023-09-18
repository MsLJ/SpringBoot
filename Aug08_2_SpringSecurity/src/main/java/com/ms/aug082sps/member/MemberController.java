package com.ms.aug082sps.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MemberController {
	@Autowired
	private MemberDAO mDAO;
	
@RequestMapping("/member.login")
	public String memberLogin(HttpServletRequest request,Member m) {
	mDAO.login(request, m);
	
	return "index";
}
}
