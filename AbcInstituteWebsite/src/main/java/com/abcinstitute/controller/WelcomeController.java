package com.abcinstitute.controller;
///**
// * 
// */
//package com.app.Controller;
//
//import java.security.Principal;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import com.app.Database.NamedJdbcTemplateDao;
//import com.app.beans.Password;
//import com.app.beans.User;
//import com.app.service.UserService;
//
///**
// * @author pras_khanal
// *
// */
//@Controller
//public class WelcomeController {
//	
//	@Autowired
//	protected UserService userService;
//
//	@RequestMapping(value="/welcome", method = RequestMethod.GET)
//	public String printWelcome(ModelMap model, Principal principal,SecurityContextHolderAwareRequestWrapper request ) {
//		userService.user = namedJdbcTemplateDao.getUser(Integer.parseInt( principal.getName()));
//		
//		
//		if(request.isUserInRole("ROLE_ADMIN"))principleUser.setUserRole("ROLE_ADMIN");
//		if(request.isUserInRole("ROLE_STUDENT"))principleUser.setUserRole("ROLE_STUDENT");
//		if(request.isUserInRole("ROLE_TEACHER"))principleUser.setUserRole("ROLE_TEACHER");
//		
//		
//		if(request.isUserInRole("ROLE_ADMIN"))principleUser.setSubjectList(namedJdbcTemplateDao.generateSubjectList());
//		if(!namedJdbcTemplateDao.isDefaultPassword(Integer.parseInt((principal.getName())))){
//		model.addAttribute("principleUser", principleUser);
//		return "Welcome";}
//		else{
//			model.addAttribute("password", new Password());
//			return "changePassword";
//		}
// 
//	}
//	
//
//}
