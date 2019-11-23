package com.zhaomingchen.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.zhaomingchen.entity.Article;

public interface ArticleService {

	// 获取最新文章
	List<Article> getArticel();

	// 获取单个文章
	Article getArticelByid(Integer id);

	// 获取热门文章下的文章
	 PageInfo gethorList(int pageNum);

	 // 查询节目下的热门节目
	PageInfo getChannelHot(int pageNum,int id,int cid);

	
	/**
	 * 
	 * @Title: getArticlerUser 
	 * @Description:获取用户自己的文章
	 * @param pageNum
	 * @param id
	 * @return
	 * @return: PageInfo
	 */
	PageInfo getArticlerUser(Integer pageNum, Integer id);
	/**
	 * 
	 * @Title: delete 
	 * @Description: 删除文章
	 * @param id
	 * @return
	 * @return: int
	 */
	int delete(Integer id);

	
	/**
	 * 
	 * @Title: add 
	 * @Description: 添加
	 * @param article
	 * @return
	 * @return: int
	 */
	int add(Article article);

	PageInfo getPageList(int status, Integer page);

	/**
	 * 
	 * @Title: getDetailById 
	 * @Description:  获取单个文章而且是已经是审核过了
	 * @param id
	 * @return
	 * @return: Article
	 */
	Article getDetailById(int id);

	/**
	 * 
	 * @Title: updateStutes 
	 * @Description: 修改审核的状态
	 * @param id
	 * @param status
	 * @return
	 * @return: int
	 */
	int updateStutes(int id, int status);

	/**
	 * 
	 * @Title: UpdateHot 
	 * @Description: 修改热门的状态
	 * @param id
	 * @param status
	 * @return
	 * @return: int
	 */
	int UpdateHot(int id, int status);

	int updateArticle(Article article);

	void upMoneent(int id);

	/**
	 * 
	 * @Title: addNum 
	 * @Description: 增加文章的点击量
	 * @param id
	 * @return: void
	 */
	void addNum(Integer id);
	
	

}
