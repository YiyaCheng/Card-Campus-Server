<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath()); /*根路径 /jay_ssm */
%>
<link rel="stylesheet" href="${APP_PATH}/static/bootstrap/css/bootstrap.css">
<link rel="stylesheet" href="${APP_PATH}/static/css/font-awesome.css">
<link rel="stylesheet" href="${APP_PATH}/static/css/index.css">
<!-- 修改自Bootstrap官方Demon，你可以按自己的喜好制定CSS样式 -->

<link rel="stylesheet" href="${APP_PATH}/static/css/font-change.css">
<!-- 将默认字体从宋体换成微软雅黑（个人比较喜欢微软雅黑，移动端和桌面端显示效果比较接近） -->
<script type="text/javascript"
	src="${APP_PATH}/static/bootstrap/js/jquery-2.1.1.min.js"></script>
<script type="text/javascript"
	src="${APP_PATH}/static/bootstrap/js/bootstrap.min.js"></script>

<style type="text/css">
.container-fluid {
	margin-top: 20px
}
#DaiMenu {
	display: block;
}
</style>
<title>代拿快递列表</title>
<body>
<!-- 顶部菜单（来自bootstrap官方Demon）==================================== -->
	<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="index.jsp">欢迎来到卡片校园后台管理界面</a>
		</div>

		<!-- <div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav navbar-right">			            
						<li><a href="###" onclick="showAtRight('/Card-Campus-Server/WebContent/UserCURD/UserList.jsp')"><i class="fa fa-users"></i> 用户列表</a></li>	
						<li><a href="###" onclick="showAtRight('UserList.jsp')"><i class="fa fa-list-alt"></i> 产品列表</a></li>
						<li><a href="###" onclick="showAtRight('UserList.jsp')" ><i class="fa fa-list"></i> 订单列表</a></li>	
					</ul>
          			
        		</div> -->
	</div>
	</nav>
<div class="container-fluid">
		<div class="row">
			<div class="col-sm-2">
				<ul class="nav nav-sidebar">
					<!-- 一级菜单 -->
					<li class=""><a href="#userMenu"
						class="nav-header menu-first collapsed" data-toggle="collapse">
							<i class="fa fa-user"></i>&nbsp; 用户管理 <span class="sr-only">(current)</span>
					</a></li>
					<!-- 二级菜单 -->
					<!-- 注意一级菜单中<a>标签内的href="#……"里面的内容要与二级菜单中<ul>标签内的id="……"里面的内容一致 -->
					<ul id="userMenu" class="nav nav-list collapse menu-second">
						<li><a
							href="http://localhost:8080/Card-Campus-Server/listUser"><i
								class="fa fa-users"></i> 用户列表</a></li>
					</ul>


					<li><a href="#DaiMenu" class="nav-header menu-first collapsed"
						data-toggle="collapse"> <i class="fa fa-file-text"></i>&nbsp;
							代代代模块管理 <span class="sr-only">(current)</span></a></li>
					<ul id="DaiMenu" class="nav nav-list collapse menu-second">
						<li><a
							href="http://localhost:8080/Card-Campus-Server/listDaike"><i
								class="fa fa-list"></i> 代课列表</a></li>
						<li><a href="http://localhost:8080/Card-Campus-Server/listDaifood"><i
								class="fa fa-list"></i> 代拿外卖列表</a></li>
						<li><a href="http://localhost:8080/Card-Campus-Server/listDaiactivity"><i
								class="fa fa-list"></i> 代活动列表</a></li>
						<li><a href="http://localhost:8080/Card-Campus-Server/listDaiwalk"><i
								class="fa fa-list"></i> 代健步走列表</a></li>
						<li><a href="http://localhost:8080/Card-Campus-Server/listDaibuy"><i
								class="fa fa-list"></i> 代购列表</a></li>
						<li><a href="http://localhost:8080/Card-Campus-Server/listDaideliver"><i
								class="fa fa-list"></i> 代拿快递列表</a></li>
					</ul>


					<li><a href="#BaishitongMenu"
						class="nav-header menu-first collapsed" data-toggle="collapse">
							<i class="fa fa-globe"></i>&nbsp; 百事通模块管理 <span class="sr-only">(current)</span>
					</a></li>
					<ul id="BaishitongMenu" class="nav nav-list collapse menu-second">
						<li><a href="http://localhost:8080/Card-Campus-Server/listQuestionPost"><i
								class="fa fa-list-alt"></i> 百事通帖子列表</a></li>
						<li><a href="http://localhost:8080/Card-Campus-Server/listQuestionReply"><i
								class="fa fa-list-alt"></i> 百事通回复列表</a></li>
					</ul>

					<li><a href="#LoveMenu"
						class="nav-header menu-first collapsed" data-toggle="collapse">
							<i class="fa fa-globe"></i>&nbsp; 表白墙模块管理 <span class="sr-only">(current)</span>
					</a></li>
					<ul id="LoveMenu" class="nav nav-list collapse menu-second">
						<li><a href="http://localhost:8080/Card-Campus-Server/listLovePost"><i
								class="fa fa-list-alt"></i> 表白帖子列表</a></li>
						<li><a href="http://localhost:8080/Card-Campus-Server/listLoveReply"><i
								class="fa fa-list-alt"></i> 表白帖子回复列表</a></li>
					</ul>

					<li><a href="#BookMenu"
						class="nav-header menu-first collapsed" data-toggle="collapse">
							<i class="fa fa-globe"></i>&nbsp; 二手书籍模块管理 <span class="sr-only">(current)</span>
					</a></li>
					<ul id="BookMenu" class="nav nav-list collapse menu-second">
						<li><a
							href="http://localhost:8080/Card-Campus-Server/listBookPost"><i
								class="fa fa-list-alt"></i> 图书列表</a></li>
					</ul>
				</ul>



				<!-- <a href="#" class="list-group-item active"><span
					class="glyphicon glyphicon-home"></span>商品管理 </a> <a href="test2.jsp"
					class="list-group-item"> 小图标样式设置 <span
					class="glyphicon glyphicon-search" aria-hidden="true"> </span>VIP客户查询
				</a> <a href="#" class="list-group-item"> <span
					class="glyphicon glyphicon-align-left" aria-hidden="true"> </span>VIP客户录入
				</a> <a href="#" class="list-group-item"> <span
					class="glyphicon glyphicon-camera" aria-hidden="true"> </span>VIP客户消费
				</a> <a href="#" class="list-group-item"> <span
					class="glyphicon glyphicon-plus" aria-hidden="true"> </span>VIP客户增加
				</a> <a href="#" class="list-group-item"> <span
					class="glyphicon glyphicon-minus" aria-hidden="true"> </span>VIP客户删除
				</a> <a href="#" class="list-group-item"> <span
					class="glyphicon glyphicon-search" aria-hidden="true"> </span>VIP客户注销
				</a> <a href="#" class="list-group-item"> <span
					class="glyphicon glyphicon-user" aria-hidden="true"> </span>个人设置
				</a> -->
			</div>
