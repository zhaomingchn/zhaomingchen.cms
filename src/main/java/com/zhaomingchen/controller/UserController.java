package com.zhaomingchen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhaomingchen.service.UserService;

@Controller
public class UserController {
	
	
	private UserService service;
	
	
	@RequestMapping("index.do")
	public String login(Model m) {
		return "/admin/index";
	}
	
	

	
	
}
