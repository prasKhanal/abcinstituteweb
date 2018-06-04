/**
 * 
 */
package com.abcinstitute.beans;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * @author pras_khanal
 *
 */
public class Payment {
    private String name;
	private String type;
	@Min(value = 40000000,message=" Card Number should contain 16 digit number")
	@Max(value = 99999999, message=" Card Number should contain 16 digit number")
	private int cardNumber;
	@Min(value = 40000000,message=" Card Number should contain 16 digit number")
	@Max(value = 99999999, message=" Card Number should contain 16 digit number")
	private int cardNumber1;
	private String expiryDate;
	private int cvcCode;
	
	
	/**
	 * @return the cardNumber1
	 */
	public int getCardNumber1() {
		return cardNumber1;
	}
	/**
	 * @param cardNumber1 the cardNumber1 to set
	 */
	public void setCardNumber1(int cardNumber1) {
		this.cardNumber1 = cardNumber1;
	}
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
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the cardNumber
	 */
	public int getCardNumber() {
		return cardNumber;
	}
	/**
	 * @param cardNumber the cardNumber to set
	 */
	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}
	/**
	 * @return the expiryDate
	 */
	public String getExpiryDate() {
		return expiryDate;
	}
	/**
	 * @param expiryDate the expiryDate to set
	 */
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	/**
	 * @return the cvcCode
	 */
	public int getCvcCode() {
		return cvcCode;
	}
	/**
	 * @param cvcCode the cvcCode to set
	 */
	public void setCvcCode(int cvcCode) {
		this.cvcCode = cvcCode;
	}
	
	

}
