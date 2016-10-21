<%--
  Created by IntelliJ IDEA.
  User: zhuxinquan
  Date: 16-10-20
  Time: 下午10:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<html:form action="/registerDetail.do" method="post">
    <b>详情</b>
    sex：<html:radio property="sex" value="male"/>男
         <html:radio property="sex" value="female"/>女
    <html:submit>注册</html:submit>
    <html:reset>重新输入</html:reset>
    <html:hidden property="hiddenInfo" value="Detail"/>
</html:form>
