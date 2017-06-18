package com.web.controller;

import com.web.model.LeaveMessage;
import com.web.model.User;
import com.web.service.LeaveMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by zhuxinquan on 6/14/17.
 */
@Controller("AskForLeave")
public class AskForLeaveController {

    @Autowired
    LeaveMessageService leaveMessageService;

    @RequestMapping("/askforleave/submit")
    public ModelAndView askforleavesubmit(@ModelAttribute LeaveMessage leaveMessage,  HttpServletRequest request) {
        HttpSession session = request.getSession();
        if(session.getAttribute("login") != null) {
            if((Boolean)session.getAttribute("login") == false){
                request.setAttribute("info", "请登陆");
                request.setAttribute("redirectPage", "/");
                return new ModelAndView("redirect");
            }
        }
        leaveMessageService.insertLeaveMessage(leaveMessage);
        request.setAttribute("info", "请假成功，等待批准");
        return new ModelAndView("askforleave");
    }

    @RequestMapping("/approval")
    public ModelAndView approval(HttpServletRequest request) {
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
        String id = request.getParameter("id");
        return new ModelAndView("home");
    }

}
