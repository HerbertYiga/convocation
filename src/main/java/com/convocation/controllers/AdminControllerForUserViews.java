package com.convocation.controllers;

import java.io.File

;







import java.io.IOException;
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
import com.convocation.bean.StudentsForm;
import com.convocation.bean.Test;
import com.convocation.dao.StudentsFormDao;



@Controller

public class AdminControllerForUserViews {
	@Autowired
	StudentsFormDao dao;
	@Autowired
	private JavaMailSender mailSender;
	

	
	

	
	//submiting details by the student
	
	@RequestMapping("adminsaveStudentDetailsbyStudent")
	public String saveStudentDetailsByStudent(HttpServletRequest servletRequest,@Valid @ModelAttribute("addstudentdetailsbyuser") StudentsForm studentsForm,BindingResult bindingResult,Model model){
		
	
		
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

		

		    return "AfterDetailsSubmissionByStudentAdmin"; 
		
		
	}
	
	
	//add student details by the user
	@RequestMapping("adminaddDetailsByStudent")
	public String addDetailsByStudent(@ModelAttribute("addstudentdetailsbyuser") StudentsForm studentsform){
		
		return "addDetailsByAdmin";
		
		
		
	}
	
	
     //download excel  
	
	@RequestMapping(value="/admindownloadExcel",method=RequestMethod.GET)
	
	public ModelAndView downloadExcel(){
	
		
		List <StudentsForm> list=dao.getStudentDetails();
		
		return new ModelAndView("excelView","list",list);
		
		
	}

	

	
	
	//Email send form view 
	
		@RequestMapping(value="sendEmailFormAdmin/{id}",method=RequestMethod.GET)
		public ModelAndView  viewSendEmailView(Model model,Model model2,StudentsForm studentform,@PathVariable int id){
			
			
		    //adding the  students form details  to the form 
			
            StudentsForm studentsform2=new StudentsForm();
			model.addAttribute("studentsform2",studentsform2);
			
			StudentsForm studentsemail=dao.getStudentById(studentform.getId());
			model2.addAttribute("studentsemail",studentsemail);
			
			
			return new ModelAndView("sendEmailFormAdmin","command",new StudentsForm());
		}
		
	
	
	
	//sending a message
	@RequestMapping("/adminsendEmail")
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
        
        
        
		
		
		return "EmailSentSuccesFullyAdmin";
		
		
		
	}
	//selecting students according to there regNo so as to send one by one an email
	
	@RequestMapping("adminEmailRegno")
	public String EmailByRegNo(StudentsForm studentsform,Model model){
		if((dao.getStudentByRegNo(studentsform.getRegNo()))!=null){
		
		StudentsForm studentsformbyregno=dao.getStudentByRegNo(studentsform.getRegNo());
		model.addAttribute("studentsformbyregnoformail",studentsformbyregno);
		
		return "sendEmailToIndividualAdmin";}
		else{
			
			return "cantFindRegNoDetailsForEmailingAdmin";
		}
		
		
	}
	
	
	//selcting the student details basing on the students regNo so as to delete them
	
	@RequestMapping("admindeleteByRegno")
	public String deleteByRegNo(StudentsForm studentsform,Model model){
		if((dao.getStudentByRegNo(studentsform.getRegNo()))!=null){
		
		StudentsForm studentsformbyregno=dao.getStudentByRegNo(studentsform.getRegNo());
		model.addAttribute("studentsformbyregno",studentsformbyregno);
		
		return "admindeleteByRegno";}
		else{
			
			return "cantFindRegNoDetailsAdmin";
		}
		
		
	}
	

	//deleting the selected users from the database
	
	@RequestMapping("admindeleteslectedstudents")
	public String deleteSelectedStudents(StudentsForm studentsform,Model model){
		
		if(studentsform.getCheckid()==null){
			model.addAttribute("selectcheckbox","please make sure you have selected a check box");
			
			model.addAttribute("FormerStudentDetailsViewAdmin");
			
			return "";
			
			
		}
		
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
		
		return "redirect:FormerStudentDetailsViewAdmin";
		
		
		
	}
	
	
	//geting and returning all the selected emails
	
	@RequestMapping("adminemailaccountstobesenttointhereform")
	public String getSelectedEmails(StudentsForm studentsform,Model model,Model model2){
		
		//capture info in the array
		int [] userid=studentsform.getCheckid();
		
		
		
		  //putting the ids in a for loop
		
			 //out puting the inserted ids from the for loop
			
				
		//getting the elements into a list
		List<StudentsForm> list=dao.getStudentDetails();
		
	
		
			 
		//adding the list to a model
		
		
		model.addAttribute("list",list);
		
		
		
		
		
		model2.addAttribute("sendemailform",new StudentsForm());

		  
		 
		
			
		
			
		
	
			
			
		
		
		
		
		
		return "emailaccountstobesenttointhereformAdmin";
		
		
		
	}
	
	
	
	
	//method for viewing the student Form 
	@RequestMapping("StudentFormAdmin")
	
	public String getstudentform(Model model){
		StudentsForm studentsForm=new StudentsForm();
		model.addAttribute("studentsForm",studentsForm);

		return  "StudentFormAdmin";
		
	}
	
	
	//Method for inserting the details to the database
	
	
	@RequestMapping(value="/adminsaveStudentDetailsCon",method=RequestMethod.POST)
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
	
			
	
			    return "redirect:FormerStudentDetailsViewAdmin"; 
			    
		
			    
	}
	
	
	//method for viewing the former student details
	@RequestMapping("FormerStudentDetailsViewAdmin")
	public ModelAndView viewFormerStudenrDetails(Model model){
		     
		model.addAttribute("studentsForm",new StudentsForm());
		List <StudentsForm>list=dao.getStudentDetails();
		
		
		return new ModelAndView ("FormerStudentDetailsViewAdmin","list",list);
		
	}
	
	

	
	
	//Send messages 
	
	@RequestMapping("sendMessageViewAdmin")
	public ModelAndView sendMessageView(){
		List <StudentsForm>list=dao.getStudentDetails();
		
		return new ModelAndView("sendMessageViewAdmin","list",list);
	}
	
	
	//Send Email view
	
		@RequestMapping("sendEmailViewAdmin")
		public ModelAndView sendEmailView(Model model){
			model.addAttribute("studentsemailmodel",new StudentsForm());
			List <StudentsForm>list=dao.getStudentDetails();
			
			return new ModelAndView("sendEmailViewAdmin","list",list);
		}
		
		
		
		
		
		//Calling the former students Edit view  
		
		@RequestMapping(value="/admineditformerstudent/{id}")
		
		public ModelAndView editFormerStudent(@PathVariable int id){
			
			StudentsForm  studentsform=dao.getStudentById(id);
			
			return new ModelAndView("editFormerStudentFormAdmin","command",studentsform);
			
		}
		
		//saving after editing the fomer student
	
		
	
		
		
		//method for deleting the former student
		@RequestMapping(value="/admindeleteformerstudent/{id}",method=RequestMethod.GET)
		
		public ModelAndView delete(@PathVariable int id){
			
			dao.delete(id);
		
			return new ModelAndView("redirect:/FormerStudentDetailsViewAdmin");
		}
		
		
		
		
		
		
		
		
		
		      
		
		
		
		  //view messages
				@RequestMapping("viewAndReplyMessages")
				public ModelAndView viewMessages(){
					
					
					return new ModelAndView("viewAndReplyMessages");
				}
		
				
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

}
