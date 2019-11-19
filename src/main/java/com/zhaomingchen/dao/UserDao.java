package com.zhaomingchen.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhaomingchen.entity.User;

public interface UserDao {

	/**
	 * 
	 * @Title: getUser 
	 * @Description: 获取所有用户
	 * @param name
	 * @return
	 * @return: List<User>
	 */
	List<User> getUser(String name);

	// 获取单个id的值
	User getById(Integer id);

	int updateLocked(@Param("id")Integer id,@Param("lock")Integer lock);

	// 用户名的查询 看看是否重复
	User byName(@Param("name")String name);
	

	
}
