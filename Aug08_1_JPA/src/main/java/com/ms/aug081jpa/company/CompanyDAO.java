package com.ms.aug081jpa.company;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class CompanyDAO {
@Autowired
CompanyRepo cr;
	public void getCompany(HttpServletRequest request) {
		List<Company>companys=cr.findAll();
		request.setAttribute("companys", companys);
	}
}
