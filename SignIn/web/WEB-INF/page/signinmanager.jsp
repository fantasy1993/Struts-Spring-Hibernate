<%--
  Created by IntelliJ IDEA.
  User: zhuxinquan
  Date: 6/13/17
  Time: 9:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>

    <!--jquery-->
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    <script src="/js/jquery1.8.3.min.js"></script>
    <!--bootstrap-->
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/css/index.css">
    <link rel="stylesheet" href="/css/menu.css">
    <title>签到管理</title>
</head>
<body>
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
            <span>当前位置 >> 个人中心 >> 签到管理</span>
        </div>
        <hr style="border-color: black; margin-top: 0px; border-style: dashed; margin-bottom: 0px;">
        <div id="manageinfo">
            <span>当前已签到：<%=request.getAttribute("normal")%>人</span><br>
            <span>当前未签到：<%=request.getAttribute("absent")%>人</span><br>
            <span>今日请假：<%=request.getAttribute("leave")%>人</span>
        </div>
        <div class="manager">
            <a class="btn btn-default userinfobutton" href="#" role="button">已签到列表</a>
            <a class="btn btn-default userinfobutton" href="#" role="button">未签到列表</a>
            <a class="btn btn-default userinfobutton" href="/signinmanager/approve" role="button">请假审批</a>
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
