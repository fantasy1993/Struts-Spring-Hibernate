package action;

import com.opensymphony.xwork2.ActionSupport;
import model.Users;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import service.IUserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by zhuxinquan on 16-12-2.
 */
public class RegistAction extends ActionSupport implements ServletRequestAware {
    private String userName;

    private String password;

    private String email;

    private Users user;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    private IUserService userService;

    public IUserService getUserService() {
        return userService;
    }

    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    public String input() {
        System.out.println("Registe Action Input:");
        return INPUT;
    }

    public String checkUser() throws Exception {
        System.out.println("checkUser()");
        String userName = servletRequest.getParameter("userName");
        boolean isNameValid = userService.isNameValid(userName);
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setHeader("Cache-Control", "no-store");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("text/html");
        response.getWriter().write("{\"isNameValid\":" + isNameValid + "}");
        System.out.println(isNameValid);
        return null;
    }

    public String regist() throws Exception {
        System.out.println("in register() action");
        Users user = new Users();
        user.setName(userName);
        user.setPassword(password);
        user.setEmail(email);
        try {
            userService.addUser(user);
        } catch (RuntimeException e) {
            servletRequest.setAttribute("fail", "failure, please re-regist!");
            return INPUT;
        }
        setUser(user);
        System.out.println("register action:" + user);
        return SUCCESS;
    }

    protected HttpServletRequest servletRequest = null;
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        this.servletRequest = httpServletRequest;
    }

}
