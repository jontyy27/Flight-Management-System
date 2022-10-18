package com.cg.fms.dto;

import java.math.BigInteger;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class User {
	
  private String userType;
  @Id
  private BigInteger userId;
  private String userName;
  private String userPassword;
  private BigInteger userPhone;
  private String email;
 
  public User() {
	  
  }
  public User(String userType, BigInteger userId, String userName, String userPassword, BigInteger userPhone, String email){
    this.userType=userType;
    this.userId=userId;
    this.userName=userName;
    this.userPassword=userPassword;
    this.userPhone=userPhone;
    this.email=email;
  }
  
  
  public BigInteger getUserId() {
	return userId;
  }
  public String getUserType(){
    return userType;
  }
  public void setUserType(String userType){
    this.userType=userType;
  }
  public BigInteger getUserID(){
    return userId;
  }
  public void setUserId(BigInteger userId){
     this.userId=userId;
  }
  public String getUserName(){
    return userName;
  }
  public void setUserName(String userName){
    this.userName=userName;
  }
  public String getUserPassword(){
    return userPassword;
  }
  public void setUserPassword(String userPassword){
    this.userPassword=userPassword;
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

}
