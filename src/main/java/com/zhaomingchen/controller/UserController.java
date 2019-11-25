package com.zhaomingchen.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.zhaomingchen.entity.Article;
import com.zhaomingchen.entity.Category;
import com.zhaomingchen.entity.Channel;
import com.zhaomingchen.entity.Collect;
import com.zhaomingchen.entity.Image;
import com.zhaomingchen.entity.User;
import com.zhaomingchen.finalnum.CmsAssert;
import com.zhaomingchen.finalnum.FinalNum;
import com.zhaomingchen.finalnum.MsgResult;
import com.zhaomingchen.finalnum.TypeEnum;
import com.zhaomingchen.service.ArticleService;
import com.zhaomingchen.service.CategoryService;
import com.zhaomingchen.service.ChannelService;
import com.zhaomingchen.service.CollectService;
import com.zhaomingchen.service.UserService;
@Controller
@RequestMapping("user")
public class UserController {
	
	

	Logger log = Logger.getLogger(UserController.class);
	

	
	private SimpleDateFormat dateFormat;

	  // 自动注入 upload.path的值 也就是D/pic
	@Value("${upload.path}")
	String updloadPath;

	

	
	@Autowired
	private  UserService service;
	
	@Autowired
	private ArticleService Atservice;
	
	@Autowired
	private ChannelService Cservice;
	
	@Autowired
	private CategoryService cateservice;
	
	@Autowired
	private CollectService coservice;
	   /**
	    * 
	    * @Title: getArticlerUser 
	    * @Description: 
	    * @param request
	    * @param pageNum
	    * @return
	    * @return: String
	    */
	  /**
	   * 
	   * @Title: getArticlerUser 
	   * @Description: 跳转到我的文章
	   * @param request
	   * @param pageNum
	   * @param m
	   * @return
	   * @return: String
	   */
	   @RequestMapping("getArticlerUser")
	   public String getArticlerUser(HttpServletRequest request,@RequestParam(defaultValue = "1")Integer pageNum,Model m) {
		   
			User loginUser = (User) request.getSession().getAttribute(FinalNum.USER_KEY);
			 //获取这个用户的所有的文章
			  PageInfo info=Atservice.getArticlerUser(pageNum,loginUser.getId());
 
			  m.addAttribute("pageInfo",info);
		   return "/loginorregister/myarticles";
	   }
	   
	   
	  @RequestMapping("delArticle")
	  @ResponseBody
	  public MsgResult delArticle(Integer id,Model m,HttpServletRequest request){
		  
		  // 先查询 id是否大于1
		 CmsAssert.AssertTrue(id>0,"文章id必须大于0"); 
		 
		 //查询是否存在这篇文章
		 
		 Article articelByid = Atservice.getArticelByid(id);
		 CmsAssert.AssertTrue(articelByid!=null,"该文章不存在");
		 
		 
	User loginUser = (User)request.getSession().getAttribute(FinalNum.USER_KEY);	
	
	CmsAssert.AssertTrue(loginUser.getRole()==FinalNum.ROLE||articelByid.getUserId()==loginUser.getId(),"只有管理员,和自己的文章才能删除此文章");
	   	  
	  int num=Atservice.delete(id);
    	CmsAssert.AssertTrue(num>0,"文章删除失败");
	   return new MsgResult(1,"删除成功",null);
	  }


	  
	  
	  
	  /**
	   * 
	   * @Title: postArticle 
	   * @Description: 获取所有频道
	   * @param request
	   * @return
	   * @return: String
	   */
	  @GetMapping("postArticle")
	  public String postArticle(HttpServletRequest request) {
		   
		  // 获取所有的文章
		 List<Channel> channel = Cservice.getChannel();
		 request.setAttribute("channels",channel);
		 return "articel/publish";
		  
	  }
	  
	  /**
	   * 
	   * @Title: getCategoryByChannel 
	   * @Description: 获取所有频道下的内容 用于二级联动
	   * @param chnId
	   * @return
	   * @return: Obeject
	   */
	  @RequestMapping("getCategoryByChannel")
	  @ResponseBody
	  public Object getCategoryByChannel(int chnId) {
		  
		  List<Category> categories = cateservice.getCategory(chnId);
		  return new MsgResult(1, "对不起，没有获取这个数据", categories);
		  
	  }
	  /**
	   * 
	   * @Title: postArticle1 
	   * @Description: 方法的重载 也是用于不同的提交方式 文章的提交
	   * @param request
	   * @return
	   * @return: MsgResult
	 * @throws Exception 
	 * @throws IllegalStateException 
	   */
	  @PostMapping("postArticle")
	  @ResponseBody
	  public MsgResult postArticle1(HttpServletRequest request, MultipartFile file,Article article) throws IllegalStateException, Exception {
		  
		  if(!file.isEmpty()) {
			  // 调用获取文件的方法
			   String processFile = ProcessFile(file);
			   // 获取图片文件的位置
			   article.setPicture(processFile);
		  }
		  
		  // 在session 作用域里面取到User 的值
		User user = (User) request.getSession().getAttribute(FinalNum.USER_KEY);  
		 article.setUserId(user.getId());
		 
		 
		 int result=Atservice.add(article);
		 
		 if(result>0) {
			  
			 return new MsgResult(1,"",null);
		 }else {
			 return new MsgResult(0,"",null);
		 }
		  
		  
		 
	  }

