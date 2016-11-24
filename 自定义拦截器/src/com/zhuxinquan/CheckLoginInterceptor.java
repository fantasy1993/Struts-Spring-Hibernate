package com.zhuxinquan;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.Interceptor;

import java.util.Map;

public class CheckLoginInterceptor implements Interceptor {

	public void destroy() {
	}

	public void init() {
	}

	public String intercept(ActionInvocation actionInvocation) throws Exception {
		System.out.println("自定义拦截器");

		Object action = actionInvocation.getAction();
		if (action instanceof LoginAction){
			System.out.println("登录用的Action，不掉用自定义拦截器");
			return actionInvocation.invoke();
		}
		//ȷ��Session���Ƿ����LOGIN
		Map session = actionInvocation.getInvocationContext().getSession();
		String login = (String)session.get("loginFlag");
		if (login != null && login.equals("login")){
			System.out.println("已登录，调用随后的拦截器");
			return actionInvocation.invoke();
		}
		else{
			System.out.println("未登录，返回登陆界面");
			((ActionSupport) action).addActionMessage("");
			return "input";
		}
	}

}
