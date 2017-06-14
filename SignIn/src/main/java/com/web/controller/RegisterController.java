package com.web.controller;

import com.web.dao.UserDao;
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
 * Created by zhuxinquan on 6/6/17.
 */
@Controller("RegisterController")
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    UserService userService;

    @RequestMapping("")
    public ModelAndView forwardRegister(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("register");
        return modelAndView;
    }

    @RequestMapping("registeruser")
    public ModelAndView registerUser(HttpServletRequest request) {
        User user = new User();
        String username = request.getParameter("username");
        String gender = request.getParameter("gender");
        String email = request.getParameter("email");
        String qq = request.getParameter("qq");
        String passwd = request.getParameter("password");
        String phone = request.getParameter("phone");
        String vcode = request.getParameter("vcode");
        //前端已做确认密码校验
//        String confirmpassword = request.getParameter("confirmpassword");
        user.setUsername(username);
        user.setEmail(email);
        user.setGender(gender);
        user.setPhone(phone);
        user.setPasswd(SHA1.encode(passwd));
        user.setQq(qq);
        HttpSession session = request.getSession();
        String sessionVcode = (String) session.getAttribute("vCode");
        if(userService.existUser(username)){
            request.setAttribute("error", "用户已存在!");
        } else if(sessionVcode != null && !sessionVcode.equals(vcode)) {
            request.setAttribute("error", "验证码不正确!");
        } else {
            request.setAttribute("info", "注册成功，请登陆!");
            userService.insertUser(user);
        }
        return new ModelAndView("redirect");
    }
}
