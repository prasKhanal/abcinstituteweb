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
import org.springframework.web.bind.annotation.RequestParam;

import com.abcinstitute.beans.Subject;
import com.abcinstitute.service.MessageService;
import com.abcinstitute.service.ResourceService;
import com.abcinstitute.service.SubjectService;
import com.abcinstitute.service.UserService;
@Controller
public class SubjectController {
    private MessageService messageService;
	private UserService userService;
	private SubjectService subjectService;
	private ResourceService resourceService;
	@Autowired
	public void setResourceService(ResourceService resourceService){
		this.resourceService=resourceService;
	}
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

	@RequestMapping(value="/addSubject",method=RequestMethod.GET)
	public String addsubject(ModelMap model, Principal principal){  
		model.addAttribute("role", userService.getUserRole(principal.getName()));
		 model.addAttribute("principleUser", userService.getUserFirstName(principal.getName()));
		 model.addAttribute("subject", new Subject());
	    return "addSubject";
	  }
	@RequestMapping(value="/addSubject",method=RequestMethod.POST)
	public String addSubject(@Valid Subject subject, 
	                                 BindingResult bindingResult,ModelMap model, Principal principal) {
		model.addAttribute("role", userService.getUserRole(principal.getName()));
		 model.addAttribute("principleUser", userService.getUserFirstName(principal.getName()));
	  if(bindingResult.hasErrors()) { 
	    return "addSubject";
	  }
	  else{
		  return "addSubjectConfirm"; 
	  }
	}
	@RequestMapping(value="/addSubjectConfirm", method = RequestMethod.POST)
	public String addsubject(ModelMap model,Subject subject, @RequestParam(required=false, 
	value = "Confirm")String action, Principal principal) {
		if( action!=null){
			int subjectcode= subjectService.addSubjecttoDatabase(subject);
			if(subjectcode!=0){
				subject.setSubjectType((subject.getSubjectType()+subjectcode));
				model.addAttribute("subject",subject);
				model.addAttribute("role", userService.getUserRole(principal.getName()));
				 model.addAttribute("principleUser", userService.getUserFirstName(principal.getName()));
				 return "newSubject";
			}
			else{
				model.addAttribute("err","Subject already in the database");
				return "addSubjectConfirm";
			}
			}
		else
		     return "addSubject"; 
		}
  /**
   * 
   * @param model
   * @param principal
   * @return
   */
	@RequestMapping(value="/editSubjectDescription",method=RequestMethod.GET)
	public String editSubjectDescription(ModelMap model, Principal principal){
		model.addAttribute("role", userService.getUserRole(principal.getName()));
		 model.addAttribute("principleUser", userService.getUserFirstName(principal.getName()));
		 model.addAttribute("subject",new Subject());
		model.addAttribute("tempSubject",new Subject());
		return "editSubjectDescription";
	} 
	@RequestMapping(value="/extractSubjectDescription",method=RequestMethod.POST)
	public String extractSubjectDescription(ModelMap model,Subject tempSubject, Principal principal){
		model.addAttribute("role", userService.getUserRole(principal.getName()));
		 model.addAttribute("principleUser", userService.getUserFirstName(principal.getName()));
		 model.addAttribute("subject",subjectService.getSubject(tempSubject.getSubjectType()));
		model.addAttribute("tempSubject",tempSubject);
		return "editSubjectDescription";
	} 
	@RequestMapping(value="/editSubjectDescriptionConfirm",method=RequestMethod.POST)
	public String editSubjectDescriptionConfirm(ModelMap model,Subject tempSubject, Principal principal){
		model.addAttribute("role", userService.getUserRole(principal.getName()));
		 model.addAttribute("principleUser", userService.getUserFirstName(principal.getName()));
		 model.addAttribute("tempSubject",tempSubject);
		return "editSubjectDescriptionConfirm";
	} 
	@RequestMapping(value="/editSubjectConfirm",method=RequestMethod.POST)
	public String editSubjectConfirm(ModelMap model,Subject tempSubject, @RequestParam String action, Principal principal){
		model.addAttribute("role", userService.getUserRole(principal.getName()));
		 model.addAttribute("principleUser", userService.getUserFirstName(principal.getName()));
		 model.addAttribute("tempSubject",tempSubject);
		if(action.equals("Confirm")){
			subjectService.editSubject(tempSubject);
			return "subjectEdited";
		}
		else{
			return "editSubjectDescription";
		}
	} 
	@RequestMapping(value="/subject/{subjectType}",method=RequestMethod.GET)
	public String assignSubjectList( ModelMap model,@PathVariable("subjectType") String subjectType,Principal principal){ 
		model.addAttribute("role", userService.getUserRole(principal.getName()));
		 model.addAttribute("principleUser", userService.getUserFirstName(principal.getName()));
		 Subject subject=subjectService.getSubject(subjectType);
		 subject.setMessageList(messageService.getSubjectMessageList(subject.getSubjectType()));
		 subject.setResourceList(resourceService.getResouresList(subject.getSubjectType()));
		 model.addAttribute("subject",subject);
	    return "showSubjectDescription";
	  }

}
