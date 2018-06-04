/**
 * 
 */
package com.abcinstitute.beans;


/**
 * @author pras_khanal
 *
 */
public class Receipt {

	private int receiptId;
	private int invoiceId;
	private String description;
	private int totalAmount;
	private int userId;
	private String date;
	
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
	 * @return the receptId
	 */
	public int getReceiptId() {
		return receiptId;
	}
	/**
	 * @param receptId the receptId to set
	 */
	public void setReceiptId(int receptId) {
		this.receiptId = receptId;
	}
	/**
	 * @return the invoiceId
	 */
	public int getInvoiceId() {
		return invoiceId;
	}
	/**
	 * @param invoiceId the invoiceId to set
	 */
	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the totalAmount
	 */
	public int getTotalAmount() {
		return totalAmount;
	}
	/**
	 * @param totalAmount the totalAmount to set
	 */
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
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
	

}