		/**
		 * 
		 * @Title: 保存文件的相对路径
		 * @Description: TODO
		 * @param file
		 * @return: void
		 * @throws Exception 
		 * @throws IllegalStateException 
		 */
	private String ProcessFile(MultipartFile file) throws IllegalStateException, Exception {
		// TODO Auto-generated method stub
		//1 求文件的扩展名  "xxx.jsp"
		String suffixName=file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
		 // 获取新的文件名
		String fileNamePre = UUID.randomUUID().toString();
		// 计算出新的文件名称
		String string = fileNamePre+suffixName;
		
		 dateFormat = new SimpleDateFormat("yyyyMMdd");
		 String path = dateFormat.format(new Date());
		 
		 // 拼接字符串
		 File pathFile = new File(updloadPath+"/"+path);
		 // 查看有没有这个文件夹 如果没有就创建
		 if(!pathFile.exists()) {
			 pathFile.mkdir();
		 }
		 
		 // 获取最终的文件名称
	String newFileName = updloadPath+"/"+path+"/"+string;
	// 赋值到
	 file.transferTo(new File(newFileName));	
	 
	 return path+"/"+string;
		
	}
	
	/**
	 * 
	 * @Title: updateArticle 
	 * @Description: 用于文章的回显 也就是修改
	 * @param m
	 * @param id
	 * @return
	 * @return: String
	 */
	@GetMapping("updateArticle")
	public String updateArticle(Model m,int id) {
		
		
		Article article = Atservice.getDetailById(id);
		m.addAttribute("article",article);
		m.addAttribute("contentl",htmlspecialchars(article.getContent()));
		
		System.out.println("将要修改的文章"+article);
		
	   // 再一次获取所有的频道
        List<Channel> channels = Cservice.getChannel();	
        m.addAttribute("channels",channels);
        
		return "/articel/update";
	}
	
	
	/**
	 * 
	 * @Title: MsgResult 
	 * @Description:文章的修改
	 * @param m
	 * @param article
	 * @param file
	 * @return 
	 * @return: void
	 * @throws Exception 
	 * @throws IllegalStateException 
	 */
	
   @PostMapping("updateArticle")
   @ResponseBody
   public MsgResult updateArticle(Model m,Article article,MultipartFile file) throws IllegalStateException, Exception {
	   
	   //  
		  if(!file.isEmpty()) {
			  // 调用获取文件的方法
			   String processFile = ProcessFile(file);
			   // 获取图片文件的位置
			   article.setPicture(processFile);
		  }
	   
	   
		  int result=Atservice.updateArticle(article);
		  if(result>0) {
			  
				 return new MsgResult(1,"",null);
			 }else {
				 return new MsgResult(0,"",null);
			 }
   }
   
   
   /**
    * 
    * @Title: collectList 
    * @Description: 用户自己的收藏
    * @param request
    * @param pageNum
    * @return
    * @return: String
    */
   @RequestMapping("collect")
   public String collectList(HttpServletRequest request,@RequestParam(defaultValue = "1")Integer pageNum) {
	   
	   // 获取session 作用于里面的user 对象 然后获取对象
	   
	   User user = (User) request.getSession().getAttribute(FinalNum.USER_KEY);
	   // 查询这个用户收藏的文章
	    PageInfo list=coservice.getList(user.getId(),pageNum);
	    request.setAttribute("p",list);
	   return  "/loginorregister/collect";
   }
   
   @RequestMapping("delCollect")
   @ResponseBody
    public boolean delCollect(Integer id) {
	   
	   coservice.deleteCollect(id);
	   
	   return true;
   }
   
   
    @GetMapping("postImg")
    public String postImg(HttpServletRequest request) {
    	
    	// 先获取所有频道
    	List<Channel> channel = Cservice.getChannel();
    	request.setAttribute("channels",channel);
    	
    	return "/articel/postimg";
    }
    
     @PostMapping("postImg")
     @ResponseBody
     public MsgResult postImgs(HttpServletRequest request,Article article,
 			MultipartFile file[],String desc[]) throws Exception {
 		
 		User loginUser = (User)request.getSession().getAttribute(FinalNum.USER_KEY);
 		
 		
 		List<Image> list = new ArrayList<>();
 		// 遍历处理每个上传图片 并存入list
 		for (int i = 0; i < file.length && i < desc.length; i++) {
 			String url = ProcessFile(file[i]);
 			Image image = new Image();
 			image.setDesc(desc[i]);
 			image.setUrl(url);
 			list.add(image);
 		}
 		
 		//
 		Gson gson = new Gson();
 		
 		//设置作者
 		article.setUserId(loginUser.getId());
 		article.setContent(gson.toJson(list));
 		//设置文章类型 是图片
 		article.setArticleType(TypeEnum.IMG);
 		
 		int add = Atservice.add(article);
 		if(add > 0) {
 			return new MsgResult(1,"发布成功11",null);
 		}else {
 			return new MsgResult(2,"发布失败11",null);
 		}
 		
 	}
    
	
	/**
	 * 
	 * @Title: htmlspecialchars 
	 * @Description:替换
	 * @param str
	 * @return
	 * @return: String
	 */
	private String htmlspecialchars(String str) {

		str = str.replaceAll("&", "&amp;");

		str = str.replaceAll("<", "&lt;");

		str = str.replaceAll(">", "&gt;");

		str = str.replaceAll("\"", "&quot;");

		return str;

	}
}
