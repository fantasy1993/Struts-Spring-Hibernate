<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<title><bean:message key="welcome.info"/></title>
</head>
<body>
	<h3><bean:write name="user" property="name"></bean:write><bean:message key="welcome.info"/></h3>
	<p><logic:notEmpty name="user" property="email">您注册的邮箱是：<bean:write name="user" property="email"></bean:write></logic:notEmpty>
	<logic:empty name="user" property="email">您未注册邮箱。</logic:empty></p>
</body>
</html>
