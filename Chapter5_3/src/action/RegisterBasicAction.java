package action;

import form.RegisterForm;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by zhuxinquan on 16-10-20.
 */
public class RegisterBasicAction extends Action {
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        RegisterForm registerForm = (RegisterForm)form;
        request.getSession().setAttribute("account", ((RegisterForm) form).getUserName());
        return mapping.findForward("detail");
    }
}
