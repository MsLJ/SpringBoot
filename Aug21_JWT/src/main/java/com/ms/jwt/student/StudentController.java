package com.ms.jwt.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class StudentController {

	@Autowired
	private StudentDAO sDAO;
	
	@RequestMapping(value="/student.save",produces="application/json;charset=utf-8")
	public @ResponseBody StudentToken studentSave(Student s,HttpServletResponse res) {
		res.addHeader("Access-Control-Allow-Origin", "*");
		return sDAO.makeToken(s);
	}
	@RequestMapping(value="/student.update",produces="application/json;charset=utf-8")
	public @ResponseBody StudentToken studentUpdate(@RequestParam(value="token") String token,HttpServletResponse res) {
		res.addHeader("Access-Control-Allow-Origin", "*");
		return sDAO.update(token);
	}
	@RequestMapping(value="/student.get",produces="application/json;charset=utf-8")
	public @ResponseBody Student studentGet
	(@RequestParam(value = "token")String token,HttpServletResponse res) {
		res.addHeader("Access-Control-Allow-Origin", "*");
		return sDAO.getStudent(token);
	}
}
