<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Maintenance System</title>
<link rel="stylesheet" href="../css/style.css">
</head>
<body >
        
<jsp:directive.include file="header.jsp"/> 

<div align="center">
    <h1 class="pageheading"> Administrative Dashboard</h1>
    </div>
    <hr width="60%">
    <div id= "headermenu" align="center">
         <h2 class="pageheading">Quick Actions:</h2>
         <b>
         <a href="create_book">New Service</a> &nbsp;
         <a href="user_form.jsp">New User</a> &nbsp;
         <a href="create_category">New Category</a> &nbsp;
         <a href="create_customer">New Customer</a> &nbsp;
    </b>
    </div>
    <hr width="60%">
    <div align="center">
    <h2 class="pageheading">Recent Sales: </h2>
    </div>
    
    <hr width="60%">
    <div align="center">
    <h2 class="pageheading">Recent Reviews: </h2>
    </div>
    
    <hr width="60%">
    <div align="center">
    <h2 class="pageheading">Stastics: </h2>
    </div>
    <hr>
    
    <jsp:directive.include file="footer.jsp"/>
</body>
</html>