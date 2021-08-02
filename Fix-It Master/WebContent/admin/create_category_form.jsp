<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Category form</title>
<link type="text/css" rel="stylesheet" href="../css/admin.css">
<link type="text/css" rel="stylesheet" href="../css/form.css">
<script type="text/javascript" src="../js/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
</head>
<body>
   <jsp:directive.include file="header.jsp"/>
   <hr>
	
   <div align="center">
        <h1>Category Management</h1></div>
   <div align="center">
   
   <form id="categoryForm" action="create_category" method="post">
 
   <table>
      <tbody>
          <tr>
	          <td align="right"><label>Category Name :</label></td>
	          <td align="left"><input type="text" name="name" id="name" />
          </tr>
           <tr>
	          <td align="right"><label>Image :</label></td>
              <td align="left"><input type="file" name="image" id="image" size="20" /><br/>
                 <img id="thumbnail" alt="image-preview"  style="width:20%; margin-top:10px"
                 src="data:imagejpg;base64,${category.image }"/> 
                   
                </td>    
          </tr>
          <tr>
	          <td align="right"><input type="submit" value="Create" class="save"/></td> 
			  <td align="left"><input type="button" value="Cancel" onclick="javascript:history.go(-1);" class="cancel"/></td>
		     </tr>
		      
      </tbody>
   
   </table>
   </form>
   
   
   </div>
   <div style="clear:both;"></div>
   <p >
   <a href="list_category" >Back To List</a>
   </p>
  
  <br/><br/><br/><br/><hr>
    <jsp:directive.include file="footer.jsp"/>
   
</body>
<script type="text/javascript">

   $(document).ready(function(){
	 $("#categoryForm").validate({
    rules:{
    	name:"required",
    	image:"required",
    	 
    },
    messages:{
    	
    	name:"Please enter Category Name",
    	 image:"Please Enter Image of the Image"
    }
	 });
   });
   function showImageThumbnail(fileInput){
		  var file=fileInput.files[0];
		  
		  var reader= new FileReader();
		  
		  reader.onload=function(e){
			  $("#thumbnail").attr("src",e.target.result);
		  };
		  reader.readAsDataURL(file);
	  }
</script>
</html>