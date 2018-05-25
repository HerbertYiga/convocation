package com.convocation.controllers;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;




















import com.convocation.bean.EmailBean;
import com.convocation.bean.MessagesBean;
import com.convocation.bean.StudentsForm;
import com.convocation.bean.Test;
import com.convocation.dao.MessagesDao;
import com.convocation.dao.StudentsFormDao;



@Controller

public class StudentsFormController {
	@Autowired
	StudentsFormDao dao;
	@Autowired
	MessagesDao  mdao;
	@Autowired
	private JavaMailSender mailSender;
	

//------------------------------------------students login-------------------------------------	
	//students login page 
	
	
	@RequestMapping("studentslogin")
	
	public ModelAndView studentsLogin(@ModelAttribute("studentlogindetails") StudentsForm studentlogindetails){
		
		return new ModelAndView("studentslogin");
	}
	
    //checking and authorizing the student if the user details are true
	@RequestMapping("checkandloginandaddstudentsAdmindetails")
	
	public ModelAndView checkStudentlogin(@ModelAttribute("studentlogindetails") StudentsForm studentsForm,Model model) throws SQLException, ClassNotFoundException{
		
		
		
		
	


		
			Class.forName("com.mysql.jdbc.Driver");
		Connection  connection=DriverManager.getConnection("jdbc:mysql://localhost/convocation","root","onlylord");


		String sql="select username,password1,fullName,imageLink,email,id,phoneNumber,regNo,courseStudied from studentdetails where username = '"+ studentsForm.getUsername() +"' and password1='"+ studentsForm.getPassword1() +"'";


		Statement st=connection.createStatement();



		ResultSet rs=st.executeQuery(sql);



		   if(rs.next()) {
			   //getting the notice baord to the list
			List<MessagesBean>list=mdao.getNotices();
			model.addAttribute("list",list);
			//end of the notice board
			StudentsForm studentdetails=new StudentsForm();
			
			
			studentdetails.setId(rs.getInt("id"));
			studentdetails.setFullName(rs.getString("fullName"));
			studentdetails.setEmail(rs.getString("email"));
			studentdetails.setUsername(rs.getString("username"));
			studentdetails.setPassword1(rs.getString("password1"));
			studentdetails.setPhoneNumber(rs.getInt("phoneNumber"));
			studentdetails.setCourseStudied(rs.getString("courseStudied"));
			studentdetails.setImageLink(rs.getString("imageLink"));
			studentdetails.setRegNo(rs.getString("regNo"));
			model.addAttribute("studentdetails" ,studentdetails);
			
			return new ModelAndView("studentspanel");
				
			
		}

		
		
			
			
			else{
				model.addAttribute("error","Maked sure you are registered,then insert a correct password and username");
				return new ModelAndView("studentslogin");
			}
		
	
		
	}
	
	
	
	
	//user logout 
	@RequestMapping("logoutstudent")
	
	
	public ModelAndView logoutStudent(){
		
		
		
		return new ModelAndView("studentslogin");
	}
	
	
/*--------------------------------------------------end of a student loged in ---------------------------------------------------*/
	
	
	
	
	//logout
	
	@RequestMapping("logout")
	public ModelAndView logout(){
		
		return new ModelAndView("login");
		}
	
	//submiting details by the student
	

@RequestMapping(value="/saveStudentDetailsbyStudents")
	public ModelAndView saveStudentDetailsByStuden(HttpServletRequest servletRequest,@Valid @ModelAttribute("addstudentdetailsbyuser") StudentsForm studentsForm,BindingResult result,Model model){

	
		
		
		
		/*
		 checking for whether the regNo exist in the database and return an error
		 */
	
		
		//get the regNo from the form
		String regNo=studentsForm.getRegNo();
		
		
		
		//making sure that the passwords are the same
		
		if(!(studentsForm.getPassword1().equals(studentsForm.getPassword2()))){
			
 	      model.addAttribute("passordcheck","please make sure that the passwords correspond");
			    
				return  new ModelAndView("addDetailsByStudent");
			
				
		}
		
		//makiing sure that the regNo exists in the database

		if(dao.getRegNoFromDataBase(regNo)!=null)
				
		{
			
			//if it exists then get it from the database
			StudentsForm st=dao.getRegNoFromDataBase(regNo);
			//checking whether the regno got from the form equals to that got from the database
			if(regNo.equals(st.getRegNo())){
			
				//if it equals then return an error message 
		    model.addAttribute("error","regNo Arleady Exists");
		    
			return  new ModelAndView("addDetailsByStudent");
		
			
			}
		
		
		}
		
	     
		
		

	
		
		
		//getting the uploaded images and putting them in a list of multipart file
		List <MultipartFile>files=studentsForm.getImages();
		
		//A list to contain all the file names
		List<String>fileNames=new ArrayList<String>();
		//checking whether we have images in files List
		
		if(null!=files&&files.size()>0){
			
			//get all the images and put them to the multipart file
			for(MultipartFile multipartFile:files){
				
				//getting the image name
				String fileName=multipartFile.getOriginalFilename();
				//putting the image name to the setter
				studentsForm.setImageLink(fileName);
				//adding all the names to the list
				fileNames.add(fileName);
				//stroring the images to the server
				
				File imagefile=new File(servletRequest.getServletContext().getRealPath("/resources/image"),fileName);
				try{
					multipartFile.transferTo(imagefile);
				}
				catch(IOException e){
					e.printStackTrace();
				}
				
				
				
			}
			
		}
		    
	
	
		//save the students details to the data  base
		dao.saveFormerStudentDetails(studentsForm);
			
		
			return  new ModelAndView("AfterDetailsSubmissionByStudent");
					}

