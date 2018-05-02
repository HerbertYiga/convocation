
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>C.O.S.R.S</title>
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
     <a class="navbar-brand" href="#">Convocation Old Students Registration System</a>
    </div>
    <div class="navbar-collapse collapse">
     
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
       <a href="<c:url value="/StudentForm"/>" target=""><i class="glyphicon glyphicon-flash"></i>Home</a></h3>     <hr>
      
      <ul class="nav nav-stacked">
       
       
     <li><a href="<c:url value="/StudentForm"/>" target=""><i class="glyphicon glyphicon-flash"></i> Add Details</a></li>
        <li><a href="<c:url value="/FormerStudentDetailsView"/>" target=""><i class="glyphicon glyphicon-link"></i> View Details</a></li>
         <li><a href="<c:url value="/sendEmailView"/>" target=""><i class="glyphicon glyphicon-book"></i> Send Email</a></li>
       <li><a href="<c:url value="/sendMessageView"/>" target=""><i class="glyphicon glyphicon-list-alt"></i>Down load Excel</a></li>
           
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
                  <div class="panel-heading">  <h4 style="text-align:center"><b>Send Email</b></h4></div>
                  <div class="panel-body">
                    
                    <!-- -Form    -->
         <form:form id=""  action="saveStudentDetailsCon"   method="POST"  class="form-horizontal" commandName="sendemailform">
        <fieldset>
        <div class="form-group">
            <label class="col-lg-2 control-label" for="firstName">To</label>
            <div class="col-lg-10">
            <form:input path="recepient" class="form-control" placeholder="Enter Email" id="one" type="email" value="${studentsemails.email}"/>
         <form:errors path="recepient" cssStyle="color: #ff0000;" />
            </div>
          
        </div>
        <br>  

        <div class="form-group">
            <label class="col-lg-2 control-label" for="otherName">subject</label>
            <div class="col-lg-10">
            <form:input path="subject" class="form-control" placeholder="Subject" type="username"/>
            <form:errors path="subject" cssStyle="color: #ff0000;" />
             </div>
     
        </div>
        
   <br>  
   
   
   
      <div class="form-group">
            <label class="col-lg-2 control-label" for="otherName">Message</label>
            <div class="col-lg-10">
            <form:textarea path="message" class="form-control" placeholder="Message" type="username" cols="50" rows="10" />
            <form:errors path="message" cssStyle="color: #ff0000;" />
             </div>
     
        </div>
        
       
             
          
             
             
    
        

   <br>  





   






    

        <div class="modal-footer">
            <button class="btn btn-primary" type="submit"  >Send</button>
            <button class="btn btn-default" data-dismiss="modal" type="button">Cancel</button> 
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