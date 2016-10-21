<%--
  Created by IntelliJ IDEA.
  User: zhuxinquan
  Date: 16-10-20
  Time: 下午10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<html:form action="/registerIntroduction.do" method="post">
    <b>Introduction</b>
    <html:textarea property="introduction" rows="3" cols="30" value=""/><br>
    <html:errors property="introductionError" bundle="CN"/>
    <html:submit>注册</html:submit>
    <html:reset>重新输入</html:reset>
    <html:hidden property="hiddenInfo" value="Introduction"/>
</html:form>