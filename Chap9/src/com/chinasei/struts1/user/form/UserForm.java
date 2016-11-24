package com.chinasei.struts1.user.form;

import org.apache.struts.validator.ValidatorActionForm;

public class UserForm extends ValidatorActionForm {
	private static final long serialVersionUID = 4282638767253037432L;
	private String userName;
	private String password;
	private String email;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
