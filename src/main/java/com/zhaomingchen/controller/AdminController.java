package com.zhaomingchen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.zhaomingchen.entity.User;
import com.zhaomingchen.finalnum.MsgResult;
import com.zhaomingchen.service.UserService;

@Controller
@RequestMapping("admin")
public class AdminController {

	
	@Autowired
	private UserService service;
	
	/**
	 * 
	 * @Title: getUser 
	 * @Description: 获取用户
	 * @param name
	 * @param pageNum
	 * @return
	 * @return: String
	 */
	@RequestMapping("users")
	public String getUser(String name,@RequestParam(defaultValue = "1")Integer pageNum,Model m) {
		
		PageInfo info=service.getUser(name,pageNum);
		m.addAttribute("page",info);
		m.addAttribute("name",name);
		return "/admin/user/list";
	}
	/**
	 * 
	 * @Title: updateLock 
	 * @Description: 修改状态
	 * @param id
	 * @param lock
	 * @return
	 * @return: Object
	 */
	@ResponseBody
	@RequestMapping("updateLock.do")
	public Object updateLock(Integer id,Integer lock) {
		
		// 判断系统是否有bug lock 只有0 和1
		if(lock!=0 && lock!=1) {
			
			return new MsgResult(2,"抱歉此操作无效",null);
		}
		
		// 判断有没有这个用户
		 User use=service.getByID(id);
		 if(use==null) {
			 return new MsgResult(2,"抱歉没有此用户",null);

		 }
		 
		 //判断前台得数据 和数据库的值是否一样
		 
		 if(use.getLocked()==lock) {
			 return  new MsgResult(2,"抱歉您不能执行此操作",null);
		 }
		 
		 //改locked的值
		 int result=service.updateLocked(id,lock);
 
		 if(result==1) {
			 
			 return  new MsgResult(1,"恭喜你操作成功",null); 
		 }else {
			 return  new MsgResult(2,"抱歉操作失败,请重新操作",null); 
		 }
	}
		
		
	
	
}
