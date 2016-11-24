<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<s:form action="login" method="post">
	<s:textfield name="userName" label="帐号"/>
	<s:password name="userPassword" label="密码"/>
	<s:submit value="登录"/><s:actionerror/>
</s:form>
