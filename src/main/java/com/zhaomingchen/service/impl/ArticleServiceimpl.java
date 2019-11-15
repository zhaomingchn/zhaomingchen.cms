package com.zhaomingchen.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhaomingchen.dao.ArticleDao;
import com.zhaomingchen.entity.Article;
import com.zhaomingchen.finalnum.MsgResult;
import com.zhaomingchen.service.ArticleService;

@Service
public class ArticleServiceimpl implements ArticleService {

	
	@Autowired
	private ArticleDao dao;

	/**
	 * 获取热门文章
	 */
	@Override
	public List<Article> getArticel() {
		// TODO Auto-generated method stub
			int i=3;
			
		return dao.getArticel(i);
	}
	
	/**
	 * 获取单个文章的信息
	 */

	@Override
	public Article getArticelByid(Integer id) {
		// TODO Auto-generated method stub
		
		return dao.getArticelById(id);
	}
	
	
	
	
}
