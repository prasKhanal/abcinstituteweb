package com.abcinstitute.beans;

import java.util.Iterator;
import java.util.Set;

import javax.security.auth.Subject;

public class Enrolment {
private int enrollmentId;
private Student student;
private Set <Subject>subjectList;
private int session;


/**
 * @return the enrollmentId
 */
public int getEnrollmentId() {
	return enrollmentId;
}


/**
 * @param enrollmentId the enrollmentId to set
 */
public void setEnrollmentId(int enrollmentId) {
	this.enrollmentId = enrollmentId;
}


/**
 * @return the student
 */
public Student getStudent() {
	return student;
}


/**
 * @param student the student to set
 */
public void setStudent(Student student) {
	this.student = student;
}


/**
 * @return the subjectList
 */
public Set<Subject> getSubjectList() {
	return subjectList;
}


/**
 * @param subjectList the subjectList to set
 */
public void setSubjectList(Set<Subject> subjectList) {
	this.subjectList = subjectList;
}


/**
 * @return the session
 */
public int getSession() {
	return session;
}


/**
 * @param session the session to set
 */
public void setSession(int session) {
	this.session = session;
}


//Enrollment contains specific subject or not
public boolean hasSubject(com.abcinstitute.beans.Subject subject){
	Iterator<Subject> it = subjectList.iterator();
	while(it.hasNext()){
		if(it.next().equals(subject)) return true;
	}
	return false;
}

}
