package com.zhaomingchen.cms;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.zhaomingchen.entity.Category;
import com.zhaomingchen.service.CategoryService;

@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:spring-beans.xml")
public class CategoryTest {
	
	@Autowired
	private CategoryService service;
	@Test
	public void CategoryTest() {
		
		List<Category> category = service.getCategory(1);
		for (Category category2 : category) {
			System.out.println(category2);
		}
	}

}
