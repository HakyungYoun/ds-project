package com.ds.hakyung.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@GetMapping("user/reg")
	String userReg() {
		
		return "/userWrite";
	}
}
