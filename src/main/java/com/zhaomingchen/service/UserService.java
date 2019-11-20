package com.zhaomingchen.service;


import com.github.pagehelper.PageInfo;
import com.zhaomingchen.entity.User;

public interface UserService {

	PageInfo getUser(String name, Integer pageNum);

	User getByID(Integer id);

	int updateLocked(Integer id, Integer lock);



}
