<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manage Category</title>
<link type="text/css" rel="stylesheet" href="../css/admin.css"/>
<link type="text/css" rel="stylesheet" href="../css/table.css"/>
</head>
<body>
<jsp:directive.include file="header.jsp"/>
<hr>
<div align="center">
   <h1>Category Management</h1><br/><br/>
			    
   <a class="create_category" href="create_category_form.jsp">Create New Category</a><br/><br/><br/>
   
   <form action="search_category" method="get">
	   <label>Search Category</label> 
	   <input type="text" name="searchCategory"/> 
	   <input type="submit" name="searchCategory" value="Search" class="search_category"/><br/>
	  </form>
	  <c:if test="${message!=null }">
   <div align="center">
      <h4 class="message">${message }</h4>
   </div>
   </c:if>
   <table border="1">
	   <tr>
	      <th>Index</th>
	      <th>Id</th>
	      <th>Name</th>
	      <th>Image</th>
	      <th>Action</th>
	   </tr>
	   <c:forEach var="tempCategory" items="${list_Category}" varStatus="status" >
	   
	   <tr>
	      <td>${status.index +1}</td>
	      <td>${tempCategory.categoryId }</td>
	      <td>${tempCategory.name}</td>
	      <td><img src="data:image/jpg;base64,${tempCategory.base64Image}" width="240" height="300"/></td>
	      <td><a href="edit_category?categoryId=${tempCategory.categoryId}">Update</a>|
	      <a href="delete_category?categoryId=${tempCategory.categoryId}" onclick="if(!(confirm('Are You sure .You want to delete this categoryId: ' + ${tempCategory.categoryId}))) return false">Delete</a></td>
	   </tr>
       </c:forEach>
   </table>
   </div>
   <br/><br/><br/><br/><hr>
<jsp:directive.include file="footer.jsp"/>
</body>
</html>