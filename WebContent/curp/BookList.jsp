<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">


<html>
  <head>
      
    <title>图书列表</title>	
    <style type="text/css">
        table {
            border: 1px solid black;
            border-collapse: collapse;
        }
        
        table thead tr th {
            border: 1px solid black;
            padding: 3px;
            background-color: #cccccc;
        }
        
        table tbody tr td {
            border: 1px solid black;
            padding: 3px;
        }
    </style>
    
  </head>
  
  <body>
  <div  align="center">
   <h2>图书列表</h2>
        <table cellspacing="0">
            <thead>
                <tr>
                    <th>select</th>
                    <th>ISBN</th>
                    <th>Title</th>
                    <th>Price</th>
                    <th>Operation</th>
                </tr>
            </thead>
            <tbody> 
              <c:forEach items="${cs}" var="c" varStatus="st">
              	<tr>
              		<td></td>
              		<td>${c.isbn}</td><!-- isbn一定要小写不知道为什么 -->
              		<td>${c.title}</td>
              		<td>${c.price}</td>
              		<td>
              			<a href='loadBook?bookId=${c.bookId}'>Edit</a>
                    	<a href='deleBook?bookId=${c.bookId}'>Delete</a>
              		</td>
              	</tr>
              </c:forEach>  
            </tbody>
        </table>                 
        <p><a href="/SSMBook/curp/BookAdd.jsp">Add</a></p>
 
         
        
  </div>
  </body>
</html>