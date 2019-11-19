<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <meta http-equiv="X-UA-Compatible" content="IE=edge">
 <meta name="viewport" content="width=device-width,inital-scale=1,maximum-scale=1,user-scalable=no;"/>
 <meta name="viewport" content="width=device-width, initial-scale=1">
 <link href="/resource/bootstrap/css/bootstrap.css" rel="stylesheet">  
 <script type="text/javascript" src="/resource/js/jquery-3.2.1.js"></script> 
 <script type="text/javascript" src="resource/bootstrap/js/bootstrap.js"></script>

<title>${article.title}</title>
</head>
<body>

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
		</div>
		<div>
			<nav aria-label="...">
			  <ul class="pager">
			    <li><a href="upById?id=${article.id}">上一篇</a></li>
			    <li><a href="#">下一篇</a></li>
			  </ul>
			</nav>
		</div>
		<div>
			<!-- 	显示文章的评论 -->
		</div>
	</div>

<script type="text/javascript">
 
  $(function(){
	  location.reload();
	    var i=${num};
	    var msg=${msg};
	  if(i==1){
		  alert(msg);
	  }
	  
  })
      
 

</script>
</body>
</html>