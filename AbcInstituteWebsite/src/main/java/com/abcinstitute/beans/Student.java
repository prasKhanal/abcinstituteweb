package com.abcinstitute.beans;

import java.util.Iterator;
import java.util.Set;


public class Student extends User {

	private int StudentId;
	private Set <Enrolment> enrollmentList;
	
	
	/**
	 * @return the studentId
	 */
	public int getStudentId() {
		return StudentId;
	}


	/**
	 * @param studentId the studentId to set
	 */
	public void setStudentId(int studentId) {
		StudentId = studentId;
	}


	/**
	 * @return the enrollmentList
	 */
	public Set<Enrolment> getEnrollmentList() {
		return enrollmentList;
	}


	/**
	 * @param enrollmentList the enrollmentList to set
	 */
	public void setEnrollmentList(Set<Enrolment> enrollmentList) {
		this.enrollmentList = enrollmentList;
	}


	//method to check either student is already enrolled
	//in a subject or not
	public boolean isAlreadyEnrolled(Subject subject){
		Iterator<Enrolment> it=enrollmentList.iterator();
		while(it.hasNext()){
			if(it.next().hasSubject(subject)){return true;}
		}
		return true;
	}
	
}
