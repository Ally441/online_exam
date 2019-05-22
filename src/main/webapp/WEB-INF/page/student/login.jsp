<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登陆页面</title>
    <link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/css/ionicons.min.css">
    <link rel="stylesheet" type="text/css" href="/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="/css/common.css">
</head>
<body>
<!--top menu-->
<header>
    <img src="/img/图标.jpg">
    <strong>Java在线考试系统</strong>
    <span id="userName" class="m-r-10"><a href="index.html">  退出</a></span>
</header>
<!-- section area -->
<div class="section col-md-10  clearfix">
    <div class="tab-content">
        <div class="ion-log-in1">
            <p class="p1">登陆</p>
            <form method="post" action="/login" id="submitForm" class="form-denglu">
                <input type="text" id="studentNum_input" name="studentNumber" placeholder="请输入学号" value="">
                <input type="password" id="passwd_rigester_input" name="studentPassword" placeholder="请输入密码" value="">
            </form>
            <form method="get" class="form-denglu" id="login1">
                <input type="button" onclick="initPost()" value="登陆" class="btn btn-info" id="denglu">
            </form>
            <input type="checkbox" id="inlineCheckbox1" value="option1" class="self-motion">
            <span>下次自动登陆</span>
            <a href="#" class="gaimi">忘记密码？</a>
        </div>
    </div>
</div>
<!-- section area end -->
<div class="footer">
    <strong class="footer m-l-20">Copyright © 2019 <a href="https://me.csdn.net/Ally441">Ally</a>.All rights
        reserved.</strong>
</div>
<script type="text/javascript" src="/js/jquery-1.7.1.js"></script>
<script type="text/javascript" src="/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/common.js"></script>
<script type="text/javascript">

    function initPost() {
        if (document.getElementById('studentNum_input').value.length == 0) {
            alert('请输入学号！');
            document.getElementById('studentNum_input').focus();
            return false;
        }
        if (document.getElementById('passwd_rigester_input').value.length == 0) {
            alert('请输入密码');
            document.getElementById('passwd_rigester_input').focus();
            return false;
        }
        var data = {
            studentNumber:$("#studentNum_input").val(),
            studentPassword:$("#passwd_rigester_input").val()
        }
        console.log(data),
            $.ajax({
                url: '/student/login',
                data: data,
                type: "post",
                success: function (data) {
                    if(data==true){
                        console.log("success");
                        window.location.replace("/student/to_student");
                    }else{
                        console.log("false");
                        alert("学号或密码错误");
                        window.location.replace("/student/to_login");
                    }
                },
            });

    }
</script>
</body>

</html>

