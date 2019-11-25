package com.zhaomingchen.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhaomingchen.dao.ConllectDao;
import com.zhaomingchen.entity.Collect;
import com.zhaomingchen.service.CollectService;

@Service
public class CollectServiceimpl implements CollectService {

	@Autowired
	private ConllectDao dao;

	/**
	 * 查看是否已经存在这篇文章
	 */
	@Override
	public Collect getCollectByid(Integer id, Integer id2) {
		// TODO Auto-generated method stub
		return dao.getCollectByid(id,id2);
	}

	/**
	 * 添加收藏
	 */
	@Override
	public void addCollect(Integer id, Integer id2) {
		// TODO Auto-generated method stub
		dao.addaddCollect(id,id2);
		
	}
	
	/**
	 * 获取用户收藏的文章
	 */
	

	@Override
	public  PageInfo getList(Integer id,Integer pageNum) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum,5);
		return new PageInfo(dao.getList(id));
	}

	/**
	 * 删除相对应的文章
	 */
	@Override
	public void deleteCollect(Integer id) {
		// TODO Auto-generated method stub
		
		dao.deleteCollect(id);
	}
	
	
}
