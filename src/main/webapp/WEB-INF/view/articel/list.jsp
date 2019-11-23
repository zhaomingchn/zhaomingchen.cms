<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

 <meta name="viewport" content="width=device-width, initial-scale=1">

 <link href="/resource/bootstrap/css/bootstrap.css" rel="stylesheet">  
 <script type="text/javascript" src="/resource/js/jquery-3.2.1.js"></script> 
  

<title>${article.title}</title>
</head>
<body>
    <nav class="navbar navbar-default" style="background:#000099">
	<%@include  file="../common/top.jsp" %>
</nav>

<div class="container">
	    
	 
		<h2>   
			${article.title}
		</h2>
		<h5>
			作者：${article.user.username} 
			&nbsp;&nbsp;&nbsp;&nbsp; 发布时间：${article.created} 
			&nbsp;&nbsp;&nbsp;&nbsp; 频道：${article.channel.name} 
			&nbsp;&nbsp;&nbsp;&nbsp; 分类：${article.category.name} 
		</h5>
		<div>

			${article.content}
			<p style="margin-top: 20px; margin-left:850px;">文章的浏览量为<span>${article.num}</span> 点赞量为${article.commentCnt}		
			&nbsp;&nbsp;&nbsp;点赞
			<input type="hidden" name="idss" value="${article.id}">
			<a href="#"><img src="/resource/jquerycss/Images/zan.png" id="praise-img" style="width: 30px;height: 30px;" onclick="upmoneent(${article.id})"/>	</a>	
			</p>
				<div class="container" >
				<div class="row clearfix">
					<div class="col-md-12 column">
					  <textarea rows="8" cols="100" id="talis"></textarea>	
			          <input type="button" style="margin-top: -25px" type="button" class="btn btn-danger" onclick="add()" value="发布">
			          
					</div>
				</div>
			</div>
	
		</div>
	     <div id="up">

	     </div>
                <div style="margin-top:-180px;" id="idsa">
			<!-- 	显示文章的评论 -->
			<c:forEach items="${list}" var="l">
			<div>
			<p>${l.content}
				<a href="#"><img src="/resource/jquerycss/Images/zan.png" id="praise-img" style="width: 30px;height: 30px;" class="pull-right" onclick="upHos(${l.id})"/>	</a>	
			</p>
			<p>评论人:${l.user.username}
			<span class="pull-right">点赞量:${l.hos}</span>
			</p>
			</div>
			</c:forEach>
			<nav aria-label="...">
			  <ul class="pager">
			    <li><a href="ByIdArticel.do?PageNum=${page.prePage}&id=${article.id}">上一页</a></li>
			    <li><a href="ByIdArticel.do?PageNum=${page.nextPage}&id=${article.id}">下一页</a></li>
			  </ul>
			</nav>
	  </div>

		</div>
		
			<div >
			<nav aria-label="...">
			  <ul class="pager">
			    <li><a href="upById?id=${article.id}&num=1">上一篇</a></li>
			    <li><a href="ceById?id=${article.id}&num=1">下一篇</a></li>
			  </ul>
			</nav>
		</div>
<script type="text/javascript">
     
	function add(){
		 if(${sessionScope.SESSION_USER_KEY!=null}){
			  var flag=2;
			 var name=$("#talis").val();
			 $.post(
						"addMonmment",
						{name:name,flag:flag},
						function(msg){
							if(msg){
								alert("评论成功");
								location.reload();
							}
						}
					  )
			 
		 }else{ 
			 var url="upindex1.do";
			 
			  $("#up").load(url); 
		 }
	}
	 
	  
	  function upHos(id){
		  var flag=2;
		  $.post(
			"upHos.do",
			{id:id,flag:flag},
			function(msg){
				if(msg){
					alert("点赞成功");
					
					location.reload("#idsa");
				}
			}
		  )
	  }
	  function upmoneent(id){
		  var flag=2;
		  $.post(
					"upmoneent.do",
					{id:id,flag:flag},
					function(msg){
						if(msg){
							alert("点赞成功");
							location.reload();
						}
					}
				  )
	  }
      
 
	

</script>
</body>
</html>