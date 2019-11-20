package com.zhaomingchen.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhaomingchen.entity.Article;

public interface ArticleDao {

	// 获取最新的章节文章
	List<Article> getArticel(int i);

	
	// 获取单个文章的信息
	Article getArticelById(Integer id);

	
      // 获取热门的文章
	List<Article> gethorList();


	//获取文章下的热门文章
	List<Article> getChannelHot(@Param("id")int id,@Param("cid")int cid);

  
	/**
	 * 
	 * @Title: getArticlerUser 
	 * @Description: 获取用户自己的文章
	 * @return
	 * @return: List
	 */
	List<Article> getArticlerUser(Integer id);

	
	
	
	
}
