
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
   <a class="navbar-brand" href="#" style="color:#1E90FF;">Kyambogo Old Students Registration System</a>
    </div>
    <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <li class="active" ><a href="<c:url value="/StudentForm"/>" class="" style="color:#1E90FF;">Home</a></li>

                        <li class="active"><a href="<c:url value="/StudentForm"/>" class="" style="color:#1E90FF;">Add Details</a></li>

                         <li class="active"><a href="<c:url value="/FormerStudentDetailsView"/>" class="" style="color:#1E90FF;">View Details</a></li>
                        
                        <li class="active"><a href="<c:url value="/sendEmailView"/>" class="" style="color:#1E90FF;">send Email</a></li>
                        
                        <li class="active"><a href="<c:url value="/downloadExcel"/>" class="" style="color:#1E90FF;">Download Excel</a></li>
                        

                        
                        </ul>
                    <ul class="nav navbar-nav pull-right">
                                                <li class=""><a href="<c:url value="/logout" />">Logout</a></li>
                    </ul>
                </div>
  </div><!-- /container -->
</div>
<!-- /Header -->

<!-- Main -->
<div class="container">
  
  <!-- upper section -->
  <div class="row">
	<!-- /span-3 -->
    <div class="col-sm-12">
      	
      <!-- column 2 -->	
     
      
	   <div class="row">
            <!-- center left-->	
         	<div class="col-md-12">
			  
              <hr>
              
              <div class="panel panel-default" >
                  <div class="panel-heading"> 
<div class="container">
	<div class="row">
	
        <div class="searchform text-center">
                <br/>
                <form:form method="POST"  action="EmailRegno" commandName="studentsemailmodel" >
                    <form:input path="regNo"  placeholder="Enter RegNo"/>
                    <input type="submit"/>
                </form:form>
            </div>
	</div>
</div> </div>
                  <div class="panel-body">
                    
                    <!-- -List of all former students-->
                       <form:form id="yourForm" action="emailaccountstobesenttointhereform" method="POST" commandName="studentsemailmodel" >    
                 
                   <input type="submit" value="select and send mail" />
                       <br><br>
                     
                     
                                 <table class="table table-striped table-bordered table-list">
                  <thead>
                    <tr>
                   
                       
                        <th>Full Name</th>
                        <th>Email</th>
                        <th>Phone Number</th>
                        <th>Course Studied </th>
                          <th>Reg No </th>
                           <th>Select</th>
                        <th>Image</th>
                 
                        <th>send mail</th>
                    </tr> 
                  </thead>
                  <tbody id="myTable">
               <c:forEach var="formerstudent" items="${list}"> 
                          <tr>
                         
                         
                            <td>${formerstudent.fullName}</td>
                            <td>${formerstudent.email}</td>
                            <td>${formerstudent.phoneNumber}</td>
                            <td>${formerstudent.courseStudied}</td>
                                 <td>${formerstudent.regNo}</td>
                                      <td>
                    <form:checkbox path="checkid"  value="${formerstudent.id}"/>
                </td>
                      
                         
                                       <td width="90px">   <img width="50" height="50" src="<c:url value='/resources/image/${formerstudent.imageLink}'/>" alt="Photo of Youthful William" id="pic" />
         </td>
                           
                          
    
                             <td><a href="sendEmailForm/${formerstudent.id}">Send Email</a></td> 


         
                            
                          </tr>
                             </c:forEach>
                          
                        </tbody>
                </table>
                     
                     
                     
                     
                                            
    </form:form>
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                    
                    
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


<footer class="text-center">All rights Reserved&nbsp;&nbsp;<a href=""><strong>Kyambogo Convocation </strong></a></footer>


<!-- /.modal -->




  
</body>
</html>