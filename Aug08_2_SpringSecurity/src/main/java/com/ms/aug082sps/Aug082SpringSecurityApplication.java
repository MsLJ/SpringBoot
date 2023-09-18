package com.ms.aug082sps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


//자동으로 로그인 시스템 빼고
@SpringBootApplication(exclude= {SecurityAutoConfiguration.class})
public class Aug082SpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(Aug082SpringSecurityApplication.class, args);
	}

}
