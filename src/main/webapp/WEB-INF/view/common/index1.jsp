<style>
	*{ margin:0; padding:0;}
	button, input{ outline:none;}
	button, .login{ width:120px; height:42px; background:#f40; color:#fff; border:none; border-radius:6px; display: block; margin:20px auto; cursor: pointer;}
	.popOutBg{ width:100%; height:100%; position: fixed; left:0; top:0; background:rgba(0,0,0,.6); display: none;}
	.popOut{ position:fixed; width:600px; height:300px; top:50%; left:50%; margin-top:-150px; margin-left:-300px; background:#fff; border-radius:8px; overflow: hidden; display: none;}
	.popOut > span{ position: absolute; right:10px; top:0; height:42px; line-height:42px; color:#000; font-size:30px; cursor: pointer;}
	.popOut table{ display: block; margin:42px auto 0; width:520px;}
	.popOut caption{ width:520px; text-align: center; color:#f40; font-size:18px; line-height:42px;}
	.popOut table tr td{ color:#666; padding:6px; font-size:14px;}
	.popOut table tr td:first-child{ text-align: right;}
	.inp{ width:280px; height:30px; line-height:30px; border:1px solid #999; padding:5px 10px; color:#000; font-size:14px; border-radius:6px;}
	.inp:focus{ border-color:#f40;}
	@keyframes ani{
		from{
			transform:translateX(-100%) rotate(-60deg) scale(.5);
		}
		50%{
			transform:translateX(0) rotate(0) scale(1);
		}
		90%{
			transform:translateX(20px) rotate(0) scale(.8);
		}
		to{
			transform:translateX(0) rotate(0) scale(1);
		}
	}
	.ani{ animation:ani .5s ease-in-out;}
</style>
<body> 
<div class="popOutBg"></div>
<div class="popOut">
	<span title="关闭">x</span>
<form action="logins.do" method="post">
	<p style="text-align: cneter;">${error}</p>
	<table>
		<caption>对不起,还没有登录,请先登录
	
		</caption>
			
		<tr>
	       
			<td width="120">用户名：</td>
			<td><input type="text" class="inp" placeholder="请输入你的账号"  id="username" name="username" ></td>
		</tr>
		<tr>
			<td>密码：</td>
			<td><input type="password" class="inp" placeholder="请输入密码" name="password"></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" class="login" value="登录" />
			 <input type="hidden" name="ids" value="${sessionScope.ids}">
			</td>
		</tr>
		<tr>
			<td colspan="2">没有账号去注册--><a href="Register">注册</a></td>
		</tr>
	</table>
	</form>
</div>
 <script type="text/javascript">



 		$(".popOut").style.display = "block";
 		ani();
 		$(".popOutBg").style.display = "block";
 		
 		function $(param){
 			if(arguments[1] == true){
 				return document.querySelectorAll(param);
 			}else{
 				return document.querySelector(param);
 			}
 		}
 		
 	function ani(){
 		$(".popOut").className = "popOut ani";
 	}
 	
 	$(".popOut > span").click = function(){
 		$(".popOut").style.display = "none";
 		$(".popOutBg").style.display = "none";
 	};
 	
 	$(".popOutBg").click = function(){
 		$(".popOut").style.display = "none";
 		$(".popOutBg").style.display = "none";
 	}; 
 
 </script>
</body>

