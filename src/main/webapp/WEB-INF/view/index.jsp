<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
			<li class="list-group-item" >热门频道</li>
			<c:forEach items="${channel}" var="c">
			<li class="list-group-item" style="height:45px; "><a href="#">${c.name}</a></li>
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

</div>
    
    <!--页脚 -->
   <div class="row clearfix" style="height:200px;">
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