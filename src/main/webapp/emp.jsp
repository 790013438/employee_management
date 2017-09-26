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
                    <h1>${dept.name}员工信息</h1>
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
                            <a href="emp?no=${dept.no}&page=1">首页</a>&nbsp;&nbsp;	
                            <c:if test="${currentPage gt 1}">		
                                <a href="emp?no=${dept.no}&page=${currentPage-1}" >上一页</a>&nbsp;&nbsp;
                            </c:if>
                            <c:if test="${currentPage eq 1}">
                                <span style="color: #ccc;">上一页</span>&nbsp;&nbsp;
                            </c:if>
                            <c:if test="${currentPage lt totalPage}">
                                <a href="emp?no=${dept.no}&page=${currentPage+1}" >下一页</a>&nbsp;&nbsp;
                            </c:if>
                            <c:if test="${currentPage eq totalPage}">
                                <span style="color: #ccc;">下一页</span>&nbsp;&nbsp;
                            </c:if>
                            <a href="emp?no=${dept.no}&page=${totalPage}">末页</a>
                        </div>
                    </c:if>
                    <a href="dept">返回部门列表</a>
                    <a href="addEmp?dno=${dept.no}">新增员工</a>
                </div>
            </div>
        </div>
        <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    </body>
</html>
