package com.convocation.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.convocation.bean.StudentsForm;
import com.convocation.bean.User;
import com.convocation.dao.UserDao;




@Controller
public class UserContoller {
	
	
	@Autowired
	UserDao userdao;
	
	//page for adding the user
	@RequestMapping("adduser")
	public ModelAndView addUser(@ModelAttribute("adduser") User adduser){
		
		return new ModelAndView("addUser");
	}
	
	
      //login page 
	  @RequestMapping(value = "/login", method = RequestMethod.GET)
	    public String login(ModelMap model,@ModelAttribute("logindetails") User studentdetails) {
	 
	        return "login";
	 
	    }
	
	
	
	//saving the user details
	@RequestMapping("saveuserdetails")
	public ModelAndView addUser(@Valid @ModelAttribute("adduser") User userdetails,BindingResult bindingresult,Model model){
		
		
		if(bindingresult.hasErrors()){
			
			return new ModelAndView("addUser");
		}
		//checking whether the passwords are no equal
		if(!(userdetails.getPassword().equals(userdetails.getPassword2()))){
			
			model.addAttribute("error","Make sure the passwords correspond!!");
			return new ModelAndView("addUser");
		}
		
		//saving the user details to the database
		userdao.saveFormerStudentDetails(userdetails);
		//model for returning message for successful installation
		model.addAttribute("saveusermessage","user details submitted successfully........");
		
		return new ModelAndView("admin");
	}
	
	
	
	//viewing the users in a list
	   
	  @RequestMapping("UsersView")
	  public ModelAndView viewUsers(){
		  
		  
		  List<User>list=userdao.getUserDetails();
		  
		  return new ModelAndView("UsersView","list",list);
	  }
	
	   //calling the form for deleting the user details from the data base
	  
	  @RequestMapping("DeleteUserDetails")
	  public ModelAndView DeleteUserDetails(){
		  
		  
		  List<User>list=userdao.getUserDetails();
		  
		  return new ModelAndView("DeleteUserDetails","list",list);
	  }
	  
	  
	  
		//deleting all the user details from the users and users_roles taable
		@RequestMapping(value="/deleteuserdetails/{id}",method=RequestMethod.GET)
		
		public ModelAndView delete(@PathVariable int id){
			
			userdao.delete(id);
		
			return new ModelAndView("redirect:/DeleteUserDetails");
		}
		
		
		//getting the user details from the users and users_roles databases by id for editing
		@RequestMapping(value="/edituserdetails/{id}",method=RequestMethod.GET)
		
		public ModelAndView editUserDetails(@PathVariable int id,@ModelAttribute("edituser") User edituser,Model model){
			
			User user=userdao.getUserById(id);
		   model.addAttribute("user",user);
		
			return new ModelAndView("editUserDetails");
		}
		
		//updating the user details
		
		
		@RequestMapping(value="updateuser")
		public ModelAndView updateUserDetails(User userdetails){
			userdao. update(userdetails);

			return new ModelAndView("redirect:/DeleteUserDetails");
			
			
			
		}
		
		
		//editing the user password
		
		
		 @RequestMapping("editUserPassword")
		  public ModelAndView editUserDetails(){
			  
			  
			  List<User>list=userdao.getUserDetails();
			  
			  return new ModelAndView("editUserPassword","list",list);
		  }
		 
		 
		 //geting the password by id
		  
         @RequestMapping(value="/changeuserpassword/{id}",method=RequestMethod.GET)
		
		public ModelAndView editUserPassword(@PathVariable int id,@ModelAttribute("edituserpassword") User changeuserpassoword,Model model){
			
			User user=userdao.getUserById(id);
		   model.addAttribute("user",user);
		
			return new ModelAndView("ChangeUserPasswordForm");
		}
		
       //updating the user password
 		
 		
 		@RequestMapping(value="updatepassword")
 		public ModelAndView updateUserPassword(@ModelAttribute("edituserpassword") User userdetails,Model model){
 			//checking whether the passwords are no equal
 			if(!(userdetails.getPassword().equals(userdetails.getPassword2()))){
 				
 				model.addAttribute("error","Make sure the passwords correspond!!");
 				return new ModelAndView("ChangeUserPasswordForm");
 			}
 			userdao.updatePassword(userdetails);

 			return new ModelAndView("redirect:/DeleteUserDetails");
 			
 			
 			
 		}
 		
		
		
	
	

}