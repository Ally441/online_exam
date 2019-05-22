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
</head>
<body class="row">

<!-- left area -->
<div class="left col-md-2">
    <aside>
        <div class="welcome t-c">
            <strong>Java在线考试管理系统</strong>
        </div>
        <ul class="f-16">
            <a href="#"  class="side-menu-color"><li class="nav-list-item-actived">
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
        <span id="userName" class="m-r-10">${admin.adminName}<a href="/admin/to_login">  退出</a></span>
    </header>
    <main>
        <div class="heading clearfix m-b-30">
            <h4 class="f-l">管理员个人信息概况 </h4>
        </div>
        <div class="section col-md-10  clearfix">
            <div class="tab-content">
                <div role="tabpanel" class="tab-pane panel panel-info fade in active" id="myClass">
                    <div class="panel-heading">
                        <h3 class="panel-title">个人信息</h3>
                    </div>
                    <table id="detailed1" class="table table-striped">
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>账号</th>
                            <th>密码</th>
                            <th>管理个人信息</th>
                        </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>${admin.adminId}</td>
                                <td>
                                    ${admin.adminName}
                                </td>
                                <td>${admin.adminPassword}</td>
                                <td>
                                    <a href="http://www.bootcss.com/" data-toggle="modal" data-target="#myModal" class="button button-raised button-royal">修改信息</a>
                                </td>
                            </tr>
                        </tbody>
                    </table>

                </div>

            </div>
        </div>
    </main>
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
                    修改密码
                </h4>
            </div>
            <div class="modal-body" hidden="hidden">
                <input type="text" id="adminName" >${admin.adminName}</input>
            </div>
            <div class="modal-body">
                <h4>修改密码：</h4><p><input type="password" id="adminPassword" aria-valuetext="${admin.adminPassword}"></p>
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
<script type="text/javascript" src = "/js/jquery.min.js"></script>
<script type="text/javascript" src = "/js/common.js"></script>
<script type="text/javascript" src="/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/exam-summary.js"></script>

<script>
    function initPost() {
        if (document.getElementById('adminPassword').value.length == 0) {
            alert('请输入新密码！');
            document.getElementById('adminPassword').focus();
            return false;
        }
        var data = {
            adminPassword:$("#adminPassword").val()
        }

        console.log(data),
            $.ajax({
                url: '/admin/update_password',
                data: data,
                type: "post",
                success: function (data) {
                    if(data==true){
                        console.log("success");
                        window.location.replace("/admin/to_index");
                    }else{
                        alert("修改失败");
                    }
                },
            });

    }
</script>
</body>
</html>
