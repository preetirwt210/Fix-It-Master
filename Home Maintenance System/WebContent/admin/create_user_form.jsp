<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User form</title>
<link type="text/css" rel="stylesheet" href="../css/style.css">
</head>
<body>
   <jsp:directive.include file="header.jsp"/>
   
   <div align="center">
        <h1>Users Management</h1></div>
   <div align="center">
   <form id="formLogin" action="create_user" method="post">
   <table>
      <tbody>
          <tr>
	          <td><label>FullName :</label></td>
	          <td><input type="text" name="fullName" />
          </tr>
          <tr>
	          <td><label>Email:</label></td>
	          <td><input type="text" name="email" />
          </tr>
          <tr>
	          <td><label>Password:</label></td>
	          <td><input type="password" name="password""/>
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