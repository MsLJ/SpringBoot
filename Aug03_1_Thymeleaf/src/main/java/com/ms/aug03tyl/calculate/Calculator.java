package com.ms.aug03tyl.calculate;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.ms.aug03tyl.snack.Snack;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class Calculator {

	public void calculate(HttpServletRequest request, CalcResult cr) {

		cr.setHab(cr.getX() + cr.getY());
		cr.setCha(cr.getX() - cr.getY());
		cr.setMoks(cr.getX() / cr.getY());
		cr.setGob(cr.getX() * cr.getY());
		request.setAttribute("crr", cr);
		request.setAttribute("a", "zzzzzzzzz");

		ArrayList<Snack> snacks = new ArrayList<>();
		snacks.add(new Snack("빼빼로", 5000));
		snacks.add(new Snack("오레오", 7000));
		request.setAttribute("s", snacks);

		HashMap<String, Snack> snacks2 = new HashMap<>();
		snacks2.put("ㄱ", new Snack("초코과자", 7000));
		snacks2.put("ㄴ", new Snack("거북칩", 9000));
		request.setAttribute("ss", snacks2);

		request.getSession().setAttribute("d", 12362);

		request.setAttribute("e", new Random().nextInt(6));

		request.setAttribute("f", 123412341);
		request.setAttribute("g", 12.3412341);
		request.setAttribute("h", new Date());
		request.setAttribute("i", "https:www.naver.com");
	}

}
