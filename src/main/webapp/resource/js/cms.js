//获取分页连接的URL .并进行加载
 $('.page-link').off("click");
$(function(){
      $('.page-link').click(function (e) {
      	  //获取点击的的url
          var url = $(this).attr('data');
         //在中间区域显示地址的内容
         $('#content-wrapper').load(url);
      });
	
})

//导航的样式的增加或移除
$(function () {
     
	   $('ul li').off("click");
       $('ul li').click(function () {
       	
       	/*   //获取当前默认高亮的属性
            var li = $('ul li.active');
       	   //移除目前高亮的样式
               li.removeClass('active');
       	   //为当前点击行添加高亮的样式
               $(this).addClass('active');*/
       	   //获取当前默认高亮的属性
       		var li = $('ul li.list-group-item-success');
   			//移除目前高亮的样式
   			li.removeClass('list-group-item-success');
   		
   			//为当前点击行添加高亮的样式
   			$(this).addClass('list-group-item-success');
       	   
           });  
       
       $('.nav-link').off("click");
       $('.nav-link').click(function () {
       	
    	   //获取当前默认高亮的属性   
           var li = $('.nav-link.active');
    	   //移除目前高亮的样式
            li.removeClass('active');
    	   //为当前点击行添加高亮的样式
            $(this).addClass('active');
            
           
    	   
        });
      
       
       function loadnav(){
	       //当点击左侧菜单时  加载url
	       //获取点击的的url
	       var url = $(this).attr('data');
	   	  // console.log(url);
	      //在中间区域显示地址的内容
	      $('#content-wrapper').load(url);
      }
     //  $('.nav-link').off("click",loadnav);
       $('.nav-link').click(loadnav)
      
       
      
     //个人主页当点击左侧菜单时-->
      $('.channel').off("click");
      $('.channel').click(function (e) {
      	  //获取点击的的url
          var url = $(this).attr('data');
          
          console.log(url);
         //在中间区域显示地址的内容
          $('#center').load(url);

      });
      
    })
    