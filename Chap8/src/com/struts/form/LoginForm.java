package com.struts.form;

import org.apache.struts.validator.ValidatorForm;

/**
 * Created by zhuxinquan on 16-10-26.
 */
public class LoginForm extends ValidatorForm{
    private String userName;
    private String userPasswd;

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
}
