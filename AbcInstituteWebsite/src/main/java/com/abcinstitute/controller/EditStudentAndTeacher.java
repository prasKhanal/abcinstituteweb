/**
 * 
 */
package com.abcinstitute.controller;

import java.beans.PropertyEditorSupport;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.abcinstitute.beans.Subject;
import com.abcinstitute.beans.User;
import com.abcinstitute.service.AddressService;
import com.abcinstitute.service.SubjectService;
import com.abcinstitute.service.UserService;

/**
 * @author pras_khanal
 *
 */
@Controller
public class EditStudentAndTeacher {
	private AddressService addressService;
	private SubjectService subjectService;
	private UserService userService;
	@Autowired
	public void setAddressService(AddressService addressService){
		this.addressService=addressService;
	}
    @Autowired
    public void setUserService(UserService userService){
    	this.userService=userService;
    }
    @Autowired
	public void setSubjectService(SubjectService subjectService){
		this.subjectService=subjectService;
	}

	@RequestMapping(value="/EditStudentOrTeacher",method=RequestMethod.GET)
	public String editUser(ModelMap model, Principal principal){  		
		model.addAttribute("role", userService.getUserRole(principal.getName()));
		 model.addAttribute("principleUser", userService.getUserFirstName(principal.getName()));
		model.addAttribute("user",new User());

	    return "EditStudentOrTeacher";
	  }
	@RequestMapping(value="/EditStudentOrTeacher",method=RequestMethod.POST)
	public String editUser2(ModelMap model,User user,@RequestParam String action,Principal principal){  		
		model.addAttribute("role", userService.getUserRole(principal.getName()));
		 model.addAttribute("principleUser", userService.getUserFirstName(principal.getName()));
	
		if(action.equals("ExtractUser")){
			user=userService.getUser(user.getUserId());
			user.setAddress(addressService.getAddress(user.getUserId()));
			user.setUserRole(userService.checkRole(user.getUserId()));
			user.setSubjectList(userService.generateSubjectList(user.getUserId()));
			if(user!=null &&!userService.checkRole(user.getUserId()).equals("ROLE_ADMIN")){
				model.addAttribute("user",user);
				return "EditStudentOrTeacher";	
			}
			else {
				model.addAttribute("err","No Such User Available");
				model.addAttribute("user",new User());
				return "EditStudentOrTeacher";
			
			}
			}
		if(action.equals("Edit Detail")){
			if(user.getUserId()>0){
			model.addAttribute("user",user);
			return "EditUserDetail";
			}
			}
		if(action.equals("Assign")){
			if(user.getUserId()>0){
				model.addAttribute("user",user);
				if(userService.checkRole(user.getUserId()).equals("ROLE_TEACHER")){
					model.addAttribute("subjectList",subjectService.generateUnassignedSubjectList());
				}
				else
				model.addAttribute("subjectList",subjectService.generateAllSubjectList());
				return "assignSubjectList";
				}
				}
		if(action.equals("Edit")){
			user=userService.getUser(user.getUserId());
			model.addAttribute("user",user);
			if(user.getSubjectList().size()!=0){
			model.addAttribute("subjectList",user.getSubjectList());
			return "editSubjectList";
			}
			else{
				model.addAttribute("err","No User SubjectList Avialiable");
				return "EditStudentOrTeacher";
			}
		}
		model.addAttribute("err","Please Enter Valid User Id");
		model.addAttribute("user",new User());
		return "EditStudentOrTeacher";
		}
	@RequestMapping(value="/editSubjectList",method=RequestMethod.POST)
	public String editSubjectList(ModelMap model,User user,Principal principal){
		model.addAttribute("role", userService.getUserRole(principal.getName()));
		 model.addAttribute("principleUser", userService.getUserFirstName(principal.getName()));
		userService.editSubjectofUser(user);
		user=userService.getUser(user.getUserId());
		return "assignSubjectListCommit";
	} 
	@RequestMapping(value="/assignSubjectList",method=RequestMethod.POST)
	public String assignSubjectList(ModelMap model,User user,Principal principal){
		model.addAttribute("role", userService.getUserRole(principal.getName()));
		 model.addAttribute("principleUser", userService.getUserFirstName(principal.getName()));
		model.addAttribute("subjectList",user.getSubjectList());
		model.addAttribute("user",user);
		return "assignSubjectListConfirm";
	} 
	@RequestMapping(value="/confirmAssignSubjectList",method=RequestMethod.POST)
	public String assignSubjectListFinal(ModelMap model,User user,Principal principal){
		model.addAttribute("role", userService.getUserRole(principal.getName()));
		 model.addAttribute("principleUser", userService.getUserFirstName(principal.getName()));
		userService.addSubjectToUser(user);
		user=userService.getUser(user.getUserId());
		return "assignSubjectListCommit";
	} 	

	@InitBinder
	protected void initBinder(ServletRequestDataBinder binder) throws Exception {
	    binder.registerCustomEditor(Subject.class, "subjectList", new PropertyEditorSupport() {
	    	@Override
	    public void setAsText(String text) {
	       Subject subject  = subjectService.getSubject(text);
	        setValue(subject);
	    }
	    });
	}

}
