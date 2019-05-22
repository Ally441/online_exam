<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Java在线考试管理系统</title>
    <link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/css/ionicons.min.css">
    <link rel="stylesheet" type="text/css" href="/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="/css/common1.css">
    <link rel="stylesheet" type="text/css" href="/css/common.css">
    <link rel="stylesheet" type="text/css" href="/css/exam-summary.css">
    <link rel="stylesheet" type="text/css" href="/css/exam-manage.css">
</head>
<body class="row">

<!-- left area -->
<div class="left col-md-2">
    <aside>
        <div class="welcome t-c">
            <strong>Java在线考试管理系统</strong>
        </div>
        <ul class="f-16">
            <a href="/admin/to_index"  class="side-menu-color"><li class="nav-list-item-actived">
                <i class="icon ion-navicon-round f-18 m-r-10"></i>  个人信息
                <span class="icon ion-android-radio-button-off f-r f-13"></span>
            </li></a>
            <a href="/admin/to_manage_student"  class="side-menu-color"><li>
                <i class="icon ion-person-stalker f-18 m-r-10"></i> 学生管理
                <span class="icon ion-android-radio-button-off f-r f-13"></span>
            </li></a>
            <a href="/admin/to_manage_teacher"  class="side-menu-color"><li>
                <i class="icon ion-person-stalker f-18 m-r-10"></i> 教师管理
                <span class="icon ion-android-radio-button-off f-r f-13"></span>
            </li></a>
            <li  class="side-menu-color" id="course">
                <i class="icon ion-ios-list-outline f-18 m-r-10"></i>  题库管理
                <span class="icon ion-ios-arrow-back f-r f-18"></span>
            </li>
            <a href="/admin/to_manage_multi_question" class="side-menu-color"><li class="course child-menu">
                <i class="icon ion-ios-arrow-forward f-18 m-r-10"></i>  选择题管理
                <span class="icon ion-android-checkbox-outline f-r f-18"></span>
            </li></a>
            <a href="subject-library.html"  class="side-menu-color"><li class="course child-menu">
                <i class="icon ion-ios-arrow-forward f-18 m-r-10"></i>  填空题管理
                <span class="icon ion-android-list f-r f-18"></span>
            </li></a>
            <a href="lesson-info.html" class="side-menu-color"><li class="course child-menu">
                <i class="icon ion-ios-arrow-forward f-18 m-r-10"></i>  判断题管理
                <span class="icon ion-android-checkbox-outline f-r f-18"></span>
            </li></a>
            <a href="subject-library.html"  class="side-menu-color"><li class="course child-menu">
                <i class="icon ion-ios-arrow-forward f-18 m-r-10"></i>  编程题管理
                <span class="icon ion-android-list f-r f-18"></span>
            </li></a>
        </ul>
    </aside>
</div>
<!-- left area end -->

