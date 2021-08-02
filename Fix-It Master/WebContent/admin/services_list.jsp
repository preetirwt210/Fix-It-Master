<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manage Services</title>
<link type="text/css" rel="stylesheet" href="../css/admin.css"/>
<link type="text/css" rel="stylesheet" href="../css/table.css"/>
</head>
<body>
<jsp:directive.include file="header.jsp"/>
<hr>
<div align="center">
   <h1>Services Management</h1><br/><br/>
			    
   <a class="create_service" href="new_services">Create New Service</a><br/><br/><br/>
   <c:if test="${message!=null }">
   <div align="center">
      <h4 class="message">${message }</h4>
   </div>
   </c:if>
   <form action="search_service" method="get">
	   <label>Search Service</label> 
	   <input type="text" name="search_service"/> 
	   <input type="submit" name="searchService" value="Search" class="search_service"/><br/>
	  </form>
	  
   <table border="1">
	   <tr>
	      <th>Index</th>
	      <th>Id</th>
	      <th>Title</th>
	      <th>Category</th>
	       <th>Price</th>
	      <th>Action</th>
	   </tr>
	   <c:forEach var="tempServ" items="${list_serv}" varStatus="status" >
	   <tr>
	      <td>${status.index +1}</td>
	      <td>${tempServ.serviceId }</td>
	      <td>${tempServ.title}</td>
	      <td>${tempServ.category.name}</td>
	      <td>${tempServ.price}</td>
	      <td><a href="edit_service?serviceId=${tempServ.serviceId}">Update</a>|
	      <a href="delete_service?serviceId=${tempServ.serviceId}" onclick="if(!(confirm('Are You sure .You want to delete this serviceId ' + ${tempServ.serviceId}))) return false">Delete</a></td>
	   </tr>
       </c:forEach>
   </table>
   </div>
   <br/><br/><br/><br/><hr>
<jsp:directive.include file="footer.jsp"/>
</body>
</html>