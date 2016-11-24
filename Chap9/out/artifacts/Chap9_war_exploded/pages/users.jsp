<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="bean" uri="http://jakarta.apache.org/struts/tags-bean" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<fmt:setBundle basename="/com/chinasei/com.chinasei.struts1/MessageResources" var="messageBundle"></fmt:setBundle>
	<title><fmt:message key="lable.text.userlist" bundle="${messageBundle}"></fmt:message></title>
</head>

<body>
	<table border="1">
		<tr>
			<td><bean:message key="lable.text.code"/></td>
			<td><bean:message key="lable.text.userName"/></td>
			<td><bean:message key="lable.text.email"/></td>
		</tr>
		<c:forEach var="user" items="${userList}" varStatus="status">
		<tr>
			<td width="40">${status.index+1}</td>
			<td width="80"><c:out value="${user.name}" /></td>
			<td width="150"><c:out value="${user.email}" /></td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>

