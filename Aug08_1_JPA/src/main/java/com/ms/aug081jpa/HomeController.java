package com.ms.aug081jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ms.aug081jpa.company.CompanyDAO;
import com.ms.aug081jpa.snack.SnackDAO;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

	@Autowired
	private SnackDAO sDAO;
	@Autowired
	private CompanyDAO cDAO;

	@RequestMapping("/")
	public String home(HttpServletRequest request) {
		sDAO.snackGet(request);
		cDAO.getCompany(request);
		return "index";
	}
}
