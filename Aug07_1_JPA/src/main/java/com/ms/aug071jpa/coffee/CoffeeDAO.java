package com.ms.aug071jpa.coffee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class CoffeeDAO {

	@Autowired
	private CoffeeRepo cr;

	public void reg(HttpServletRequest request, Coffee c) {
		// 이러면 알아서 자동으로 insert into해주는
		try {
			cr.save(c);
			request.setAttribute("result", "등록성공");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "등록실패");

		}

	}

	public void get(HttpServletRequest request) {
		try {
			// select*from 테이블명
//			List<Coffee>coffees=cr.findAll();
//			List<Coffee>coffees=cr.findByPriceGreaterThanEqual(5000);
//			List<Coffee>coffees=cr.findByNameContaining("라떼");
			// Sort정렬 가격비싼순정렬 가격 똑같으면 이름 가나다순 정렬
			Sort s = Sort.by(Sort.Order.desc("price"), Sort.Order.asc("name"));
			// 페이지번호(0번부터),한페이지당 몇개,정렬
			Pageable p = PageRequest.of(0, 5, s);
			List<Coffee> coffees = cr.findByNameContaining("", p);
			

			request.setAttribute("coffees", coffees);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(HttpServletRequest request, Coffee c) {
		try {
			cr.deleteById(c.getName());
			request.setAttribute("result", "삭제성공");

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "삭제실패");
		}

	}

	public void update(HttpServletRequest request, Coffee c) {
		try {
			// 그 이름에 해당하는 커피 전체 정보 조회 가져오기
			c = cr.findById(c.getName()).get();
			// 그대로 둘 정보는 그대로 두고,바꿀거는 바꾸고
			c.setPrice(0);

			// 똑같은 PK가 없으면 insert
			// 똑같은 PK가 있으면 Update
			cr.save(c);

			request.setAttribute("result", "업데이트성공");

		} catch (Exception e) {
			request.setAttribute("result", "업데이트실패");
			e.printStackTrace();
		}

	}

}
