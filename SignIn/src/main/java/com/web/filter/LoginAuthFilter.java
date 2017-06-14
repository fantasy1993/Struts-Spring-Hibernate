package com.web.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by zhuxinquan on 6/12/17.
 */
public class LoginAuthFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        if( request.getSession().getAttribute("login") != null &&  (Boolean)request.getSession().getAttribute("login")  == false){
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } else {
            filterChain.doFilter(request, response);
        }
    }

    public void destroy() {

    }
}
