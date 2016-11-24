<%@ taglib prefix="bean" uri="http://jakarta.apache.org/struts/tags-bean" %>
<%@ taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html" %>
<%--
  Created by IntelliJ IDEA.
  User: zhuxinquan
  Date: 16-10-26
  Time: 上午9:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html:form action="/login.do" method="post" onsubmit="return validateLoginForm(this)">
    <bean:message key="info.input" arg0="账号"/>
        <html:text property="userName"/>
        <html:errors property="userName"/>
    <bean:message key="info.input" arg0="密码"/>
        <html:text property="userPasswd"/>
        <html:errors property="userPasswd"/>
    <html:submit><bean:message key="login"/></html:submit>
    <html:javascript formName="loginForm" cdata="false"/>
</html:form>