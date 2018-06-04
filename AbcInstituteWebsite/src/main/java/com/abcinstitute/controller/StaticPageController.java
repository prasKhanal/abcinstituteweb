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

import com.abcinstitute.service.UserService;

/**
 * @author pras_khanal
 *
 */
@Controller
public class StaticPageController {
	
	private UserService userService;
    @Autowired
    public void setUserService(UserService userService){
    	this.userService=userService;
    }
	
	@RequestMapping(value="/welcomeHome", method = RequestMethod.GET)
	public String welcomeHome() {
		return "welcomeHome";
 
	}
	@RequestMapping(value="/courseDetail", method = RequestMethod.GET)
	public String welcomer(ModelMap model,Principal principal) {
		
		return "courseDetail";
 
	
	}
	@RequestMapping(value="/aboutUs", method = RequestMethod.GET)
	public String aboutUs(ModelMap model,Principal principal) {
		if(principal!=null)
			 model.addAttribute("principleUser", userService.getUserFirstName(principal.getName()));
		return "aboutus";
 
	}
	@RequestMapping(value="/contactUs", method = RequestMethod.GET)
	public String contactUs(ModelMap model,Principal principal) {
		if(principal!=null)
		 model.addAttribute("principleUser", userService.getUserFirstName(principal.getName()));

		return "contactUs";
 
	}

}
