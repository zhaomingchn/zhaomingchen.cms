<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<div class="row">
	<form id="form" >
		<div class="input-group">
			<span class="input-group-addon">文章标题</span>
		  <input type="text" name="title" class="form-control" placeholder="文章标题" aria-describedby="basic-addon2">
		</div>
		<div class="input-group">
			 <span class="input-group-addon">频道</span>
		      <select class="custom-select custom-select-sm mb-3" id="channel"  name="channelId">
				  <option value="0">请选择</option>
				  <c:forEach items="${channels}" var="channel">
				  		<option value="${channel.id}">${channel.name}</option>
				  </c:forEach>
			   </select>
			
		</div>
		    
		<div class="input-group">
			 <span class="input-group-addon">分类</span>
			 <select class="custom-select custom-select-sm mb-3" id="category" name="categoryId">
			</select>
		</div>
		<div id="imgdiv">
			<div class="input-group">
				 <span class="input-group-addon">图片</span>
				 <input type="file"
					class="form-control"  name="file">
			</div>
			<div class="input-group">
				 <span class="input-group-addon">图片描述</span>
				 <input type="Text"
					class="form-control"  name="desc">
			</div>
		</div>
		<div class="input-group">
			<input type="button" onclick="addImg()" value="添加图片">
			<input type="button" onclick="publish()" value="发布">
			
		</div>
		
	</form>
</div>
<script>


//当频道的数据发生改变的时候，分类需要联动
$("#channel").change(function(){
// 获取修改后的频道值
	var channelId =  $(this).val();
// 根据频道的数据获取相应的分裂
$.post("/user/getCategoryByChannel",{chnId:channelId},function(data){
	   //data 包含了分类的信息
	   if(data.num==1){
		   $("#category").empty();
		   $("#category").append("<option value='0'>请选择</option>")
		   for ( var index in data.date) {
			   $("#category").append("<option value='"+ data.date[index].id +"'>"+data.date[index].name+"</option>")
		   }
	   }else{
		   // 获取数据失败
		   alert(data.error);
	   }
},"json"
)

}) 

	function addImg(){
		$("#imgdiv").append('<div class="input-group">' + 
				 '<span class="input-group-addon">图片</span> ' + 
				 '<input type="file" ' + 
					' class="form-control" id="file" name="file">' + 
			'</div>' +
			'		<div class="input-group">' +
		 ' <span class="input-group-addon">图片描述</span>' +
		 ' <input type="Text" ' +
			' class="form-control"  name="desc">' +
	'  </div>	'
		)
	}
	
	function publish(){
		
		//序列化表单数据带文件
		 var formData = new FormData($( "#form" )[0]);
		
		
		$.ajax({
			type:"post",
			data:formData,
			// 告诉jQuery不要去处理发送的数据
			processData : false,
			// 告诉jQuery不要去设置Content-Type请求头
			contentType : false,
			url:"/user/postImg",
			success:function(obj){
				if(obj.num==1){
					alert("发布成功!")
					$('#content').load("/user/getArticlerUser");
				}else{
					alert("发布失败")
				}
				
			}
			
		})
	}
	
</script>