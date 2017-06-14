package com.web.controller;

import com.web.model.User;
import com.web.service.SignInService;
import com.web.service.UserService;
import com.web.util.SHA1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by zhuxinquan on 6/6/17.
 */
@Controller("LoginController")
@RequestMapping("/login")
public class LoginController {

    @Autowired
    UserService userService;

    @Autowired
    SignInService signInService;

    @RequestMapping("")
    public ModelAndView login(HttpServletRequest request) {
        String page = "home";
        String username = request.getParameter("username");
        String passwd = request.getParameter("password");
        String vcode = request.getParameter("vcode");
        HttpSession session = request.getSession();
        String sessionVcode = (String) session.getAttribute("vCode");
        if (userService.existUser(username)) {
            User user = userService.selectUserByUsername(username);
            if (!user.getPasswd().equals(SHA1.encode(passwd))) {
                request.setAttribute("info", "密码错误!");
                page = "redirect";
                return new ModelAndView(page);
            }
        } else {
            request.setAttribute("info", "用户不存在!");
            page = "redirect";
            return new ModelAndView(page);
        }
        if (vcode == null || !vcode.equals(sessionVcode)) {
            request.setAttribute("info", "验证码错误!");
            page = "redirect";
            return new ModelAndView(page);
        }
        User user = userService.selectUserByUsername(username);
        session.setAttribute("login", true);
        session.setAttribute("username", username);
        session.setAttribute("user", user);
        request.setAttribute("user", user);
        if(signInService.querySignIn(user.getId()) == true){
            request.setAttribute("info", "今天已签到！");
        }else {
            signInService.insertSignInRecoder(user.getId());
            request.setAttribute("info", "签到成功！");
        }
        return new ModelAndView(page);
    }

    @RequestMapping("userinfo")
    public ModelAndView userinfo(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if(session.getAttribute("login") != null) {
            if((Boolean)session.getAttribute("login") == false){
                request.setAttribute("info", "请登陆");
                request.setAttribute("redirectPage", "/");
                return new ModelAndView("redirect");
            }
        }
        return new ModelAndView("home");
    }

    @RequestMapping("statistics")
    public ModelAndView statistics(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if(session.getAttribute("login") != null) {
            if((Boolean)session.getAttribute("login") == false){
                request.setAttribute("info", "请登陆");
                request.setAttribute("redirectPage", "/");
                return new ModelAndView("redirect");
            }
        }
        int countNormal = signInService.countCurDateNormal();
        int countLeave = signInService.countCurDateLeave();
        int countUser = userService.countUser();
        request.setAttribute("absent", countUser - countLeave - countNormal);
        request.setAttribute("countLeave", countLeave);
        request.setAttribute("countNormal", countNormal);
        return new ModelAndView("statistics");
    }

    @RequestMapping("askforleave")
    public ModelAndView askforleave(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if(session.getAttribute("login") != null) {
            if((Boolean)session.getAttribute("login") == false){
                request.setAttribute("info", "请登陆");
                request.setAttribute("redirectPage", "/");
                return new ModelAndView("redirect");
            }
        }
        return new ModelAndView("askforleave");
    }
}