<%--
  Created by IntelliJ IDEA.
  User: zhuxinquan
  Date: 16-10-20
  Time: 下午8:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<html:form action="/registerBasic.do" method="post">
    <b>基本信息</b><br>
    Account:<html:text property="userName"/>
            <html:errors property="userNameError" bundle="CN"/><br>
    Passwd:<html:text property="userPasswd"/>
            <html:errors property="userPassError" bundle="CN"/><br>
    Confirm:<html:text property="confirmPasswd"/>
            <html:errors property="confirmPasswdError" bundle="CN"/><br>
    <html:submit>注册</html:submit>
    <html:reset>reset</html:reset>
    <html:hidden property="hiddenInfo" value="Basic"/>
</html:form>