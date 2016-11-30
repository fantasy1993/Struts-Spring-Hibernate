<%--
  Created by IntelliJ IDEA.
  User: zhuxinquan
  Date: 16-11-27
  Time: 下午5:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
测试
<a href='<s:url value="/login.jsp" />'>登录</a>&nbsp;&nbsp;
<a href='<s:url action="regist" method="input" />'>注册</a>&nbsp;&nbsp;
<a href='<s:url action="user" method="list" />'>用户列表</a>
