package web;


import com.opensymphony.xwork2.ActionSupport;
import database.UsersEntity;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import service.IUserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


public class UserAction extends ActionSupport implements ServletRequestAware {

	private static final long serialVersionUID = 919351469209964103L;

	Logger logger = Logger.getLogger(UserAction.class);

	private IUserService userService;
	
	protected HttpServletRequest servletRequest = null;
	
	private String userName;
	
	private String password;
	
	private String email;
	
	private UsersEntity user;
	
	public UsersEntity getUser() {
		return user;
	}

	public void setUser(UsersEntity user) {
		this.user = user;
	}

	public String login() throws Exception {
		UsersEntity user = null;
		try {
			user = userService.getUserByNameAndPassword(userName, password);
		} catch (Exception e) {
			logger.error(e);
		}
		if(user == null) {
			addError("errors.userNameOrPassword");
			return INPUT;
		}
		setUser(user);
		return SUCCESS;
	}

	public String input() {
		return INPUT;
	}

	public String regist() throws Exception {
		UsersEntity user = new UsersEntity();
		user.setUserName(userName);
		user.setuPassword(password);
		user.setuEmail(email);
		try {
			userService.addUser(user);
		} catch (RuntimeException e) {
			logger.error(e);
			servletRequest.setAttribute("fail", "failure, please re-regist!");
			return INPUT;
		}
		setUser(user);
		return SUCCESS;
	}

	public String checkUser() throws Exception {
		String userName = servletRequest.getParameter("userName");
		boolean isNameValid = userService.isNameValid(userName);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Cache-Control", "no-store");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("text/html");
		response.getWriter().write("{\"isNameValid\":" + isNameValid + "}");
		return null;
	}

	public String list() throws Exception {
		List<UsersEntity> userList = null;
		try {
			userList = userService.findAll();
		} catch (RuntimeException e) {
			logger.error(e);
		}
		servletRequest.setAttribute("userList", userList);
		return "userlist";
	}

	public void addError(String errorKey) {
		addActionError(getText(errorKey));
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

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

	public void setServletRequest(HttpServletRequest request) {
		this.servletRequest = request;
	}

}
