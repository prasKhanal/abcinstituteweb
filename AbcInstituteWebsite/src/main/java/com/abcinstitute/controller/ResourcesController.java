/**
 * 
 */
package com.abcinstitute.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.Principal;


import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.abcinstitute.beans.Resource;
import com.abcinstitute.service.ResourceService;
import com.abcinstitute.service.UserService;

/**
 * @author pras_khanal
 *
 */
@Controller
public class ResourcesController {

	private UserService userService;
	private ResourceService resourceService;


	@Autowired
    public void setUserService(UserService userService){
    	this.userService=userService;
    }
	@Autowired
	public void setResourceService(ResourceService resourceService){
		this.resourceService=resourceService;
	}
	
	@RequestMapping(value="/uploadResources",method=RequestMethod.GET)
	public String uploadResources(ModelMap model,Principal principal){
		model.addAttribute("role", userService.getUserRole(principal.getName()));
		 model.addAttribute("principleUser", userService.getUserFirstName(principal.getName()));
		 model.addAttribute("resource",new Resource());
		return "uploadResources";
	} 
	@RequestMapping(value="/uploadResources",method=RequestMethod.POST)
	public String uploadResourcesSubmit(ModelMap model,Principal principal,
			@Valid Resource resource,BindingResult bindingResult){
		model.addAttribute("role", userService.getUserRole(principal.getName()));
		 model.addAttribute("principleUser", userService.getUserFirstName(principal.getName()));
       if(resource.getFile()!=null){
    	   if(resource.getFile().getSize()>19843488){
         	  model.addAttribute("err",new String("Size of file Exceed 20MB:"+(resource.getFile().getSize())));
         	 model.addAttribute("resource",resource);
               return "uploadResources";
           }
    	   if(!resourceService.checkValidFileType(resource.getFile().getContentType())){
        	  model.addAttribute("err","Please Select Correct Type of File "+resource.getFile().getContentType());
        	  model.addAttribute("resource",resource);
              return "uploadResources";
          }
    	   try{
    		   if(resourceService.containResource(resource)==0){
    			   resourceService.saveResource(resource);
    		   model.addAttribute("err","File Uploaded\nPlease Select Another File");
    		   model.remove("resource");
    		   model.addAttribute("resource",new Resource());
    		   return "uploadResources";
    		   }
    	   }
    	   catch(Exception e){
    		   model.addAttribute("err","Invalid File Unable To Upload");
    		   model.addAttribute("resource",resource);
    	       return "uploadResources";
    	   }
       }
       model.addAttribute("err","File Already Exists Or No File Selected");
       model.addAttribute("resource",resource);
       return "uploadResources";

	} 
	@RequestMapping(value="/subject/download/{subjectType}/{file}.{fileType}",method=RequestMethod.GET)
	public void downloadResource( ModelMap model,@PathVariable("subjectType") String subjectType,@PathVariable("fileType") String fileType,
			@PathVariable("file") String file,HttpServletResponse response){ 
		String fileLocation=subjectType+"/"+file+"."+fileType;
		File rtnFile = new File("/var/lib/tomcat7/webapps/ROOT/resources" +
                "/resources/uploads/" +fileLocation);
		 try {
	            FileCopyUtils.copy(new FileInputStream(rtnFile), response.getOutputStream());
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	  }
	
		


	
	
	
}
