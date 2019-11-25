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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((article == null) ? 0 : article.hashCode());
		result = prime * result + ((articleld == null) ? 0 : articleld.hashCode());
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((created == null) ? 0 : created.hashCode());
		result = prime * result + ((hos == null) ? 0 : hos.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result + ((userid == null) ? 0 : userid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comment other = (Comment) obj;
		if (article == null) {
			if (other.article != null)
				return false;
		} else if (!article.equals(other.article))
			return false;
		if (articleld == null) {
			if (other.articleld != null)
				return false;
		} else if (!articleld.equals(other.articleld))
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (created == null) {
			if (other.created != null)
				return false;
		} else if (!created.equals(other.created))
			return false;
		if (hos == null) {
			if (other.hos != null)
				return false;
		} else if (!hos.equals(other.hos))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (userid == null) {
			if (other.userid != null)
				return false;
		} else if (!userid.equals(other.userid))
			return false;
		return true;
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