	//add student details by the user
	@RequestMapping("addDetailsByStudent")
	public String addDetailsByStudent(@ModelAttribute("addstudentdetailsbyuser") StudentsForm studentsform){
		
		return "addDetailsByStudent";
		
		
		
	}
	
	
     //download excel  
	
	@RequestMapping(value="/downloadExcel",method=RequestMethod.GET)
	
	public ModelAndView downloadExcel(){
	
		
		List <StudentsForm> list=dao.getStudentDetails();
		
		return new ModelAndView("excelView","list",list);
		
		
	}

	

	
	
	//Email send form view 
	
		@RequestMapping("sendEmailForm")
		public ModelAndView  viewSendEmailView(Model model,Model model2,StudentsForm studentform){
			
			StudentsForm studentsform2=new StudentsForm();
			model.addAttribute("studentsform2",studentsform2);
			
			StudentsForm studentsemail=dao.getStudentById(studentform.getId());
			model2.addAttribute("studentsemail",studentsemail);
			
			
			return new ModelAndView("sendEmailForm","command",new StudentsForm());
		}
		
	
	@RequestMapping("test")
	public String test(Model model){
		model.addAttribute("sendemailforms",new StudentsForm());
		return "test";
	}
	
	
	
	//sending a message
	@RequestMapping("/sendEmail")
	public String sendEmail(StudentsForm emailbean,HttpServletRequest request){
		
		
     //taking the inputs from the bean 
		 String recepient = emailbean.getRecepient();
	        String subject = emailbean.getSubject();
	        String message = emailbean.getMessage();

        // prints debug info
        System.out.println("To: " + recepient);
        System.out.println("Subject: " + subject);
        System.out.println("Message: " + message);
        
        //send email object
        SimpleMailMessage email=new SimpleMailMessage();
        email.setTo(recepient);
        email.setSubject(subject);
        email.setText(message);
        
        
        
        //send the email
        mailSender.send(email);
        
        
        
		
		
		return "EmailSentSuccesFully";
		
		
		
	}
	//selecting students according to there regNo so as to send one by one an email
	
	@RequestMapping("EmailRegno")
	public String EmailByRegNo(StudentsForm studentsform,Model model){
		if((dao.getStudentByRegNo(studentsform.getRegNo()))!=null){
		
		StudentsForm studentsformbyregno=dao.getStudentByRegNo(studentsform.getRegNo());
		model.addAttribute("studentsformbyregnoformail",studentsformbyregno);
		
		return "sendEmailToIndividual";}
		else{
			
			return "cantFindRegNoDetailsForEmailing";
		}
		
		
	}
	
	
	//selcting the student details basing on the students regNo so as to delete them
	
	@RequestMapping("deleteByRegno")
	public String deleteByRegNo(StudentsForm studentsform,Model model){
		if((dao.getStudentByRegNo(studentsform.getRegNo()))!=null){
		
		StudentsForm studentsformbyregno=dao.getStudentByRegNo(studentsform.getRegNo());
		model.addAttribute("studentsformbyregno",studentsformbyregno);
		
		return "deleteByRegno";}
		else{
			
			return "cantFindRegNoDetails";
		}
		
		
	}
	

	
	
	
	
	
	
	//deleting the selected users from the database
	
	@RequestMapping("deleteslectedstudents")
	public String deleteSelectedStudents(StudentsForm studentsform){
		
		//capture info in the array
		int [] userid=studentsform.getCheckid();
		
		
		  //using a for loop
		for(int i=0;i<userid.length;i++){
			
			//puting the array to the id
		for(int id:userid){
			//using setter method
			studentsform.setId(id);
			//deleting method
			dao.delete(id);
			
		}
			
			
		}
		
		return "redirect:FormerStudentDetailsView";
		
		
		
	}
	
	
	//geting and returning all the selected emails
	
