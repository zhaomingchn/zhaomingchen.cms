package com.zhaomingchen.service;

import java.util.List;

import com.zhaomingchen.entity.Category;

public interface CategoryService {

	/**
	 * 
	 * @Title: getCategory 
	 * @Description: 获取频道下 分类
	 * @param id
	 * @return
	 * @return: List<Category>
	 */
	List<Category> getCategory(int id);

}
