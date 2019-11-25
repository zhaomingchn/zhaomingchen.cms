<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>      
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
 <link href="/resource/bootstrap/css/bootstrap.css" rel="stylesheet">  
 <script type="text/javascript" src="/resource/js/jquery-3.2.1.js"></script> 
 <script type="text/javascript" src="/resource/bootstrap/js/bootstrap.js"></script>
<title>${article.title}</title>
</head>
<body>
	<h1> ${article.title} </h1>
	
	<div id="myCarousel" class="carousel slide" style="minheight:200px">
						<!-- 轮播（Carousel）指标 -->
						<ol class="carousel-indicators">
							<c:forEach items="${article.imges}" var="img" varStatus="index">
								<li data-target="#myCarousel" data-slide-to="${index.index}" ${index.index==0?"class='active'":""}></li>
							</c:forEach>
							
						</ol>   
						<!-- 轮播（Carousel）项目 -->
						<div class="carousel-inner thumbnail" style="border-radius:12px;">
							<c:forEach items="${article.imges}" var="img" varStatus="index">
								<div class="item ${index.index==0?"active":"" }">
									<img  class="img-rounded"  src="/D:\Eclipse-1707A-work7\com.zhaomingchen.cms\Eclipse-1707A-work7com.zhaomingchen.cmsEclipse-1707A-work7\20191125/${img.url}" style=" border-radius:24px; align:center;width:800px; height:400px;" alt="First slide">
								</div>
							</c:forEach>
							
						</div>
						<!-- 轮播（Carousel）导航 -->
						<a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
							<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
							<span class="sr-only">Previous</span>
						</a>
						<a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
							<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
							<span class="sr-only">Next</span>
						</a>
					</div>
					
</body>
</html>