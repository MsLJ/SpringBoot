package com.ms.aug081jpa.company;

import java.util.List;

import com.ms.aug081jpa.snack.Snack;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "aug08_company")
public class Company {
//	CREATE TABLE aug08_company(
//			c_name varchar2(10 char)PRIMARY KEY,
//			c_addr varchar2(10 char)NOT null
//			);
	@Id
	@Column(name = "c_name")
	private String name;
	
	@Column(name = "c_addr")
	private String addr;
	//댓글작업할려면 이게 필요할꺼
	//반대쪽 JoinColumn에 준거 변수명
	//이렇게 바꿔놓으면 html name도 바꿔놔야함
	@OneToMany(mappedBy = "company")
	private List<Snack>snacks;

}
