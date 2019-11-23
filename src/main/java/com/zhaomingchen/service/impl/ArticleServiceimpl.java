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

	/**
	 * 获取用户的自己的文章
	 */
	@Override
	public PageInfo getArticlerUser(Integer pageNum,Integer id) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum,FinalNum.PAGESIZE);
		return  new PageInfo(dao.getArticlerUser(id)) ;
	}

	/**
	 * 删除
	 */
	@Override
	public int delete(Integer id) {
		// TODO Auto-generated method stub
		
		return dao.delete(id);
	}

	
	/**
	 * 添加文章
	 */
	@Override
	public int add(Article article) {
		// TODO Auto-generated method stub
		return dao.add(article);
	}

	/**
	 * 获取管理员的所有文章
	 */
	@Override
	public PageInfo getPageList(int status, Integer page) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page,8);
		return new PageInfo(dao.getPostList(status));
	}

	/**
	 * 获取单个文章  而且是未被删除的
	 * 
	 */
	@Override
	public Article getDetailById(int id) {
		// TODO Auto-generated method stub
		return dao.getDetailById(id);
	}
	
	/**
	 * 修改审核的状态
	 */

	@Override
	public int updateStutes(int id, int status) {
		// TODO Auto-generated method stub
		return dao.updateStutes(id,status);
	}

	/**
	 * 修改热门的状态
	 */
	@Override
	public int UpdateHot(int id, int status) {
		// TODO Auto-generated method stub
		return dao.UpdateHot(id,status);
	}

	/**
	 * 文章的修改
	 */
	@Override
	public int updateArticle(Article article) {
		// TODO Auto-generated method stub
		return dao.updateArticle(article);
	}

	/**
	 * 增加浏览器的点赞量
	 */
	@Override
	public void upMoneent(int id) {
		// TODO Auto-generated method stub
		dao.upMoneent(id);
		
	}
	
	/**
	 * 增加文章的点击量
	 */

	@Override
	public void addNum(Integer id) {
		// TODO Auto-generated method stub
		dao.addNum(id);
	}
	
	
	
	
}
