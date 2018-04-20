<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath()); /*根路径 /jay_ssm */
%>
<script type="text/javascript"
	src="${APP_PATH }/static/js/jquery-2.1.1.min.js"></script>
<link rel="stylesheet"
	href="${APP_PATH }/static/bootstrap/css/bootstrap.min.css">
<script src="${APP_PATH }/static/bootstrap/js/bootstrap.min.js"></script>

<style type="text/css">
      .container{
      	margin-top:20px
      	}  
</style>
<title>代课列表</title>
<body>
<div  class="container">
	<div class="row">
    	<div class = "col-md-8 col-md-offset-2">
  			<div class = "panel panel-default">
  				<div class = "panel-heading">
  					<div class = "row">
  						<h1 class = "col-md-5">代课列表</h1>
  						<form action="findByName" class = "col-md-5" style="margin:20px 0 10px 0;" id = "form1">
  							<div class = "input-group">
	  							<input type ="text" name ="name" class="form-control" placeholder = "请输入帖子标题"/>
	  							<span class = "input-group-addon btn" id = "search">搜索</span>
  							</div>
  						</form>
  						<div class = "col-md-2" style ="margin-top:20px">
  							<a class="btn btn-default" href = "toAdd" role = "button">
					    	<span class="glyphicon glyphicon-plus" aria-hidden="true"></span> 新增图书
					    	</a>
  						</div>
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
        			<c:forEach items="${daike}" var="c" varStatus="st">
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
               				<a role="button" class="btn btn=danger btn-xs" href='deleteDaike?dpost_id=${c.dpost_id}'>
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