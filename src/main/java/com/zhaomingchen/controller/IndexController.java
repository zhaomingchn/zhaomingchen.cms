package com.zhaomingchen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.zhaomingchen.entity.Article;
import com.zhaomingchen.entity.Category;
import com.zhaomingchen.entity.Channel;
import com.zhaomingchen.service.ArticleService;
import com.zhaomingchen.service.CategoryService;
import com.zhaomingchen.service.ChannelService;



@Controller
public class IndexController {

	// 所有的频道
	@Autowired
	private ChannelService service;
	
	// 所有的文章
	@Autowired
	private ArticleService art;
	
	// 频道下对应的节目
	@Autowired
	private CategoryService cat;
	/**
	 * 
	 * @Title: getChannel 
	 * @Description: 用于导航列表的显示
	 * @param m
	 * @return
	 * @return: String
	 */
	@RequestMapping( value= {"index","/"})
	public String getChannel(Model m,@RequestParam(defaultValue = "1") int pageNum
			
			,@RequestParam(defaultValue = "1") int id) {
   
		// 获取频道的集合
		  List<Channel> channel=service.getChannel();
		   m.addAttribute("channel",channel);
		 // 获取 最新的文章
		   List<Article> article = art.getArticel();
		   m.addAttribute("article",article);
		  //获取热门的文章 
		  PageInfo horList=art.gethorList(pageNum);
		   m.addAttribute("hotList",horList);
		   
		   
		   
		   
		return "index";
	}
	
	/**
	 * 
	 * @Title: ByIdArticel 
	 * @Description:单个文章的信息
	 * @param id
	 * @param m
	 * @return
	 * @return: String
	 */
	@RequestMapping("ByIdArticel.do")
	public String ByIdArticel(Integer id,Model m){
		
		// 获取这个文章的所有信息
		Article articel=art.getArticelByid(id);
		m.addAttribute("article",articel);
		
		return "/articel/list";
		
	}
	/**
	 * 
	 * @Title: upById 
	 * @Description: 上一篇
	 * @param id
	 * @param m
	 * @return
	 * @return: String
	 */
	@RequestMapping("upById")
	 public String upById(Integer id,Model m){
 
		System.out.println("----------------"+id);
		// 先判断id 的上一个值 有没有
		Article article;
		int i=1;
		 for (;;) {
			id--;
			article=art.getArticelByid(id);
			if(article!=null) {
				m.addAttribute("article",article);
				return  "/articel/list";
			}else {
				article=art.getArticelByid(id++);
				m.addAttribute("msg","对不起这已经是最新的一篇了");
				m.addAttribute("num",i);
				m.addAttribute("article",article);
				return "/articel/list";
			}
		}
	}
	
	/**
	 * 
	 * @Title: getChannel 
	 * @Description: 去一个新的页面 来显示频道的信息
	 * @param m
	 * @param pageNum
	 * @param id
	 * @return
	 * @return: String
	 */
	
	@RequestMapping("channel")
	public String getCate(Model m,@RequestParam(defaultValue = "1") int pageNum
			, int id,
			@RequestParam(defaultValue = "0")
			int cid){
		// 获取频道的集合
		  List<Channel> channel=service.getChannel();
		   m.addAttribute("channel",channel);
		 // 获取 最新的文章
		   List<Article> article = art.getArticel();
		   m.addAttribute("article",article);
		  //获取热门的文章 
		  PageInfo horList=art.getChannelHot(pageNum,id,cid);
		   m.addAttribute("hotList",horList);
		   List ss = horList.getList();
		   // 获取频道下的节目所有节目
		    List<Category> list=cat.getCategory(id);
		    m.addAttribute("list",list);
		    // 回调函数 做高亮
		    m.addAttribute("id",id);
		return "/channel/channel";
	}
	
	
	
}
