package com.ms.mwb.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class MemberController {
	
	@Autowired
	private MemberDAO mDAO;
	
//jackson-mapper-asl
		//jwt
	//정확하게는 JSON형태로 만들어주는
	//예를들어 http://localhost:81/member.join?id=dlwmsgk21&pw=1234&name=dw를 넣으면
//	{
//		  "id": "dlwmsgk21",
//		  "pw": "1234",
//		  "name": "dw"
//		}
	@RequestMapping(value="/member.join", produces = "application/json; charset=utf-8",method = RequestMethod.POST)
	public @ResponseBody Member memberJoin(Member m,HttpServletResponse res) {
		res.addHeader("Access-Control-Allow-Origin", "*");
		return mDAO.join(m);
	}
	
	@RequestMapping(value="/member.login", produces = "application/json; charset=utf-8",method = RequestMethod.POST)
	public @ResponseBody MemberJWT memberLogin(Member m,HttpServletResponse res) {
		res.addHeader("Access-Control-Allow-Origin", "*");
		return mDAO.login(m);
	}
	
	@RequestMapping(value="/member.info.get", produces = "application/json; charset=utf-8",method = RequestMethod.GET)
	public @ResponseBody Member memberInfoGet(@RequestParam("token")String token,HttpServletResponse res) {
		res.addHeader("Access-Control-Allow-Origin", "*");
		return mDAO.get(token);
	}
	@RequestMapping(value="/member.token.update", produces = "application/json; charset=utf-8",method = RequestMethod.GET)
	public @ResponseBody MemberJWT memberLogin(@RequestParam("token")String token,HttpServletResponse res) {
		res.addHeader("Access-Control-Allow-Origin", "*");
		return mDAO.updateToken(token);
	}
	
	
	
	
	
	
	
}
