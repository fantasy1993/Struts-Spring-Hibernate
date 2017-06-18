<%@ page import="com.web.model.User" %><%--
  Created by IntelliJ IDEA.
  User: zhuxinquan
  Date: 6/13/17
  Time: 8:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    User user = (User) session.getAttribute("user");
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
    <link rel="stylesheet" href="/css/laydate.css">
    <link rel="stylesheet" href="/css/laydate1.css">
    <link rel="stylesheet" href="/css/index.css">
    <link rel="stylesheet" href="/css/menu.css">
    <script src="/js/laydate.js"></script>
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
            <span>当前位置 >> 个人中心 >> 请假申请</span>
        </div>
        <hr style="border-color: black; margin-top: 0px; border-style: dashed; margin-bottom: 0px;">
        <div id="userinfo">
            <div id="askforleave">
                <form class="form-horizontal" action="/askforleave/submit" method="post">
                    <input name="uid" type="hidden" value="<%=user.getId()%>"/>
                    <div class="form-group">
                        <label for="something" class="col-sm-2 control-label">请假事由</label>
                        <div class="col-sm-10">
                            <textarea type="text" class="form-control" id="something" name="something" placeholder="请假事由"></textarea>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputUserName" class="col-sm-2 control-label">请假时间</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="inputUserName" name="time" onclick="laydate()" placeholder="格式：2017-01-02"/>
                        </div>
                        <script>
                            ;!function(){
                                laydate({
                                    elem: '#demo'
                                })
                            }();
                        </script>
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