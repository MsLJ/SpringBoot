package com.ms.aug02jb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ms.aug02jb.menu.Menu;
import com.ms.aug02jb.snack.Snack;


@Controller
public class HomeController {

	@Autowired
	private Menu m;
	
	
	@RequestMapping("/")
	public String home() {
		System.out.println(m.getName());
		System.out.println(m.getPrice());
		
		
		
		
		AbstractApplicationContext aac
		= new AnnotationConfigApplicationContext(Beans.class);
		aac.registerShutdownHook();
		Snack sss1=aac.getBean("sss1",Snack.class);
		System.out.println(sss1.getName());
		System.out.println(sss1.getPrice());
		Snack sss2=aac.getBean("sss2",Snack.class);
		System.out.println(sss2.getName());
		System.out.println(sss2.getPrice());
		aac.close();
		
		return "index";
	}
}
