<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>员工信息</title>
        <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <h1>${deptName}员工信息</h1>
                    <hr>
                    <c:if test="${not empty empList}">
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th>编号</th>
                                    <th>姓名</th>
                                    <th>性别</th>
                                    <th>职位</th>
                                    <th>状态</th>
                                    <th>电话</th>
                                    <th>操作</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${empList}" var="emp">
                                <tr id="tr${emp.no}">
                                    <td>${emp.no}</td>
                                    <td>${emp.name}</td>
                                    <td>${emp.sex}</td>
                                    <td>${emp.job}</td>
                                    <td>${emp.status}</td>
                                    <td>${emp.tel}</td>
                                    <td>
                                        <a href="">删除</a> 
                                        <a href="">编辑</a>
                                    </td>
                                </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        <div align="center">
                            <button id="firstBtn" class="btn btn-info" type="button" disabled>首页</button>				
                            <button id="prevBtn" class="btn btn-info" type="button" disabled>上一页</button>
                            <button id="nextBtn" class="btn btn-info" type="button" disabled>下一页</button>
                            <button id="lastBtn" class="btn btn-info" type="button" disabled>末页</button>
                        </div>
                    </c:if>
                    <a href="dept">返回部门列表</a>
                    <a href="addEmp?dno=${deptNo}">新增员工</a>
                </div>
            </div>
        </div>
        <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
        <script>
            $(function() {
                if (${currentPage > 1}) {
                    $('#firstBtn').removeAttr('disabled');
                    $('#prevBtn').removeAttr('disabled');
                }	
                if (${currentPage < totalPage}) {
                    $('#nextBtn').removeAttr('disabled');
                    $('#lastBtn').removeAttr('disabled');
                }

                var baseUrl = 'emp?no=' + ${deptNo} + '&page=';
                $('#firstBtn').on('click', function() {
                    $(this).attr('disabled', 'disabled');
                    $('#prevBtn').attr('disabled', 'disabled');
                    location.href = baseUrl + '1';
                });
                $('#prevBtn').on('click', function() { 
                    if (${currentPage - 1 eq 1}) {
                        $('#firstBtn').attr('disabled', 'disabled');
                        $(this).attr('disabled', 'disabled');
                    }
                    location.href = baseUrl + ${currentPage - 1};
                });
                $('#nextBtn').on('click', function() { 
                    if (${currentPage + 1 eq totalPage}) {
                        $('#nextBtn').attr('disabled', 'disabled');
                        $('#lastBtn').attr('disabled', 'disabled');
                    }				
                    location.href = baseUrl + ${currentPage + 1};
                });
                $('#lastBtn').on('click', function() {
                    $('#nextBtn').attr('disabled', 'disabled');
                    $('#lastBtn').attr('disabled', 'disabled');
                    location.href = baseUrl + ${totalPage};
                });
            });
        </script>
    </body>
</html>
