<%--
  Created by IntelliJ IDEA.
  User: zhuxinquan
  Date: 16-9-8
  Time: 下午8:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%--<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"  %>--%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"  %>
<html:html>
<head>
    <meta http-equiv="content-type" content="text/html;charset=UTF-8">
    <title>用户登陆页面</title>
</head>
<body>
    <html:form action="/login.do" method="post">
        Account:<html:text property = "userName"/><html:errors property = "errorUserInfoAccount"/><br>
        Password:<html:password property = "userPassword"/><html:errors property = "errorUserInfoPasswd"/><br>
        <html:submit>Login</html:submit>
    </html:form>
</body>
</html:html>
