
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
        <div role="tabpanel" class="tab-pane fade panel panel-info" id="history">
            <table class="history-table table table-striped">
                <tr>
                    <td>考试名称</td>
                    <td>考试命题人</td>
                    <td>考试时间</td>
                    <td>成绩</td>
                    <td>考试详情</td>
                </tr>
                <c:forEach items="${gradeList}" var="grade">
                    <tr>
                        <td>${grade.exam.examName}</td>
                        <td>${grade.exam.examCreater}</td>
                        <td>${grade.exam.examTime}分钟</td>
                        <td>${grade.gradeScore}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
<!--footer area-->
<div  class="footer">
    <strong class="footer m-l-20">Copyright © 2019 <a href="http://thoughtcoding.csxupt.com">Java在线考试系统</a>.All rights reserved.</strong>
</div>

<script type="text/javascript" src = "/js/jquery.min.js"></script>
<script type="text/javascript" src="/js/bootstrap.min.js"></script>
<script type="text/javascript" src = "/js/common.js"></script>
<script>
    $(function () {
        $('#myTab a[href="#history"]').tab('show')
    })
    $('#myTab a').click(function (e) {
        e.preventDefault()
        $(this).tab('show')
    })
</script>
</body>
</html>
