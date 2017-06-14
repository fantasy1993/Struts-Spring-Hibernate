<%--
  Created by IntelliJ IDEA.
  User: zhuxinquan
  Date: 6/7/17
  Time: 8:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>跳转中...</title>
</head>
<body>
<script type="text/javascript">
    <%
    if(request.getAttribute("error") == null){
    %>
    window.onload=function () {
        alert("<%= request.getAttribute("info") %>");
        <%
        if(request.getAttribute("redirectPage") == null){
        %>
        window.location.href='/'
        <%
        } else {
        %>
        window.location.href='<%= request.getAttribute("redirectPage") %>'
        <%
        }
        %>
    }
    <%
    } else {
    %>
    window.onload=function () {
        alert("<%= request.getAttribute("error") %>");
        <%
        if(request.getAttribute("redirectPage") == null){
        %>
        window.location.href='/register'
        <%
        } else {
        %>
        window.location.href='<%= request.getAttribute("redirectPage") %>'
        <%
        }
        %>
    }
    <%
    }
    %>
</script>
</body>
</html>
