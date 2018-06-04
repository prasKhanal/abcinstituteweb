package com.abcinstitute.beans;



import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class User implements Cloneable {
    //unique id for each user
	private int userId;
    
    //First name of user including validation condition on its size and pattern
	@Size(min=3, max=20, message=" Name should be 3 to 10 characters long")
	@Pattern(regexp="^[a-zA-Z]+$",message="Name Should only contain alphabet")
	private String name;
	
    
    //Surname  of user including validation condition on its size and pattern
	@Size(min=3, max=20, message=" Sur Name should be 3 to 10 characters long")
	@Pattern(regexp="^[a-zA-Z]+$",message="Sur Name Should only contain alphabet")
	private String surName;
	
    //phone number of user including validation for maximum and minimum number
    //which can be used
	@Min(value = 400000000,message=" Phone Number should contain 10 digit number")
	@Max(value = 999999999, message=" Phone Number should contain 10 digit number")
	private int phoneNumber;
    
    //Email address of the user with validation
	@NotEmpty(message="Invalid email address.")
	@NotNull(message="Invalid email address.")
	@Email(message="Invalid email address.")
	private String email;
    
    //passord used for login 
	private String password;
    //address class which provides address detail of user
	@Valid
	private Address address;
    //the list of subject student are enrolled on
	private List<Subject> subjectList;
    //list of invoice created form user enrollment
	private List<Invoice> invoiceList;
    //payment detail of the user
	private Payment payment;
	/**
	 * @return the payment
	 */
	public Payment getPayment() {
		return payment;
	}

	/**
	 * @param payment the payment to set
	 */
	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	/**
	 * @return the invoiceList
	 */
	public List<Invoice> getInvoiceList() {
		return invoiceList;
	}

	/**
	 * @param invoiceList the invoiceList to set
	 */
	public void setInvoiceList(List<Invoice> invoiceList) {
		this.invoiceList = invoiceList;
	}

	/**
	 * @return the subjectList
	 */
	public List<Subject> getSubjectList() {
		return subjectList;
	}
	
	/**
	 * @param subjectList the subjectList to set
	 */
	public void setSubjectList(List<Subject> subjectList) {
		this.subjectList = subjectList;
	}
	private String userRole;
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the surName
	 */
	public String getSurName() {
		return surName;
	}
	/**
	 * @param surName the surName to set
	 */
	public void setSurName(String surName) {
		this.surName = surName;
	}
	/**
	 * @return the phoneNumber
	 */
	public int getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	


	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}
	
	/**
	 * @return the userRole
	 */
	public String getUserRole() {
		return userRole;
	}
	/**
	 * @param userRole the userRole to set
	 */
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	
	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String toString(){
		return name+surName;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	

}
