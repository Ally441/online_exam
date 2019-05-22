<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>考试介绍</title>
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
    <span id="userName" class="m-r-10">${student.studentName} </span>
</header>

<!-- section area -->
<div class="section col-md-10  clearfix">
    <div class="tab-content">
        <div role="tabpanel" class="tab-pane panel panel-info fade in active" id="myClass">
            <div class="panel-heading">
                <h3 class="panel-title">${exam.examName}考试信息</h3>
            </div>
            <ul id="detailed" class="panel-body">
                <c:if test="${multiquestionnumber!=0}">
                    <li>选择题:<span>${multiquestionnumber}题,共${multiscore}分</span></li>
                </c:if>
                <c:if test="${fillquestionnumber!=0}">
                    <li>填空题:<span>${fillquestionnumber}题,共${fillscore}分</span></li>
                </c:if>
                <c:if test="${judgequestionnumber!=0}">
                    <li>判断题:<span>${judgequestionnumber}题,共${judgescore}分</span></li>
                </c:if>
                <c:if test="${programquestionnumber!=0}">
                    <li>编程题:<span>${programquestionnumber}题,共${programscore}分</span></li>
                </c:if>
                <c:if test="${exam.examTime!=0}">
                    <li>考试时间:<span>${exam.examTime}分钟</span></li>
                </c:if>
            </ul>
            <div>
                <button class="btn btn-info" style="float: right" type="button" onclick="javascript:window.location.href='/student/${exam.examId}/exam'">开始考试</button>
            </div>
        </div>
    </div>
</div>

<div  class="footer">
    <strong class="footer m-l-20">Copyright © 2019 <a href="https://me.csdn.net/Ally441">Java在线考试系统</a>.All rights reserved.</strong>
</div>

<script type="text/javascript" src = "/js/jquery.min.js"></script>
<script type="text/javascript" src="/js/bootstrap.min.js"></script>
<script type="text/javascript" src = "/js/common.js"></script>
<script type="text/javascript">
    $("#home[href=home]").show();
</script>
</body>
</html>
