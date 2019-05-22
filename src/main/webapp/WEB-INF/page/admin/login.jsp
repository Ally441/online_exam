<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ZH-cn">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>后台登录</title>
    <link rel="stylesheet" href="/plugins/layui/css/layui.css">
    <link rel="stylesheet" href="/src/css/login.css">
</head>

<body>
<div class="kit-login">
    <div class="kit-login-bg"></div>
    <div class="kit-login-wapper">
        <h2 class="kit-login-slogan">欢迎使用 <br> Java在线考试后台管理系统</h2>
        <div class="kit-login-form">
            <h4 class="kit-login-title">登录</h4>
            <form class="layui-form" action="/admin/login" method="post">
                <div class="kit-login-row">
                    <div class="kit-login-col">
                        <i class="layui-icon">&#xe612;</i>
                        <span class="kit-login-input">
                <input type="text" name="loginName"   placeholder="用户名" />
              </span>
                    </div>
                    <div class="kit-login-col"></div>
                </div>
                <div class="kit-login-row">
                    <div class="kit-login-col">
                        <i class="layui-icon">&#xe64c;</i>
                        <span class="kit-login-input">
                <input type="password" name="password"  placeholder="密码" />
              </span>
                    </div>
                    <div class="kit-login-col"></div>
                </div>
                <div class="kit-login-row">
                    <div class="kit-login-col">
                        <input type="checkbox" name="rememberMe" title="记住帐号" lay-skin="primary">
                    </div>
                </div>
                <div class="kit-login-row">
                    <button class="layui-btn kit-login-btn" lay-submit="submit" lay-filter="login_hash">登录</button>
                </div>
                <div class="kit-login-row" style="margin-bottom:0;">
                    <a href="javascript:;" style="color: rgb(153, 153, 153); text-decoration: none; font-size: 13px;" id="forgot">忘记密码</a>
                </div>
            </form>
        </div>
    </div>
</div>
<script type="text/javascript" src="/js/jquery-1.7.1.js"></script>
<script type="text/javascript" src="/js/bootstrap.min.js"></script>
<script src="/plugins/polyfill.min.js"></script>
<script src="/plugins/layui/layui.js"></script>
<script>
    layui.use(['layer', 'form'], function() {
        var form = layui.form,
            $ = layui.jquery;

        $('#forgot').on('click', function() {
            layer.msg('请联系管理员.');
        });
    });

</script>
</body>

</html>