<!-- right area -->
<div class="right col-md-10 f-r">
    <header>
        <span id="userName" class="m-r-10"> ${admin.adminName}<a href="/admin/to_login">  退出</a></span>
    </header>
    <main>
        <div class="tab-content">
            <div class="panel-heading">
                <h3 class="panel-title">选择题信息</h3>
            </div>
            <input type="text" style="border:0;text-align:center" id="studentId" hidden="hidden" value="${multiquestion.questionId}"/>
            <ul id="detailed" class="panel-body">
                <li>选择题科目：<span><input type="text" style="border:0;text-align:center" id="questionName" value="${multiquestion.questionName}"/> </span></li>
                <li>选择题内容：<span><input type="text" style="border:0;text-align:center" id="questionContext" value="${multiquestion.questionContext}"/></span></li>
                <li>选择题选项: <span><input type="text" style="border:0;text-align:center" id="questionA" value="${multiquestion.questionA}"/></span></li>
                <li>选择题选项: <span><input type="text" style="border:0;text-align:center" id="questionB" value="${multiquestion.questionB}"/></span></li>
                <li>选择题选项: <span><input type="text" style="border:0;text-align:center" id="questionC" value="${multiquestion.questionC}"/></span></li>
                <li>选择题选项: <span><input type="text" style="border:0;text-align:center" id="questionD" value="${multiquestion.questionD}"/></span></li>
                <li>选择题答案: <span><input type="text" style="border:0;text-align:center" id="answear" value="${multiquestion.answear}"/></span></li>
                <li>选择题分值: <span><input type="text" style="border:0;text-align:center" id="score" value="${multiquestion.score}"/></span></li>
                <li>选择题难度：
                    <span>
                            <c:if test="${multiquestion.level==0}">
                                <input type="text" style="border:0;text-align:center" id="level" value="简单"/>
                            </c:if>
                            <c:if test="${multiquestion.level==1}">
                                <input type="text" style="border:0;text-align:center" id="level" value="一般"/>
                            </c:if>
                            <c:if test="${multiquestion.level==2}">
                                <input type="text" style="border:0;text-align:center" id="level" value="困难"/>
                            </c:if>
                        </span>
                </li>
                <li>选择题知识点: <span><input type="text" style="border:0;text-align:center" id="questionChapter" value="${multiquestion.questionChapter}"/></span></li>
            </ul>
            <button type="button" class="btn btn-info" onclick="initPost()">修改信息</button>
        </div>

    </main>
    <footer>
        <strong class="m-l-20">Copyright © 2019 <a href="">Ally</a>.</strong> All rights reserved.
    </footer>
    <!-- right area end -->
</div>
<script type="text/javascript" src = "/js/jquery.min.js"></script>
<script type="text/javascript" src = "/js/common.js"></script>
<script type="text/javascript" src="/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/exam-manage.js"></script>
<script type="text/javascript">
    function initPost() {
        if (document.getElementById('questionName').value.length == 0) {
            alert('选择题科目不能为空！');
            document.getElementById('questionName').focus();
            return false;
        }
        if (document.getElementById('questionContext').value.length == 0) {
            alert('选择题内容不能为空！');
            document.getElementById('questionContext').focus();
            return false;
        }
        if (document.getElementById('questionA').value.length == 0||document.getElementById('questionB').value.length == 0
            ||document.getElementById('questionC').value.length == 0||document.getElementById('questionD').value.length == 0) {
            alert('选择题选项不能为空！');
            document.getElementById('questionA').focus();
            return false;
        }
        if (document.getElementById('answear').value.length == 0) {
            alert('选择题答案不能为空！');
            document.getElementById('answear').focus();
            return false;
        }
        if (document.getElementById('score').value.length == 0) {
            alert('选择题分值不能为空！');
            document.getElementById('score').focus();
            return false;
        }
        if (document.getElementById('level').value.length == 0) {
            alert('选择题难度不能为空！');
            document.getElementById('level').focus();
            return false;
        }
        if (document.getElementById('questionChapter').value.length == 0) {
            alert('选择题知识点不能为空！');
            document.getElementById('questionChapter').focus();
            return false;
        }
        var level;
        if($("#level").val()=="简单"){
            level=0;
        }else if($("#level").val()=="一般"){
            level=1;
        }else{
            level=2;
        }
        var data={
            questionName:$("#questionName").val(),
            questionContext:$("#questionContext").val(),
            questionA:$("#questionA").val(),
            questionB:$("#questionB").val(),
            questionC:$("#questionC").val(),
            questionD:$("#questionD").val(),
            answear:$("#answear").val(),
            score:$("#score").val(),
            level:level,
            questionChapter:$("#questionChapter").val()
        }
        console.log(data)
        $.ajax({
            url: '/admin/updateMulti_question',
            data: data,
            type: "post",
            success: function (data) {
                if(data==true){
                    console.log("success");
                    window.location.replace("/admin/to_manage_multi_question");
                }
            },
        });
    }

</script>
</body>
</html>
