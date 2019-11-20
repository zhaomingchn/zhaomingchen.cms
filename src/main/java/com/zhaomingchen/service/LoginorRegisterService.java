package com.zhaomingchen.service;

import com.zhaomingchen.entity.User;

public interface LoginorRegisterService {

	User login(User user);

	User getByName(String username);

	int addUser(User user);

}
