package com.zhaomingchen.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.zhaomingchen.entity.User;
import com.zhaomingchen.finalnum.FinalNum;
import com.zhaomingchen.service.ArticleService;
import com.zhaomingchen.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {
	
	
	
	@Autowired
	private  UserService service;
	
	@Autowired
	private ArticleService Atservice;
	   /**
	    * 
	    * @Title: getArticlerUser 
	    * @Description: 
	    * @param request
	    * @param pageNum
	    * @return
	    * @return: String
	    */
	   @RequestMapping("getArticlerUser")
	   public String getArticlerUser(HttpServletRequest request,@RequestParam(defaultValue = "1")Integer pageNum) {
		   
			User loginUser = (User) request.getSession().getAttribute(FinalNum.USER_KEY);
			System.out.println(loginUser);
			 //获取这个用户的所有的文章
			  PageInfo info=Atservice.getArticlerUser(pageNum,loginUser.getId());
			  List<User> list = info.getList();
   
			  for (Object object : list) {
				System.out.println(object);
			}
			  
		   return "";
	   }

}
