<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<title><s:text name="lable.text.userlist"></s:text></title>
</head>
<body>
	<table border="1">
		<tr>
			<td><s:text name="lable.text.ordinal"/></td>
			<td><s:text name="lable.text.userName"/></td>
			<td><s:text name="lable.text.email"/></td>
		</tr>
		<s:iterator value="#request.userList" status="status">
		<tr>
			<td width="40"><s:property value="#status.index+1"></s:property></td>
			<td width="80"><s:property value="name"></s:property></td>
			<td width="150"><s:property value="email"></s:property></td>
		</tr>
		</s:iterator>
	</table>
</body>
</html>
