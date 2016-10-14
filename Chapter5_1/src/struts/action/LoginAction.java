package struts.action;

import org.apache.struts.action.*;
import struts.form.LoginForm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by zhuxinquan on 16-8-30.
 */

public class LoginAction extends Action {
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        DynaActionForm loginForm = (DynaActionForm)form;
//        LoginForm loginForm = (LoginForm)form;
        String userName = (String)loginForm.get("userName");
        String userPassword  = (String)loginForm.get("userPassword");
//        String userName = loginForm.getUserName();
//        String userPassword = loginForm.getUserPassword();

        if("admin".equals(userName) && "admin".equals(userPassword)) {
//            return new ActionForward("/success.jsp");
            return mapping.findForward("success");
        }
        ActionMessages errors = new ActionMessages();
        if(("admin".equals(userName)) != true){
            errors.add("errorUserInfoAccount", new ActionMessage("userInfoAccount_wrong"));
//            throw new Exception("账号错误");
        }
        if(("admin".equals(userPassword)) != true){
            errors.add("errorUserInfoPasswd", new ActionMessage("userInfoPasswd_wrong"));
//            throw new Exception("密码错误");

        }
        this.saveErrors(request, errors);
        return new ActionForward("/login.jsp");
//        return mapping.findForward("success");
    }
}