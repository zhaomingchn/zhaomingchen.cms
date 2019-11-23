package com.zhaomingchen.controller;



import java.lang.ProcessBuilder.Redirect;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhaomingchen.entity.User;
import com.zhaomingchen.finalnum.CmsAssert;
import com.zhaomingchen.finalnum.FinalNum;
import com.zhaomingchen.service.ArticleService;
import com.zhaomingchen.service.LoginorRegisterService;

@Controller
public class LoginorRegisterController {
	

	@Autowired 
	private  LoginorRegisterService service;
	
	// 获取文章
	@Autowired
	private ArticleService articl;
	
	
	@RequestMapping("index.do")
	public String login(Model m) {
		return "/admin/user/index";
	}
	
	
	
	// 跳转到登录界面
	@RequestMapping("login.do")
	public String userLogin(HttpServletRequest request){
		  
	
		return "/loginorregister/login";
	}
	

	// 跳转到注册页面
	@RequestMapping("Register")
	public String Register() {
		return "/loginorregister/Register";
	}
	
	// 跳转到用户管理文章界面
	@RequestMapping("home")
	public String reHome(HttpServletRequest request) {
	
		return "/loginorregister/home";
	}
	
	/**
	 * 
	 * @Title: userLogin 
	 * @Description: 登录
	 * @param user
	 * @param request
	 * @return
	 * @return: String
	 */
	@RequestMapping(value= "login",method = RequestMethod.POST)
	public String userLogin(User user,HttpServletRequest request,Model m) {
	User loginUser=service.login(user);
	if(loginUser!=null) {
		request.getSession().setAttribute(FinalNum.USER_KEY,loginUser);
		return loginUser.getRole()==FinalNum.ROLE?"redirect:index.do":"redirect:home";
	}else {
		request.getSession().setAttribute("error",1);
		request.getSession().setAttribute("user",user);
		return "redirect:/login.do";
	}
	}
	
	
	@RequestMapping(value= "logins.do",method = RequestMethod.POST)
	public String userLogins(User user,HttpServletRequest request,Model m,int ids) {
	
	User loginUser=service.login(user);
	if(loginUser!=null) {
		request.getSession().setAttribute(FinalNum.USER_KEY,loginUser);
		      return  "redirect:ByIdArticel.do?id="+ids;
	}else {
		m.addAttribute("error", "账号或者密码错误");
		request.getSession().setAttribute("user",user);
		return  "/common/index1";
	}
	}
	
	
	/**
	 * 
	 * @Title: getByName 
	 * @Description: 验证名字是否唯一 用于添加用户的判断
	 * @param username
	 * @return
	 * @return: boolean
	 */
   @ResponseBody
	@RequestMapping("checkExists")
	public boolean getByName(String username) {
		User user=service.getByName(username);
		return user==null;
	}
   
   
  /***
   * 
   * @Title: addUser 
   * @Description: 添加用户
   * @param user
   * @return
   * @return: String
   */
   @RequestMapping("addUser")
   public String addUser(User user) {
	   int result=service.addUser(user);
	  CmsAssert.AssertTrue(result>0,"用户注册失败,请稍后再试"); 
	   return "redirect:/login.do";
   }



   /**
    * 
    * @Title: exit 
    * @Description: 退出用户
    * @param request
    * @return
    * @return: String
    */

			@RequestMapping("exit.do")
			public String exit(HttpServletRequest request) {
				
				request.getSession().invalidate();
				
				return "redirect:login.do";
			}
	
	
	
	
	
	
	
}
