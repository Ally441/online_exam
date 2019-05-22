<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>前台测试页</title>
    <link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/css/ionicons.min.css">
    <link rel="stylesheet" type="text/css" href="/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="/css/common.css">
</head>
<body >
<!--top menu-->
<header>
    <img src="/img/图标.jpg">
    <strong>Java在线考试系统</strong>
    <ul class="nav nav-tabs myTab-all" role="tablist" id="myTab">
        <li role="presentation" class="active"><a href="#myClass" role="tab" data-toggle="tab" onclick="javascript:window.location.href='/student/to_student'">我的课程</a></li>
        <li role="presentation"><a href="#test" role="tab" data-toggle="tab" onclick="javascript:window.location.href='/student/to_test'">待考课程</a></li>
        <li role="presentation"><a href="#history" role="tab" data-toggle="tab" onclick="javascript:window.location.href='/student/to_history'">历史成绩</a></li>
        <li role="presentation"><a href="#home" role="tab" data-toggle="tab" onclick="javascript:window.location.href='/student/to_self'">个人信息</a></li>
    </ul>
    <span id="userName" class="m-r-10">${student.studentName}  <a href="/student/logout">  退出</a></span>
</header>



<!-- section area -->
<div class="section col-md-10  clearfix">
    <div class="tab-content">
        <div role="tabpanel" class="tab-pane fade panel panel-info " id="home">
            <div class="panel-heading">
                <h3 class="panel-title">个人信息</h3>
            </div>
            <ul id="detailed" class="panel-body">
                <li>学号：<span>${student.studentNumber}</span></li>
                <li>姓名：<span>${student.studentName}</span></li>
                <li>密码: <span>${student.studentPassword}</span></li>
                <li>性别：
                        <c:if test="${student.studentSex==true}">
                            <span>男</span>
                        </c:if>
                        <c:if test="${student.studentSex==false}">
                            <span>女</span>
                        </c:if>
                </li>
                <li>专业：<span>${student.studentClassName}</span></li>
                <li>电话号码：<span>${student.studentPhone}</span></li>
                <li>Email：<span>${student.studentEmail}</span></li>
            </ul>
            <button type="button" class="btn btn-info" data-toggle="modal" data-target="#myModal">修改信息</button>
        </div>
    </div>
</div>
<div class="modal fade" style="z-index: 100;" id="myModal" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    修改个人信息
                </h4>
            </div>
            <div class="modal-body" hidden="hidden">
                <p id="studentNumber">${student.studentNumber}</p>
            </div>
            <div class="modal-body">
                <h4>修改密码：</h4><p><input type="password" id="studentPassword" aria-valuetext="${student.studentPassword}"></p>
            </div>
            <div class="modal-body">
                <h4>电话号码：</h4><p><input id="studentPhone" aria-valuetext="${student.studentPhone}"></p>
            </div>
            <div class="modal-body">
                <h4>Email：</h4><p><input id="studentEmail" aria-valuetext="${student.studentEmail}"> </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                </button>
                <button type="button" class="btn btn-primary">
                    <a href="#" onclick="javascript:initPost()" style="display: block; width: 100%; height: 100%;">确认修改</a>
                </button>
            </div>
        </div>
    </div><!-- /.modal -->
</div>
<div  class="footer">
    <strong class="footer m-l-20">Copyright © 2019 <a href="http://thoughtcoding.csxupt.com">Java在线考试系统</a>.All rights reserved.</strong>
</div>

<script type="text/javascript" src = "/js/jquery.min.js"></script>
<script type="text/javascript" src="/js/bootstrap.min.js"></script>
<script type="text/javascript" src = "/js/common.js"></script>
<script>
    $(function () {
        $('#myTab a:last').tab('show')
    })

    $('#myTab a').click(function (e) {
        e.preventDefault()
        $(this).tab('show')
    })
    function initPost() {
        if (document.getElementById('studentPassword').value.length == 0) {
            alert('请输入新密码！');
            document.getElementById('studentPassword').focus();
            return false;
        }
        if (document.getElementById('studentPhone').value.length == 0) {
            alert('请输入手机号码');
            document.getElementById('studentPhone').focus();
            return false;
        }
        if (document.getElementById('studentEmail').value.length == 0) {
            alert('请输入Email');
            document.getElementById('studentEmail').focus();
            return false;
        }
        var data = {
            studentPassword:$("#studentPassword").val(),
            studentNumber:$("#studentNumber").val(),
            studentPhone:$("#studentPhone").val(),
            studentEmail:$("#studentEmail").val()
        }
        console.log(data),
            $.ajax({
                url: '/student/self',
                data: data,
                type: "get",
                success: function (data) {
                    if(data==true){
                        console.log("success");
                        window.location.replace("/student/to_self");
                    }
                },
            });

    }
</script>
</body>
</html>