<div  class="container">
	<div class="row">
    	<div class = "col-sm-10">
  			<div class = "panel panel-default">
  				<div class = "panel-heading">
  					<div class = "row">
  						<h1 class = "col-md-5">代拿快递列表</h1>
  						<!-- <form action="findByName" class = "col-md-5" style="margin:20px 0 10px 0;" id = "form1">
  							<div class = "input-group">
	  							<input type ="text" name ="name" class="form-control" placeholder = "请输入帖子标题"/>
	  							<span class = "input-group-addon btn" id = "search">搜索</span>
  							</div>
  						</form>
  						<div class = "col-md-2" style ="margin-top:20px">
  							<a class="btn btn-default" href = "toAdd" role = "button">
					    	<span class="glyphicon glyphicon-plus" aria-hidden="true"></span> 新增帖子
					    	</a>
  						</div> -->
  					</div>
  				</div>
      			<table align="center" class="table table-bordered">
      				<thead>
      					<tr>
      						<td>编号</td>
      						<td>发布用户</td>
            				<td>发布时间</td>
            				<td>内容</td>
            				<td>标题</td>
            				<td>类型</td>
            				<td>是否解决</td>
        				</tr> 
        			</thead>
        			<tbody>
        			<c:forEach items="${daideliver}" var="c" varStatus="st">
        				<tr>
        					<td>${c.dpost_id}</td>
            				<td>${c.user.user_nickname}</td>
            				<!-- 这样获取属性也可以<td>${c.user.getUser_sno()}</td> -->
             				<td>${c.dpost_time}</td>
           					<td>${c.dpost_content}</td>
          					<td>${c.dpost_title}</td>
          					<td>${c.dpost_type}</td>
          					<td>${c.is_solved}</td>
          					<td>
              		<!-- deleteBookPost与BookPostController中注解的名字一致 -->
               				<a role="button" class="btn btn=danger btn-xs" href='deleteDaideliver?dpost_id=${c.dpost_id}'>
                				<span class="glyphicon glyphicon-trash" aria-hidden="true"></span> 删除
               				</a>
             				</td>
          				</tr>
        			</c:forEach>  
        			</tbody>
      			</table>
      	 	</div>
      	</div> 
  	</div>                    
</div>
</body>
</html>