<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manage Users</title>
<link type="text/css" rel="stylesheet" href="../css/style.css"/>
</head>
<body>
<jsp:directive.include file="header.jsp"/>

<div align="center">
   <h1>Users Management</h1>
   <a href="create_user_form.jsp">Create New User</a><br/><br/>
   <table border="1">
	   <tr>
	      <th>Index</th>
	      <th>Id</th>
	      <th>FullName</th>
	      <th>Email</th>
	      <th>Action</th>
	   </tr>
	   <c:forEach var="tempUser" items="${List_User}" varStatus="status" >
	   <tr>
	      <td>${status.index +1}</td>
	      <td>${tempUser.userId }</td>
	      <td>${tempUser.fullName}</td>
	      <td>${tempUser.email}</td>
	      <td><a href="edit_user?userId=${tempUser.userId}">Update</a>|
	      <a href="delete_user" onclick="if(!(confirm('Are You sure .You want to delete this userId: ' + ${tempUser.userId}))) return false">Delete</a></td>
	   </tr>
       </c:forEach>
   </table>
    </div>
<jsp:directive.include file="footer.jsp"/>
</body>
</html>