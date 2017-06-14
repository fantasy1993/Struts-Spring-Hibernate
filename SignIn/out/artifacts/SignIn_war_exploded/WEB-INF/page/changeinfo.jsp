<%@ page import="com.web.model.User" %><%--
  Created by IntelliJ IDEA.
  User: zhuxinquan
  Date: 6/13/17
  Time: 9:41 AM
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
    <script src="/bootstrap.min.js"></script>
    <script src="/jquery1.8.3.min.js"></script>
    <script src="/bootstrap.min.js"></script>
    <script src="/easing.js"></script>
    <!--bootstrap-->
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/css/index.css">
    <link rel="stylesheet" href="/css/menu.css">
    <title>修改信息</title>
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
            <span>当前位置 >> 个人中心 >> 修改信息</span>
        </div>
        <hr style="border-color: black; margin-top: 0px; border-style: dashed; margin-bottom: 0px;">
        <div id="userinfo">
            <div class="avatar">
                <img src="http://q2.qlogo.cn/headimg_dl?spec=100&dst_uin=<%=user.getQq()%>">
            </div>
            <div id="changeinfo">
                <form class="form-horizontal" action="/changeinfo/submit" method="post">
                    <%--<input type="hidden" name="id" value="<%=user.getId()%>"/>--%>
                    <div class="form-group">
                        <label for="inputUserName" class="col-sm-2 control-label">用户名</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="inputUserName" name="username" placeholder="UserName">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputEmail3" class="col-sm-2 control-label">Email</label>
                        <div class="col-sm-10">
                            <input type="email" class="form-control" id="inputEmail3" name="email" placeholder="Email">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputQq" class="col-sm-2 control-label">QQ</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="inputQq" name="qq" placeholder="QQ">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputPhoneNumber" class="col-sm-2 control-label">Phone</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="inputPhoneNumber" name="phonenumber" placeholder="PhoneNumber">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="selectGender" class="col-sm-2 control-label">性别</label>
                        <div class="col-sm-10">
                            <select class="form-control" name="gender" id="selectGender">
                                <option value="MEN" selected="selected">男</option>
                                <option value="WOMEN">女</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputPassword3" class="col-sm-2 control-label">Password</label>
                        <div class="col-sm-10">
                            <input type="password" class="form-control" name="passwd" id="inputPassword3" placeholder="Password">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="submit" class="btn btn-default" value="提交">提交</button>
                        </div>
                    </div>
                </form>
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