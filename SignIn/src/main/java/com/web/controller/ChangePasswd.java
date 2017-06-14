package com.web.controller;

import com.web.model.User;
import com.web.service.UserService;
import com.web.util.SHA1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by zhuxinquan on 6/13/17.
 */
@Controller("ChangePasswd")
public class ChangePasswd {

    @Autowired
    UserService userService;

    @RequestMapping("/changepasswd")
    public ModelAndView changeinfo(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if(session.getAttribute("login") != null) {
            if((Boolean)session.getAttribute("login") == false){
                request.setAttribute("info", "请登陆");
                request.setAttribute("redirectPage", "/");
                return new ModelAndView("redirect");
            }
        }
        return new ModelAndView("changepasswd");
    }

    @RequestMapping("/changepasswd/submit")
    public ModelAndView changinfosubmit(HttpServletRequest request) {
        String oldPasswd = request.getParameter("oldpasswd");
        String newPasswd = request.getParameter("newpasswd");
        String confirmpasswd = request.getParameter("confirmpasswd");
        HttpSession session = request.getSession();
        if(session.getAttribute("login") != null) {
            if((Boolean)session.getAttribute("login") == false){
                request.setAttribute("info", "请登陆");
                request.setAttribute("redirectPage", "/");
                return new ModelAndView("redirect");
            }
        }
        User user = (User) session.getAttribute("user");
        if(!user.getPasswd().equals(SHA1.encode(oldPasswd))){
            request.setAttribute("info", "原密码错误");
            return new ModelAndView("changepasswd");
        }else if(!newPasswd.equals(confirmpasswd)) {
//            System.out.println(newPasswd + ": " + confirmpasswd);
            request.setAttribute("info", "确认密码不一致");
            return new ModelAndView("changepasswd");
        }
        user.setPasswd(SHA1.encode(newPasswd));
        userService.updatePaswd(user);
        request.setAttribute("info", "密码修改成功");
        return new ModelAndView("home");
    }
}
