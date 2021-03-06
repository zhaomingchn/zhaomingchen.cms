package com.zhaomingchen.controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.zhaomingchen.entity.Article;
import com.zhaomingchen.entity.Category;
import com.zhaomingchen.entity.Channel;
import com.zhaomingchen.entity.Collect;
import com.zhaomingchen.entity.Comment;
import com.zhaomingchen.entity.Image;
import com.zhaomingchen.entity.User;
import com.zhaomingchen.finalnum.CmsAssert;
import com.zhaomingchen.finalnum.FinalNum;
import com.zhaomingchen.finalnum.TypeEnum;
import com.zhaomingchen.service.ArticleService;
import com.zhaomingchen.service.CategoryService;
import com.zhaomingchen.service.ChannelService;
import com.zhaomingchen.service.CollectService;
import com.zhaomingchen.service.CommentService;



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
	
	// 评论
	@Autowired
	private CommentService comservice;
	
	// 收藏文章
	@Autowired
	private CollectService colservice;
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
		   
		   // 获取图片最新文章信息
		  List<Article> imgArticles=art.imgArticles();
		   m.addAttribute("imgArticles",imgArticles);
		   
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
	public String ByIdArticel(Integer id,Model m,HttpServletRequest request,@RequestParam(defaultValue = "1")Integer PageNum,@RequestParam(defaultValue = "1")Integer flag){
	
		// 获取这个文章的所有信息
		Article articel=art.getArticelByid(id);
		m.addAttribute("article",articel);
		 request.getSession().setAttribute("ids",id);
		 
		// 获取这个文章的评论
		PageInfo lis=comservice.getComment(id,PageNum);
		    List list = lis.getList();
		  m.addAttribute("list",list);
		  m.addAttribute("page",lis);
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
	/*
	 * @RequestMapping("upById") public String upById(Integer id,int num,Model m){
	 * // 先判断id 的上一个值 有没有
	 * 
	 * if(num==FinalNum.NUM) {
	 * 
	 * }
	 * }
	 */
	 /**
		 * 
		 * @Title: upById 
		 * @Description: 下一篇
		 * @param id
		 * @param m
		 * @return
		 * @return: String
		 */
		@RequestMapping("ceById")
		 public String ceById(Integer id,Model m){
	 
			// 先判断id 的上一个值 有没有
			Article article;
			 for (;;) {
				id++;
				article=art.getArticelByid(id);
				if(article!=null) {
					m.addAttribute("article",article);
					return  "/articel/list";
				}else {
					 return  ceById(article.getId(),m);
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
		   // 获取图片最新文章信息
			  List<Article> imgArticles=art.imgArticles();
			   m.addAttribute("imgArticles",imgArticles);
		    List<Category> list=cat.getCategory(id);
		    m.addAttribute("list",list);
		    // 回调函数 做高亮
		    m.addAttribute("id",id);
		return "/channel/channel";
	}
	
	
	/**
	 * 
	 * @Title: upHos 
	 * @Description: 增加评论的点击量
	 * @param id
	 * @return
	 * @return: boolean
	 */
	@ResponseBody
	@RequestMapping("upHos.do")
	public boolean upHos(int id) {
		
		comservice.upHos(id);
		
		return true;
	}
	/**
	 * 
	 * @Title: upHos 
	 * @Description: 增加浏览器的点击量
	 * @param id
	 * @return
	 * @return: boolean
	 */
	@ResponseBody
	@RequestMapping("upmoneent.do")
	public boolean upmoneent(int id) {
		art.upMoneent(id);
		return true;
	}
	/**
	 * 
	 * @Title: addMonmmtent 
	 * @Description: 添加评论
	 * @param name
	 * @return
	 * @return: boolean
	 */
	@RequestMapping("addMonmment")
	@ResponseBody
	public boolean addMonmmtent(String name,HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute(FinalNum.USER_KEY);
		int  id= (int) request.getSession().getAttribute("ids");
		
	
		comservice.add(name,user.getId(),id);
		
		 
		
		
		return true;
	}
	
	
	@RequestMapping("collect.do")
	@ResponseBody
	public boolean Collects(Integer id,HttpServletRequest request) {
		
		// 获取session作用域里面的对象
		User user = (User) request.getSession().getAttribute(FinalNum.USER_KEY);
		
		// 然后添加这篇文章
		//先查询这篇文章是否已经存在
		  Collect co=colservice.getCollectByid(id,user.getId());
		  if(co==null){
			  // 收藏
			  colservice.addCollect(id,user.getId());  
			  return true;
		  }else {
			  
			  return false;
		  }
	}
	
	
	
	/**
	 * 
	 * @Title: upindex1 
	 * @Description: 加载index路径
	 * @return
	 * @return: String
	 */
	
	@RequestMapping("upindex1.do")
	public  String upindex1() {
		return "/common/index1";
	}
	
	
	
	@RequestMapping("showdetail")
	public String showdetail(HttpServletRequest request,Integer id) {
		
		Article article = art.getArticelByid(id); 
		CmsAssert.AssertTrue(article!=null, "文章不存在");
		
		
		request.setAttribute("article",article);
		if(article.getArticleType()==TypeEnum.HTML)
			return  "redirect:ByIdArticel.do?id="+id;
		else {
			Gson gson = new Gson();
			// 文章内容转换成集合对象
			List<Image> imgs = gson.fromJson(article.getContent(), List.class);
			article.setImges(imgs);
			
			return "/articel/detailimg";
		}
		
	}
	
}
