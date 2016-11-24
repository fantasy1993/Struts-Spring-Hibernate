package com.zhuxinquan;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

public class LoginAction extends ActionSupport implements SessionAware{
	private String userName;
	private String userPassword;
	private Map mySession;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	} 
	
	public String execute(){
		if(getUserName().equals("Wangjg") && getUserPassword().equals("Wangjg")){
			addActionMessage("login success");
			mySession.put("loginFlag", "login");
			return SUCCESS;
		}
		else{
			addActionError("Login Error");
			return INPUT;
		}
	}
	public void setSession(Map session) {
		mySession = session;
		
	}
}
