<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:actionmessage/>
您的帐号是：<s:property value="userName"/><br>
您的密码是：<s:property value="userPassword"/><br>
<br>
<s:a action="test">成功登录后，自定义拦截器测试！</s:a>