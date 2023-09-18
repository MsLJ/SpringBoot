package com.ms.aug03tyl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 기술적 욕심
//		1)그 회사에서 쓰는거 신입에게 교육해야
//		2)기술/패러다임 바뀌고


// HTML/CSS/JS
//------프로그램적 부분이 약해서
// Servlet:HTML/CSS/JS를 만드는 자바 프로그램
//---------
//JSP(Java Servlet Page) :
//		작업형태-웹 바탕에 자바소스 넣는 형태
//		실행하면 톰캣이 Servlet으로 바꿔서 실행함
//		.jsp에 자바소스 넣어지니까 좋다
//-----분업
//JSP Model 2==V쪽 문제
//---------
//JSP Model 2+EL+JSTL
//		=>정작 jsp가 하는게?
//		=>jsp는 서블릿으로 바꿔서 실행->느림->톰캣이 없으면 실행불가

//위와 같은 이유로
//=> Spring boot에서 .jsp를 자제
//	 HTML템플릿엔진을 권장(Thymeleaf)

//=>.jsp + EL + JSTL ->Thymeleaf

//thymeleaf사용하려면 플러그인 설치 이클립스 마켓플레이스가서
//Spring boot폴더쪽 들어가서 SpringToolsuite4.ini
//--add-opens=java.base/sun.security.ssl=ALL-UNNAMED
//이거 위에 하나 복사 붙여넣기 해서 
//--add-opens=java.base/java.lang=ALL-UNNAMED
//이렇게 하나 수정하기
@Controller
public class HomeController {

	@RequestMapping("/")
	public String home() {
		return "index";
	}
	

	
	
	
}
