package com.abcinstitute.beans;


import javax.validation.constraints.Size;

public class Message {
	private String date;
	@Size(min=10, max=100, message=" Message should be more than 10 to 100 characters long")
	private String message;
	@Size(min=10, max=100, message=" Message Subject  should be 5 to 50 characters long")
	private String subject;	
	@Size(min=6, message="One subject should be selected")
	private String subjectType;
	
	
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
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}
	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}
	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
}
