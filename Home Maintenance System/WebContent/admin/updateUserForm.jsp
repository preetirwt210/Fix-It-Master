<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit form</title>
<link type="text/css" rel="stylesheet" href="../css/style.css">
</head>
<body>
   <jsp:directive.include file="header.jsp"/>
   
   <div align="center">
        <h1>Edit User</h1></div>
   <div align="center">
   <form id="formLogin" action="update_user" method="post">
   <input type="hidden" name="userId" value="${theUser.userId}"/>
   <table>
      <tbody>
          <tr>
	          <td><label>FullName :</label></td>
	          <td><input type="text" name="fullName" value="${theUser.fullName}" />
          </tr>
          
          <tr>
	          <td><label>Email:</label></td>
	          <td><input type="text" name="email" value="${theUser.email}"/>
          </tr>
          <tr>
	          <td><label>Password:</label></td>
	          <td><input type="password" name="password" value="${theUser.password}"/>
          </tr>
          <tr>
	          <td><input type="submit" value="Save"/></td> 
			  <td><input type="submit" value="Cancel"/></td>
		     </tr>
      </tbody>
   </table>
   </form>
   
   
   </div>
   <a href="list_users">Back To List</a>
  
  
    <jsp:directive.include file="footer.jsp"/>
   
</body>
</html>