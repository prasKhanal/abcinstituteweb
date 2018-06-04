package com.abcinstitute.beans;

import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

public class Resource {
@Size(min=6, max=7, message=" Select One Subject")
private String subjectType;
@Size(min=3, max=20, message=" Name should be 3 to 10 characters long")
private String resourceName;
private MultipartFile file;
private String actualName;


/**
 * @return the actualName
 */
public String getActualName() {
	return actualName;
}
/**
 * @param actualName the actualName to set
 */
public void setActualName(String actualName) {
	this.actualName = actualName;
}
/**
 * @return the file
 */
public MultipartFile getFile() {
	return file;
}
/**
 * @param file the file to set
 */
public void setFile(MultipartFile file) {
	this.file = file;
}
/**
 * @return the subjectType
 */
public String getSubjectType() {
	return subjectType;
}
/**
 * @param subjectType the subjectType to set
 */
public void setSubjectType(String subjectType) {
	this.subjectType = subjectType;
}
/**
 * @return the resourceName
 */
public String getResourceName() {
	return resourceName;
}
/**
 * @param resourceName the resourceName to set
 */
public void setResourceName(String resourceName) {
	this.resourceName = resourceName;
}
public String toString(){
	return this.getActualName()+" "+this.resourceName;
}

}
