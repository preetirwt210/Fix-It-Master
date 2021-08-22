<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
<link type="text/css" rel="stylesheet" href="css/style.css"/>
</head>
<body >

<jsp:directive.include file="header.jsp"/>
<div>
         <img id="background"  class="background"  src="images/start.jpg" title ="Fix-It Master" alt="Image not available" width="1320px" height="250px"/>
         <!--  <img id="background"  class="background"  src="images/header1.jpg" title ="Home-Maintenance-Services" alt="Image not available" width="1330px" height="400px"/>
          <img id="background"  class="background"  src="images/header2.jpg" title ="Home-Maintenance-Services" alt="Image not available" width="1330px" height="400px"/>
  -->       
</div>
  <br/>
  <br/><br/><br/><br/>
<div align="center">
         <h1 align="center">Corporate Service PortFolio</h1><br/>
         All services
         <h1 align="center">Customers Reviews</h1>
         what our customer says..
         <h1 align="center">Contact us</h1>
           form<br/>
           df<br/>
           df<br/>
           df<br/>
           df<br/>
           
</div>
<br/><br/><br/><br/><br/><br/>
<jsp:directive.include file="footer.jsp"/>
</body>
<script>
// Automatic Slideshow - change image every 3 seconds
var myIndex = 0;
carousel();

function carousel() {
  var i;
  var x = document.getElementsByClassName("background");
  for (i = 0; i < x.length; i++) {
    x[i].style.display = "none";
  }
  myIndex++;
  if (myIndex > x.length) {myIndex = 1}
  x[myIndex-1].style.display = "block";
  setTimeout(carousel, 3000);
}
</script>

</html>