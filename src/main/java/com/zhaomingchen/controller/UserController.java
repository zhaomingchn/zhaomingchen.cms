package com.zhaomingchen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	
	
	@RequestMapping("index.do")
	public String login(Model m) {
		
		
		m.addAttribute("name","沾上干");
		
		return "/admin/index";
	}

	
	
}
