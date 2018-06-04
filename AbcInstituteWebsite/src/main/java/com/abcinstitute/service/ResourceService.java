
package com.abcinstitute.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abcinstitute.Database.ResourceDao;
import com.abcinstitute.beans.Resource;

/**
 * @author pras_khanal
 *
 */
@Service("resourceService")

public class ResourceService {
	private ResourceDao resourceDao;
	@Autowired
	public void setResourceDao(ResourceDao resourceDao){
		this.resourceDao=resourceDao;
	}
	

	public List<Resource> getResouresList(String subjectType){
		 List<Resource> list = new ArrayList<Resource>();
		 Iterator <Integer>iterator= resourceDao.getResourcesIds(subjectType).iterator();
		 while(iterator.hasNext()) list.add(resourceDao.getResource(iterator.next()));
		 return list;
	}
	public void saveResource(Resource resource)
		      throws Exception {
		  try {
		    File file = new File("/var/lib/tomcat7/webapps/ROOT/resources" +
		                          "/resources/uploads/" + resource.getSubjectType()+"/"+resource.getFile().getOriginalFilename());
		    FileUtils.writeByteArrayToFile(file, resource.getFile().getBytes());
		    resourceDao.addResource(resource);
		  } catch (IOException e) {
		    throw new Exception("Unable to save image", e);
		} }


	/**
	 * @param resource
	 * @return
	 */
	public int containResource(Resource resource) {
		return resourceDao.containResource(resource);
	}
	public boolean checkValidFileType(String value){
		List<String> list=new ArrayList<String>();
	    list.add("application/pdf");
	    list.add("application/msword");
	    list.add("application/vnd.ms-powerpoint");
	    list.add("text/plain");
	    list.add("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
	    Iterator <String>iterator=list.iterator();
	   while(iterator.hasNext())
		   if(iterator.next().equals(value)) return true;
	   return false;
}

}
