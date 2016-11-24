<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:actionerror/>
<s:actionmessage/>
<s:form action="login" method="post">
	<s:textfield name="userName" label="帐号"/>
	<s:password name="userPassword" label="密码" showPassword="true"/>
	<s:submit value="登录"/>
</s:form>
<s:a action="test">未登录时，自定义拦截器测试！</s:a>
