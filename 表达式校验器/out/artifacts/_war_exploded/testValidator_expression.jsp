<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:actionerror/>
<s:actionmessage/>
<s:form method="post" action="testExpression" >
	<s:textfield name="stuName" label="姓名"/>
	<s:textfield name="stuPassword" label="密码"/>
	<s:submit value="添加"/>
</s:form>