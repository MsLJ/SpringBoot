package com.ms.jwt.student;

import java.io.UnsupportedEncodingException;
import java.time.Duration;
import java.util.Date;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.WeakKeyException;
//yarn add axios

//JWT(JSON WEB TOKEN)
//	데이터를 암호화
//	만료시간이 있는
//	JSON을 주고받는
//
//
//
//session:클-서 연결
//	-구조가 다르고
//	-가끔 인터넷이 끊길때가 ->세션 끊김?
//	-서버가 여러대
//		클1-서1 연결
//		클2-서2 연결
//		......
//		서1뻗어서 ->클1을 서2에 연결
//		서버들끼리 세션정보 공유?
//
//
//	Spring/Springboot:거기서 만들어낸 html
//		전체적으로 tomcatWAS속에서..
//
//	react:tomcatWAS따로
//		node.jsWAS따로




@Service
public class StudentDAO {
	//32자리 이상
	private static final String KEY="0x38d47e9f1e0725d679aafcdba6f0a018a45be6fde01f6a1bb6fb83c21faf4f90";

	public StudentToken makeToken(Student s) {
		try {
			Date now=new Date();
			//지금으로부터 10초뒤 10초뒤에는 없어지는
			Date expiration=new Date(now.getTime()+Duration.ofSeconds(10).toMillis());
			
			String token=Jwts.builder()
					.signWith(Keys.hmacShaKeyFor(KEY.getBytes("utf-8")))
					.setExpiration(expiration)
					.claim("namee", s.getName())
					.claim("agee", s.getAge())
					.compact();
			System.out.println(token);
			return new StudentToken(token);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Student getStudent(String token) {
		try {
			JwtParser jp=Jwts.parserBuilder()
					.setSigningKey(Keys.hmacShaKeyFor(KEY.getBytes("utf-8"))).build();
			Jws<Claims>cs=jp.parseClaimsJws(token);
			//위에 클레임한것들
			Claims c= cs.getBody();
			//위에 지정한거키 
			String n=(String) c.get("namee");
			int a=(Integer)c.get("agee");
			return new Student(n,a);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public StudentToken update(String token) {
		try {
			JwtParser jp=Jwts.parserBuilder()
					.setSigningKey(Keys.hmacShaKeyFor(KEY.getBytes("utf-8"))).build();
			Jws<Claims>cs=jp.parseClaimsJws(token);
			//위에 클레임한것들
			Claims c= cs.getBody();
			Date now=new Date();
			//지금으로부터 10초뒤 10초뒤에는 없어지는
			Date expiration=new Date(now.getTime()+Duration.ofSeconds(10).toMillis());
			
			String token2=Jwts.builder()
					.signWith(Keys.hmacShaKeyFor(KEY.getBytes("utf-8")))
					.setExpiration(expiration)
					.claim("namee", c.get("namee"))
					.claim("agee", c.get("agee"))
					.compact();
			System.out.println(token2);
			return new StudentToken(token2);
		} catch (Exception e) {
			e.printStackTrace();
			return new StudentToken("없음");
		}
	}
	
	
	
	
}
