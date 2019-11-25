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
 <script type="text/javascript" src="/resource/kindeditor/kindeditor-all.js"></script>

<title>Insert title here</title>
</head>
<body>
   <nav class="navbar navbar-default" style="background:#000099">
	<%@include  file="../common/top.jsp" %>
</nav>
<!-- 导航条 -->
<div class="container">
	<div class="row" style="margin-top: 100px; ">
		<div class="col-md-3" style=" height:300px; text-align: center;">
			<ul class="list-group homemenu" style="height: 200px;">
			 <li class="list-group-item list-group-item-success" data="/user/getArticlerUser"><a>我的文章</a></li>
			 <li class="list-group-item list-group-item-info" data="/user/postArticle">发布文章</li>
			 <li class="list-group-item list-group-item-info">我的评论</li>
			 <li class="list-group-item list-group-item-info">投票管理</li>
			 <li class="list-group-item list-group-item-info">个人设置</li>
			 <li class="list-group-item list-group-item-info" data="/user/collect">我的收藏</li>
			 <li class="list-group-item list-group-item-info" data="/user/postImg">发布图片</li>
			</ul>
		</div>
		<div class="col-md-9" id="content">
		  <h1>欢迎你</h1>
		  <div id="kindEditor" style="display: none">
				   <!-- 引入kindEditor的样式 -->
				  <jsp:include page="/resource/kindeditor/jsp/demo.jsp"></jsp:include>
              </div>
		  
		</div>
	</div>
</div>
<script type="text/javascript">
	$(".homemenu li").click(function(){
		var url  = $(this).attr("data");
		$("#content").load(url);
	})
	
</script>


</body>
</html>