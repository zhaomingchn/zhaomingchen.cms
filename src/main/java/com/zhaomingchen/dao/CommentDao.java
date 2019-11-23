package com.zhaomingchen.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhaomingchen.entity.Comment;

public interface CommentDao {

	/**
	 * 
	 * @Title: getComment 
	 * @Description: 获取文章的评论
	 * @param id
	 * @return
	 * @return: List<Comment>
	 */
	List<Comment> getComment(Integer id);

	
	void UpHos(int id);


	void add(@Param("name")String name, @Param("ids")Integer id, @Param("id")int id2);


}
