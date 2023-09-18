package com.ms.aug02jb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ms.aug02jb.snack.Snack;

@Configuration
public class Beans {

	@Bean("sss1")
	public Snack getS1() {
		Snack s=new Snack("초코파이",5000);
		return s;
	}
	@Bean("sss2")
	public Snack getS2() {
		Snack s=new Snack();
		s.setName("오");
		s.setPrice(5000);
		return s;
	}
	
	
	
}
