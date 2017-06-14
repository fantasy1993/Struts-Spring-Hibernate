<%@ page import="com.web.model.User" %><%--
  Created by IntelliJ IDEA.
  User: zhuxinquan
  Date: 6/8/17
  Time: 8:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    User user = (User)session.getAttribute("user");
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <!--jquery-->
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    <script src="/js/jquery1.8.3.min.js"></script>
    <script src="/js/easing.js"></script>
    <!--bootstrap-->
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" type="image/png" href="/image/favicon.png" />
    <link rel="stylesheet" href="/css/index.css">
    <link rel="stylesheet" href="/css/menu.css">
    <title>用户中心</title>
</head>
<body>

<script type="text/javascript">
    <%
    if(request.getAttribute("info") != null){
    %>
    window.onload=function () {
        alert("<%= request.getAttribute("info") %>")
    }
    <%
    }
    %>
</script>
<div id="container">

    <div id="header">
        <div id="headertitle">
            <h1>签到管理系统</h1>
        </div>
        <div id="exist">
            <a href="/logout/"><button type="button" class="btn btn-info">安全退出</button></a>
        </div>
    </div>

    <div id="menu">
        <ul class="menu">
            <li class="level1">
                <a href="/login/userinfo">个人中心</a>
            </li>
            <li class="level1">
                <a href="/login/statistics">考勤统计</a>
            </li>
            <li class="level1">
                <a href="/login/askforleave">请假申请</a>
            </li>
            <li class="level1">
                <a href="/signinmanager">签到管理</a>
            </li>
        </ul>
    </div>

    <div id="content">
        <div id="currentlocaltion">
            <span>当前位置 >> 个人中心</span>
        </div>
        <hr style="border-color: black; margin-top: 0px; border-style: dashed; margin-bottom: 0px;">
        <div id="userinfo">
            <div class="avatar">
                <img src="http://q2.qlogo.cn/headimg_dl?spec=100&dst_uin=<%=user.getQq()%>">
            </div>
            <div class="row">
                <div class="col-md-2">
                    姓 名:
                </div>
                <div class="col-md-3">
                    <%=user.getUsername()%>
                </div>
            </div>
            <div class="row">
                <div class="col-md-2">
                    E-mail:
                </div>
                <div class="col-md-3">
                    <%=user.getEmail()%>
                </div>
            </div>
            <div class="row">
                <div class="col-md-2">
                    Phone:
                </div>
                <div class="col-md-3">
                    <%=user.getPhone()%>
                </div>
            </div>
            <div class="row">
                <div class="col-md-2">
                    QQ:
                </div>
                <div class="col-md-3">
                    <%=user.getQq()%>
                </div>
            </div>
            <div class="row">
                <div class="col-md-2">
                    性别:
                </div>
                <div class="col-md-3">
                    <%=user.getGender()%>
                </div>
            </div>
            <div class="manager">
                <a class="btn btn-default userinfobutton" href="/changeinfo" role="button">修改信息</a>
                <a class="btn btn-default userinfobutton" href="/changepasswd" role="button">修改密码</a>
            </div>
        </div>
    </div>

    <div id="footer">
        <p>Copyright &copy;
            <script type="text/javascript">
                copyright=new Date();
                update=copyright.getFullYear();
                document.write(update);
            </script>
            All Rights Reserved.</p>
    </div>

</div>
</body>
</html>