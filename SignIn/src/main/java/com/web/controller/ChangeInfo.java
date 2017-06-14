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
@Controller("ChangeInfo")
public class ChangeInfo {

    @Autowired
    UserService userService;


    @RequestMapping("/changeinfo")
    public ModelAndView changeinfo(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if(session.getAttribute("login") != null) {
            if((Boolean)session.getAttribute("login") == false){
                request.setAttribute("info", "请登陆");
                request.setAttribute("redirectPage", "/");
                return new ModelAndView("redirect");
            }
        }
        return new ModelAndView("changeinfo");
    }

    @RequestMapping("/changeinfo/submit")
    public ModelAndView changinfosubmit(HttpServletRequest request) {
//        String id = request.getParameter("id");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String qq = request.getParameter("qq");
        String phone = request.getParameter("phonenumber");
        String gender = request.getParameter("gender");
        String passwd = request.getParameter("passwd");
//        System.out.println(id + " " + username + " " + email);
        HttpSession session = request.getSession();
        if(session.getAttribute("login") != null) {
            if((Boolean)session.getAttribute("login") == false){
                request.setAttribute("info", "请登陆");
                request.setAttribute("redirectPage", "/");
                return new ModelAndView("redirect");
            }
        }
        User user = (User) session.getAttribute("user");
        User user1 = new User();
        user1.setId(user.getId());
        user1.setGender(gender);
        user1.setQq(qq);
        user1.setEmail(email);
        user1.setUsername(username);
        user1.setPhone(phone);
        if(!user.getPasswd().equals(SHA1.encode(request.getParameter("passwd")))){
            System.out.println("密码错误");
            request.setAttribute("info", "原密码错误");
            return new ModelAndView("changeinfo");
        }
        userService.updateUserInfo(user1);
        session.setAttribute("user", user1);
        return new ModelAndView("home");
    }
}
