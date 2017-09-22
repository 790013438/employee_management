<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
    <head>
        <meta charset="utf-8">
        <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <h1>部门信息</h1>
        <hr>
        <div class="container">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>编号</th>
                                <th>产品</th>
                                <th>交付时间</th>
                                <th>状态</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>1</td>
                                <td>TB - Monthly</td>
                                <td>01/04/2012</td>
                                <td>Default</td>
                            </tr>
                            <tr class="success">
                                <td>1</td>
                                <td>TB - Monthly</td>
                                <td>01/04/2012</td>
                                <td>Approved</td>
                            </tr>
                            <tr class="error">
                                <td>2</td>
                                <td>TB - Monthly</td>
                                <td>02/04/2012</td>
                                <td>Declined</td>
                            </tr>
                            <tr class="warning">
                                <td>3</td>
                                <td>TB - Monthly</td>
                                <td>03/04/2012</td>
                                <td>Pending</td>
                            </tr>
                            <tr class="info">
                                <td>4</td>
                                <td>TB - Monthly</td>
                                <td>04/04/2012</td>
                                <td>Call in to confirm</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <table>
            <tr>
                <th>部门编号</th>
                <th>部门名称</th>
                <th>部门所在地</th>
                <th>操作</th>
            </tr>
            <!-- JSTL (JSP Standard Tag Library) -->
            <c:forEach items="${deptList}" var="dept">
            <tr id="tr${dept.no}">
                <td>${dept.no}</td>
                <td>${dept.name}</td>
                <td>${dept.location}</td>
                <td><a href="javascript:deleteDept(${dept.no})">删除</a> <a
                       href="">编辑</a></td>
            </tr>
            </c:forEach>
        </table>
        <a href="add_dept.jsp">新增部门</a>
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
