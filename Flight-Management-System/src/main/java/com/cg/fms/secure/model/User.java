package com.cg.fms.secure.model;
import java.math.BigInteger;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class User {
	
  private String userType;
  @Id
  private int userId;
  private String username;
  private String password;
  private BigInteger userPhone;
  private String email;
  private String role;
  
  public User() {
	  
  }
  public User(String userType, int userId, String username, String password, BigInteger userPhone, String email, String role){
    this.userType=userType;
    this.userId=userId;
    this.username=username;
    this.password=password;
    this.userPhone=userPhone;
    this.email=email;
    this.role=role;
    }
  
  
  public int getUserId() {
	return userId;
  }
  public String getUserType(){
    return userType;
  }
  public void setUserType(String userType){
    this.userType=userType;
  }
 
  public void setUserId(int userId){
     this.userId=userId;
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
  public BigInteger getUserPhone(){
    return userPhone;
  }
  public void setUserPhone(BigInteger userPhone){
    this.userPhone=userPhone;
  }
  public String getEmail(){
    return email;
  }
  public void setEmail(String email){
    this.email=email;
  }
  public String getRole() {
	return role;
  }
  public void setRole(String role) {
	this.role = role;
  }
  
}

