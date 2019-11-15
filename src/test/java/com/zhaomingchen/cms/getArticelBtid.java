package com.zhaomingchen.cms;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.zhaomingchen.entity.Article;
import com.zhaomingchen.service.ArticleService;

@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:spring-beans.xml")
public class getArticelBtid {
	
	
	@Autowired
	private ArticleService art;
	@Test
	public void getArticelByid() {
		
		Article articelByid = art.getArticelByid(10);
		System.out.println(articelByid);
	}

}
