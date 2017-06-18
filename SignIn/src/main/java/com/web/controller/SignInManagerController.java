package com.web.controller;

import com.web.model.User;
import com.web.service.SignInService;
import com.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by zhuxinquan on 6/13/17.
 */
@Controller
@RequestMapping("/signinmanager")
public class SignInManagerController {

    @Autowired
    SignInService signInService;

    @Autowired
    UserService userService;

    @RequestMapping("")
    public ModelAndView signinmanager(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if(session.getAttribute("login") != null) {
            if((Boolean)session.getAttribute("login") == false){
                request.setAttribute("info", "请登陆");
                request.setAttribute("redirectPage", "/");
                return new ModelAndView("redirect");
            }
        }
        User user = (User) session.getAttribute("user");
        if(user.getFlag() == 0){
            request.setAttribute("info", "你无权进行操作！");
            return new ModelAndView("home");
        }
        int countNormal = signInService.countCurDateNormal();
        int countLeave = signInService.countCurDateLeave();
        int countAbsent = userService.countUser() - countLeave - countNormal;
        request.setAttribute("normal", countNormal);
        request.setAttribute("absent", countAbsent);
        request.setAttribute("leave", countLeave);
        return new ModelAndView("signinmanager");
    }

    @RequestMapping("approve")
    public ModelAndView approve(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if(session.getAttribute("login") != null) {
            if((Boolean)session.getAttribute("login") == false){
                request.setAttribute("info", "请登陆");
                request.setAttribute("redirectPage", "/");
                return new ModelAndView("redirect");
            }
        }
        User user = (User) session.getAttribute("user");
        if(user.getFlag() == 0){
            request.setAttribute("info", "你无权进行操作！");
            return new ModelAndView("home");
        }
        return new ModelAndView("approve");
    }

}
