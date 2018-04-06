<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'BookAdd.jsp' starting page</title>
    
  </head>
  
  <body>
  <div align="center">edit book <br>
   <form action="/SSMBook/editBook" method="post">
   		<input type="hidden" name="bookId" value='${book.bookId }'/>
   		<!-- book.bookId中的book取决于loadBook方法中mav.addObject("book",book)中的的key值 -->
   		Isbn:<input type="text" name="Isbn" value='${book.isbn}'/>    <!-- name一定要与Book.java的属性值一样 -->
   		Title:<input type="text" name="Title"  value='${book.title}'/>
   		Price:<input type="text" name="Price"  value='<c:catch>${book.price}</c:catch>'>
   		<input type="submit" value="提交"/>
   </form>
   
   </div>
  </body>
</html>
