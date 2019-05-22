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
            <a href="/admin/to_fill_multi_question"  class="side-menu-color"><li class="course child-menu">
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
        <table style="float:left;margin-bottom:2px;" >
            <td><button type="button" class="btn btn-info" data-toggle="modal" data-target="#myModal">添加填空题</button><span style="display:block;width:100px;"> </span></td>
            <td><button type="button" class="btn btn-info" onclick="OutputFillExcel()">填空题信息导出</button><span style="display:block;width:130px;"> </span></td>
            <span> </span>
            <td>
                <input type="file" name="upload" style="border:0;text-align:center" id="upload_fill_question" value="选择题信息导入"/>
                <span style="display:block;width:100px;"> </span>
            </td>
            <td><button type="button" class="btn btn-info" onclick="uploadFillFile()">选择题信息导入</button>
        </table>
        <table class="table table-hover m-t-20" id="tableUser" >
            <thead id="userThead">
            <tr class="active">
                <th style="text-overflow:ellipsis;white-space:nowrap;">选择题ID</th>
                <th style="text-overflow:ellipsis;white-space:nowrap;">选择题科目</th>
                <th style="text-overflow:ellipsis;white-space:nowrap;">选择题内容</th>
                <th style="text-overflow:ellipsis;white-space:nowrap;">选择题选项</th>
                <th style="text-overflow:ellipsis;white-space:nowrap;">选择题选项</th>
                <th style="text-overflow:ellipsis;white-space:nowrap;">选择题选项</th>
                <th style="text-overflow:ellipsis;white-space:nowrap;">选择题选项</th>
                <th style="text-overflow:ellipsis;white-space:nowrap;">选择题答案</th>
                <th style="text-overflow:ellipsis;white-space:nowrap;">选择题分值</th>
                <th style="text-overflow:ellipsis;white-space:nowrap;">选择题难度</th>
                <th style="text-overflow:ellipsis;white-space:nowrap;">选择题知识点</th>
                <th style="text-overflow:ellipsis;white-space:nowrap;">管理选择题</th>
            </tr>
            </thead>
            <tbody id="userTbody">
            <c:forEach items="${multi_questionList}" var="multiquestion">
                <tr>
                    <td style="word-break:break-all;">${multiquestion.questionId}</td>
                    <td >${multiquestion.questionName}</td>
                    <td style="word-break:break-all;">${multiquestion.questionContext}</td>
                    <td >${multiquestion.questionA}</td>
                    <td >${multiquestion.questionB}</td>
                    <td >${multiquestion.questionC}</td>
                    <td >${multiquestion.questionD}</td>
                    <td >${multiquestion.answear}</td>
                    <td >${multiquestion.score}</td>
                    <c:if test="${multiquestion.level==0}">
                        <td >简单</td>
                    </c:if>
                    <c:if test="${multiquestion.level==1}">
                        <td>一般</td>
                    </c:if>
                    <c:if test="${multiquestion.level==2}">
                        <td>困难</td>
                    </c:if>
                    <td >${multiquestion.questionChapter}</td>
                    <td >
                        <a href="/admin/to_edit_multi_question?questionId=${multiquestion.questionId}">修改</a>
                        <a href="/admin/remove_multi_question?questionId=${multiquestion.questionId}">删除</a>
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
                        <a href="/admin/to_manage_multi_question?currentPage=1">[首页]</a>
                        <a href="/admin/to_manage_multi_question?currentPage=${pageBean.currPage-1}">[上一页]</a>
                    </c:if>
                    <c:if test="${pageBean.currPage!=pageBean.totalPage}">
                        <a href="/admin/to_manage_multi_question?currentPage=${pageBean.currPage+1}">[下一页]</a>
                        <a href="/admin/to_manage_multi_question?currentPage=${pageBean.totalPage}">[尾页]</a>
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
                    添加选择题信息
                </h4>
            </div>
            <div class="modal-body" >
                选择题科目:<input type="text" id="questionName" /><br/>
            </div>
            <div class="modal-body" >
                选择题内容:<input type="text" id="questionContext" /><br/>
            </div>
            <div class="modal-body" >
                选项A:<input type="text" id="questionA" /><br/>
            </div>
            <div class="modal-body" >
                选项B:<input type="text" id="questionB" /><br/>
            </div>
            <div class="modal-body" >
                选项C:<input type="text" id="questionC" /><br/>
            </div>
            <div class="modal-body" >
                选项D:<input type="text" id="questionD" /><br/>
            </div>
            <div class="modal-body" >
                选择题答案:<input type="text" id="answear" /><br/>
            </div>
            <div class="modal-body" >
                选择题分值:<input type="text" id="score" /><br/>
            </div>
            <div class="modal-body" >
                选择题难度:<input type="text" id="level" /><br/>
            </div>
            <div class="modal-body" >
                选择题知识点:<input type="text" id="questionChapter" /><br/>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                </button>
                <button type="button" class="btn btn-primary">
                    <a href="#" onclick="javascript:initPost()" style="display: block; width: 100%; height: 100%;">确认添加</a>
                </button>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src = "/js/jquery.min.js"></script>
<script type="text/javascript" src = "/js/common.js"></script>
<script type="text/javascript" src="/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/exam-manage.js"></script>

</body>
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
            score:parseInt($("#score").val()),
            level:level,
            questionChapter:$("#questionChapter").val()
        }
        console.log(data)
        $.ajax({
            url: '/admin/insertMulti_question',
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
    function uploadFillFile() {
        var file = $("#upload_fill_question").val();
        var title="fill";
        file = file.substring(file.lastIndexOf('.'), file.length);
        if (file == '') {
            alert("上传文件不能为空！");
        } else if (file != '.xlsx' && file != '.xls') {
            alert("请选择正确的excel类型文件！");
        } else {
            ajaxFileUpload(title);
        }
    }
    function ajaxFileUpload(data) {
        var formData = new FormData();
        if(data=="fill"){
            var name = $("#upload_fill_question").val();
            formData.append("file", $("#upload_fill_question")[0].files[0]);
            formData.append("name", name);
            $.ajax({
                url : "/admin/input_Fill_Excel",
                type : "POST",
                async:false,
                data : formData,
                processData:false,
                contentType:false,
                success : function(e) {
                    if (e == "01") {
                        alert("导入成功");
                    } else {
                        alert("导入失败");
                    }
                }
            });
        }
    }
    function OutputFillExcel() {
        window.location.href = "/admin/output_Fill_Excel";
    }
</script>
</html>
