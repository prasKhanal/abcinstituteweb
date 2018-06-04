/**
 * 
 */
package com.abcinstitute.beans;

/**
 * @author pras_khanal
 *
 */
public class Invoice {

	
		private int invoiceId;
		private String date;
		private boolean status;
		private int userId;
		private int cost;
		private String subjectEnrolled;
		private String label;
       
		/**
		 * @return the label
		 */
		public String getLabel() {
			return label;
		}
		/**
		 * @param label the label to set
		 */
		public void setLabel(String label) {
			this.label = label;
		}
		/**
		 * @return the invoicdId
		 */
		public int getInvoiceId() {
			return invoiceId;
		}
		/**
		 * @param invoicdId the invoicdId to set
		 */
		public void setInvoiceId(int invoiceId) {
			this.invoiceId = invoiceId;
		}
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
		 * @return the status
		 */
		public boolean isStatus() {
			return status;
		}
		/**
		 * @param status the status to set
		 */
		public void setStatus(boolean status) {
			this.status = status;
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
		/**
		 * @return the subjectEnrolled
		 */
		public String getSubjectEnrolled() {
			return subjectEnrolled;
		}
		/**
		 * @param subjectEnrolled the subjectEnrolled to set
		 */
		public void setSubjectEnrolled(String subjectEnrolled) {
			this.subjectEnrolled = subjectEnrolled;
		}
		/**
		 * @return the cost
		 */
		public int getCost() {
			return cost;
		}
		/**
		 * @param cost the cost to set
		 */
		public void setCost(int cost) {
			this.cost = cost;
		}
		

		
		
		}





