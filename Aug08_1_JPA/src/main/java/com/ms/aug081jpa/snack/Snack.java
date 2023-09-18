package com.ms.aug081jpa.snack;

import com.ms.aug081jpa.company.Company;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//persistence
//영속성
//프로그램 종료돼도 종료x

//??.save()
//pk값이 있으면 update
// 		없으면 insert
//과자 번호를 seq로 올릴거라 값이 없
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "aug08_snack")
public class Snack {
//	s_no number(3)PRIMARY KEY,
//	s_name varchar2(10 char)NOT NULL,
//	s_price number(5)NOT NULL,
//	s_maker varchar2(10 char)NOT NULL,
	@Id
	//						OracleDB의 seq이름, .java에서 쓸 이름, 한번에얼마씩올릴지
	@SequenceGenerator(sequenceName = "aug08_snack_seq",name = "ass",allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "ass")
	@Column(name = "s_no")
	private Integer no;
	@Column(name = "s_name")
	private String name;
	@Column(name = "s_price")
	private Integer price;
	
	//회사가 한개면 과자가 여러개
	//join할꺼면 어떤 칼럼으로?
	@ManyToOne
	@JoinColumn(name="s_maker")
	private Company company;
	
}