	@RequestMapping("emailaccountstobesenttointhereform")
	public String getSelectedEmails(StudentsForm studentsform,Model model,Model model2){
		
		//capture info in the array
		int [] userid=studentsform.getCheckid();
		
		
		  //using a for loop
		for(int i=0;i<userid.length;i++){
			
			//puting the array to the id
		for(int id:userid){
			//using setter method
			studentsform.setId(id);
			//deleting method
		
			StudentsForm studentsemails=dao.getStudentById(id);
			model.addAttribute("studentsemails",studentsemails);
			model2.addAttribute("sendemailform",new StudentsForm());
			
		}
			
			
		}
		
		return "emailaccountstobesenttointhereform";
		
		
		
	}
	
	
	
	@RequestMapping(value="/loginError")
	public String loginError(ModelMap model){
		
		
		model.addAttribute("error","true");
		return "login";
	}


	
	
	//admin
	@RequestMapping(value="/adminLogin")
	public  String viewadminLoginPage(Model model){
		model.addAttribute("logindetails",new StudentsForm());
		return "adminLogin";
		
	}
	
	
	//loging in 
	
	@RequestMapping("login")
	public String login(@ModelAttribute("logindetails") StudentsForm logindetails,Model model,@ModelAttribute("studentsForm") StudentsForm studentdetails){
		//checking if username is not empty
		
		if(logindetails.getUsername()=="123"){
			model.addAttribute("error","Please insert user name");
			return "StudentForm";
			
		}
		
		
			return "StudentForm";
	
		
		
	}
	
	//method for viewing the student Form 
	@RequestMapping("StudentForm")
	
	public String getstudentform(Model model){
		StudentsForm studentsForm=new StudentsForm();
		model.addAttribute("studentsForm",studentsForm);

		return  "StudentForm";
		
	}
	
	
	//Method for inserting the details to the database
	
	
	@RequestMapping(value="/saveStudentDetailsCon",method=RequestMethod.POST)
	public  String saveStudentDetailsByAdminCon(HttpServletRequest servletRequest,@Valid StudentsForm studentsForm,BindingResult bindingResult){
		
		
	
			
			
			//getting the uploaded images and putting them in a list of multipart file
			List <MultipartFile>files=studentsForm.getImages();
			
			//A list to contain all the file names
			List<String>fileNames=new ArrayList<String>();
			//checking whether we have images in files List
			
			if(null!=files&&files.size()>0){
				
				//get all the images and put them to the multipart file
				for(MultipartFile multipartFile:files){
					
					//getting the image name
					String fileName=multipartFile.getOriginalFilename();
					//putting the image name to the setter
					studentsForm.setImageLink(fileName);
					//adding all the names to the list
					fileNames.add(fileName);
					//stroring the images to the server
					
					File imagefile=new File(servletRequest.getServletContext().getRealPath("/resources/image"),fileName);
					try{
						multipartFile.transferTo(imagefile);
					}
					catch(IOException e){
						e.printStackTrace();
					}
					
					
					
				}
				
			}
			
				dao.saveFormerStudentDetails(studentsForm);
	
			
	
			    return "redirect:FormerStudentDetailsView"; 
			    
		
			    
	}
	
	
	//method for viewing the former student details
	@RequestMapping("FormerStudentDetailsView")
	public ModelAndView viewFormerStudenrDetails(Model model){
		
		model.addAttribute("studentsForm",new StudentsForm());
		List <StudentsForm>list=dao.getStudentDetails();
		
		
		return new ModelAndView ("FormerStudentDetailsView","list",list);
		
	}
	
	

	//viewing the admin page 
	@RequestMapping("admin")
	
	
	public ModelAndView viewAdminPage(){
		
		return new ModelAndView("admin");
	}
	
	
	
	
	//Send messages 
	
	@RequestMapping("sendMessageView")
	public ModelAndView sendMessageView(){
		List <StudentsForm>list=dao.getStudentDetails();
		
		return new ModelAndView("sendMessageView","list",list);
	}
	
	
	//Send Email view
	
		@RequestMapping("sendEmailView")
		public ModelAndView sendEmailView(Model model){
			model.addAttribute("studentsemailmodel",new StudentsForm());
			List <StudentsForm>list=dao.getStudentDetails();
			
			return new ModelAndView("sendEmailView","list",list);
		}
		
		//Calling the former students Edit view  
		
		@RequestMapping(value="/editformerstudent/{id}")
		
		public ModelAndView editFormerStudent(@PathVariable int id){
			
			StudentsForm  studentsform=dao.getStudentById(id);
			
			return new ModelAndView("editFormerStudentForm","command",studentsform);
			
		}
		
		//saving after editing the fomer student
	
		
	
		
		
		//method for deleting the former student
		@RequestMapping(value="/deleteformerstudent/{id}",method=RequestMethod.GET)
		
		public ModelAndView delete(@PathVariable int id){
			
			dao.delete(id);
		
			return new ModelAndView("redirect:/FormerStudentDetailsView");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

}
