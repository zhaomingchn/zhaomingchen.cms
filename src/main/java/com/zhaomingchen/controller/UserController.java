package com.zhaomingchen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhaomingchen.entity.User;
import com.zhaomingchen.service.UserService;

@Controller
public class UserController {
	
	
	private UserService service;
	
	
	@RequestMapping("index.do")
	public String login(Model m) {
		return "/admin/index";
	}
	
	
	
	// 跳转到登录界面
	@RequestMapping("login.do")
	public String userLogin(){
	
		return "/admin/user/login";
	}
	
	// 跳转到注册页面
	@RequestMapping("Register")
	public String Register() {
		return "/admin/user/Register";
	}
	
	
	// 判断用户是否存在
	@ResponseBody
	@RequestMapping("addUser")
	public int addUser(String name) {
		
		if(name!=null&&!name.equals("")) {
			User userUser=service.byName(name);
			if(userUser!=null){
				return 1;
			}else {
				return 2;
			}	
		}else {
			return 3;
		}
		
		
	} 
	
	
	

	
	
}
