package com.zhaomingchen.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhaomingchen.dao.LoginorRegisterDao;
import com.zhaomingchen.entity.User;
import com.zhaomingchen.finalnum.CmsAssert;
import com.zhaomingchen.finalnum.Md5;
import com.zhaomingchen.service.LoginorRegisterService;
@Service
public class LoginorRegisterServiceimpl implements LoginorRegisterService {

	
	@Autowired
	private LoginorRegisterDao dao;
	
	
	

	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		
		   //通过名字查询有没有这个用户
		String username = user.getUsername();
		    User byName = getByName(username);
		    if(byName==null) {
		    	return null;
		    }
   
		    // 计算加密后的密码
	   String password = Md5.password(user.getPassword(),username.substring(0,2));
	   
	   // 判断数据库里的密码是否与输入的密码一致 则登录成功
	   if(password.equals(byName.getPassword())) {
		 return byName;
	   }else {
		 //登录失败
		 return null;
	 }
	
		
	}




	@Override
	public User getByName(String username) {
		// TODO Auto-generated method stub
		return dao.getByName(username);
	}




	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		 // 再一次判断用户是否存在
		  User byName = getByName(user.getUsername());
		  CmsAssert.AssertTrue(byName==null,"该用户已经存在");
		  
		  // 加盐
		  user.setPassword(Md5.password(user.getPassword(),user.getUsername().substring(0,2)));
		  
		  return dao.addUser(user);
	}
	
	
}
