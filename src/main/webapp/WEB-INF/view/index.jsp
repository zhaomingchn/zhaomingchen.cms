<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
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
   
<!-- 导航 -->
  	
<div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <a class="navbar-brand" href="#">
        <img alt="Brand" src="/resource/images/logo.png">
      </a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav"  >
		<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
		<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
		<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
		<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
		
		<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
		<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
		<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
		<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
      </ul>
      
      <form class="navbar-form navbar-left">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Search">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
      </form>
      
      <ul class="nav navbar-nav navbar-right">
       <li><a href="#"><img width="30px" height="30px" src="/resource/images/donghua.gif"/> </a></li>
        <c:choose>
	        <c:when  test="${sessionScope.SESSION_USER_KEY == null}">
	        	<li><a href="Register">注册</a></li>
	        	<li><a href="login.do">登录</a></li>
	        </c:when>
	        <c:otherwise>
		        <li class="dropdown">
		          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"> 
		          	${sessionScope.SESSION_USER_KEY.username}
		           <span class="caret"></span></a>
		         <ul class="dropdown-menu ">
		            <li><a href="">个人中心</a></li>
		            <li><a href="#">个人设置</a></li>
		            <li><a href="#">修改头像</a></li>
		            <li><a href="index">去主页面</a></li>
		            <li role="separator" class="divider"></li>
		            <li><a href="exit.do">退出登录</a></li>
		          </ul>
		        </li> 、
	        </c:otherwise>
        </c:choose>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
  

   <!--大概信息 -->
<div class="container-fluid" style="background: ; margin-top:30px;">
			
			<!-- 导航列表 -->
			<div class="col-md-2" style="background: ;min-height:700px;margin-left:100px;">
			<ul class="list-group menu" style="width:150px; margin-top:50px; ">
			<li class="list-group-item" >热门频道</li>
			<c:forEach items="${channel}" var="c">
			<li class="list-group-item" style="height:45px; "><a href="channel?id=${c.id}">${c.name}</a></li>
			</c:forEach>	    
			</ul>
			</div>
			
			
			<!--  轮播图 -->
			<div class="col-md-6" style="background: ;min-height:700px;margin-left: -30px; " >
           <div id="myCarousel" class="carousel slide" style="background:green;width: 900px;height: 500px;">
           
           
    <!-- 轮播（Carousel）指标 -->
    <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>   
    <!-- 轮播（Carousel）项目 -->
    <div class="carousel-inner" style="width: 900px;height: 500px;">
    
        <div class="item active" style="width:900px;height: 500px;">
            <img src="/resource/images/ss.jpg" alt="First slide" style="width: 900px;height: 500px;">
            <div class="carousel-caption">小老婆</div>
        </div>
        <div class="item" style="width: 900px;height: 500px;">
            <img src="/resource/images/325392.jpg" alt="Second slide" style="width: 900px;height: 500px;">
            <div class="carousel-caption">大老婆</div>
        </div>
        <div class="item" style="width: 900px;height: 500px;">
            <img src="/resource/images/aaa.jpg" alt="Third slide" style="width: 900px;height: 500px;">
            <div class="carousel-caption">大大老婆</div>
        </div>
    </div>
    <!-- 轮播（Carousel）导航 -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
  </div>
  
  
  
   <div class="container-fluid" style="font-size: 18px" >
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
					<ul class="pagination">

								    <li><a href="/index?pageNum=${hotList.prePage}">&laquo;</a></li>

								    <c:forEach begin="${hotList.pageNum-2 > 1 ? hotList.pageNum-2:1}" end="${hotList.pageNum+2 > hotList.pages ? hotList.pages:hotList.pageNum+2}" varStatus="index">    		

								    	<c:if test="${hotList.pageNum!=index.index}">

								    		<li><a href="/index?pageNum=${index.index}">${index.index}</a></li>

								    	</c:if>

								    	<c:if test="${hotList.pageNum==index.index}">

								    		<li><a href="/index?pageNum=${index.index}"><strong> ${index.index} </strong> </a></li>

								    	</c:if>

								    	

								    </c:forEach>

								    <li><a href="/index?pageNum=${hotList.nextPage}">&raquo;</a></li>

								</ul>
				
    </div>
      </div>
      
      
      <!--  面板 -->
      <div class="col-md-3" style="margin-left: 40px;">
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
</script>
</body>
</html>