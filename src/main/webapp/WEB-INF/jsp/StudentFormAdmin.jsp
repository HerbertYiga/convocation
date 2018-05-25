
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>K.O.S.R.S</title>
<!-- booot strap,css and java script files -->

<link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">

<link href="<c:url value="/resources/css/.css"/>" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script>
function show(input) {
    debugger;
    var validExtensions = ['jpg','png','jpeg']; //array of valid extensions
    var fileName = input.files[0].name;
    var fileNameExt = fileName.substr(fileName.lastIndexOf('.') + 1);
    if ($.inArray(fileNameExt, validExtensions) == -1) {
        input.type = ''
        input.type = 'file'
        $('#user_img').attr('src',"");
        alert("Only these file types are accepted : "+validExtensions.join(', '));
    }
    else
    	
    	if((input.files && input.files[0])==null){
    		alert("Please Upload Photo")
    	}
    	else
    {
    if (input.files && input.files[0]) {
        var filerdr = new FileReader();
        filerdr.onload = function (e) {
            $('#user_img').attr('src', e.target.result);
        }
        filerdr.readAsDataURL(input.files[0]);
    }
    }
}


</script>

<script>

function Checkfiles()
{
var fup = document.getElementById('file');
var fileName = fup.value;
var ext = fileName.substring(fileName.lastIndexOf('.') + 1);
if(ext == "gif" || ext == "GIF" || ext == "JPEG" || ext == "jpeg" || ext == "jpg" || ext == "JPG" || ext == "doc")
{
return true;
} 
else
{
alert("please make sure that you have uploaded a photo");
fup.focus();
return false;
}
}

</script>

<!-- Script for validating that an image is captured -->

</head>
<body>

<!-- Header -->
<div id="top-nav" class="navbar navbar-inverse navbar-static-top">
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
          <span class="icon-toggle"></span>
      </button>
       <a class="navbar-brand" href="#" style="color:#1E90FF;">Kyambogo Old Students Registration System</a>
    </div>
    <div class="navbar-collapse collapse">
     <ul class="nav navbar-nav navbar-right">
      
        <li><a href="<c:url value="/logout" />">Log out</a></li>
      </ul>
     
    </div>
  </div><!-- /container -->
</div>
<!-- /Header -->

