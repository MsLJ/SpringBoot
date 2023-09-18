package com.ms.mwb.member;

import java.awt.RenderingHints.Key;
import java.time.Duration;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class MemberDAO {

	//JWT키값 30자이상으로 이루어져야함 블록체인이 들어가기 적합해보이는
	private static final String KEY="1234567890123456789012345678901234567890";
	
	
	
	@Autowired
	private MemberRepo mr;
	
	private BCryptPasswordEncoder bcpe;
	
	public MemberDAO() {
		bcpe=new BCryptPasswordEncoder();
	}
	
	public Member join(Member m) {
		System.out.println(m.getId());
		System.out.println(m.getPw());
		System.out.println(bcpe.encode(m.getPw()));
		System.out.println(m.getName());
		try {
		if	(mr.findById(m.getId()).isEmpty()) {
			m.setPw(bcpe.encode(m.getPw()));
			return mr.save(m);
		}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}
	
	public MemberJWT login(Member inputMember) {
		//로그인할때 JWT를 만들어내는
		try {
			//							PK					id
			//JPA의 Optional이라는걸 활용 ID값만 갖고와서 검사하고
			Optional<Member>dbMember=mr.findById(inputMember.getId());
			if (dbMember.isPresent()) {
				if (bcpe.matches(inputMember.getPw(), dbMember.get().getPw())) {
					//비밀번호가 일치하면 세션대신에 사용할 JWT를생성
					String token=Jwts.builder()
							.signWith(Keys.hmacShaKeyFor(KEY.getBytes("utf-8"))).setExpiration(new Date(new Date().getTime() + Duration.ofSeconds(10).toMillis()))
							.claim("id", dbMember.get().getId())
							.claim("pw", dbMember.get().getPw())
							.claim("name", dbMember.get().getName())
							.compact();
					//한번에 객체로 받는게 안되기에 다 따로 하나하나 클레임해줄것 id pw name
					//로그인 유지시간 get time 지금으로부터의 시간을 구해서  10초를 유지하는
							//세션대신 쓰는그 claim에 앞에 이제 View쪽에 쓸꺼 함수명 그리고 그 안에 들어갈 값은 뒤에있는거
					return new MemberJWT(token);
				}else {
					return new MemberJWT("비밀번호 불일치");
				}
			}else {
				return new MemberJWT("실패(미가입)");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new MemberJWT("실패(DB)");
		
		}
		
		
	}
	
	public Member get(String token) {
		//세션에서 꺼내는게아니라 파싱할게 회원정보를 필요한
		//로그인이 돼었을때 나올
		try {
			JwtParser jp=
					Jwts.parserBuilder()
					.setSigningKey(Keys.hmacShaKeyFor(KEY.getBytes("utf-8"))).build();
			Jws<Claims>jwt=jp.parseClaimsJws(token);
			Claims c=jwt.getBody();
			//여기서도 위에서 만든거 하나씩 다 받기
			String id=(String)c.get("id");
			String pw=(String)c.get("pw");
			String name=(String)c.get("name");
			
			return new Member(id,pw,name);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public MemberJWT updateToken(String token) {
		//세션이랑은 다르게 자동으로 행동할때마다 계속해서 갱신이되는게아니라서
		//따로 갱신 작업이 필요한JWT
		//그래서 기존 JWT정보 받아서 JWT토큰을 새로 만드는
		try {
			JwtParser jp=
					Jwts.parserBuilder()
					.setSigningKey(Keys.hmacShaKeyFor(KEY.getBytes("utf-8"))).build();
			Jws<Claims>jwt=jp.parseClaimsJws(token);
			Claims c=jwt.getBody();
			//여기서도 위에서 만든거 하나씩 다 받기
			String id=(String)c.get("id");
			String pw=(String)c.get("pw");
			String name=(String)c.get("name");
			
			String token2=Jwts.builder()
					.signWith(Keys.hmacShaKeyFor(KEY.getBytes("utf-8"))).setExpiration(new Date(new Date().getTime() + Duration.ofSeconds(10).toMillis()))
					.claim("id", id)
					.claim("pw", pw)
					.claim("name",name)
					.compact();
			
			
			return new MemberJWT(token2);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	
}
