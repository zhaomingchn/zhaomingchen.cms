<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<table class="table">
  <caption>我的文章</caption>
  <thead>
    <tr>
      <th>id</th>
      <th width="50%">标题</th>
      <th>频道</th>
      <th>分类</th>
      <th>发布日期</th>
      <th>状态</th>
      <th>操作</th>
      </tr>
  </thead>
  <tbody>
    <c:forEach items="${pageInfo.list}" var="article">
	    <tr class="active">
	       <td>${article.id}</td>
	       <td>${article.title}</td>
	       <td>${article.channel.name}</td>
	       <td>${article.category.name}</td>
	       <td><fmt:formatDate value="${article.created}" pattern="yyyy-MM-dd"/></td>
	       <td>
	       <c:choose>
	       	<c:when test="article.status==0">
	       		待审核
	       	</c:when>
	       	<c:when test="article.status==1">
	       		审核通过
	       	</c:when>
	       	<c:when test="article.status==2">
	       		审核被拒
	       	</c:when>
	       	<c:otherwise>
	       		未知
	       	</c:otherwise>	
	       </c:choose>
	       </td>
	      <td>
	      	<input type="button" onclick="updateArticle(${article.id})" value="修改" class="btn-info"/>
	      	<input type="button" onclick="delArticle(${article.id})" value="删除"  class="btn-danger"/>
	      </td></tr>
   	</c:forEach>
  </tbody>
</table>
<ul class="pagination">
    <li><a href="javascript:goPage(${pageInfo.prePage})">&laquo;</a></li>
    <c:forEach begin="${pageInfo.pageNum-2 > 1 ? info.pageNum-2:1}" end="${pageInfo.pageNum+2 > info.pages ? info.pages:info.pageNum+2}" varStatus="index">    		
    	<c:if test="${pageInfo.pageNum!=index.index}">
    		<li><a href="javascript:goPage(${index.index})">${index.index}</a></li>
    	</c:if>
    	<c:if test="${pageInfo.pageNum==index.index}">
    		<li><a href="javascript:void"><strong> ${index.index} </strong> </a></li>
    	</c:if>
    	
    </c:forEach>
    <li><a href="javascript:goPage(${pageInfo.nextPage})">&raquo;</a></li>
</ul>

<script type="text/javascript">

	function goPage(page){
		var url="/user/getArticlerUser?pageNum="+page ;
		$("#content").load(url);
	}
	function delArticle(articleId){
		$.post("/user/delArticle",{id:articleId},function(data){
			if(data.num==1){
				alert("删除成功");
				$("#content").load("/user/myarticles?page=${pageInfo.pageNum}");
				location.reload();
			}else{
				alert(data.error);
			}
		},"json")
	}
	// 文章的修改
	function updateArticle(articleId){
		var url="/user/updateArticle?id="+articleId;
		$("#content").load(url);
	}
	 
	
</script>
