package com.zhaomingchen.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhaomingchen.dao.CategoryDao;
import com.zhaomingchen.entity.Category;
import com.zhaomingchen.service.CategoryService;
@Service
public class CategoryServiceimpl implements CategoryService {

	@Autowired
	private CategoryDao dao;
	@Override
	public List<Category> getCategory(int id) {
		// TODO Auto-generated method stub
		return dao.getCategoryDao(id);
	}
	
	

}
