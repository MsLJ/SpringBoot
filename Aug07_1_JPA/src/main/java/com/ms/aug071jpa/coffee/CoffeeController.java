package com.ms.aug071jpa.coffee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class CoffeeController {

	@Autowired
	CoffeeDAO cDAO;
	
	@RequestMapping("/coffee.reg")
	public String coffeeReg(HttpServletRequest request,Coffee c) {
		cDAO.reg(request, c);
		cDAO.get(request);
		return "index";
	}
	@RequestMapping("/coffee.delete")
	public String coffeeDelete(HttpServletRequest request,Coffee c) {
		cDAO.delete(request, c);
		cDAO.get(request);
		return "index";
	}
	@RequestMapping("/coffee.update")
	public String coffeeUpdate(HttpServletRequest request,Coffee c) {
		cDAO.update(request, c);
		cDAO.get(request);
		return "index";
	}
	
}
