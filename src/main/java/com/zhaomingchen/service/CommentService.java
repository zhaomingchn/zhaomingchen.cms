package com.zhaomingchen.service;


import com.github.pagehelper.PageInfo;

public interface CommentService {

	PageInfo getComment(Integer id,Integer pageNum);

	void upHos(int id);

	void add(String name, Integer id, int id2);


}
