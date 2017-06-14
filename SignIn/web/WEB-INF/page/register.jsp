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
    <title>Register - Sign In</title>

    <link rel="icon" type="image/png" href="/image/favicon.png" />
    <link rel="stylesheet" type="text/css" href="http://pandao.github.io/dist/css/planeui.css">
    <link rel="stylesheet" type="text/css" href="/css/login.css" />
    <script type="text/javascript" src="http://static.runoob.com/assets/jquery-validation-1.14.0/lib/jquery.js"></script>
    <script type="text/javascript" src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/jquery.validate.min.js"></script>
    <script type="text/javascript" src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/localization/messages_zh.js"></script>
</head>
<body>
<a name="top"></a>
<div class="pui-layout pui-flexbox pui-flex-column login-layout">
    <div class="pui-layout pui-flex login-main">
        <div class="pui-layout pui-layout-fixed pui-layout-fixed-1200 login-main-con">
            <div class="login-panel">
                <script type="text/javascript">
                    $().ready(function() {
                        $("#registerForm").validate({
                            rules: {
                                username: "required",
                                email: "required",
                                qq: "required",
                                password: "required",
                                confirmpassword: "required",
                                vcode: "required",
                                username: {
                                    required: true,
                                    minlength: 2,
                                },
                                password: {
                                    required: true,
                                    minlength: 6,
                                    maxlength:16
                                },
                                confirmpassword: {
                                    required: true,
                                    minlength: 6,
                                    maxlength:16,
                                    equalTo: "#password"
                                },
                                email: {
                                    required: true,
                                    email: true
                                },
                                vcode: {
                                    required: true,
                                }
                            },
                            messages: {
                                username: {
                                    required: "请输入用户名",
                                    minlength: "用户名必至少两个字母组成"
                                },
                                password: {
                                    required: "请输入密码",
                                    minlength: "密码长度不能小于 6 个字母",
                                    maxlength: "密码长度不能小于 16 个字母"
                                },
                                confirmpassword: {
                                    required: "请输入密码",
                                    minlength: "密码长度不能小于 6 个字母",
                                    maxlength: "密码长度不能小于 16 个字母"
//                                    equalTo: "两次密码输入不一致"
                                },
                                vcode: {
                                    require: "请输入验证码"
                                },
                                email: "请输入一个正确的邮箱"
                            }
                        });
                    });
                </script>
                <form class="pui-form login-form" action="/register/registeruser" method="post" id="registerForm">
                    <div class="pui-form-group">
                        <h1 class="pui-text-white pui-text-normal">
                            <i class="planeui-logo-2x pui-text-xxxxxl"></i> 注册 Register
                        </h1>
                        <div role="username">
                            <input type="text" name="username" maxlength="16" class="pui-unbordered" placeholder="用户名" />
                            <i class="fa fa-user pui-text-blue"></i>
                        </div>
                    </div>
                    <div class="pui-form-group">
                        <div role="password">
                            <input type="text" name="email" class="pui-unbordered" placeholder="邮箱" />
                            <i class="fa fa-envelope pui-text-blue"></i>
                        </div>
                    </div>
                    <div class="pui-form-group">
                        <div role="password">
                            <input type="text" name="qq" maxlength="16" class="pui-unbordered" placeholder="QQ" />
                            <i class="fa fa-qq pui-text-blue"></i>
                        </div>
                    </div>
                    <div class="pui-form-group">
                        <div role="password">
                            <input type="text" name="phone" maxlength="11" class="pui-unbordered" placeholder="Phone" />
                            <i class="fa fa-phone pui-text-blue"></i>
                        </div>
                    </div>
                    <div class="pui-form-group">
                        <div role="password">
                            <input type="password" minlength="6" id="password" name="password" maxlength="16" class="pui-unbordered" placeholder="密码" />
                            <i class="fa fa-lock pui-text-blue"></i>
                        </div>
                    </div>
                    <div class="pui-form-group">
                        <div role="password">
                            <input type="password" name="confirmpassword" minlength="6" maxlength="16" class="pui-unbordered" placeholder="确认密码" />
                            <i class="fa fa-lock pui-text-blue"></i>
                        </div>
                    </div>
                    <div class="pui-form-group  select-sex">
                        <i class="fa pui-text-blue fa-transgender"></i>
                        <label>请选择性别：</label>
                        <label><input name="gender" type="radio" value="MEN" checked="checked"/>男</label>
                        <label><input name="gender" type="radio" value="WOMEN" />女</label>
                    </div>
                    <div class="pui-form-group">
                        <div role="vcode">
                            <input type="text" name="vcode" maxlength="4" class="pui-unbordered" placeholder="验证码" />
                            <i class="fa fa-shield pui-text-blue"></i>
                            <img src="/vcode" id="vcode-img" />
                        </div>
                    </div>
                    <div class="pui-form-group">
                        <input type="submit" name="submit" class="pui-btn pui-btn-default pui-bg-blue-800 pui-unbordered" value="注册" style="width: 296px;"/>
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

<script type="text/javascript" src="/js/planeui.js"></script>
<script type="text/javascript" src="/js/jquery-2.1.1.min.js"></script>
</body>
</html>