package com.convocation.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.convocation.bean.MessagesBean;
import com.convocation.bean.StudentsForm;
import com.convocation.dao.MessagesDao;
import com.convocation.dao.StudentsFormDao;


@Controller

public class MessagesController {
	
	
	@Autowired
	MessagesDao mdao;
	
	
	//viewing the form for sending thed messages
	
	@RequestMapping("sendMessagesViewByAdmin")
	
	public String sendMessagesViewByAdmin(@ModelAttribute("messagesbean") MessagesBean messagesbean){
		
		
	return "sendMessagesViewByAdmin";
		
	}
	
	//saving the message and the message heading to the two different databases
	
	@RequestMapping("saveMessagesByAdmin")
	
	public String saveMessagesByAdmin(@Valid @ModelAttribute("messagesbean") MessagesBean messagesbean,BindingResult bindingResult,Model model){
	

		
		
    mdao.saveMessageAndHeading(messagesbean);
	model.addAttribute("messagesent","Message sent successfully........");
	return "admin";
		
	}
	
	
	
	
	//returning the list of headings basing on the latest
	
	@RequestMapping("headingsView")
	
	public ModelAndView viewHeadingsList(MessagesBean headings){
		
		
		List<MessagesBean>list=mdao.getMessageHeadingDetails();

		return new ModelAndView("headingsView","list",list);
	}
	
	
	
	//getting the headings  by id and returning the value
	@RequestMapping(value="/headingsid/{id}")
	
	public ModelAndView viewMessagesAdmin(@PathVariable int id,Model model){
		
		MessagesBean messages=mdao.getMessagesAndMessageHeadings(id);
		model.addAttribute("messages",messages);
		
		return new ModelAndView("messagesView");
		
	}
	
	
	//returning the list of headings basing on the latest by student
	
		@RequestMapping("headingsViewByStudent")
		
		public ModelAndView viewHeadingsListBystudent(MessagesBean headings){
			
			
			List<MessagesBean>list=mdao.getMessageHeadingDetails();

			return new ModelAndView("headingsViewByStudent","list",list);
		}
	
		
		
		
		//getting the headings  by id and returning the value by student
		@RequestMapping(value="/headingsidbystudent/{id}")
		
		public ModelAndView viewMessagesByStudent(@PathVariable int id,Model model){
			
			MessagesBean messages=mdao.getMessagesAndMessageHeadings(id);
			model.addAttribute("messages",messages);
			
			return new ModelAndView("messagesViewByStudent");
			
		}
	//-----------------------------------Handling the notices-------------------------------------------------
	
	
	
	
	//viewing the form for sending thed messages
	
	@RequestMapping("noticeBoard")
	
	public ModelAndView noticeBoard(@ModelAttribute("messagesbean") MessagesBean messagesbean){
		
		
	return new ModelAndView("noticeBoard");
		
	}
	
	//saving notices by admin
	
	@RequestMapping("saveNoticesByAdmin")
	
	public ModelAndView saveNoticesByAdmin(@Valid @ModelAttribute("messagesbean") MessagesBean messagesbean,BindingResult bindingResult,Model model){
		
	
	
	mdao.saveNotices(messagesbean);
	model.addAttribute("messagesent","Notice  sent successfully........");
	return new ModelAndView("admin");
		
	}
	
	
	//viewing notices by the admin 
	
@RequestMapping("noticesView")
	
	public ModelAndView viewNoticesList(MessagesBean headings){
		
		
		List<MessagesBean>list=mdao.getNotices();

		return new ModelAndView("noticesView","list",list);
	}
	
	
	

}
