<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<title>login</title>
</head>
<body>
	<s:actionerror/>
	<s:form method="POST" action="login">
		<s:textfield name="userName" key="lable.text.userName"></s:textfield><br />
		<s:password name="password" key="lable.text.password"></s:password><br />
		<s:submit type="input" action="login" method="login" key="lable.text.login"/>
	</s:form>
</body>
</html>