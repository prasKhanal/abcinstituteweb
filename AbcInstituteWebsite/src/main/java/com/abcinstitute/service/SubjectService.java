/**
 * 
 */
package com.abcinstitute.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abcinstitute.Database.SubjectDao;
import com.abcinstitute.beans.Subject;

/**
 * @author pras_khanal
 *
 */
@Service("subjectService")

public class SubjectService {
	private SubjectDao subjectDao;
	@Autowired
	public void setSubjectDao(SubjectDao subjectDao){
		this.subjectDao=subjectDao;
	}
	
	public List<Subject> generateAllSubjectList(){
		 List<Subject> list = new ArrayList<Subject>();
		for (Map<String, Object> map : subjectDao.generateSubjects()) {
			Subject subject=null;
		    for (Map.Entry<String, Object> entry : map.entrySet()) {
		        subject = subjectDao.getSubject(entry.getValue().toString());
		        }
		    list.add(subject);
		}
		return list;
	}
	public List<Subject> getSubjectList(int userId){
		 List<Subject> list = new ArrayList<Subject>();
		 Iterator<String> iterator=subjectDao.getAssignedSubject(userId).iterator();
			while(iterator.hasNext())
			    list.add(subjectDao.getSubject(iterator.next()));
			return list;	
	}

	/**
	 * @param subject
	 * @return
	 */
	public int addSubjecttoDatabase(Subject subject){
		if(subjectDao.containSubject(subject)>0)
			return 0;
		else
			return subjectDao.addSubject(subject);
		
	}


	/**
	 * @param subjectType
	 * @return
	 */
	public Subject getSubject(String subjectType) {
		// TODO Auto-generated method stub
		return subjectDao.getSubject(subjectType);
	}

	/**
	 * @param tempSubject
	 */
	public void editSubject(Subject tempSubject) {
		subjectDao.editSubject(tempSubject);
	}

	/**
	 * @param parseInt
	 * @return
	 */
	public List<String> getAssignedSubjectList(int userId) {
		return subjectDao.getAssignedSubject(userId);
	}

	/**
	 * @return
	 */
	public List<Subject> generateUnassignedSubjectList() {
		// TODO Auto-generated method stub
		return subjectDao.generateUnassignedSubjectList();
	}

	

	
}
