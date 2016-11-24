package com.chinasei.ss.spring;

import com.chinasei.ss.form.LoginForm;

public class MessageBean {
	public String addMessage(LoginForm loginForm){
		String uName = loginForm.getUserName();
		String uPassword = loginForm.getUserPassword(); 
		String message = "您输入的帐号是：" + uName + "<br>您输入的密码是：" + uPassword;
		return message;
	}
}
