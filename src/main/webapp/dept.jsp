<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
    <head>
        <meta charset="utf-8">
        <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <h1>部门信息</h1>
                    <hr>
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>部门编号</th>
                                <th>部门名称</th>
                                <th>部门所在地</th>
                                <th>操作</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${deptList}" var="dept">
                            <tr id="tr${dept.id}">
                                <td>${dept.no}</td>
                                <td>
                                    <a href="emp?no=${dept.id}">${dept.name}</a>
                                </td>
                                <td>${dept.location}</td>
                                <td>
                                    <a href="javascript:deleteDept(${dept.id})">删除</a> 
                                    <a href="">编辑</a></td>
                            </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <a href="addDept">新增部门</a>
                </div>
            </div>
        </div>
        <!-- jQuery / Zepto.js -->
        <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
        <script>
            function deleteDept(no) {
                if (confirm("确定要删除吗?")) {
                    $.ajax({ 
                        url: 'delDept?no=' + no,
                        success: function(data) {
                            if (data.indexOf('success') >= 0) {
                                $('#tr' + no).remove();
                            }
                        }
                    });
                }
            }
        </script>
    </body>
</html>
