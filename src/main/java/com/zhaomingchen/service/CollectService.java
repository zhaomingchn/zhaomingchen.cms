package com.zhaomingchen.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.zhaomingchen.entity.Collect;

public interface CollectService {

	Collect getCollectByid(Integer id, Integer id2);

	void addCollect(Integer id, Integer id2);

     PageInfo getList(Integer id,Integer pageNum);

	void deleteCollect(Integer id);

}
