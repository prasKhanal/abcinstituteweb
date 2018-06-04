/**
 * 
 */
package com.abcinstitute.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abcinstitute.Database.MessageDao;
import com.abcinstitute.beans.Message;

/**
 * @author pras_khanal
 *
 */
@Service("messageService")

public class MessageService {
	private MessageDao messageDao;
	@Autowired
	public void setMessageDao(MessageDao messageDao){
		this.messageDao=messageDao;
	}

	/**
	 * @param message
	 */
	public void addMessage(Message message) {
		messageDao.addMessage(message);
	}

	/**
	 * @param subject
	 * @return
	 */
	public Message getMessage(String subject) {
		
		return messageDao.getMessage(subject);
	}

	/**
	 * @param subjectType
	 * @return
	 */
	public List<Message> getSubjectMessageList(String subjectType){
		 List<Message> list = new ArrayList<Message>();
		 Iterator<Integer> iterator=messageDao.getSubjectsMessage(subjectType).iterator();
			while(iterator.hasNext())
			    list.add(messageDao.getMessage(iterator.next()));
			return list;	
	}
	

}
