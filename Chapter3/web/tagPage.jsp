<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%--
  Created by IntelliJ IDEA.
  User: zhuxinquan
  Date: 16-9-19
  Time: 下午8:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<bean:page id="req" property="request"/>
<html>
<head>
    <title>tagPage</title>
</head>
<body>
    客户端地址：<bean:write name="req" property="localAddr"/>
    主机名称:<bean:write name="req" property="localName"/>
    客户端语言环境:<bean:write name="req" property="locale"/>
</body>
</html>