<!-- Main -->
<div class="container">
  
  <!-- upper section -->
  <div class="row">
	<div class="col-sm-3">
      <!-- left -->
       <a href="<c:url value="/admin"/>" target=""><i class="glyphicon glyphicon-home"></i> Home</a></h3>
      <hr>
      
      <ul class="nav nav-stacked">
       
       
     <li><a href="<c:url value="/StudentFormAdmin"/>" target=""><i class="glyphicon glyphicon-plus"></i> Add Details</a></li>
        <li><a href="<c:url value="/FormerStudentDetailsViewAdmin"/>" target=""><i class="glyphicon glyphicon-book"></i> View Details</a></li>
         <li><a href="<c:url value="/sendEmailViewAdmin"/>" target=""><i class="glyphicon glyphicon-envelope"></i> Send Email</a></li>
       <li><a href="<c:url value="/admindownloadExcel"/>" target=""><i class="glyphicon glyphicon-download"></i>Down load Excel</a></li>
           
      </ul>
      
      <hr>
      
  	</div><!-- /span-3 -->
    <div class="col-sm-9">
      	
      <!-- column 2 -->	
     
      
	   <div class="row">
            <!-- center left-->	
         	<div class="col-md-12">
			  
              <hr>
              
              <div class="panel panel-default" >
                  <div class="panel-heading">  <h4><b>Enter The Student's Details</b></h4></div>
                  <div class="panel-body">
                    
                    <!-- -Form    -->
          <form:form id=""  action="adminsaveStudentDetailsCon"   method="POST" enctype="multipart/form-data" class="form-horizontal" commandName="studentsForm">
        <fieldset>
         <div class="form-group">
            <label class="col-lg-2 control-label" for="firstName">User Name</label>
            <div class="col-lg-10">
            <form:input path="username" class="form-control" placeholder="Enter User Name" id="one" type="text"/>
          <form:errors path="username" cssStyle="color: #ff0000;" />
            </div>
          
        </div>
          <br>
        <div class="form-group">
            <label class="col-lg-2 control-label" for="firstName">FullName</label>
            <div class="col-lg-10">
            <form:input path="fullName" class="form-control" placeholder="Enter Full Name" id="one" type="text"/>
          <form:errors path="fullName" cssStyle="color: #ff0000;" />
            </div>
          
        </div>
        <br>  

        <div class="form-group">
            <label class="col-lg-2 control-label" for="otherName">Course Studied</label>
            <div class="col-lg-10">
            <form:input path="courseStudied" class="form-control" placeholder="Enter Course Studied" type="text"/>
            <form:errors path="courseStudied" cssStyle="color: #ff0000;" />
             </div>
     
        </div>
        
   <br>  
   
   
   
      <div class="form-group">
            <label class="col-lg-2 control-label" for="otherName">Reg No</label>
            <div class="col-lg-10">
            <form:input path="regNo" class="form-control" placeholder="Enter Reg No" type="username"/>
            <form:errors path="regNo" cssStyle="color: #ff0000;" />
            
            <h5 style="color: #ff0000;"> ${error}</h5>
           
             </div>
     
        </div>
        
        <br>
        <div class="form-group">
            <label class="col-lg-2 control-label" for="email">Email</label>
            <div class="col-lg-10">
            <form:input path="email" class="form-control" placeholder="Enter Email" type="email"/>
             <form:errors path="email" cssStyle="color: #ff0000;" />
           </div>
             
          
             
             
        </div>
        

   <br>  



  
        <div class="form-group">
            <label class="col-lg-2 control-label" for="email">Phone Number</label>
            <div class="col-lg-10">
            <form:input path="phoneNumber" class="form-control" placeholder="Enter phone Number" type="text"/>
             <form:errors path="phoneNumber" cssStyle="color: #ff0000;" />
             
             
           </div>
             
          
             
             
        </div>


 <div class="form-group">
            <label class="col-lg-2 control-label" for="firstName">Password</label>
            <div class="col-lg-10">
            <form:input path="password1" class="form-control" placeholder="Enter password" id="one" type="password"/>
          <form:errors path="password1" cssStyle="color: #ff0000;" />
            </div>
          
        </div>
         <div class="form-group">
            <label class="col-lg-2 control-label" for="firstName">ConfirmPassword</label>
            <div class="col-lg-10">
            <form:input path="password2" class="form-control" placeholder="Confirm password" id="one" type="password"/>
          <form:errors path="password2" cssStyle="color: #ff0000;" />
         
          <h5 style="color: #ff0000;">${passordcheck}</h5>
             
            </div>
          
        </div>


<br>
<div class="form-group">
            <label class="col-lg-2 control-label" for="images">Image</label>
                    <div class="col-md-4">
                        <div>
                            <img id="user_img"
                                 height="130"
                                 width="130"
                                 style="border:solid" /><br><br>
                        </div>
                        <div>
          <form:input path="images" class=""  type="file" id="file"  name="file" onchange="show(this)"/>
           
                        <form:errors path="images" cssStyle="color: #ff0000;" />      
                        </div>
                    </div>
                </div>


    

        <div class="modal-footer">
            <button class="btn btn-primary" type="submit"  onClick="return Checkfiles()" style="color:orange;">Submit</button>
            <button class="btn btn-default" data-dismiss="modal" type="reset">Reset</button> 
       
        </div><!-- end modal-footer -->
        </fieldset>
    </form:form>
        
     
  
        
  
        
        
        
        
                <!--  -->
                    
                    
                    
                    </div>

                  </div><!--/panel-body-->
              </div><!--/panel-->                     
              
          	</div><!--/col-->
         
            <!--center-right-->
        	<!--/col-span-6-->
     
       </div><!--/row-->
  	</div><!--/col-span-9-->
    
  </div><!--/row-->
  <!-- /upper section -->
  
  <!-- lower section -->
<!--/row-->
  
</div><!--/container-->
<!-- /Main -->


<br><br><br>
<footer class="text-center">All rights Reserved&nbsp;&nbsp;<a href=""><strong>Kyambogo Convocation </strong></a></footer>


<!-- /.modal -->







  
</body>
</html>