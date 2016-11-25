package com.zhuxinquan;

import com.opensymphony.xwork2.ActionSupport;

public class TestExpressionAction extends ActionSupport{
	private String stuName;
	private String stuPassword;
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getStuPassword() {
		return stuPassword;
	}
	public void setStuPassword(String stuPassword) {
		this.stuPassword = stuPassword;
	}
	public String execute(){
		addActionMessage("Success");
		return SUCCESS;
	}
}
