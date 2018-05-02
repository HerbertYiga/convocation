
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
          
          <li><a href="<c:url value="/studentslogin" />">Log out</a></li>
      </ul>
     
    </div>
  </div><!-- /container -->
</div>
<!-- /Header -->

<!-- Main -->
<div class="container">



<!-- /Header -->

<!-- Main -->
<br><br>




<div class="col-lg-2 col-md-2 col-sm-3 col-xs-12">

    <ul class="nav nav-pills nav-stacked" style="border-right:1px solid black">
        <!--<li class="nav-header"></li>-->
        <li><a href="<c:url value="/admin" />"><i class="glyphicon glyphicon-home""></i> Home</a></li>
         <li><a href="<c:url value="/headingsViewByStudent" />"> Messages<span class="badge badge-info">4</span></a></li>
         
       
    </ul>
</div><!-- /span-3 -->
<div class="col-lg-10 col-md-10 col-sm-9 col-xs-12">
    <!-- Right -->

    <a href="#"><strong><span class="glyphicon glyphicon-dashboard"></span> Messages</strong></a>
    <hr>
</div>



 <div class="row">
        <div class="col-md-9">
            <div class="panel panel-default">
                <div class="panel-heading">
       
                    <h1 class="panel-title">
                    
                    <b style="color:green;">${messages.theHeading}</b>
                       </h1>
                        
                        
                </div>
                <div class="panel-body">
  
  
  
${messages.messageBody}

  
  
  
  
  
  
  
  
        
  
                 
               
                    </div>
                    
                </div>
            </div>
        </div>
    </div>
  	</div><!--/col-span-9-->
    
  </div><!--/row-->
  <!-- /upper section -->
  
  <!-- lower section -->
 
<!-- /Main -->
<br><br><br>
<br><br><br>
<br><br><br>



<footer class="text-center">All rights Reserved&nbsp;&nbsp;<a href=""><strong>Kyambogo Convocation.</stong></a></footer>


<!-- /.modal -->




  
</body>
</html>