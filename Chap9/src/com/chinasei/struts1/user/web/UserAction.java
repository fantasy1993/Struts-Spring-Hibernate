package com.chinasei.struts1.user.web;


import com.chinasei.struts1.user.Model.Users;
import com.chinasei.struts1.user.form.UserForm;
import com.chinasei.struts1.user.service.IUserService;
import com.chinasei.struts1.user.service.impl.UserServiceImpl;
import org.apache.struts.action.*;
import org.apache.struts.actions.DispatchAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class UserAction extends DispatchAction {
	
	private static IUserService userService = new UserServiceImpl();
	
	//Logger logger = Logger.getLogger(UserAction.class);

	public ActionForward login(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("login");
		UserForm loginForm = (UserForm)form;
		String userName = loginForm.getUserName();
		String password = loginForm.getPassword();
		Users user = null;
		try {
			user = userService.getUserByNameAndPassword(userName, password);
		} catch (Exception e) {
			//logger.error(e);
		}
		if(user == null) {
			return mapping.findForward(mapping.getInput());
		}
//		System.out.println("UserAction:" + user.getEmail() + " " + user.getName());
		request.setAttribute("user", user);
		return mapping.findForward("success");
	}
	
	public ActionForward toRegist(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("toRegist");
		saveToken(request);
		return mapping.findForward("regist");
	}
	
	public ActionForward regist(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionMessages messages = new ActionMessages();
		if(!isTokenValid(request)) {
			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("errors.invalid.token"));
			saveErrors(request, messages);
			saveToken(request);
			return mapping.findForward("regist");
		}
		resetToken(request);
		UserForm loginForm = (UserForm)form;
		String userName = loginForm.getUserName();
		String password = loginForm.getPassword();
		String email = loginForm.getEmail();
		Users user = new Users();
		user.setName(userName);
		user.setPassword(password);
		user.setEmail(email);
		int result = 0;
		try {
			result = userService.addUser(user);
		} catch (RuntimeException e) {
			//logger.error(e);
			e.printStackTrace();
		}
		if(result < 1) {
			request.setAttribute("fail", "failure, please re-regist!");
			return mapping.findForward("regist");
		}
		request.setAttribute("user", user);
		return mapping.findForward("success");
	}

	public ActionForward checkUser(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userName = request.getParameter("userName");
		boolean isNameValid = userService.isNameValid(userName);
		response.getWriter().write("{\"isNameValid\":" + isNameValid + "}");
		return null;
	}

	public ActionForward list(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("list");
		List<Users> userList = null;
		try {
			userList = userService.findAll();
		} catch (RuntimeException e) {
			//logger.error(e);
		}
		request.setAttribute("userList", userList);
		return mapping.findForward("userlist");
	}

}
