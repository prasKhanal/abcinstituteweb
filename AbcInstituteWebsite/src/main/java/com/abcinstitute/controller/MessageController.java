package com.abcinstitute.controller;

import java.security.Principal;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.abcinstitute.beans.Message;
import com.abcinstitute.service.MessageService;
import com.abcinstitute.service.SubjectService;
import com.abcinstitute.service.UserService;

/**
 * @author pras_khanal
 *
 */
@Controller
public class MessageController {
	private SubjectService subjectService;
	private UserService userService;
	private MessageService messageService;
	@Autowired
	public void setMessageService(MessageService messageService){
		this.messageService=messageService;
	}
    @Autowired
    public void setUserService(UserService userService){
    	this.userService=userService;
    }
    @Autowired
	public void setSubjectService(SubjectService subjectService){
		this.subjectService=subjectService;
	}

	@RequestMapping(value="/postMessage",method=RequestMethod.GET)
	public String postMessage(ModelMap model, Principal principal){
		model.addAttribute("role", userService.getUserRole(principal.getName()));
		 model.addAttribute("principleUser", userService.getUserFirstName(principal.getName()));
		 model.addAttribute("message",new Message());
		 model.addAttribute("subjectList", subjectService.getAssignedSubjectList(Integer.parseInt(principal.getName())));
		return "postMessage";
	} 
	@RequestMapping(value="/postMessage",method=RequestMethod.POST)
	public String postMessage(@Valid Message message, Principal principal, 
	                                 BindingResult bindingResult,ModelMap model){
		model.addAttribute("role", userService.getUserRole(principal.getName()));
		 model.addAttribute("principleUser", userService.getUserFirstName(principal.getName()));
		 if(bindingResult.hasErrors()) { 
	    return "postMessage";
	  }
	  else
		  
	  return "confirmPostMessage"; 
	}
	
	@RequestMapping(value="/postMessageConfirm",method=RequestMethod.POST)
	public String postMessageConfirm(ModelMap model,Message message, Principal principal){
		model.addAttribute("role", userService.getUserRole(principal.getName()));
		 model.addAttribute("principleUser", userService.getUserFirstName(principal.getName()));
		 model.addAttribute("message",message);
		messageService.addMessage(message);
		return "Welcome";
	} 
	@RequestMapping(value="/subject/message/{subject}",method=RequestMethod.GET)
	public String showMessage( ModelMap model,@PathVariable("subject") String subject, Principal principal ){ 
		model.addAttribute("role", userService.getUserRole(principal.getName()));
		 model.addAttribute("principleUser", userService.getUserFirstName(principal.getName()));
		 model.addAttribute("message", messageService.getMessage(subject));
	    return "showMessage";
	  }
	
}