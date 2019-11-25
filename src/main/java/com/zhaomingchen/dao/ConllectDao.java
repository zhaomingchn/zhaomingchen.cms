package com.zhaomingchen.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

import com.zhaomingchen.entity.Collect;

public interface ConllectDao {


	Collect getCollectByid(@Param("id")Integer id, @Param("id2")Integer id2);

	void addaddCollect(@Param("id")Integer id, @Param("id2")Integer id2);

	
	List<Collect> getList(@Param("id")Integer id);

	@Delete("delete from cms_collect where id=#{value}")
	void deleteCollect(Integer id);

}
