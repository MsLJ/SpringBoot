package com.ms.rbk.snack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SnackDAO {
	@Autowired
	private SnackRepo sr;

	public Snack reg(Snack s) {
		
		try {
			sr.save(s);
			return s;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		
		}
	}
	
	public Snacks get() {
		try {
			return new Snacks(sr.findAll());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		
		}
	}
	
	
	
}
