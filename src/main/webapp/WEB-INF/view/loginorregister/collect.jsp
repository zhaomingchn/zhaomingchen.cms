<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
   <%@ taglib  uri="http://www.springframework.org/tags/form"  prefix="form"%>

    
<!DOCTYPE html>
<link href="/resource/bootstrap/css/bootstrap.css" rel="stylesheet">
<script type="text/javascript" src="/resource/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="/resource/bootstrap/js/bootstrap.js"></script>
 
 <script type="text/javascript">

 function getArticelByid(id){
		window.open("ByIdArticel.do?id="+id)
}
  function fenye(id){
	  
	    var url="/user/collect?pageNum="+id;
	  
		$("#content").load(url);
  }
  function del(id){
	  $.post(
				"/user/delCollect.do",
				{id:id},
				function(msg){
					if(msg){
						alert("删除成功");
						location.reload();
					}
				}
			  )
	  
	  
  }
</script>
 
<div style="height:500px;width: 1000px;margin-left: 100px;margin-top: 20px" >
				<table class="table table-striped" style="font-size: 20px;font-family: courier">
		  		<thead>
			 		<tr>
					    <th>收藏编号</th>
					    <th>文章名</th>
					    <th>收藏时间</th>
					    <th>操作</th>
					</tr>
		  		</thead>
				  <tbody>
				  <c:forEach items="${p.list}" var="collect">
				    <tr class="active">
				        <td>${collect.id}</td>
					    <td>
					    <a href="javascript:getArticelByid(${collect.article.id})">${collect.article.title}</a>
					    </td>
					    <td><fmt:formatDate value="${collect.created}" pattern="YYYY年MM月dd日"/></td>
					    <td><button onclick="del(${collect.id})">取消收藏</button></td>				    	
				    </tr>
				    </c:forEach>
				    
				  </tbody>
			</table>
			<nav aria-label="Page navigation">
		<!-- 有空看一下 分页 不是很明白  -->
		<div id="upd">
		  <a href="#" onclick="fenye(1)"> 首页</a>
		  <a  href="#"  onclick="fenye(${p.prePage})"> 上一页</a>
		  <a  href="#" onclick="fenye(${p.nextPage})">下一页</a>
		  <a  href="#" onclick="fenye(${p.pages})">尾页</a>
		
		</div>	
	
		</nav>	
	</div>
	