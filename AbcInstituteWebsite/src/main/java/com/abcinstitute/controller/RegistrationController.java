/**
 * 
 */
package com.abcinstitute.controller;

import java.security.Principal;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.abcinstitute.beans.User;
import com.abcinstitute.service.UserService;

/**
 * @author pras_khanal
 *
 */
@Controller
public class RegistrationController {
    private UserService userService;
    @Autowired
    public void setUserService(UserService userService){
    	this.userService=userService;
    
    } 
	@RequestMapping(value="/RegisterUser", method = RequestMethod.GET)
	public String register(ModelMap model,Principal principal) {
		model.addAttribute("role", userService.getUserRole(principal.getName()));
		 model.addAttribute("principleUser", userService.getUserFirstName(principal.getName()));
		 model.addAttribute("user", new User());
		model.addAttribute("title","Register User");
		return "RegisterUser";
 
	}
	
	@RequestMapping(value="/RegisterUser",method=RequestMethod.POST)
	public String addForm(@Valid User user, 
	                                 BindingResult bindingResult,Principal principal,ModelMap model) {
		model.addAttribute("role", userService.getUserRole(principal.getName()));
		 model.addAttribute("principleUser", userService.getUserFirstName(principal.getName()));
		model.addAttribute("title","Register User");
	  if(bindingResult.hasErrors()) { 
	    return "RegisterUser";
	  }
	  else{
		  return "RegisterConfirm"; 
	  }
	}
	@RequestMapping(value="/confirmRegister", method = RequestMethod.POST)
	public String registerConfirm(ModelMap model,User user, @RequestParam(required=false , value = "Confirm")String action,Principal principal) {
		model.addAttribute("title","Register User");
		model.addAttribute("role", userService.getUserRole(principal.getName()));
		 model.addAttribute("principleUser", userService.getUserFirstName(principal.getName()));
		if( action!=null){
	  //newly generated id from database
		int id=	userService.addUsertoDatabase(user);
	  //if id value is zero than no principleUser has been created in database due to
		//duplicate principleUser presence
		if(id!=0){
      model.addAttribute("id",id);
		return "crediantialPage";
		}
		else{
			 model.addAttribute("duplicateUser","User is already in database.");
			 return "RegisterConfirm";
		}
		}
		else
			{
			return "RegisterUser"; 
			}
 
	}

}
