<%--
  Created by IntelliJ IDEA.
  User: zhuxinquan
  Date: 6/12/17
  Time: 10:44 PM
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
    <title>用户中心</title>
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
            <span>当前位置 >> 个人中心</span>
        </div>
        <hr style="border-color: black; margin-top: 0px; border-style: dashed; margin-bottom: 0px;">
        <div id="echarts">
            <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/echarts-all-3.js"></script>
            <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts-stat/ecStat.min.js"></script>
            <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/extension/dataTool.min.js"></script>
            <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/map/js/china.js"></script>
            <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/map/js/world.js"></script>
            <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=ZUONbpqGBsYGXNIYHicvbAbM"></script>
            <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/extension/bmap.min.js"></script>
            <script type="text/javascript">
                var dom = document.getElementById("echarts");
                var myChart = echarts.init(dom);
                var app = {};
                option = null;
                option = {
                    title : {
                        text: '考勤统计',
//                        subtext: '纯属虚构',
                        x:'center'
                    },
                    tooltip : {
                        trigger: 'item',
                        formatter: "{a} <br/>{b} : {c} ({d}%)"
                    },
                    legend: {
                        orient: 'vertical',
                        left: 'left',
                        data: ['正常','请假','缺勤']
                    },
                    series : [
                        {
                            name: '考勤状态',
                            type: 'pie',
                            radius : '55%',
                            center: ['50%', '60%'],
                            data:[
                                {value:<%=request.getAttribute("countNormal")%>, name:'正常'},
                                {value:<%=request.getAttribute("countLeave")%>, name:'请假'},
                                {value:<%=request.getAttribute("absent")%>, name:'缺勤'},
                            ],
                            itemStyle: {
                                emphasis: {
                                    shadowBlur: 10,
                                    shadowOffsetX: 0,
                                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                                }
                            }
                        }
                    ]
                };
                ;
                if (option && typeof option === "object") {
                    myChart.setOption(option, true);
                }
            </script>
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