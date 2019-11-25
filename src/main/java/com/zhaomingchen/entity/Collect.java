package com.zhaomingchen.entity;

import java.sql.Date;

public class Collect {
	
	
	
	private Integer id;
	
	private User user;
	
	private Integer userId;
	
	private Article article;
	
	private  Integer articleId;
	
	private Date created;

	@Override
	public String toString() {
		return "Collect [id=" + id + ", user=" + user + ", userId=" + userId + ", article=" + article + ", articleId="
				+ articleId + ", created=" + created + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Integer getArticleId() {
		return articleId;
	}

	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Collect(Integer id, User user, Integer userId, Article article, Integer articleId, Date created) {
		super();
		this.id = id;
		this.user = user;
		this.userId = userId;
		this.article = article;
		this.articleId = articleId;
		this.created = created;
	}

	public Collect() {
		super();
	}

	
	
	
	
	
	

}
