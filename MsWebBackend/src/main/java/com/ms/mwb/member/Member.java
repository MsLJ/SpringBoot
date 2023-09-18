package com.ms.mwb.member;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "msweb_member")
public class Member {
	
	
//	CREATE TABLE msweb_member(
//			msm_id varchar2(10 char)PRIMARY KEY,
//			msm_pw char(60 char)NOT NULL,
//			msm_name varchar2(10 char)NOT null
//
//			);

	@Id
	@Column(name = "msm_id")
	private String id;
	@Column(name = "msm_pw")
	private String pw;
	@Column(name = "msm_name")
	private String name;
	
	
	
}
