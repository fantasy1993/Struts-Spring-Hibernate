package struts.form;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zhuxinquan on 16-8-30.
 */
public class LoginForm extends ActionForm {
    private String userName = null;
    private String userPassword = null;

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

    @Override
    public void reset(ActionMapping mapping, HttpServletRequest request) {
        this.userName = "admin";
        this.userPassword = "admin";
    }

    @Override
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        if(userName == ""){
            errors.add("errorUserInfoAccount", new ActionMessage("nameNull"));
        }else if(userName.length() < 3 || userName.length() > 16){
            errors.add("errorUserInfoAccount", new ActionMessage("nameLengthError"));
        }

        if(userPassword == ""){
            errors.add("errorUserInfoPasswd", new ActionMessage("passwdNull"));
        }else if(userPassword.length() < 3 || userPassword.length() > 16){
            errors.add("errorUserInfoPasswd", new ActionMessage("passwdLengthError"));
        }

        return errors;
    }


}
