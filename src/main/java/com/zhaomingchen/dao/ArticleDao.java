package com.zhaomingchen.dao;

import java.util.List;

import com.zhaomingchen.entity.Article;

public interface ArticleDao {

	// 获取最新的章节文章
	List<Article> getArticel(int i);

	
	// 获取单个文章的信息
	Article getArticelById(Integer id);

	
	
	
	
}
