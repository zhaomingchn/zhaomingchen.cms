package com.zhaomingchen.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhaomingchen.dao.ArticleDao;
import com.zhaomingchen.entity.Article;
import com.zhaomingchen.finalnum.FinalNum;
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
			int i=5;
			
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

	@Override
	public PageInfo gethorList(int pageNum) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum,FinalNum.PAGESIZE);
		return  new PageInfo(dao.gethorList());
	}

	/**
	 * 获取节目下的热门文章
	 */
	@Override
	public PageInfo getChannelHot(int pageNum,int id,int cid) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum,FinalNum.PAGESIZE);
		return  new PageInfo(dao.getChannelHot(id,cid));
	}
	
	
	
	
}
