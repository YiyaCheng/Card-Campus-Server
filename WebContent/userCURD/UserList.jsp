<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>

<style type="text/css">
table {
	border: 1px solid black;
	border-collapse: collapse;
}

table thead tr th {
	background-color: #fcb69f;
	font-size: 15px;
	border: 1px solid #9DB3C5;
	padding: 1px;
	
	text-align: center;
	margin: 20px auto;
}

table tbody tr td {
	border: 1px solid black;
	padding: 3px;
}
</style>


</head>
<body>
<div  align="center">
   <h2>用户列表</h2>
        <table cellspacing="0">
            <thead>
                <tr>
                    <th>select</th>
                    <th>昵称</th>
                    <th>头像</th>
                    <th>性别</th>
                    <th>手机号</th>
                    <th>QQ</th>
                    <th>删除</th>
                </tr>
            </thead>
            <tbody> 
              <c:forEach items="${user}" var="c" varStatus="st">
              	<tr>
              		<td></td>
              		<td>${c.user_nickname}</td><!-- isbn一定要小写不知道为什么 -->
              		<td>${c.user_avatar}</td>
              		<td>${c.user_sex}</td>
              		<td>${c.user_tel}</td>
              		<td>${c.user_qq}</td>
              		<td>
              		<!-- deleteUser与UserCOntroller中注解的名字一致 -->
                    	<a href='deleteUser?user_sno=${c.user_sno}'>Delete</a>
              		</td>
              	</tr>
              </c:forEach>  
            </tbody>
        </table>                     
  </div>
</body>
</html>