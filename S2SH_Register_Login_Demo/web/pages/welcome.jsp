<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<title><s:text name="welcome.info"/></title>
</head>
<body>
	<h3><s:property value="user.name"></s:property><s:text name="welcome.info"/></h3>
	<p><s:if test="user.email==null || user.email==''">您未注册邮箱。</s:if>
	<s:else>您注册的邮箱是：<s:property value="user.email"></s:property></s:else></p>
</body>
</html>
