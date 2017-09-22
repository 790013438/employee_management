<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
    <head>
        <meta charset="utf-8">
    </head>
    <body>
        <h1>部门信息</h1>
        <hr>
        <table>
            <tr>
                <th>部门编号</th>
                <th>部门名称</th>
                <th>部门所在地</th>
                <th>操作</th>
            </tr>
            <!-- JSTL (JSP Standard Tag Library) -->
            <c:forEach items="${deptList}" var="dept">
            <tr>
                <td>${dept.no}</td>
                <td>${dept.name}</td>
                <td>${dept.location}</td>
                <td>
                    <a href="delDept?no=${dept.no}">删除</a>
                    <a href="">编辑</a>
                </td>
            </tr>
            </c:forEach>
        </table>
    </body>
</html>
