package com.zhaomingchen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhaomingchen.entity.Article;
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
	@RequestMapping("index")
	public String getChannel(Model m) {
   
		// 获取频道的集合
		  List<Channel> channel=service.getChannel();
		   m.addAttribute("channel",channel);
		 // 获取 最新的文章
		   List<Article> article = art.getArticel();
		   m.addAttribute("article",article);
		  //获取热门的文章 
		   
		   
		return "index";
	}
	
	
	@RequestMapping("ByIdArticel.do")
	public String ByIdArticel(Integer id,Model m){
		
		// 获取这个文章的所有信息
		Article articel=art.getArticelByid(id);
		m.addAttribute("article",articel);
		
		return "/articel/list";
		
	}
	@RequestMapping("upById")
	 public String upById(Integer id,Model m){

		
		 System.out.println(id);
		m.addAttribute("id",id);
		
		return  "/articel/list";
		
	}
	
	
	
	
	
	
	
}
