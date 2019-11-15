package com.zhaomingchen.service;

import java.util.List;

import com.zhaomingchen.entity.Article;

public interface ArticleService {

	List<Article> getArticel();

	Article getArticelByid(Integer id);

}
