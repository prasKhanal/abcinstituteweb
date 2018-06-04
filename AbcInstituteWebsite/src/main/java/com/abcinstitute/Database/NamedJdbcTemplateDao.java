/*package com.abcinstitute.Database;


import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import com.abcinstitute.beans.Address;
import com.abcinstitute.beans.Message;
import com.abcinstitute.beans.Resource;
import com.abcinstitute.beans.Subject;
import com.abcinstitute.beans.User;

public class NamedJdbcTemplateDao extends NamedParameterJdbcDaoSupport {
	
	
	
	 @Autowired
	 NamedJdbcTemplateDao(DataSource dataSource){
	        setDataSource(dataSource);
	    }
	
private	GeneratedKeyHolder key =new GeneratedKeyHolder();


//to generate subjectLists
public List<Subject> generateSubjectList(){
	 List<Subject> list = new ArrayList<Subject>();
	for (Map<String, Object> map : generateSubjects()) {
		Subject subject=null;
	    for (Map.Entry<String, Object> entry : map.entrySet()) {
	        subject = getSubject(entry.getValue().toString());
	        
	    }
	    list.add(subject);
	}
	return list;
}
private List< Map<String, Object>> generateSubjects(){
	String sql="SELECT  subject_type FROM Subject";
	return this.getJdbcTemplate().queryForList(sql);
}
//add Subject to database
public int addSubjecttoDatabase(Subject subject){
	if(containSubject(subject)>0)
		return 0;
	else
		return addSubject(subject);
	
}
//Add subject to database
public int addSubject(Subject subject){
	String sql="INSERT INTO Subject(Subject_Name,Subject_Overview,PrescribedText,Cost)" +
			"VALUES(:subjectName,:subjectOverview,:prescribedText,:Cost)";
	SqlParameterSource namedParameter=new MapSqlParameterSource("subjectName",subject.getSubjectName()).
			addValue("subjectOverview",subject.getSubjectOverview()).
			addValue("prescribedText",subject.getPrescribedText()).addValue("Cost", subject.getCost());
	this.getNamedParameterJdbcTemplate().update(sql, namedParameter,key,new String[]{"subject_code"});
	int code=key.getKey().intValue();
	addSubjectCode(subject.getSubjectType(),code);
	return code;
}

private void addSubjectCode(String subjectType, int code) {
	String sql="Update Subject SET subject_type=:subjectType where subject_code=:subjectCode";
	SqlParameterSource namedParameter=new MapSqlParameterSource("subjectType",subjectType+code).
			addValue("subjectCode", code);
	this.getNamedParameterJdbcTemplate().update(sql,namedParameter);
	
}
//check subject already in the database
public int containSubject(Subject subject){
	String sql="SELECT COUNT(*)  FROM  Subject WHERE Subject_Name =:subjectName AND subject_type=:subjectType";
	SqlParameterSource namedParameters = new MapSqlParameterSource("subjectName",subject.getSubjectName()).addValue("subjectType",subject.getSubjectType());
	return this.getNamedParameterJdbcTemplate().queryForInt(sql, namedParameters);
}

//cheeck user avability and write to database
public int addUsertoDatabase(User user){
	
	 if(containUser(user)>0) return 0;
	 else return addUser( user);
}
//Edit user detail+address;
public void editUserDetail(User user){
	editUser(user);
	editUserAddress(user.getAddress(),user.getUserId());
}
//edit just user detail
public void editUser(User user){
	String sql="UPDATE  User SET User_FirstName=:firstName, User_LastName=:lastName," +
			"User_PhoneNumber=:phoneNumber, User_Email=:email     where user_id=:userId";
	SqlParameterSource namedParameters=new MapSqlParameterSource("firstName",user.getName()).
			addValue("lastName", user.getSurName()).addValue("phoneNumber", user.getPhoneNumber()).
			addValue("email", user.getEmail()).addValue("userId", user.getUserId());
	this.getNamedParameterJdbcTemplate().update(sql,namedParameters);
}
//edit address
public void editUserAddress(Address address, int userId){
	String sql="UPDATE  Address SET  StreetNumber=:streetNumber, Street=:street," +
		" City=:city, State=:state, PostCode=:postCode where user_id=:userId";	
	SqlParameterSource namedParameter=new MapSqlParameterSource("streetNumber",address.getStreetNumber()).
			addValue("street", address.getStreet()).addValue("city", address.getCity()).
			addValue("state", address.getState()).addValue("postCode", address.getPostCode()).
			addValue("userId", userId);
	this.getNamedParameterJdbcTemplate().update(sql, namedParameter);
}
//add user to database 
public int addUser(User user){
	String sql="INSERT INTO User" +
			"(User_Password,User_FirstName , User_LastName , ENABLED , User_PhoneNumber , User_Email , User_DeafaultPassword) " +
			"VALUES(:password, :name,:surName,:enabled,:phNumber,:email,:defaultPassword)";
	SqlParameterSource namedParameters = new MapSqlParameterSource("password", "password").
			addValue("name", user.getName().toLowerCase())
			.addValue("surName", user.getSurName().toLowerCase())
			.addValue("enabled", true)
			.addValue("phNumber",user.getPhoneNumber())
			.addValue("email",user.getEmail())
			.addValue("defaultPassword",true);
	
	 this.getNamedParameterJdbcTemplate().update(sql, namedParameters,key,new String[]{"User_Id"});
	 user.setUserId(key .getKey().intValue());
     addAddress(user.getAddress(),user.getUserId());
     addUserRole(user);
	 return user.getUserId();

}
public void addUserRole(User user) {
	String sql="INSERT INTO UserRole" +
			"(User_Id , UserAuthority )" +
			"VALUES (:userId,:userAuthority)";
	SqlParameterSource namedParameters = new MapSqlParameterSource("userId", user.getUserId())
	.addValue("userAuthority",user.getUserRole());
	this.getNamedParameterJdbcTemplate().update(sql, namedParameters);
}
public void addAddress(Address address,int userId) {
	String sql="INSERT INTO Address" +
			"(StreetNumber, Street ,City ,State , PostCode, User_Id) " +
			"VALUES(:streetNumber, :street,:city,:state,:postcode,:User_Id)";
	SqlParameterSource namedParameters = new MapSqlParameterSource("password", "password").
			addValue("streetNumber", address.getStreetNumber())
			.addValue("street", address.getStreet().toLowerCase())
			.addValue("city", address.getCity().toLowerCase())
			.addValue("state",address.getState().toLowerCase())
			.addValue("postcode",address.getPostCode())
			.addValue("User_Id",userId);
	
	 this.getNamedParameterJdbcTemplate().update(sql, namedParameters);
}
//checking weather user is already available in
//the database or not
public int containUser(User user){
	String sql="SELECT COUNT(*)  FROM  h WHERE User_FirstName =:name AND User_LastName=:surName AND User_PhoneNumber=:phNumber";
	SqlParameterSource namedParameters = new MapSqlParameterSource("name",user.getName().toLowerCase())
	.addValue("surName", user.getSurName().toLowerCase()).addValue("phNumber", user.getPhoneNumber());
	return this.getNamedParameterJdbcTemplate().queryForInt(sql, namedParameters);
}

//check password is default or not
public boolean isDefaultPassword(int userId){
	String sql="SELECT User_DeafaultPassword FROM User WHERE User_Id=:userId";
	SqlParameterSource namedParameters = new MapSqlParameterSource("userId",userId);
	if( this.getNamedParameterJdbcTemplate().queryForInt(sql, namedParameters)==1) return true;
	else return false;
}
public int getCircleCount(){
	String sql="SELECT COUNT(*) FROM circle";
	return this.getJdbcTemplate().queryForInt(sql);
}

public User getUser(int userId){
	String sql="SELECT * FROM User WHERE User_Id=:userId";
	SqlParameterSource namedParameters = new MapSqlParameterSource("userId",userId);
	try{
	User user =this.getNamedParameterJdbcTemplate().queryForObject(sql,namedParameters, new UserMapper());
    user.setAddress(getAddress(userId));
    user.setSubjectList(getSubjectList(userId));
	return user;
	}
	catch(Exception e){
		System.out.println("Error creating user");
		return null;
		
	}
}
public List<String> getAssignedSubject(int userId) {
	String sql="SELECT Subject_Type FROM SubjectStudent WHERE user_id=:userId";
	SqlParameterSource namedParameters = new MapSqlParameterSource("userId",userId);
	return (List<String>)this.getNamedParameterJdbcTemplate().queryForList(sql,namedParameters,String.class);
	
}
public List<Subject> getSubjectList(int userId){
	 List<Subject> list = new ArrayList<Subject>();
	 Iterator<String> iterator=getAssignedSubject(userId).iterator();
		while(iterator.hasNext())
		    list.add(getSubject(iterator.next()));
		return list;	
}
public List<Integer> getSubjectsMessage(String subjectType) {
	String sql="SELECT Message_Id FROM Message WHERE Subject_code=:subjectType";
	SqlParameterSource namedParameters = new MapSqlParameterSource("subjectType",subjectType);
	return (List<Integer>)this.getNamedParameterJdbcTemplate().queryForList(sql,namedParameters,Integer.class);
	
}
public List<Message> getSubjectMessageList(String subjectType){
	 List<Message> list = new ArrayList<Message>();
	 Iterator<Integer> iterator=getSubjectsMessage(subjectType).iterator();
		while(iterator.hasNext())
		    list.add(getMessage(iterator.next()));
		return list;	
}
public Message getMessage(int messageId){
	String sql="SELECT * FROM Message WHERE Message_Id=:messageId";
	SqlParameterSource namedParameters = new MapSqlParameterSource("messageId",messageId);
	return this.getNamedParameterJdbcTemplate().queryForObject(sql,namedParameters, new MessageMapper());
}
public Address getAddress(int userId){
	String sql="SELECT * FROM Address WHERE User_Id=:userId";
	SqlParameterSource namedParameters = new MapSqlParameterSource("userId",userId);
	return this.getNamedParameterJdbcTemplate().queryForObject(sql,namedParameters, new AddressMapper());
}
public Subject getSubject(String subjectType){
	String sql="SELECT * FROM Subject WHERE subject_type=:subjectType";
	SqlParameterSource namedParameters = new MapSqlParameterSource("subjectType",subjectType);
	Subject subject=this.getNamedParameterJdbcTemplate().queryForObject(sql,namedParameters, new SubjectMapper());
	subject.setMessageList(getSubjectMessageList(subject.getSubjectType()));
	subject.setResourceList(getResouresList(subject.getSubjectType()));
	return subject;
}

final class AddressMapper implements RowMapper<Address>{

	@Override
	public Address mapRow(ResultSet rs, int arg1) throws SQLException {
		Address address=new Address();
		address.setStreetNumber(rs.getInt( "StreetNumber"));
		address.setStreet(rs.getString("street"));
		address.setCity(rs.getString("City"));
		address.setState(rs.getString("State"));
		address.setPostCode(rs.getInt("PostCode"));
		return address;
    }
	}
final class SubjectMapper implements RowMapper<Subject>{

	@Override
	public Subject mapRow(ResultSet rs, int rowNum) throws SQLException {
		Subject subject =new Subject();
		subject.setSubjectType(rs.getString("subject_type"));
		subject.setSubjectOverview(rs.getString("Subject_Overview"));
		subject.setPrescribedText(rs.getString("PrescribedText"));
		subject.setSubjectName(rs.getString("Subject_Name"));
		subject.setCost(rs.getInt("Cost"));
		return subject;
	}}
final class MessageMapper implements RowMapper<Message>{
	@Override
	public Message mapRow(ResultSet rs,int rowNum) throws SQLException{
		Message message=new Message();
		message.setMessage(rs.getString("Message_Message"));
		message.setSubject(rs.getString("Message_Subject"));
		message.setSubjectType(rs.getString("Subject_code"));
		message.setDate(rs.getString("Date"));
		return message;
	}
}
final class ResourceMapper implements RowMapper<Resource>{
	@Override
	public Resource mapRow(ResultSet rs,int rowNum)throws SQLException{
		Resource resource=new Resource();
		resource.setSubjectType(rs.getString("Subject_Type"));
		resource.setActualName(rs.getString("Resource_ActualName"));
		resource.setResourceName(rs.getString("Resource_Name"));
		return resource;
	}
}

final class UserMapper implements RowMapper<User>{

	@Override
	public User mapRow(ResultSet rs, int arg1) throws SQLException {
		User user=new User();
		user.setUserId(rs.getInt("User_Id"));
		user.setEmail(rs.getString("User_Email"));
		user.setName(rs.getString("User_FirstName"));
		user.setPhoneNumber(rs.getInt("User_PhoneNumber"));
		user.setSurName(rs.getString("User_LastName"));
		return user;

	}
	
}


public void addSubject (int userId, Subject subject) {
	 assignSubject(userId,subject.getSubjectType());
	 if(checkRole(userId).equals("ROLE_TEACHER")){
		assignSubjectTeacher( userId,subject.getSubjectType());
	}
	 if(checkRole(userId).equals("ROLE_STUDENT")) createInvoice(userId,subject);
}
*//**
 * @param userId
 * @param subjectCode
 *//*
private int createInvoice(int userId, Subject subject) {
	String sql="insert into invoice(SubjectEnrolled,userId,cost) values (:id,:user,:cost)";
	SqlParameterSource nameParameters=new MapSqlParameterSource("id",subject.getSubjectType()).addValue("user", userId)
			.addValue("cost", subject.getCost());
	return this.getNamedParameterJdbcTemplate().update(sql, nameParameters);
}
private void assignSubjectTeacher(int userId, String subjectCode) {
	// TODO Auto-generated method stub
	String sql="UPDATE Subject SET user_id=:id WHERE Subject_Type=:code";
	SqlParameterSource namedParameters = new MapSqlParameterSource("id",userId).
			addValue("code", subjectCode);
	 this.getNamedParameterJdbcTemplate().update(sql, namedParameters);
	
}
private int assignSubject(int userId, String subjectCode) {
	// TODO Auto-generated method stub
	String sql="INSERT INTO SubjectStudent Values(:id,:code)";
	SqlParameterSource namedParameters = new MapSqlParameterSource("id",userId).
			addValue("code", subjectCode);
	return this.getNamedParameterJdbcTemplate().update(sql, namedParameters);
}
public String checkRole(int userId) {
	String sql="SELECT UserAuthority from UserRole WHERE User_Id=:userId";
	SqlParameterSource namedParameters = new MapSqlParameterSource("userId",userId);
	return this.getNamedParameterJdbcTemplate().queryForObject(sql, namedParameters,String.class);
	
}
public void addSubjectToUser(User user) {
	// TODO Auto-generated method stub
	Iterator<Subject> iterator=user.getSubjectList().iterator();
	while(iterator.hasNext()){
		Subject subject=iterator.next();
		String subjectCode=subject.getSubjectType();
		if(checkDuplicateAssign(user.getUserId(),subjectCode)==0)
		addSubject(user.getUserId(),subject);
	}
}
private int checkDuplicateAssign(int userId, String subjectCode) {
	String sql="SELECT COUNT(*) from SubjectStudent Where User_Id=:id and subject_type=:code";
	SqlParameterSource namedParameters = new MapSqlParameterSource("id",userId).
			addValue("code", subjectCode);
	return this.getNamedParameterJdbcTemplate().queryForInt(sql, namedParameters);

}
public void editSubject(Subject subject) {
String sql="UPDATE Subject SET Subject_Name=:subjectName,Subject_Overview=:subjectOverview," +
		" PrescribedText=:text WHERE subject_type=:code";
SqlParameterSource namedParameters = new MapSqlParameterSource("subjectName",subject.getSubjectName()).addValue("subjectOverview", subject.getSubjectOverview())
.addValue("text", subject.getPrescribedText()).addValue("code", subject.getSubjectType());
this.getNamedParameterJdbcTemplate().update(sql, namedParameters);
}
public void editSubjectofUser(User user) {
	String sql="Delete from SubjectStudent Where User_Id=:id";
	SqlParameterSource namedParameters = new MapSqlParameterSource("id",user.getUserId());
	this.getNamedParameterJdbcTemplate().update(sql, namedParameters);
	addSubjectToUser(user);
}
public void addMessage(Message message) {
	String sql="Insert Into Message(Message_Subject, Message_Message , Subject_code) VALUES(:subject,:message,:code)";
	SqlParameterSource namedParameters = new MapSqlParameterSource("message",message.getMessage()).addValue("subject", message.getMessage()).
			addValue("code", message.getSubjectType());
	this.getNamedParameterJdbcTemplate().update(sql, namedParameters);	
}
public Message getMessage(String subject) {
	String sql="SELECT * FROM Message WHERE Message_Subject=:subject";
	SqlParameterSource namedParameters = new MapSqlParameterSource("subject",subject);
	return this.getNamedParameterJdbcTemplate().queryForObject(sql,namedParameters, new MessageMapper());
}
public void saveResource(Resource resource)
		      throws Exception {
		  try {
		    File file = new File("/Users/pras_khanal/Documents/workspace-sts-3.2.0.RELEASE/prasPok/src/main/webapp" +
		                          "/resources/uploads/" + resource.getSubjectType()+"/"+resource.getFile().getOriginalFilename());
		    FileUtils.writeByteArrayToFile(file, resource.getFile().getBytes());
		    addResource(resource);
		  } catch (IOException e) {
		    throw new Exception("Unable to save image", e);
		} }
private void addResource(Resource resource) {
	String sql="Insert Into Resource(Resource_ActualName , Resource_Name,Subject_Type)" +
			"Values(:actualName,:name,:type)";
	SqlParameterSource namedParameters = new MapSqlParameterSource("actualName",resource.getFile().getOriginalFilename()).
			addValue("name", resource.getResourceName()).addValue("type",resource.getSubjectType());
	this.getNamedParameterJdbcTemplate().update(sql,namedParameters);
	
}
public int containResource(Resource resource){
	String sql="SELECT COUNT(*)  FROM  Resource WHERE Resource_ActualName =:actualName AND subject_type=:subjectType";
	SqlParameterSource namedParameters = new MapSqlParameterSource("actualName",resource.getFile().getOriginalFilename()).
			addValue("subjectType",resource.getSubjectType());
	return this.getNamedParameterJdbcTemplate().queryForInt(sql, namedParameters);
}
public List<Resource> getResouresList(String subjectType){
	 List<Resource> list = new ArrayList<Resource>();
	 Iterator <Integer>iterator= getResourcesIds(subjectType).iterator();
	 while(iterator.hasNext()) list.add(getResource(iterator.next()));
	 return list;
}
public List<Integer> getResourcesIds(String subjectType){
	String sql="SELECT Resource_Id FROM Resource WHERE Subject_Type=:subjectType";
	SqlParameterSource namedParameters = new MapSqlParameterSource("subjectType",subjectType);
	return (List<Integer>)this.getNamedParameterJdbcTemplate().queryForList(sql,namedParameters,Integer.class);
}
public Resource getResource(int id){
	String sql="Select * from Resource Where Resource_id=:id";
	SqlParameterSource namedParameters = new MapSqlParameterSource("id",id);
	return this.getNamedParameterJdbcTemplate().queryForObject(sql, namedParameters, new ResourceMapper());

}



*//**
 * @return
 *//*
//to generate subjectLists
public List<Subject> generateUnassignedSubjectList(){
	 List<Subject> list = new ArrayList<Subject>();
	for (Map<String, Object> map : generateUnassignedSubjects()) {
		Subject subject=null;
	    for (Map.Entry<String, Object> entry : map.entrySet()) {
	        subject = getSubject(entry.getValue().toString());
	        
	    }
	    list.add(subject);
	}
	return list;
}
private List< Map<String, Object>> generateUnassignedSubjects(){
	String sql="SELECT  subject_type FROM Subject where User_Id is null";
	return this.getJdbcTemplate().queryForList(sql);
}
}
*/