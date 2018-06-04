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

import com.abcinstitute.beans.Password;
import com.abcinstitute.beans.User;
import com.abcinstitute.service.UserService;

/**
 * @author pras_khanal
 *
 */
@Controller
public class EditUserDetailController {
	private UserService userService;
    @Autowired
    public void setUserService(UserService userService){
    	this.userService=userService;
    }
	@RequestMapping(value="/EditDetail", method = RequestMethod.GET)
	public String editDetail( ModelMap model, Principal principal){
		model.addAttribute("role", userService.getUserRole(principal.getName()));
		 model.addAttribute("principleUser", userService.getUserFirstName(principal.getName()));	
model.addAttribute("user",userService.getUserWithAddress(principal.getName()));
		return "EditUserDetail";
	}
	@RequestMapping(value="/EditDetail",method=RequestMethod.POST)
	public String ConfirmEditDetail(@Valid User tempUser, 
            BindingResult bindingResult,Principal principal,ModelMap model) {
		model.addAttribute("role", userService.getUserRole(principal.getName()));
		 model.addAttribute("principleUser", userService.getUserFirstName(principal.getName()));		
		 if(bindingResult.hasErrors()) { 
			return "EditUserDetail";
			}
		else{
		return "EditUserDetailConfirm"; 
		}
}
	@RequestMapping(value="/EditUserDetailConfirm",method=RequestMethod.POST)
	public String  EditUserDetailConfirm(User tempUser, ModelMap model,Principal principal){
		model.addAttribute("role", userService.getUserRole(principal.getName()));
		 model.addAttribute("principleUser", userService.getUserFirstName(principal.getName()));
		 model.addAttribute("tempUser",tempUser);
		 userService.editUserDetail(tempUser);
		 return"EditUserDetailChanged";
	}
	@RequestMapping(value="/changePassword",method=RequestMethod.GET)
	public String changepasswords( Password password,ModelMap model ,Principal principal){ 
		model.addAttribute("role", userService.getUserRole(principal.getName()));
		model.addAttribute("principleUser", userService.getUserFirstName(principal.getName()));	 
		return "changePassword";
	  }
	@RequestMapping(value="/changePassword",method=RequestMethod.POST)
	public String changepassword(@Valid Password password, 
	                                 BindingResult bindingResult,ModelMap model,Principal principal){
		model.addAttribute("role", userService.getUserRole(principal.getName()));
		model.addAttribute("principleUser", userService.getUserFirstName(principal.getName()));
	  if(bindingResult.hasErrors()) { 
	    return "changePassword";
	  }
	  else
	  userService.changePassword(password,Integer.parseInt(principal.getName()));
	  return "Welcome"; 
	}
}
