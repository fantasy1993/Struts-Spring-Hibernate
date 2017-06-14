package com.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by zhuxinquan on 6/12/17.
 */
@Controller("LogoutController")
@RequestMapping("/logout")
public class LogoutController {

    @RequestMapping("")
    public ModelAndView login(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("login", false);
        request.setAttribute("info", "退出成功");
        request.setAttribute("redirectPage", "/");
        return new ModelAndView("redirect");
    }

}
