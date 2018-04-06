<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>增加图书</title>
   
  </head>
  
  <body onload="">
  <div align="center">&nbsp; 
    增加图书 <br>
   <form action="/SSMBook/addBook" method="post">
   		Isbn:<input type="text" name="Isbn"/><!-- struts框架要写成book.*** -->
   		Title:<input type="text" name="Title"/>
   		Price:<input type="text" name="Price"/>
   		<input type="submit" value="提交"/>
   </form>
   
   <a href='/SSMBook/listBook'>返回 </a>

   
   </div>
  </body>
</html>
