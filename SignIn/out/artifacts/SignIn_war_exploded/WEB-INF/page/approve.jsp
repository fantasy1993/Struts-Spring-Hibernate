<%@ page import="com.web.model.User" %>
<%@ page import="java.util.List" %>
<%@ page import="com.web.model.LeaveMessage" %><%--
  Created by IntelliJ IDEA.
  User: zhuxinquan
  Date: 6/13/17
  Time: 8:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    User user = (User) session.getAttribute("user");
    List<LeaveMessage> list = (List<LeaveMessage>) request.getAttribute("leavemessagelist");
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
            <span>当前位置 >> 个人中心 >> 签到管理 >> 请假审批</span>
        </div>
        <hr style="border-color: black; margin-top: 0px; border-style: dashed; margin-bottom: 0px;">
        <div id="leaveuser">
            <table class="table table-bordered">
                <tr>
                    <th>Username</th>
                    <th>Something</th>
                    <th>Time</th>
                    <th>Approve</th>
                </tr>
                <%
                    for (LeaveMessage leaveMessage:list) {
                %>
                <tr>
                    <td><%=leaveMessage%></td>
                    <td>2</td>
                    <td>3</td>
                    <td>
                        <a href="/approval?id=12"><button>批准</button></a>
                        <a href="/approval?id=12"><button>撤销</button></a>
                    </td>
                </tr>
                <%
                    }
                %>
                <tr>
                    <td>1</td>
                    <td>2</td>
                    <td>3</td>
                    <td>
                        <a href="/approval?id=12"><button>批准</button></a>
                        <a href="/approval?id=12"><button>撤销</button></a>
                    </td>
                </tr>
            </table>
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