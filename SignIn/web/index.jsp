<%--
  Created by IntelliJ IDEA.
  User: zhuxinquan
  Date: 6/5/17
  Time: 11:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
  <meta charset="utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <meta http-equiv="Cache-Control" content="no-siteapp"/>
  <meta name="renderer" content="webkit" />
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
  <meta name="description" content="Plane UI" />
  <meta name="keywords" content="Plane UI" />
  <title>Login - Sign In</title>

  <script type="text/javascript" src="/js/jquery-2.1.1.min.js"></script>
  <script type="text/javascript" src="/js/planeui.js"></script>
  <link rel="icon" type="image/png" href="/image/favicon.png" />
  <link rel="stylesheet" type="text/css" href="http://pandao.github.io/dist/css/planeui.css">
  <link rel="stylesheet" type="text/css" href="/css/login.css" />
</head>
<body>
<a name="top"></a>
<div class="pui-layout pui-flexbox pui-flex-column login-layout">
  <div class="pui-layout pui-flex login-main">
    <div class="pui-layout pui-layout-fixed pui-layout-fixed-1200 login-main-con">
      <div class="login-panel">
        <form class="pui-form login-form" action="/login/" method="post">
          <div class="pui-form-group">
            <h1 class="pui-text-white pui-text-normal">
              <i class="planeui-logo-2x pui-text-xxxxxl"></i> 登录 Login
            </h1>
            <div role="username">
              <input type="text" name="username" maxlength="16" class="pui-unbordered" placeholder="用户名" />
              <i class="fa fa-user pui-text-blue"></i>
            </div>
          </div>
          <div class="pui-form-group">
            <div role="password">
              <input type="password" name="password" maxlength="16" class="pui-unbordered" placeholder="密码" />
              <i class="fa fa-lock pui-text-blue"></i>
            </div>
          </div>
          <div class="pui-form-group">
            <div role="vcode">
              <input type="text" name="vcode" maxlength="4" class="pui-unbordered" placeholder="验证码" />
              <i class="fa fa-shield pui-text-blue"></i>
              <img src="/vcode" id="vcode-img" />
            </div>
          </div>
          <div class="pui-form-group">
            <input type="submit" name="submit" class="pui-btn pui-btn-default pui-bg-blue-800 pui-unbordered" value="登录" />
            <span><a href="/register" class="pui-text-white pui-text-xs">注册</a></span>
          </div>
        </form>
      </div>
    </div>
  </div>
  <footer class="pui-layout pui-layout-fixed pui-layout-fixed-1200 login-footer">
    <div class="copyright">
      <p>Copyright &copy;
        <script type="text/javascript">
            copyright=new Date();
            update=copyright.getFullYear();
            document.write(update);
        </script>
        All Rights Reserved.<small class="pui-right">代码如诗</small></p>
    </div>
  </footer>
</div>
</body>
</html>