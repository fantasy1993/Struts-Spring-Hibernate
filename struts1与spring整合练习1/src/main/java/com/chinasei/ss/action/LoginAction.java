package com.chinasei.ss.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.chinasei.ss.form.LoginForm;

public class LoginAction extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		System.out.println("LoginAction");
		
		LoginForm loginForm = (LoginForm) form;
		
		String uName = loginForm.getUserName();
		String uPassword = loginForm.getUserPassword();

		String msg = "��������ʺ��ǣ�" + uName + "<br>������������ǣ�" + uPassword;
		request.setAttribute("message", msg);
		return mapping.findForward("welcome");
	}

}
