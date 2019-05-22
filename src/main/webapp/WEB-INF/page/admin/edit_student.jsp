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
                <input type="text" style="border:0;text-align:center" id="studentId" hidden="hidden" value="${student.studentId}"/>
                <ul id="detailed" class="panel-body">
                    <li>学号：<span><input type="text" style="border:0;text-align:center" id="studentNumber" value="${student.studentNumber}"/> </span></li>
                    <li>姓名：<span><input type="text" style="border:0;text-align:center" id="studentName" value="${student.studentName}"/></span></li>
                    <li>密码: <span><input type="text" style="border:0;text-align:center" id="studentPassword" value="${student.studentPassword}"/></span></li>
                    <li>班级: <span><input type="text" style="border:0;text-align:center" id="studentClass" value="${student.studentClass}"/></span></li>
                    <li>性别：
                        <span>
                            <c:if test="${student.studentSex==true}">
                                <input type="text" style="border:0;text-align:center" id="studentSex" value="男"/>
                            </c:if>
                            <c:if test="${student.studentSex==false}">
                                <input type="text" style="border:0;text-align:center" id="studentSex" value="女"/>
                            </c:if>
                        </span>
                    </li>
                    <li>专业：<span><input type="text" style="border:0;text-align:center" id="studentClassName" value="${student.studentClassName}"/></span></li>
                    <li>电话号码：<span><input type="text" style="border:0;text-align:center" id="studentPhone" value="${student.studentPhone}"/></span></li>
                    <li>Email：<span><input type="text" style="border:0;text-align:center" id="studentEmail" value="${student.studentEmail}"/></span></li>
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
        if (document.getElementById('studentName').value.length == 0) {
            alert('姓名不能为空！');
            document.getElementById('studentName').focus();
            return false;
        }
        if (document.getElementById('studentNumber').value.length == 0) {
            alert('学号不能为空！');
            document.getElementById('studentNumber').focus();
            return false;
        }
        if (document.getElementById('studentPassword').value.length == 0) {
            alert('密码不能为空！');
            document.getElementById('studentPassword').focus();
            return false;
        }
        if (document.getElementById('studentSex').value.length == 0) {
            alert('性别不能为空！');
            document.getElementById('studentSex').focus();
            return false;
        }
        var sex;
        if($("#studentSex").val()=="男"){
            sex=true;
        }else{
            sex=false;
        }
        var data={
            studentName:$("#studentName").val(),
            studentNumber:$("#studentNumber").val(),
            studentPassword:$("#studentPassword").val(),
            studentSex:sex,
            studentClass:$("#studentClass").val(),
            studentClassName:$("#studentClassName").val(),
            studentPhone:$("#studentPhone").val(),
            studentEmail:$("#studentEmail").val()
        }
        console.log(data),
            $.ajax({
                url: '/admin/updateStudent',
                data: data,
                type: "post",
                success: function (data) {
                    if(data==true){
                        console.log("success");
                        window.location.replace("/admin/to_manage_student");
                    }
                },
            });
    }

</script>
</body>
</html>
