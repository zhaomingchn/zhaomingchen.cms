<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <meta http-equiv="X-UA-Compatible" content="IE=edge">
 <meta name="viewport" content="width=device-width, initial-scale=1">
 <meta name="viewport" content="width=device-width, initial-scale=1">
 <link href="/resource/bootstrap/css/bootstrap.css" rel="stylesheet">  
 <script type="text/javascript" src="/resource/js/jquery-3.2.1.js"></script> 
 <script type="text/javascript" src="resource/bootstrap/js/bootstrap.js"></script>
  <script type="text/javascript" src="/resource/js/jquery.validate.js"></script>
<title>在线登录</title>
</head>
<body style="background-image: url('/resource/images/2013-12-17.jpg');">
  <jsp:include page="/WEB-INF/view/common/top.jsp"></jsp:include>

	<!-- 登录注册页面 -->
	<div style="height: 50px;"></div>

	<div class="container" >
		<div class="row passport_bg">
			<div class="col-md-6">
				<div class="passport_panel">
					<div class="card">
						<div class="card-header">欢迎回来</div>

						<div class="card-body">
							<form action="login" method="post" id="valiateform">
								<p align="center" style="font-size: 19px;color: red;"></p>
								<div class="form-group">
									<label for="username">用户名:</label> <input type="text"
										class="form-control" name=username id="username"
										value="${user.username}" placeholder="请输入用户名">
								</div>
								<div class="form-group">
									<label for="password">密码:</label> <input type="password"
										class="form-control" name="password" id="password"
										value="${user.password}" placeholder="请输入密码">
								</div>
								<div class="form-group">
									<button type="submit" class="btn btn-info">登录</button>
									<p class="w-100" align="right">
										如果没有有帐号，请<a href="Register">点这里注册</a>
									</p>
								</div>
							</form>

						</div>
					</div>
				</div>
			</div>
			<div class="col-md-6">
				<div class="passport_r">
					<h3>最新加入的用户：</h3>
					<p align="center">
						<img src="/resource/images/guest.jpg" alt="..."
							class="rounded-circle img-thumbnail" /> &nbsp;&nbsp;&nbsp;&nbsp;
						<img src="/resource/images/guest1.jpg" alt="..."
							class="rounded-circle img-thumbnail" />
					</p>
				</div>
			</div>
		</div>
	</div>
	<div>
		<br />
		<br />
	</div>
<script type="text/javascript">

			
		
		$(function() {
			$("#valiateform").validate({
				//校验规则
				rules : {
					username : {
						required : true,
					},
					password : {
						required : true,
					}
				},
				//不满足校验规则信息提示
				messages : {
					username : {
						required : "请输入用户名",
						
					},
					password: {
						required: "密码不能为空",
					},
				}

			})

		})
		
		var flag=${sessionScope.error};
			if(flag==1){
				alert("输入的用户名,或者密码错误");
			}
		
	</script>

</body>
</html>