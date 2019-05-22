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
                <h3 class="panel-title">个人信息</h3>
            </div>
            <input type="text" style="border:0;text-align:center" id="studentId" hidden="hidden" value="${teacher.teacherId}"/>
            <ul id="detailed" class="panel-body">
                <li>工号：<span><input type="text" style="border:0;text-align:center" id="teacherNumber" value="${teacher.teacherNumber}"/> </span></li>
                <li>姓名：<span><input type="text" style="border:0;text-align:center" id="teacherName" value="${teacher.teacherName}"/></span></li>
                <li>密码: <span><input type="text" style="border:0;text-align:center" id="teacherPassword" value="${teacher.teacherPassword}"/></span></li>
                <li>性别：
                    <span>
                            <c:if test="${teacher.teacherSex==true}">
                                <input type="text" style="border:0;text-align:center" id="teacherSex" value="男"/>
                            </c:if>
                            <c:if test="${teacher.teacherSex==false}">
                                <input type="text" style="border:0;text-align:center" id="teacherSex" value="女"/>
                            </c:if>
                        </span>
                </li>
                <li>电话号码：<span><input type="text" style="border:0;text-align:center" id="teacherPhone" value="${teacher.teacherPhone}"/></span></li>
                <li>Email：<span><input type="text" style="border:0;text-align:center" id="teacherEmail" value="${teacher.teacherEmail}"/></span></li>
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
        if (document.getElementById('teacherName').value.length == 0) {
            alert('姓名不能为空！');
            document.getElementById('teacherName').focus();
            return false;
        }
        if (document.getElementById('teacherNumber').value.length == 0) {
            alert('工号不能为空！');
            document.getElementById('teacherNumber').focus();
            return false;
        }
        if (document.getElementById('teacherPassword').value.length == 0) {
            alert('密码不能为空！');
            document.getElementById('teacherPassword').focus();
            return false;
        }
        if (document.getElementById('teacherSex').value.length == 0) {
            alert('性别不能为空！');
            document.getElementById('teacherSex').focus();
            return false;
        }
        var sex;
        if($("#teacherSex").val()=="男"){
            sex=true;
        }else{
            sex=false;
        }
        var data={
            teacherName:$("#teacherName").val(),
            teacherNumber:$("#teacherNumber").val(),
            teacherPassword:$("#teacherPassword").val(),
            teacherSex:sex,
            teacherPhone:$("#teacherPhone").val(),
            teacherEmail:$("#teacherEmail").val()
        }
        console.log(data),
            $.ajax({
                url: '/admin/updateTeacher',
                data: data,
                type: "post",
                success: function (data) {
                    if(data==true){
                        console.log("success");
                        window.location.replace("/admin/to_manage_teacher");
                    }
                },
            });
    }

</script>
</body>
</html>
