<%@ taglib prefix="tiles" uri="http://jakarta.apache.org/struts/tags-tiles" %>
<%--
  Created by IntelliJ IDEA.
  User: zhuxinquan
  Date: 16-10-27
  Time: 下午9:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><tiles:getAsString name="title"/></title>
</head>
<body>
    <table width="100%" height="484" border="0">
        <tr>
            <td height="100" colspan="2"><tiles:insert attribute="logo"/> </td>
        </tr>
        <tr>
            <td height="20" colspan="2" bgcolor="#DDDDDD"><tiles:insert attribute="menu"/> </td>
        </tr>
        <tr>
            <td width="160" rowspan="2"><tiles:insert attribute="left"/> </td>
            <td width="921" height="235" align="center" valign="top"><tiles:insert attribute="content"/> </td>
        </tr>
        <tr>
            <td height="20" align="right"><tiles:insert attribute="copyright"/> </td>
        </tr>
    </table>
</body>
</html>