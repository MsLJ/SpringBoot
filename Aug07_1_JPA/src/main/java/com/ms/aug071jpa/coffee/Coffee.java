package com.ms.aug071jpa.coffee;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//HTML->Servlet->JSP->EJB(Enterprise JavaBean)
//						JavaBean에 이런저런 설정...
//					->Spring
//						POJO(Plain Old Java Object)

// JPA: EJB쪽에서 발전해온

//테이블명과 자바빈 클래스명 같으면 알아서 인식
//aug07_coffee Coffee
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "aug07_coffee") // 테이블명과 자바빈 이름이 달라서
public class Coffee {
	// DB필드명/멤버변수명 같으면 알아서 인식
	// setC_name,getC_name형태로 나올텐데 ->인식 못함
	//	setName,getName형태면 인식하는데
	@Id//primary Key
	@Column(name="c_name")//c_name필드랑 연결
	private String name;//이런 형태여야 JPA써먹을수있고
						//DB필드명이랑 달라서 자동연결은 안되고
	@Column(name="c_price")//c_price필드랑 연결
	private Integer price; //굳이 BigDecimal안써도 상관없고 그리고 int형 써도 돼지만 나중에 문제가 생기는 객체형인 Integer

}
