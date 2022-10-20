package com.cg.fms.secure.model;

import java.math.BigInteger;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class UserDto {
	private String userType;
	
	  @NotEmpty(message="UserId is empty")
	  private int userId;
	  
	  @NotEmpty(message="Please enter customer name")
	  private String username;
	  
	  @NotEmpty(message="Please enter customer password")
	  private String password;
	  
	  @NotEmpty(message="Please enter valid phonenumber")
	  @Pattern(regexp="(^$|[0-9]{10})")
	  private BigInteger userPhone;
	  
	  @Email @NotEmpty (message="Please enter valid email")
	  private String email;
	  private String role;
	  
	  public UserDto() {
		// TODO Auto-generated constructor stub
	}
	  
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public BigInteger getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(BigInteger userPhone) {
		this.userPhone = userPhone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	} 
	  
}
