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
  
     <nav class="navbar navbar-default" style="background:#000099">
	<%@include  file="../common/top.jsp"%>
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
				<ul class="pagination">

								    <li><a href="channel?id=${chnId}&cid=${categoryId}&pageNum=${articles.prePage}">&laquo;</a></li>

								    <c:forEach begin="${articles.pageNum-2 > 1 ? articles.pageNum-2:1}" end="${articles.pageNum+2 > articles.pages ? articles.pages:articles.pageNum+2}" varStatus="index">    		

								    	<c:if test="${articles.pageNum!=index.index}">

								    		<li><a href="channel?id=${chnId}&cid=${categoryId}&pageNum=${index.index}">${index.index}</a></li>

								    	</c:if>

								    	<c:if test="${articles.pageNum==index.index}">

								    		<li><a href="channel?id=${chnId}&cid=${categoryId}&pageNum=${index.index}"><strong> ${index.index} </strong> </a></li>

								    	</c:if>

								    </c:forEach>
								    <li><a href="channel?id=${chnId}&cid=${categoryId}&pageNum=${articles.nextPage}">&raquo;</a></li>

								</ul>
    </div>
    
      </div>
      <!--  面板 -->
      <div class="col-md-2" style="margin-left: 40px;">
     
      <div class="panel panel-primary">
         <!-- 图片文章 -->
      	<div class="panel-heading">
						<h3 class="panel-title">图片文章</h3>
					</div>
					<div class="panel-body">
						<c:forEach items="${imgArticles}" var="article" varStatus="index"> 
							<a href="javascript:showArticle(${article.id})">${index.index+1}. ${article.title}</a>
							<br/>
						</c:forEach>
					</div>
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