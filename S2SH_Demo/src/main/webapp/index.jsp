<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<a href='<s:url value="/login.jsp"/>'>登录</a>&nbsp;&nbsp;
<a href='<s:url action="regist" method="input"/>'>注册</a>&nbsp;&nbsp;
<%--<a href='<s:url action="/regist" var="input"/>'>注册</a>&nbsp;&nbsp;--%>
<a href='<s:url action="user" method="list"/>'>用户列表</a>