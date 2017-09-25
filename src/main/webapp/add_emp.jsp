<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8"/>
        <title>Insert title here</title>
        <style>
            #photoPreview {
                border: 1px dashed #ccc;
                display: block;
                width: 150px;
                height: 150px;
            }
        </style>
    </head>
    <body>
        <h1>新增员工</h1>
        <hr>
        <div style="color:red; font-size: 12px;">${hint}</div>
        <form action="addEmp" method="post" enctype="multipart/form-data">
            <input type="number" name="no" required placeholder="请输入员工编号">
            <br><br>
            <input type="text" name="name" required placeholder="请输入员工名称">
            <br><br>
            <input type="radio" name="sex" value="1" checked>男
            <input type="radio" name="sex" value="0">女
            <br><br>
            <input type="text"  name="job" required placeholder="请输入员工职位">
            <br><br>
            <input type="number" name="salary" required placeholder="请输入员工月薪">
            <br><br>
            <input type="date" required="required" name="hiredate">
            <br><br>
            <input id="photo" type="file" name="photo">
            <img id="photoPreview" src="" alt="">
            <br><br>
            <input type="tel" name="tel" placeholder="请输入员工电话">
            <br><br>
            <input type="hidden" name="dno" required="required" value="${param.dno}">
            <input type="submit" value="确定">
        </form>
        <a href="dept">返回部门列表</a>
        <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
        <script>
            $(function() {
                $('#photo').on('change', function() {
                    if (window.FileReader) {
                        var file = this.files[0];
                        if (/image\/\w+/.test(file.type)) {
                            var fr = new FileReader();
                            fr.onloadend = function(evt) { 
                                $('#photoPreview').attr('src', evt.target.result);
                            };
                            fr.readAsDataURL(file);
                        } else {
                            $(this).val('');
                            $('#photoPreview').attr('src', '');
                            alert("请选择图片文件");
                        }
                    } else {
                        alert("浏览器不支持文件预览!");
                    }
                });
            });
        </script>
    </body>
</html>
