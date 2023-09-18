package com.ms.aug071jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ms.aug071jpa.coffee.CoffeeDAO;

import jakarta.servlet.http.HttpServletRequest;

// JDBC->ConnectionPool->

// MyBatis : 
//	SQL을 .xml에->유지보수 용이
//	ORM->자동으로 자바객체
//JPA(Java Persistance API):아이디어 이름
//	SQL이 거기서 거기 ->자동으로 만들어 줌
//	ORM
//Hibernate:실제 기술명
//	JPA라는 아이디어를 실제로 구현해놓은 기술
//Spring Data JPA:Spring + Hibernate


@Controller
public class HomeController {
	@Autowired
	CoffeeDAO cDAO;
	@RequestMapping("/")
	public String home(HttpServletRequest request) {
		cDAO.get(request);

		return "index";
	}

}
