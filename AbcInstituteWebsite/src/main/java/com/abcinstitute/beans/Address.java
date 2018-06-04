package com.abcinstitute.beans;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Address {
@Max(value = 99999, message=" Street Number should contain number")
private int streetNumber;

@Pattern(regexp="^[a-zA-Z]+$",message="Street Should only contain alphabet")
@Size(min=3, max=20, message=" Street should be 3 to 10 characters long")
private String street;	

@Pattern(regexp="^[a-zA-Z]+$",message="City Should only contain alphabet")
@Size(min=3, max=20, message=" City should be 3 to 10 characters long")
private String city;

@NotEmpty(message="Select a State Name")
private String state;

@Min(value = 1000, message=" PostCode should contain number")
private int postCode;


/**
 * @return the streetNumber
 */
public int getStreetNumber() {
	return streetNumber;
}
/**
 * @param streetNumber the streetNumber to set
 */
public void setStreetNumber(int streetNumber) {
	this.streetNumber = streetNumber;
}
/**
 * @return the street
 */
public String getStreet() {
	return street;
}
/**
 * @param street the street to set
 */
public void setStreet(String street) {
	this.street = street;
}
/**
 * @return the city
 */
public String getCity() {
	return city;
}
/**
 * @param city the city to set
 */
public void setCity(String city) {
	this.city = city;
}
/**
 * @return the state
 */
public String getState() {
	return state;
}
/**
 * @param state the state to set
 */
public void setState(String state) {
	this.state = state;
}
/**
 * @return the postCode
 */
public int getPostCode() {
	return postCode;
}
/**
 * @param postCode the postCode to set
 */
public void setPostCode(int postCode) {
	this.postCode = postCode;
}

}
