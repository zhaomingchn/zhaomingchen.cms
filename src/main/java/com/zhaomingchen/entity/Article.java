package com.zhaomingchen.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.zhaomingchen.finalnum.TypeEnum;

/**
 * 
 * @author zhuzg
 *
 */
public class Article implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6320126833474686896L;
	
	private Integer id               ;
	// 文章标题
	private String title            ;
	// 文章内容
	private String content          ;
	//标题图片的url 地址
	private String picture          ;
	// 频道
	private Integer channelId       ;
	private Channel channel       ;
	
	private Integer categoryId      ;
	// 文章的分类
	private Category category;
	
	private Integer userId          ;
	private User user          ;
	// 点击数量
	private int  hits             ;
	// 是否为热门文章 1 是  0 否
	private int hot              ;
	// 0 待审核  1 审核通过  2 审核未通过
	private int status           ;
	//是否被删除 1删除 0未删除
	private int deleted          ;
	
	//发表时间
	private Date created          ;
	
	//最后修改时间
	private Date updated          ;
	
	// 评论的数量
	private int commentCnt       ;

	
	private Integer num;
	
	// 获取该文章的所有图片
	private List<Image> imges;
	
	//文章类型
	private TypeEnum articleType = TypeEnum.HTML;

	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", content=" + content + ", picture=" + picture
				+ ", channelId=" + channelId + ", channel=" + channel + ", categoryId=" + categoryId + ", category="
				+ category + ", userId=" + userId + ", user=" + user + ", hits=" + hits + ", hot=" + hot + ", status="
				+ status + ", deleted=" + deleted + ", created=" + created + ", updated=" + updated + ", commentCnt="
				+ commentCnt + ", num=" + num + ", imges=" + imges + ", articleType=" + articleType + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Integer getChannelId() {
		return channelId;
	}

	public void setChannelId(Integer channelId) {
		this.channelId = channelId;
	}

	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}

	public int getHot() {
		return hot;
	}

	public void setHot(int hot) {
		this.hot = hot;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getDeleted() {
		return deleted;
	}

	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public int getCommentCnt() {
		return commentCnt;
	}

	public void setCommentCnt(int commentCnt) {
		this.commentCnt = commentCnt;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public List<Image> getImges() {
		return imges;
	}

	public void setImges(List<Image> imges) {
		this.imges = imges;
	}

	public TypeEnum getArticleType() {
		return articleType;
	}

	public void setArticleType(TypeEnum articleType) {
		this.articleType = articleType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Article() {
		super();
	}

	public Article(Integer id, String title, String content, String picture, Integer channelId, Channel channel,
			Integer categoryId, Category category, Integer userId, User user, int hits, int hot, int status,
			int deleted, Date created, Date updated, int commentCnt, Integer num, List<Image> imges,
			TypeEnum articleType) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.picture = picture;
		this.channelId = channelId;
		this.channel = channel;
		this.categoryId = categoryId;
		this.category = category;
		this.userId = userId;
		this.user = user;
		this.hits = hits;
		this.hot = hot;
		this.status = status;
		this.deleted = deleted;
		this.created = created;
		this.updated = updated;
		this.commentCnt = commentCnt;
		this.num = num;
		this.imges = imges;
		this.articleType = articleType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((articleType == null) ? 0 : articleType.hashCode());
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((categoryId == null) ? 0 : categoryId.hashCode());
		result = prime * result + ((channel == null) ? 0 : channel.hashCode());
		result = prime * result + ((channelId == null) ? 0 : channelId.hashCode());
		result = prime * result + commentCnt;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((created == null) ? 0 : created.hashCode());
		result = prime * result + deleted;
		result = prime * result + hits;
		result = prime * result + hot;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((imges == null) ? 0 : imges.hashCode());
		result = prime * result + ((num == null) ? 0 : num.hashCode());
		result = prime * result + ((picture == null) ? 0 : picture.hashCode());
		result = prime * result + status;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((updated == null) ? 0 : updated.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		Article other = (Article) obj;
		if (articleType != other.articleType)
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (categoryId == null) {
			if (other.categoryId != null)
				return false;
		} else if (!categoryId.equals(other.categoryId))
			return false;
		if (channel == null) {
			if (other.channel != null)
				return false;
		} else if (!channel.equals(other.channel))
			return false;
		if (channelId == null) {
			if (other.channelId != null)
				return false;
		} else if (!channelId.equals(other.channelId))
			return false;
		if (commentCnt != other.commentCnt)
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
		if (deleted != other.deleted)
			return false;
		if (hits != other.hits)
			return false;
		if (hot != other.hot)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (imges == null) {
			if (other.imges != null)
				return false;
		} else if (!imges.equals(other.imges))
			return false;
		if (num == null) {
			if (other.num != null)
				return false;
		} else if (!num.equals(other.num))
			return false;
		if (picture == null) {
			if (other.picture != null)
				return false;
		} else if (!picture.equals(other.picture))
			return false;
		if (status != other.status)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (updated == null) {
			if (other.updated != null)
				return false;
		} else if (!updated.equals(other.updated))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	
	
	
	                                

	

}
