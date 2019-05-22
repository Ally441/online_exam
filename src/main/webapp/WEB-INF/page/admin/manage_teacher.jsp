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
        <table style="float:left;margin-bottom:2px;">
            <td><button type="button" class="btn btn-info" data-toggle="modal" data-target="#myModal">添加教师</button><span style="display:block;width:100px;"> </span></td>
        </table>
        <table class="table table-hover m-t-20" id="tableUser">
            <thead id="userThead">
            <tr class="active">
                <th>教师ID</th>
                <th>教师工号</th>
                <th>教师姓名</th>
                <th>教师密码</th>
                <th>性别</th>
                <th>电话号码</th>
                <th>Email</th>
                <th>管理教师信息</th>
            </tr>
            </thead>
            <tbody id="userTbody">
            <c:forEach items="${teacherList}" var="teacher">
                <tr>
                    <td>${teacher.teacherId}</td>
                    <td>${teacher.teacherNumber}</td>
                    <td>${teacher.teacherName}</td>
                    <td>${teacher.teacherPassword}</td>
                    <c:if test="${teacher.teacherSex==true}">
                        <td>男</td>
                    </c:if>
                    <c:if test="${teacher.teacherSex==false}">
                        <td>女</td>
                    </c:if>
                    <td>${teacher.teacherPhone}</td>
                    <td>${teacher.teacherEmail}</td>
                    <td>
                        <a href="/admin/to_edit_teacher?teacherId=${teacher.teacherId}">修改</a>
                        <a href="/admin/remove_teacher?teacherId=${teacher.teacherId}">删除</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>


    </main>
    <table  style="text-align:center;" border="0" cellspacing="0" cellpadding="0"  width="900px">
        <tr>
            <td class="td2">
                <span>第${pageBean.currPage}/ ${pageBean.totalPage}页</span>
                <span>总记录数：${pageBean.count}  每页显示:${pageBean.pageSize}</span>
                <span>
                    <c:if test="${pageBean.currPage!=1}">
                        <a href="/admin/to_manage_teacher?currentPage=1">[首页]</a>
                        <a href="/admin/to_manage_teacher?currentPage=${pageBean.currPage-1}">[上一页]</a>
                    </c:if>
                    <c:if test="${pageBean.currPage!=pageBean.totalPage}">
                        <a href="/admin/to_manage_teacher?currentPage=${pageBean.currPage+1}">[下一页]</a>
                        <a href="/admin/to_manage_teacher?currentPage=${pageBean.totalPage}">[尾页]</a>
                    </c:if>
                </span>
            </td>
        </tr>
    </table>
    <footer>
        <strong class="m-l-20">Copyright © 2019 <a href="">Ally</a>.</strong> All rights reserved.
    </footer>
    <!-- right area end -->
</div>
<div class="modal fade" style="z-index: 100;" id="myModal" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    添加教师信息
                </h4>
            </div>
            <div class="modal-body" >
                教师工号:<input type="text" id="teacherNumber" /><br/>
            </div>
            <div class="modal-body" >
                教师姓名:<input type="text" id="teacherName" /><br/>
            </div>
            <div class="modal-body" >
                教师密码:<input type="password" id="teacherPassword" /><br/>
            </div>
            <div class="modal-body" >
                教师性别:<input type="text" id="teacherSex" /><br/>
            </div>
            <div class="modal-body" >
                教师电话:<input type="text" id="teacherPhone" /><br/>
            </div>
            <div class="modal-body" >
                教师Email:<input type="text" id="teacherEmail" /><br/>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                </button>
                <button type="button" class="btn btn-primary">
                    <a href="#" onclick="javascript:initPost()" style="display: block; width: 100%; height: 100%;">确认添加</a>
                </button>
            </div>
        </div>
    </div><!-- /.modal -->
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
        console.log(data)
        $.ajax({
            url: '/admin/insertTeacher',
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
