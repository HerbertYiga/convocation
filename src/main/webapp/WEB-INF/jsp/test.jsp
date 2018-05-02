<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
       <form:form id=""  action="sendEmail"   method="POST"  class="form-horizontal" commandName="sendemailforms">
        <fieldset>
        <div class="form-group">
            <label class="col-lg-2 control-label" for="firstName">To</label>
            <div class="col-lg-10">
            <form:input path="recepient" class="form-control" placeholder="Enter Email" id="one" type="username" value="${studentsemail.email}"/>
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
        

</body>
</html>