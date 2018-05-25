
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
<div class="col-lg-2 col-md-2 col-sm-3 col-xs-12">

    <ul class="nav nav-pills nav-stacked" style="border-right:1px solid black">
        <!--<li class="nav-header"></li>-->
        <li><a href="<c:url value="/admin"/>"><i class="glyphicon glyphicon-home""></i>   Home</a></li>
        <li><a href="<c:url value="/UsersView"/>"><i class="glyphicon glyphicon-user"></i>  Enable/Disable</a></li>
        <li><a href="<c:url value="/DeleteUserDetails"/>"><i class="glyphicon glyphicon-edit"></i>  Edit/Delete</a></li>
           <li><a href="<c:url value="/editUserPassword"/>"><i class="glyphicon glyphicon-user"></i>  Change Password</a></li>
      
    </ul>
</div><!-- /span-3 -->
    <div class="col-sm-9">
      	
      <!-- column 2 -->	
     
      
	   <div class="row">
            <!-- center left-->	
         	<div class="col-md-12">
			  
              <hr>
              
              <div class="panel panel-default" >
                  <div class="panel-heading"><h4><b>Edit/Delete Users</b></h4></div>
                  <div class="panel-body">
                    
                    <!-- -Form    -->
                                <table class="table table-striped table-bordered table-list">
                  <thead>
                    <tr>
                   
                        <th class="hidden-xs">ID</th>
                        <th>Name</th>
                        <th>Password</th>
                        <th>Authority</th>
                        <th>Phone Number </th>
                      
                         <th style="color:#1E90FF">Change Password</th>
                         
                 
                    </tr> 
                  </thead>
                  <tbody id="myTable">
               <c:forEach var="userdetails" items="${list}"> 
                          <tr>
                         
                            <td class="hidden-xs">${userdetails.userId}</td>
                            <td>${userdetails.username}</td>
                            <td>${userdetails.password}</td>
                            <td>${userdetails.authority}</td>
                             <td>${userdetails.phoneNumber}</td>
                                
                          
                          
                          <td>
                       <a  href="<c:url value="/changeuserpassword/${userdetails.userId}"/>" class="btn btn-primary">Change password </a>   
                  
                          </td>
                         
                  
                          </tr>
                             </c:forEach>
                          
                        </tbody>
                </table>
                

<br><br>


  

        
        
        
        
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