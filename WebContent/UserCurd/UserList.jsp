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
#userMenu {
	display: block;
}
</style>
<title>用户列表</title>
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
	</div>
	</nav>
<div class="container-fluid">
		<div class="row">
			<div class="col-sm-2">
				<ul class="nav nav-sidebar">
					<!-- 一级菜单 -->
					<li class="active"><a href="#userMenu"
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


			</div>


<div  class="container">
	<div class="row">
    	<div class = "col-sm-10">
  			<div class = "panel panel-default">
  				<div class = "panel-heading">
  					<div class = "row">
  						<h1 class = "col-md-5">用户列表</h1>
  						<!-- <form action="findByName" class = "col-md-5" style="margin:20px 0 10px 0;" id = "form1">
  							<div class = "input-group">
	  							<input type ="text" name ="name" class="form-control" placeholder = "请输入学号"/>
	  							<span class = "input-group-addon btn" id = "search">搜索</span>
  							</div>
  						</form>
  						<div class = "col-md-2" style ="margin-top:20px">
  							<a class="btn btn-default" href = "toAdd" role = "button">
					    	<span class="glyphicon glyphicon-plus" aria-hidden="true"></span> 新增用户
					    	</a>
  						</div> -->
  					</div>
  				</div>
      			<table align="center" class="table table-bordered">
      				<thead>
      					<tr>
      						<td>学号</td>
      						<td>昵称</td>
            				<td>头像</td>
            				<td>性别</td>
            				<td>手机号</td>
            				<td>QQ</td>
            				<td>删除
        				</tr> 
        			</thead>
        			<tbody>
        			<c:forEach items="${user}" var="c" varStatus="st">
        				<tr>
        					<td>${c.user_sno}</td>
            				<td>${c.user_nickname}</td>
             				<td>${c.user_avatar}</td>
           					<td>${c.user_sex}</td>
           					<td>${c.user_tel}</td>
           					<td>${c.user_qq}</td>
          					<td>
              		<!-- deleteUser与UserCOntroller中注解的名字一致 -->
               				<a role="button" class="btn btn-danger btn-xs" href='deleteUser?user_sno=${c.user_sno}'>
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
<script type="text/javascript">
        
        /*
         * 对选中的标签激活active状态，对先前处于active状态但之后未被选中的标签取消active
         * （实现左侧菜单中的标签点击后变色的效果）
         */
        $(document).ready(function () {
            $('ul.nav > li').click(function (e) {
                //e.preventDefault();    加上这句则导航的<a>标签会失效
                $('ul.nav > li').removeClass('active');
                $(this).addClass('active');
            });
        });
</script>
</body>
</html>