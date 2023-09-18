package com.ms.aug081jpa.snack;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class SnackDAO {
	@Autowired
	private SnackRepo sr;

	public void snackReg(HttpServletRequest request, Snack s) {
		try {
			sr.save(s);
			request.setAttribute("result", "등록성공");

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "등록실패");
		}

	}
	public void snackGet(HttpServletRequest request) {
		try {
			
			request.setAttribute("snacks", sr.findAll());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
