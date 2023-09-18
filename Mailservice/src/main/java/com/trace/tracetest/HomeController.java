package com.trace.tracetest;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
@Autowired
EmailService ems;

@RequestMapping(value="/", method = RequestMethod.GET)
public String home(HttpServletRequest req) {
	req.setAttribute("test", "asdfasdfasdf");
	return "index";
}
@RequestMapping(value = "join",method = RequestMethod.GET)
public String join() {
	return "join";
}
@PostMapping(value = "/api/mailcheck", consumes = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<String> mailCheck(@RequestBody HashMap<String, Object> user,HttpServletRequest request){
 
    String username = (String) user.get("username");
    String authNum = ems.sendVerificationCode(username);
 
    log.info("email : " + user.get("username"));
    log.info("checkNum : " + authNum);
 
    return ResponseEntity.status(HttpStatus.OK).body(authNum);
}




}
