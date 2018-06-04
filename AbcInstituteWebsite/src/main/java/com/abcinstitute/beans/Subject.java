package com.abcinstitute.beans;

import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Subject {
	

	@Size(min=3, message="At least one subject  must be selected")
	private String subjectType;
	@Size(min=5, max=50, message=" Subject Name should be 5 to 50 characters long")
	private String subjectName;
	@Size(min=50,  message=" Subject Overview should be minimum 50 characters long")
	private String subjectOverview;
	@Size(min=10,  message=" Subject Overview should be minimum 10 characters long")
	private String prescribedText;
	@Min(value = 1000,message=" Enter price to study this subject")
	private int cost;
	private User teacher;
	private List<Resource> resourceList;
	private List<Message> messageList;
	
	
/**
	 * @return the messageList
	 */
	public List<Message> getMessageList() {
		return messageList;
	}


	/**
	 * @param messageList the messageList to set
	 */
	public void setMessageList(List<Message> messageList) {
		this.messageList = messageList;
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
	 * @return the subjectOverview
	 */
	public String getSubjectOverview() {
		return subjectOverview;
	}


	/**
	 * @param subjectOverview the subjectOverview to set
	 */
	public void setSubjectOverview(String subjectOverview) {
		this.subjectOverview = subjectOverview;
	}


	/**
	 * @return the prescribedText
	 */
	public String getPrescribedText() {
		return prescribedText;
	}


	/**
	 * @param prescribedText the prescribedText to set
	 */
	public void setPrescribedText(String prescribedText) {
		this.prescribedText = prescribedText;
	}
	/**
	 * @return the subjectName
	 */
	public String getSubjectName() {
		return subjectName;
	}


	/**
	 * @param subjectName the subjectName to set
	 */
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}


	/**
	 * @return the teacher
	 */
	public User getTeacher() {
		return teacher;
	}


	/**
	 * @param teacher the teacher to set
	 */
	public void setTeacher(User teacher) {
		this.teacher = teacher;
	}


	/**
	 * @return the resourceList
	 */
	public List<Resource> getResourceList() {
		return resourceList;
	}


	/**
	 * @param resourceList the resourceList to set
	 */
	public void setResourceList(List<Resource> resourceList) {
		this.resourceList = resourceList;
	}



/**
	 * @return the cost
	 */
	public int getCost() {
		return cost;
	}


	/**
	 * @param cost the cost to set
	 */
	public void setCost(int cost) {
		this.cost = cost;
	}


public boolean equals(Subject subject){return true;}
}
