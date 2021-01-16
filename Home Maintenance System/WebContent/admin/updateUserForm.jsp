<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit form</title>
<link type="text/css" rel="stylesheet" href="../css/admin.css">
<link type="text/css" rel="stylesheet" href="../css/form.css">
<script type="text/javascript" src="../js/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
</head>
<body>
   <jsp:directive.include file="header.jsp"/>
   <hr>
   
   <div align="center">
        <h1>Edit User</h1></div>
   <div align="center">
   <form id="updateForm" action="update_user" method="post">
   <input type="hidden" name="userId" value="${theUser.userId}"/>
   <table>
      <tbody>
          <tr>
	          <td align="right"><label>FullName :</label></td>
	          <td align="left"><input type="text" name="fullName" id="fullName" value="${theUser.fullName}" />
          </tr>
          
          <tr>
	          <td align="right"><label>Email:</label></td>
	          <td align="left"><input type="text" name="email" id="email" value="${theUser.email}"/>
          </tr>
          <tr>
	          <td align="right"><label>Password:</label></td>
	          <td align="left"><input type="password" name="password" id="password" value="${theUser.password}"/>
          </tr>
          <tr>
	          <td align="right"><input type="submit" value="Save" class="save"/></td> 
			  <td align="left"><input type="submit" value="Cancel" class="cancel"/></td>
		     </tr>
      </tbody>
   </table>
   </form>
   
   <br/><br/>
   </div>
   <a href="list_users">Back To List</a>
  
   <br/><br/><br/><br/><br/><br/><hr>
    <jsp:directive.include file="footer.jsp"/>
   
</body>
<script type="text/javascript">

   $(document).ready(function(){
	 $("#updateForm").validate({
    rules:{
    	 email:{
    		   required:true,
    		   email:true
    	 },
    	 fullName:"required",
    	 password:"required",
    },
    messages:{
    	email:{
    		required:"Please enter email",
    		email:"Please enter valid email address"
    	},
    	fullName:"Please enter fullName",
    	password:"Please enter password"
    }
	 });
   });
</script>
</html>