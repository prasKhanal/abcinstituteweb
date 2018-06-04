/**
 * 
 */
package com.abcinstitute.controller;


import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.abcinstitute.beans.Password;
import com.abcinstitute.service.UserService;

/**
 * @author pras_khanal
 *
 */
@Controller
public class LoginController {
	 private UserService userService;
	 
	    @Autowired
	    public void setUserService(UserService userService){
	    	this.userService=userService;
	    }
	
	@RequestMapping(value={"/welcome","/Welcome"}, method = RequestMethod.GET)
	public String printWelcome(ModelMap model, Principal principal) {
		model.addAttribute("role", userService.getUserRole(principal.getName()));
		 model.addAttribute("principleUser", userService.getUserFirstName(principal.getName()));
		model.addAttribute("subjectList", userService.generateSubjectList(principal.getName()));
		if(!userService.isDefaultPassword(Integer.parseInt((principal.getName())))){
		return "Welcome";
		}
		else{
			model.addAttribute("password", new Password());
			return "changePassword";
		}
	}
	
	@RequestMapping(value={"/","","/home"}, method = RequestMethod.GET)
	public String home(ModelMap model,Principal principal) {
		if(principal!=null)
		return "redirect:/welcome";
		
		return "home";
	}
	
	@RequestMapping(value="/loginfailed", method = RequestMethod.GET)
	public String loginerror(ModelMap model) {
		model.addAttribute("error", "true");
		return "home";
 
	}
	@RequestMapping(value="/noAuthority", method = RequestMethod.GET)
	public String noAuthority(ModelMap model,Principal principal) {
		 model.addAttribute("principleUser", userService.getUserFirstName(principal.getName()));
		return "noAuthority";
 
	}
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(ModelMap model) {
		return "home";
 
	}

}
