package form;

import org.apache.struts.action.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zhuxinquan on 16-10-20.
 */
public class RegisterForm extends ActionForm{
    private String userName;
    private String userPasswd;
    private String confirmPasswd;
    private String sex;
    private String introduction;
    private String hiddenInfo;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPasswd() {
        return userPasswd;
    }

    public void setUserPasswd(String userPasswd) {
        this.userPasswd = userPasswd;
    }

    public String getConfirmPasswd() {
        return confirmPasswd;
    }

    public void setConfirmPasswd(String confirmPasswd) {
        this.confirmPasswd = confirmPasswd;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getHiddenInfo() {
        return hiddenInfo;
    }

    public void setHiddenInfo(String hiddenInfo) {
        this.hiddenInfo = hiddenInfo;
    }

    @Override
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        if("Basic".equals(hiddenInfo)){
            if(userName.equals("")){
                errors.add("userNameError", new ActionMessage("nameNull"));
            }else if(userPasswd.equals("")){
                errors.add("userPassError", new ActionMessage("passwdNull"));
            }else if(!userPasswd.equals(confirmPasswd)){
                errors.add("confirmPasswdError", new ActionMessage("passwdNonEqualError"));
            }
        }else if("Introduction".equals(hiddenInfo)){
            if(introduction.equals("")){
                errors.add("introductionError", new ActionMessage("introductionNull"));
            }
        }
        return errors;
    }
}
