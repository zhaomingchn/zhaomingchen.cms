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

<title>Insert title here</title>
</head>
<body>
    <jsp:include page="/WEB-INF/view/common/top.jsp"></jsp:include>
<!-- 导航条 -->
<div class="container">
	<div class="row" style="margin-top: 100px; margin-left: px;">
		<div class="col-md-3" >
			<ul class="list-group homemenu">
			 <li class="list-group-item list-group-item-success" data="/user/getArticlerUser">我的文章</li>
			 <li class="list-group-item list-group-item-info" data="/user/postArticle">发布文章</li>
			 <li class="list-group-item list-group-item-info">我的评论</li>
			 <li class="list-group-item list-group-item-info">投票管理</li>
			 <li class="list-group-item list-group-item-info">个人设置</li>
			</ul>
		</div>
		<div class="col-md-9" id="content">
			
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