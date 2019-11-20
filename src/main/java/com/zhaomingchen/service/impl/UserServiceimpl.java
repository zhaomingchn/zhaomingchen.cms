package com.zhaomingchen.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhaomingchen.dao.UserDao;
import com.zhaomingchen.entity.User;
import com.zhaomingchen.finalnum.FinalNum;
import com.zhaomingchen.service.UserService;

@Service
public class UserServiceimpl implements UserService {

	
	@Autowired
	private UserDao dao;

	/**
	 *  获取所有用户
	 */
	@Override
	public PageInfo getUser(String name, Integer pageNum) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum,FinalNum.PAGESIZE);
		List<User> list=dao.getUser(name);
		PageInfo info=new PageInfo(list);
		return info;
	}

	/**
	 * 获取单个用户
	 */
	@Override
	public User getByID(Integer id) {
		// TODO Auto-generated method stub
		return dao.getById(id);
	}
	/**
	 * 修改locked的值
	 */

	@Override
	public int updateLocked(Integer id, Integer lock) {
		// TODO Auto-generated method stub
		return dao.updateLocked(id,lock);
	}

	
	




	



	
	
	
	
	
	
}
