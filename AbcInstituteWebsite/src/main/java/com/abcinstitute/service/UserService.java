/**
 * 
 */
package com.abcinstitute.service;

import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abcinstitute.Database.AddressDao;
import com.abcinstitute.Database.UserConnect;
import com.abcinstitute.Database.UserRoleDao;
import com.abcinstitute.beans.Password;
import com.abcinstitute.beans.Subject;
import com.abcinstitute.beans.User;

/**
 * @author pras_khanal
 *
 */

@Service("UserService")

public class UserService {
	private SubjectService subjectService;
	//user database connection
	private UserConnect userConnect;
	//address  connection
	private AddressDao addressDao;
	//User role dao for database connection
	private UserRoleDao userRoleDao;
	private AccountService accountService;
	
	
	@Autowired
	public void setSubjectService(SubjectService subjectService){
		this.subjectService=subjectService;
	}
	/**
	 * @param accountService the accountService to set
	 */
	@Autowired
	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}
	@Autowired
	public void setUserConnect(UserConnect userConnect){
		this.userConnect=userConnect;
	}
	@Autowired
	public void setAddressDao(AddressDao addressDao){
		this.addressDao=addressDao;
	}
	@Autowired
	public void setUserRoleDao(UserRoleDao userRoleDao){
		this.userRoleDao=userRoleDao;
	}
	//returns the user role of the supplied user id as integer
	public String getUserRole(int userId){
		return userRoleDao.getUserRole(userId);
	}
	//returns the user role of the supplied user id as String

	public String getUserRole(String userId){
		return userRoleDao.getUserRole(Integer.parseInt(userId));
	}
    //returns users firstname from userid 
    public String getUserFirstName(int userId){
    	return userConnect.getUserFirstName(userId);
    }
    //returns user first name by passing userid string as argument
	public String getUserFirstName(String userId) {
	 
		return  userConnect.getUserFirstName(Integer.parseInt(userId));
	 
	 
	}
	public User getUser(int userId){
		return userConnect.getUser(userId);
	}
	
	



	/**
	 * @param user
	 * @return
	 */
	public int addUsertoDatabase(User user) {
		addressDao.addAddress(user.getAddress(),user.getUserId());
		userRoleDao.addUserRole(user);
	    
	return userConnect.addUser(user);
	}
	
	
	public List<Subject> generateSubjectList(String userId) {
	return this.generateSubjectList(Integer.parseInt(userId));	
	}
	/**
	 * @param name
	 * @return
	 */
	public List<Subject> generateSubjectList(int userId) {
		String userRole=userRoleDao.getUserRole(userId);
		if(userRole.equals("ROLE_ADMIN")) 
			return subjectService.generateAllSubjectList();
		return subjectService.getSubjectList(userId);
	}
	/**
	 * @param parseInt
	 * @return
	 */
	public boolean isDefaultPassword(int userId) {
		
		return userConnect.isDefaultPassword(userId);
	}
	/**
	 * @param name
	 * @return
	 */
	public User getUserWithAddress(int userId) {
		User user=userConnect.getUser(userId);
		user.setAddress(addressDao.getAddress(userId));
		return user;
	}

	public User getUserWithAddress(String userId){
		return getUserWithAddress(Integer.parseInt(userId));
	}
	//Edit user detail+address;
	public void editUserDetail(User user){
		userConnect.editUser(user);
		addressDao.editUserAddress(user.getAddress(),user.getUserId());
	}
	/**
	 * @param password
	 * @param parseInt
	 */
	public void changePassword(Password password, int userId) {
      userConnect.changePassword(password.getPassword(), userId);		
	}
	/**
	 * @param parseInt
	 * @return
	 */
	/**
	 * @param userId
	 * @return
	 */
	public String checkRole(int userId) {
		
		return userConnect.checkRole(userId);
	}
	/**
	 * @param user
	 */
	public void editSubjectofUser(User user) {
		userConnect.editUser(user);
		
	}
	public void addSubjectToUser(User user) {
		// TODO Auto-generated method stub
		Iterator<Subject> iterator=user.getSubjectList().iterator();
		while(iterator.hasNext()){
			Subject subject=iterator.next();
			String subjectCode=subject.getSubjectType();
			if(userConnect.checkDuplicateAssign(user.getUserId(),subjectCode)==0)
			addSubject(user.getUserId(),subject);
		}
	}

 public void addSubject (int userId, Subject subject) {
	 userConnect.assignSubject(userId,subject.getSubjectType());
	 if(checkRole(userId).equals("ROLE_TEACHER")){
		userConnect.assignSubjectTeacher( userId,subject.getSubjectType());
	}
	 if(checkRole(userId).equals("ROLE_STUDENT")) accountService.createInvoice(userId,subject);
  }
	
	


}
