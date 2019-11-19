<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <meta http-equiv="X-UA-Compatible" content="IE=edge">
 <meta name="viewport" content="width=device-width, initial-scale=1">
 <link href="/resource/bootstrap/css/bootstrap.css" rel="stylesheet">  
 <script type="text/javascript" src="/resource/js/jquery-3.2.1.js"></script> 
 <script type="text/javascript" src="resource/bootstrap/js/bootstrap.js"></script>
<title>Insert title here</title>

<style type="text/css">
  .menu li{
   font-size:20px; 
   text-align: center;
  }
  .menu li:hover {
	  background:gray;
}
 
</style>
</head>
<body>
 <div class="container-fluid" style="background-image:url('/resource/images/325392.jpg'); ">
<!-- logo -->
<nav class="navbar navbar-default" role="navigation"> 
    <div class="container-fluid" style="min-height:60px;"> 
        <div class="navbar-header" style="margin-top: 5px;" > 
			<img alt="200x200" src="/resource/images/logo.png"/ style="width: 100px;height: 70px;">
        </div> 
        <ul class="nav navbar-nav navbar-right"> 
             <li>    <div class="container-fluid" style="width:500px;height: 50px;margin-top: 13px; margin-right: 500px;">
    <!-- 模糊查询 -->
    <div class="navbar-header" >
        <a class="navbar-brand" href="#">输入姓名</a>
    </div>
    <div>
      <form class="navbar-form navbar-left" role="search">
            <div class="form-group">
                <input type="text" class="form-control" placeholder="Search">
            </div>
            <input type="button" class="btn btn-default" value="查询"/>
        </form>
    </div>
   </div>
   </li>
            <li style="margin-top: 8px;"><a href="java"><span class="glyphicon glyphicon-user"></span>注册</a></li> 
            <li style="margin-top: 15px;">
    <button type="button" class="btn dropdown-toggle" id="dropdownMenu1" data-toggle="dropdown">
                 用户
        <span class="caret"></span>
    </button>
    <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
        <li role="presentation" class="dropdown-header">下拉菜单标题</li>
        <li role="presentation">
            <a role="menuitem" tabindex="-1" href="#">Java</a>
        </li>
        <li role="presentation">
            <a role="menuitem" tabindex="-1" href="#">数据挖掘</a>
        </li>
        <li role="presentation">
            <a role="menuitem" tabindex="-1" href="#">数据通信/网络</a>
        </li>
        <li role="presentation" class="divider"></li>
        <li role="presentation" class="dropdown-header">下拉菜单标题</li>
        <li role="presentation">
            <a role="menuitem" tabindex="-1" href="#">分离的链接</a>
        </li>
    </ul>
   </li>
        </ul> 
    </div> 
</nav>

   <!--大概信息 -->
<div class="container-fluid" style="background: ; margin-top:30px;">
			
			<!-- 导航列表 -->
			<div class="col-md-2" style="background: ;min-height:700px;margin-left:100px;">
			<ul class="list-group menu" style="width:150px; margin-top:50px; ">
			<li class="list-group-item" ><a href="index">热门频道</a></li>
			<c:forEach items="${channel}" var="c">
			<li class="list-group-item" style="height:45px;"<c:if test="${c.id==id}">class="active"</c:if> ><a href="channel?id=${c.id}">${c.name}</a>
			</li>
			</c:forEach>	    
			</ul>
			</div>
			<!--  导航 -->
			<div class="col-md-6" style="background: ;min-height:700px;margin-left: -30px; " >
            <div class="container-fluid" >
            <nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
    <!-- 获取分类 -->
    <div class="navbar-header">
                    <c:forEach items="${list}" var="list">
                    <a class="navbar-brand" href="javascript:goTocar(${list.id})">${list.name}</a> 
                    </c:forEach>
    </div>
    </div>
</nav>
            </div>
  
   <div class="container-fluid"  style="font-size: 18px">
    <!--  获取热门文章 -->
    
     
     <c:forEach items="${hotList.list}" var="article" >
						<div class=row>
					<hr>
					<div class="col-md-2"><img height="80px" width="80px" src="/pic/${article.picture}"></div>
					<div class="col-md-10">
				    <a href="javascript:getArticelByid(${article.id})">${article.title}</a>
			     	<br>
				 频道：<a>${article.channel.name}</a> &nbsp;&nbsp;
				 分类：<a>${article.category.name}</a>
				<br>
				<br>
		  	${article.user.username} 发布于  <fmt:formatDate value="${article.created}" pattern="yyyy-MM-dd"/> 
					</div>
				</div>
				</c:forEach>
    </div>
    
      </div>
      <!--  面板 -->
      <div class="col-md-2" style="margin-left: 40px;">
      <div class="panel panel-primary">
       <div class="panel-heading">
        <h2 class="panel-title" style="text-align: center; margin-top: 10px">最新文章</h2>
    </div>
    <div class="panel-heading">
    <br/>
    </div>
      <c:forEach items="${article}" var="l" varStatus="count">
     <div class="panel-body">
        
        <h4><a href="javascript:getArticelByid(${l.id})">${count.count}:${l.title}</a></h4>
       </div>
      </c:forEach>       
    
</div>
      
   </div>
      </div>
    <!--页脚 -->
   <div class="row clearfix" style="height:200px; margin-top:200px;">
		<div class="col-md-12 column">
			
		      <p style="text-align: center; margin-top: 60px;">Euro icon: <span class="glyphicon glyphicon-euro">  所有版权归赵明晨所有</span></p>
		</div>
	</div>

    </div>
<script type="text/javascript">
  function getArticelByid(id){
		window.open("ByIdArticel.do?id="+id)
  }
  
  function  goTocar(cid){
	  location.href="channel?cid="+cid+"&id="+${id};
	  
  }
</script>
</body>
</html>