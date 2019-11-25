package com.zhaomingchen.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.zhaomingchen.entity.Article;
import com.zhaomingchen.entity.User;
import com.zhaomingchen.finalnum.CmsAssert;
import com.zhaomingchen.finalnum.MsgResult;
import com.zhaomingchen.service.ArticleService;
import com.zhaomingchen.service.UserService;

@Controller
@RequestMapping("admin")
public class AdminController {

	
	@Autowired
	private UserService service;
	
	
	@Autowired
	private ArticleService aservice;
	
	/**
	 * 
	 * @Title: getUser 
	 * @Description: 获取用户
	 * @param name
	 * @param pageNum
	 * @return
	 * @return: String
	 */
	@RequestMapping("users")
	public String getUser(String name,@RequestParam(defaultValue = "1")Integer pageNum,Model m) {
		
		PageInfo info=service.getUser(name,pageNum);
		m.addAttribute("page",info);
		m.addAttribute("name",name);
		return "/admin/user/list";
	}
	
	/**
	 * 
	 * @Title: updateLock 
	 * @Description: 修改状态
	 * @param id
	 * @param lock
	 * @return
	 * @return: Object
	 */
	@ResponseBody
	@RequestMapping("updateLock.do")
	public Object updateLock(Integer id,Integer lock) {
		
		// 判断系统是否有bug lock 只有0 和1
		if(lock!=0 && lock!=1) {
			
			return new MsgResult(2,"抱歉此操作无效",null);
		}
		
		// 判断有没有这个用户
		 User use=service.getByID(id);
		 if(use==null) {
			 return new MsgResult(2,"抱歉没有此用户",null);

		 }
		 
		 //判断前台得数据 和数据库的值是否一样
		 
		 if(use.getLocked()==lock) {
			 return  new MsgResult(2,"抱歉您不能执行此操作",null);
		 }
		 
		 //改locked的值
		 int result=service.updateLocked(id,lock);
 
		 if(result==1) {
			 
			 return  new MsgResult(1,"恭喜你操作成功",null); 
		 }else {
			 return  new MsgResult(2,"抱歉操作失败,请重新操作",null); 
		 }
	}
		
	/**
	 * 
	 * @Title: getUserArticles 
	 * @Description: 用于用户文章的管理
	 * status  -1 全部  0 待审核  1 审核通过  2 审核未通过
	 * @return
	 * @return: String
	 */
	@RequestMapping("articles")
	public String getUserArticles(Model m,@RequestParam(defaultValue ="-1") int status,
			@RequestParam(defaultValue ="-1")Integer page
			) {
		
		 PageInfo info =aservice.getPageList(status,page);

		 m.addAttribute("pageInfo",info);
		 
		return "/admin/article/list";
	}
		
	/**
	 * 
	 * @Title: getArticle 
	 * @Description: 获取单个文章  而且是未被删除的
	 * @param id
	 * @return
	 * @return: Object
	 */
	@RequestMapping("getArticle")
	@ResponseBody
	public MsgResult  getArticle(int id) {
		
		Article article=aservice.getDetailById(id);
		CmsAssert.AssertTrue(article!=null,"对不起你的文章已经被删除");
		return new MsgResult(1,"对不起没有获取",article) ;
	}
	
	/**
	 * 
	 * @Title: Updatestatus 
	 * @Description: 修改审核通过不通过
	 * @param m
	 * @param id
	 * @param status
	 * @return
	 * @return: MsgResult
	 */
	@RequestMapping("applyArticle")
	@ResponseBody  
	public MsgResult Updatestatus(int id,int status) {
		
		
		int num=aservice.updateStutes(id,status);
		
		return new MsgResult(num,"对不起审核没有成功",null);
		
	}
	/**
	 * 
	 * @Title: UpdateHot 
	 * @Description: 修改热门状态
	 * @param id
	 * @param status
	 * @return
	 * @return: MsgResult
	 */
	@RequestMapping("upadteHot")
	@ResponseBody
	public MsgResult UpdateHot(int id,int status) {
		
		 int num=aservice.UpdateHot(id,status);
		 
		return new MsgResult(1,"对不起修改没有成功",null);
	}
	
	
	
}
