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
            <td><button type="button" class="btn btn-info" data-toggle="modal" data-target="#myModal">添加学生</button><span style="display:block;width:100px;"> </span></td>
            <td><button type="button" class="btn btn-info" onclick="OutputExcel()">学生信息导出</button><span style="display:block;width:130px;"> </span></td>
            <span> </span>
            <td>
                <input type="file" name="upload" style="border:0;text-align:center" id="upload_student_message" value="学生信息导入"/>
                <span style="display:block;width:100px;"> </span>
            </td>
            <td><button type="button" class="btn btn-info" onclick="uploadStudentFile()">学生信息导入</button>
        </table>
        <table class="table table-hover m-t-20" id="tableUser">
            <thead id="userThead">
                <tr class="active">
                    <th>学生ID</th>
                    <th>学号</th>
                    <th>学生姓名</th>
                    <th>学生密码</th>
                    <th>性别</th>
                    <th>班级</th>
                    <th>专业</th>
                    <th>电话号码</th>
                    <th>Email</th>
                    <th>管理学生信息</th>
                </tr>
            </thead>
            <tbody id="userTbody">
            <c:forEach items="${studentList}" var="student">
                <tr>
                    <td>${student.studentId}</td>
                    <td>${student.studentNumber}</td>
                    <td>${student.studentName}</td>
                    <td>${student.studentPassword}</td>
                    <c:if test="${student.studentSex==true}">
                        <td>男</td>
                    </c:if>
                    <c:if test="${student.studentSex==false}">
                        <td>女</td>
                    </c:if>
                    <td>${student.studentClass}</td>
                    <td>${student.studentClassName}</td>
                    <td>${student.studentPhone}</td>
                    <td>${student.studentEmail}</td>
                    <td>
                        <a href="/admin/to_edit_student?studentId=${student.studentId}">修改</a>
                        <a href="/admin/remove_student?studentId=${student.studentId}">删除</a>
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
                       <a href="/admin/to_manage_student?currentPage=1">[首页]</a>
                       <a href="/admin/to_manage_student?currentPage=${pageBean.currPage-1}">[上一页]</a>
                    </c:if>
                    <c:if test="${pageBean.currPage!=pageBean.totalPage}">
                        <a href="/admin/to_manage_student?currentPage=${pageBean.currPage+1}">[下一页]</a>
                        <a href="/admin/to_manage_student?currentPage=${pageBean.totalPage}">[尾页]</a>
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
                    添加学生信息
                </h4>
            </div>
            <div class="modal-body" >
                学生学号:<input type="text" id="studentNumber" /><br/>
            </div>
            <div class="modal-body" >
                学生姓名:<input type="text" id="studentName" /><br/>
            </div>
            <div class="modal-body" >
                学生密码:<input type="password" id="studentPassword" /><br/>
            </div>
            <div class="modal-body" >
                学生性别:<input type="text" id="studentSex" /><br/>
            </div>
            <div class="modal-body" >
                学生班级:<input type="text" id="studentClass" /><br/>
            </div>
            <div class="modal-body" >
                学生专业:<input type="text" id="studentClassName" /><br/>
            </div>
            <div class="modal-body" >
                学生电话:<input type="text" id="studentPhone" /><br/>
            </div>
            <div class="modal-body" >
                学生Email:<input type="text" id="studentEmail" /><br/>
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
        console.log(data)
            $.ajax({
                url: '/admin/insertStudent',
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
    function uploadStudentFile() {
        var file=$("#upload_student_message").val();
        var title="student";
        file=file.substr(file.indexOf('.'),file.length);
        if(file==''){
            alert("上传文件不能为空！");
        } else if(file!='.xlsx'&&file!='.xls'){
            alert("请选择正确的excel类型文件！");
        }else{
            ajaxFileUpload(title);
        }
    }
    function ajaxFileUpload(data) {
        var formData = new FormData();
        if(data=="student"){
            var name = $("#upload_student_message").val();
            formData.append("file", $("#upload_student_message")[0].files[0]);
            formData.append("name", name);
            $.ajax({
                url : "/admin/input_Student_Excel",
                type : "POST",
                async:false,
                data : formData,
                processData:false,
                contentType:false,
                success : function(e) {
                    if (e == "01") {
                        alert("导入成功");
                        window.location.href="/admin/to_manage_student"
                    } else {
                        alert("导入失败");
                    }
                }
            });
        }
    }
    function OutputExcel() {
        window.location.href="/admin/output_Student_Excel";
    }
</script>
</body>
</html>
