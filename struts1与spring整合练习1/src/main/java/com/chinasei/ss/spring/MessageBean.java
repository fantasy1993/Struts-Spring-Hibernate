package com.chinasei.ss.spring;

import com.chinasei.ss.form.LoginForm;

public class MessageBean {
	public String addMessage(LoginForm loginForm){
		String uName = loginForm.getUserName();
		String uPassword = loginForm.getUserPassword(); 
		String message = "��������ʺ��ǣ�" + uName + "<br>������������ǣ�" + uPassword;
		return message;
	}
}
