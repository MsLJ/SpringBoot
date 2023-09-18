package com.ms.aug081jpa.snack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ms.aug081jpa.company.CompanyDAO;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class SnackController {
	@Autowired
	private SnackDAO sDAO;
	@Autowired
	private CompanyDAO cDAO;

	@RequestMapping("/snack.reg")
	public String regsnack(HttpServletRequest request, Snack s) {
		sDAO.snackReg(request, s);
		sDAO.snackGet(request);
		cDAO.getCompany(request);
		return "index";
	}

}
