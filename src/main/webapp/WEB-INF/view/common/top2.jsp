<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
  	
  	<!-- logo -->
  	<div class="navbar-header">
      <a class="navbar-brand" href="#">
        <img alt="Brand" src="/resource/images/logo.png">
      </a>
    </div>
    
    
      
    <!-- 搜索框和右侧登录信息 -->
    <div class="collapse navbar-collapse" style="text-align:right;"  id="bs-example-navbar-collapse-1">
       
       <form class="navbar-form"  style="float:none;text-align:center;">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Search">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
      </form> 
    
     
    
      
      <ul class="nav " >
        <li><a href="#"><img  src="/resource/images/donghua.gif"/> </a></li>
        <li class="dropdown">
        <c:choose>
	         <c:when test="${sessionScope.SESSION_USER_KEY == null}">
	         	 <a href="#" > 注册</a>
	         	 <a href="#" > 登录</a>	
	         </c:when>	
         	 <c:otherwise>
         	 
         	 	<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
          		  ${sessionScope.SESSION_USER_KEY.username}<span class="caret"></span></a>
		          <ul class="dropdown-menu ">
		            <li><a href="#">个人中心</a></li>
		            <li><a href="#">个人设置</a></li>
		            <li><a href="#">修改头像</a></li>
		            <li role="separator" class="divider"></li>
		            <li><a href="#">退出登录</a></li>
		          </ul>
		        </li>
         	 </c:otherwise> 
         </c:choose>	
          
      </ul>
    </div><!-- /.navbar-collapse -->
 