package com.zhaomingchen.dao;

import com.zhaomingchen.entity.User;

public interface LoginorRegisterDao {

	/**
	 * 
	 * @Title: getByName 
	 * @Description: 验证名字是否唯一
	 * @param username
	 * @return
	 * @return: User
	 */
	User getByName(String username);

	/**
	 * 
	 * @Title: addUser 
	 * @Description: 添加
	 * @param user
	 * @return
	 * @return: int
	 */
	int addUser(User user);

}
