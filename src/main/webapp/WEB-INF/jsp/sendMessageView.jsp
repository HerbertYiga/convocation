
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>KCS</title>
<!-- booot strap,css and java script files -->

<link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">

<link href="<c:url value="/resources/css/FormerStudentsView.css"/>" rel="stylesheet">


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
         <a href="<c:url value="/StudentForm"/>" target=""><i class="glyphicon glyphicon-flash"></i>Home</a></h3>
      <hr>
      
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
                  <div class="panel-heading"> 
<div class="container">
	<div class="row">
	
           <div id="custom-search-input">
                            <div class="input-group col-md-7">
                                <input type="text" class="  search-query form-control" placeholder="Search Student" />
                                <span class="input-group-btn">
                                    <button class="btn btn-danger" type="button">
                                        <span class=" glyphicon glyphicon-search"></span>
                                    </button>
                                </span>
                            </div>
                        </div>
	</div>
</div> </div>
                  <div class="panel-body">
                    
                    <!-- -List of all former students-->
                     
                     
                                 <table class="table table-striped table-bordered table-list">
                  <thead>
                    <tr>
                   
                        <th class="hidden-xs">ID</th>
                        <th>Name</th>
                        <th>Email</th>
                        <th>Contact</th>
                        <th>Course </th>
                        <th>Dob</th>
                        <th>Citizenship</th>
                            <th>Gender</th>
                        <th>Delete/Edit</th>
                    </tr> 
                  </thead>
                  <tbody id="myTable">
                   <c:forEach var="formerstudent" items="${list}"> 
                          <tr>
                         
                            <td class="hidden-xs">${formerstudent.id}</td>
                            <td>${formerstudent.fullName}</td>
                            <td>${formerstudent.email}</td>
                            <td>${formerstudent.phoneNumber}</td>
                            <td>${formerstudent.courseStudied}</td>
                            <td>${formerstudent.dob}</td>
                            <td>${formerstudent.citizenship}</td>
                            <td>${formerstudent.gender}</td>
                            
                             <td align="center">
                              <a class="btn btn-default"><em class="fa fa-pencil"></em></a>
                              <a class="btn btn-danger"><em class="fa fa-trash"></em></a>
                            </td>
                          </tr>
                             </c:forEach>
                        </tbody>
                </table>
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                    
                    
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