
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>KCS</title>
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
      <a class="navbar-brand" href="#">Convocation System</a>
    </div>
    <div class="navbar-collapse collapse">
      <ul class="nav navbar-nav navbar-right">
        
        <li class="dropdown">
          <a class="dropdown-toggle" role="button" data-toggle="dropdown" href="#">
            <i class="glyphicon glyphicon-user"></i> Admin <span class="caret"></span></a>
          <ul id="g-account-menu" class="dropdown-menu" role="menu">
            <li><a href="#">My Profile</a></li>
            <li><a href="#"><i class="glyphicon glyphicon-lock"></i> Logout</a></li>
          </ul>
        </li>
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
        <a href="<c:url value="/StudentForm"/>" target=""><i class="glyphicon glyphicon-flash"></i>Home</a></h3>    <hr>
      
      <ul class="nav nav-stacked">
       
 <li><a href="<c:url value="/StudentForm"/>" target=""><i class="glyphicon glyphicon-plus"></i> Add Details</a></li>
        <li><a href="<c:url value="/FormerStudentDetailsView"/>" target=""><i class="glyphicon glyphicon-book"></i> View Details</a></li>
         <li><a href="<c:url value="/sendEmailView"/>" target=""><i class="glyphicon glyphicon-envelope"></i> Send Email</a></li>
       <li><a href="<c:url value="/downloadExcel"/>" target=""><i class="glyphicon glyphicon-download"></i>Down load Excel</a></li>
   
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
              <div class="panel-heading">  <h4><b>Edit Former Student Details</b></h4></div>
             
                   <div class="panel-body">
                    
                    <!-- -Form    -->
     
     
     
     
     
     
     
     
     <div class="container">
	<div class="row">
    <div class="col-md-4">
		<div class="form_main">
                
                  
  
<f:form method="POST" action="/Convocation/saveformerstudentafteredit">

    <table>

      <tbody>
<tr>  
        <td></td>    
         <td> <form:hidden path="id"/></td>  
         </tr>
        <tr>

          <td><f:label path="fullName">Full Name:</f:label></td>

          <td><f:input path="fullName" size="40" maxlength="70"></f:input></td>
           <td><f:errors path="fullName" ></f:errors></td>

        </tr>

        <tr>

          <td><f:label path="email">Email:</f:label></td>
          <td><f:input path="email" size="40"></f:input></td>
           <td><f:errors path="email" ></f:errors></td>

        </tr>

        <tr>

          <td><f:label path="phoneNumber">Phone Number:</f:label></td>
          <td><f:input path="phoneNumber" size="40"></f:input></td>
           <td><f:errors path="phoneNumber" ></f:errors></td>

        </tr>

        <tr>

          <td><f:label path="courseStudied">Course studied:</f:label></td>

          <td><f:input path="courseStudied" size="40"></f:input></td>
            <td><f:errors path="courseStudied" ></f:errors></td>

        </tr>

        <tr>

          <td><f:label path="dob">Dob</f:label></td>

          <td><f:input path="dob" size="40" ></f:input></td>
            <td><f:errors path="dob" ></f:errors></td>

        </tr>
            <tr>

          <td><f:label path="citizenship">citizenship</f:label></td>

          <td><f:input path="citizenship" size="40" ></f:input></td>
            <td><f:errors path="citizenship" ></f:errors></td>

        </tr>
      
         <tr>

          <td><f:label path="gender">Gender</f:label></td>

          <td><f:input path="gender" size="40" ></f:input></td>
            <td><f:errors path="gender" ></f:errors></td>

        </tr>

        <tr>

          <td colspan="2"><input type="submit" value="Submit" class="button"></td>

         </tr>
      </tbody>

    </table>

    </f:form> 
		<!-- footer -->


                
            </div>
            </div>
            </div>
	</div> <!--  -->
                    
                    
                    
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


<footer class="text-center">This Bootstrap 3 dashboard layout is compliments of <a href="http://www.bootply.com/85861"><strong>Bootply.com</strong></a></footer>


<!-- /.modal -->




  
</body>
</html>