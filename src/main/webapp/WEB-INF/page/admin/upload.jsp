<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <td>学生:</td>
        <td><input type="file" id="upload_student_message" name="upload" value="上传学生信息"/></td>
        <td><button onclick="uploadStudentFile()">上传</button></td>
        <td><button onclick="OutputStudentExcel()">导出</button> </td>
        <td><button onclick="OutputStudentGradeExcel()">导出成绩单</button> </td>
    </tr>
    <tr>
        <td>选择题:</td>
        <td><input type="file" id="upload_multi_question" name="upload" value="上传题库"/></td>
        <td><button onclick="uploadMultiFile()">上传</button></td>
        <td><button onclick="OutputMultiExcel()">导出</button> </td>
    </tr>
    <tr>
        <td>填空题:</td>
        <td><input type="file" id="upload_fill_question" name="upload" value=""/> </td>
        <td><button onclick="uploadFillFile()">上传</button></td>
        <td><button onclick="OutputFillExcel()">导出</button> </td>
    </tr>
    <tr>
        <td>判断题:</td>
        <td><input type="file" id="upload_judge_question" name="upload" value=""/> </td>
        <td><button onclick="uploadJudgeFile()">上传</button></td>
        <td><button onclick="OutputJudgeExcel()">导出</button> </td>
    </tr>
    <tr>
        <td>编程题:</td>
        <td><input type="file" id="upload_program_question" name="upload" value=""/> </td>
        <td><button onclick="uploadProgramFile()">上传</button></td>
        <td><button onclick="OutputProgramExcel()">导出</button> </td>
    </tr>
</table>
<script type="text/javascript" src="/js/jquery-1.7.1.js"></script>
<script type="text/javascript" src="/js/bootstrap.min.js"></script>
<script type="text/javascript" >
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
    function uploadMultiFile() {
        var file= $("#upload_multi_question").val();
        var title="multi";
        file = file.substring(file.lastIndexOf('.'), file.length);
        if (file == '') {
            alert("上传文件不能为空！");
        } else if (file != '.xlsx' && file != '.xls') {
            alert("请选择正确的excel类型文件！");
        } else {
            ajaxFileUpload(title);
        }
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
    function uploadJudgeFile() {
        var file = $("#upload_judge_question").val();
        var title="judge";
        file = file.substring(file.lastIndexOf('.'), file.length);
        if (file == '') {
            alert("上传文件不能为空！");
        } else if (file != '.xlsx' && file != '.xls') {
            alert("请选择正确的excel类型文件！");
        } else {
            ajaxFileUpload(title);
        }
    }
    function uploadProgramFile() {
        var file = $("#upload_program_question").val();
        var title="program";
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
        } else if (data=="multi") {
            var name = $("#upload_multi_question").val();
            formData.append("file", $("#upload_multi_question")[0].files[0]);
            formData.append("name", name);
            $.ajax({
                url : "/admin/input_Multi_Excel",
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
        } else if (data=="judge"){
            var name = $("#upload_judge_question").val();
            formData.append("file", $("#upload_judge_question")[0].files[0]);
            formData.append("name", name);
            $.ajax({
                url : "/admin/input_Judge_Excel",
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
        } else if(data=="program"){
            var name = $("#upload_program_question").val();
            formData.append("file", $("#upload_program_question")[0].files[0]);
            formData.append("name", name);
            $.ajax({
                url : "/admin/input_Program_Excel",
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
        } else if(data=="student"){
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
                    } else {
                        alert("导入失败");
                    }
                }
            });
        }

    }
    function OutputStudentGradeExcel() {
        window.location.href="/admin/output_StudentGrade_Excel";
    }
    function OutputStudentExcel() {
        window.location.href="/admin/output_Student_Excel";
    }
    function OutputFillExcel() {
        window.location.href = "/admin/output_Fill_Excel";
    }
    function OutputMultiExcel() {
        window.location.href = "/admin/output_Multi_Excel";
    }
    function OutputJudgeExcel(){
        window.location.href = "/admin/output_Judge_Excel";
    }
    function OutputProgramExcel() {
        window.location.href = "/admin/output_Program_Excel";
    }

</script>
</body>
</html>
