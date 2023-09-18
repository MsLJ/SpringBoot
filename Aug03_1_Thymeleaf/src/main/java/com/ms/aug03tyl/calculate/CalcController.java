package com.ms.aug03tyl.calculate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class CalcController {
	@Autowired
	Calculator c;
	@RequestMapping("/calculate")
	public String result(HttpServletRequest request,CalcResult cr) {
		c.calculate(request, cr);
		request.setAttribute("cp", "abc");//확장자 빼고 html파일명
		request.setAttribute("cpSub", "aaa");//th:fragment이름
		return "output";
	}

}
