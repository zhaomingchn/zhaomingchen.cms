package com.zhaomingchen.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhaomingchen.dao.CommentDao;
import com.zhaomingchen.entity.Comment;
import com.zhaomingchen.service.CommentService;

@Service
public class CommentServiceimpl implements CommentService {

	@Autowired
	private CommentDao dao;

	/**
	 * 获取文章的评论
	 */
	@Override
	public PageInfo getComment(Integer id,Integer PageNum) {
		// TODO Auto-generated method stub
		PageHelper.startPage(PageNum,5);
		return new PageInfo(dao.getComment(id));
	}

	@Override
	public void upHos(int id) {
		// TODO Auto-generated method stub
		dao.UpHos(id);		
	}

	/**
	 * 增加评论
	 */
	@Override
	public void add(String name, Integer id, int id2) {
		// TODO Auto-generated method stub
		dao.add(name,id,id2);
	}

}
