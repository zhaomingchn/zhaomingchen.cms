<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
    <!-- 模糊查询 -->
    <div class="navbar-header">
        <a class="navbar-brand" href="#">输入姓名</a>
    </div>
    <div>
      <form class="navbar-form navbar-left" role="search">
            <div class="form-group">
                <input id="name" type="text" class="form-control" placeholder="Search">
            </div>
            <input type="button" class="btn btn-default" onclick="like()" value="查询"/>
        </form>
    </div>
   </div>
</nav>

 <!-- 列表展示 -->
  <div class="table-responsive">
   <table class="table">
  
   <caption>用户列表</caption>   
  
   <thead>
    <tr>
    <th>用户id</th>
    <th>用户名称</th>
    <th>注册日期</th>
    <th>生日</th>
    <th>角色</th>
    <th>状态</th>
    <th>操作</th>
    </tr>
   </thead>
   <tbody>
   <c:forEach items="${page.list}" var="user">
   <tr>
   <td>${user.id}</td>
   <td>${user.username}</td>
   <td>
   <fmt:formatDate pattern="YYYY年MM月dd号" value="${user.createTime}"/>
   </td>
   <td><fmt:formatDate pattern="YYYY年MM月dd号" value="${user.birthday}"/></td>
   <!-- 判断是不是管理员,用if判断-->
   <td>
   ${user.role==1?"管理员":"普通用户"}</td>
   <!-- 判断是不是正常 还有禁用 -->
   <td>
   <c:if test="${user.locked==1}">
   禁用
   </c:if>
     <c:if test="${user.locked!=1}">
     正常
   </c:if>
   </td>
   <td>
   <c:if test="${user.locked==1}">
   	<input type="button" class="btn btn-success" onclick="updateStatus(${user.id},0)" value="解禁" />	
   </c:if>
   <c:if test="${user.locked!=1}">
   	<input type="button" class="btn btn-info"  onclick="updateStatus(${user.id},1)" value="封禁"/>
   </c:if>
   </td>
   </tr>
   </c:forEach>
   </tbody>
   </table>
  </div>
  
   <!-- 分页 -->

<ul class="pagination">
    <li><a href="#">&laquo;</a></li>
    <li><a href="#">1</a></li>
    <li><a href="#">2</a></li>
    <li><a href="#">3</a></li>
    <li><a href="#">4</a></li>
    <li><a href="#">5</a></li>
    <li><a href="#">&raquo;</a></li>
</ul>
   
<script type="text/javascript">
 
    function updateStatus(id,lock){
	$.post(
			"/admin/updateLock.do",
			{id:id,lock:lock},
			function(msg){
				if(msg.num==1){
					alert(msg.error);
					$("#content").load("/admin/users");
				}else{
					alert(msg.error);
				}
			}
	)
}
      function like(){
    	  var msg=$("#name").val();
    	  $("#content").load("/admin/users?name="+msg);
    	  
      }


</script> 




