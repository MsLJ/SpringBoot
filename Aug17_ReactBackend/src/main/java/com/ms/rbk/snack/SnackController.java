package com.ms.rbk.snack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@Controller
public class SnackController {

	@Autowired
	private SnackDAO sDAO;
	@RequestMapping(value="/snack.reg",produces = "application/json;charset=utf-8")
	public @ResponseBody Snack snackReg(Snack s,HttpServletResponse res) {
		res.addHeader("Access-Control-Allow-Origin","*");
		return sDAO.reg(s);
	}
	@RequestMapping(value="/snack.get",produces = "application/json;charset=utf-8")
	public @ResponseBody Snacks snackGet(HttpServletResponse res) {
		res.addHeader("Access-Control-Allow-Origin","*");
		return sDAO.get();
	}
	
	
	
}
