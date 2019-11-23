package com.zhaomingchen.entity;

import java.io.Serializable;

/**
 * 
 * @ClassName: Special 
 * @Description: 评论类
 * @author:李英华
 * @date: 2019年11月21日 下午6:40:22
 */
public class Comment implements Serializable {

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 3956354704875857745L;
	
	private Integer id;
	
	private Integer articleld;
	
    private Integer userid;
    
    private String  content;
    
    private String created;

    private  Integer hos;
    
    private User user;
    
    private Article article;

	@Override
	public String toString() {
		return "Comment [id=" + id + ", articleld=" + articleld + ", userid=" + userid + ", content=" + content
				+ ", created=" + created + ", hos=" + hos + ", user=" + user + ", article=" + article + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getArticleld() {
		return articleld;
	}

	public void setArticleld(Integer articleld) {
		this.articleld = articleld;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public Integer getHos() {
		return hos;
	}

	public void setHos(Integer hos) {
		this.hos = hos;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Comment(Integer id, Integer articleld, Integer userid, String content, String created, Integer hos,
			User user, Article article) {
		super();
		this.id = id;
		this.articleld = articleld;
		this.userid = userid;
		this.content = content;
		this.created = created;
		this.hos = hos;
		this.user = user;
		this.article = article;
	}

	public Comment() {
		super();
	}

	
    
    
    
    
    
    
    
    
    
	

	
	
	
	

}
