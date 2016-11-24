<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html:html>
<head>
	<title><bean:message key="lable.text.login"/></title>
</head>
<body>
	
	<html:form action="/login.do?method=login" method="POST" onsubmit="return validateUserForm(this);">
		<bean:message key="lable.text.userName"/><bean:message key="lable.text.colon"/><html:text property="userName"></html:text><html:errors property="userName"/><br />
		<bean:message key="lable.text.password"/><bean:message key="lable.text.colon"/>&nbsp;&nbsp;&nbsp;&nbsp;<html:password property="password"></html:password><html:errors property="password"/><br />
		<html:submit><bean:message key="lable.text.login"/></html:submit>
	</html:form>
</body>
</html:html>
