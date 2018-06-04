package com.abcinstitute.beans;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Password {
	@NotNull
    @Size(min=8, max=25, message=("Password should be eight digit long."))
	private String password;
	
	private String confirmPassword;
	/**
	 * @return the password
	 */
	 @AssertTrue(message="Password are not same.")
	  private boolean match() {
	    return this.password.equals(this.confirmPassword);
	  }
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the confirmPassword
	 */
	public String getConfirmPassword() {
		return confirmPassword;
	}
	/**
	 * @param confirmPassword the confirmPassword to set
	 */
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	

}
