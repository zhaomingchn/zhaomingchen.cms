package com.zhaomingchen.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import com.zhaomingchen.entity.Article;

public interface ArticleDao {

	// 获取最新的章节文章
	List<Article> getArticel(int i);

	
	// 获取单个文章的信息
	Article getArticelById(Integer id);

	
      // 获取热门的文章
	List<Article> gethorList();


	//获取文章下的热门文章
	List<Article> getChannelHot(@Param("id")int id,@Param("cid")int cid);

  
	/**
	 * 
	 * @Title: getArticlerUser 
	 * @Description: 获取用户自己的文章
	 * @return
	 * @return: List
	 */
	List<Article> getArticlerUser(Integer id);


	/**
	 * 
	 * @Title: delete 
	 * @Description: 删除文章
	 * @param id
	 * @return
	 * @return: int
	 */
	int delete(Integer id);

	/**
	 * 
	 * @Title: add 
	 * @Description:添加
	 * @param article
	 * @return
	 * @return: int
	 */
	@Insert("INSERT INTO cms_article("
			+ " title,content,picture,channel_id,category_id,"
			+ " user_id,hits,hot,status,deleted,"
			+ " created,updated,commentCnt,articleType) "
			+ " values("
			+ " #{title},#{content},#{picture},#{channelId},#{categoryId},"
			+ "#{userId},#{hits},#{hot},#{status},#{deleted},"
			+ "now(),now(),#{commentCnt},"
			+ "#{articleType,typeHandler=org.apache.ibatis.type.EnumOrdinalTypeHandler,"
			+ "jdbcType=INTEGER,javaType=com.zhaomingchen.finalnum.TypeEnum})")
	 int add(Article article);


	/**
	 * 
	 * @Title: getPostList 
	 * @Description: 获取所有的文章
	 * @param status
	 * @return
	 * @return: List
	 */
	List getPostList(int status);


	/**
	 * 
	 * @Title: getDetailById 
	 * @Description: 获取单个文章  而且是未被删除的
	 * @param id
	 * @return
	 * @return: Article
	 */
	Article getDetailById(int id);

   
	/**
	 * 
	 * @Title: updateStutes 
	 * @Description: 修改文章的审核状态
	 * @param id
	 * @param status
	 * @return
	 * @return: int
	 */
	int updateStutes(@Param("id")int id,@Param("status") int status);


	/**
	 * 
	 * @Title: UpdateHot 
	 * @Description: 修改文章的热门状态
	 * @param id
	 * @param status
	 * @return
	 * @return: int
	 */
	int UpdateHot(@Param("id")int id,@Param("status") int status);

	/**

	 * 修改文章

	 * @param article

	 * @return

	 */

	@Update("UPDATE cms_article SET title=#{title},content=#{content},"

			+ "picture=#{picture},channel_id=#{channelId},"

			+ "category_id=#{categoryId},status=0,updated=now() WHERE id=#{id}")
	int updateArticle(Article article);

	/**
	 * 
	 * @Title: upMoneent 
	 * @Description: 修改文章的点击量
	 * @param id
	 * @return: void
	 */
    @Insert("update cms_article set commentCnt=commentCnt+1 where id=${value}")
	void upMoneent(int id);


    @Update("update cms_article set num=num+1 where id=${value}")
	void addNum(Integer id);


	List<Article> imgArticles();

	
	
}
