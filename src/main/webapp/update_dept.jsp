<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>更改部门</title>
        <style>
            table { border-collapse: collapse; border-spacing: 0px; }

            table, th, td { padding: 5px; border: 1px solid black; }
        </style>
    </head>
    <body>
        <h1>更改部门</h1>
        <hr>
        <c:if test="${not empty hint}">
            <span style="color:red; font-size: 12px;">${hint}</span>
        </c:if>

        <c:set var="actionPath" value="${pageContext.request.contextPath}/updateDept"/>
        <form action="${actionPath}" method="post">
            <table>
                <tr>
                    <td>部门编号：</td>
                    <td><input type="number" name="no" value="${dept.no}" required placeholder="请修改部门编号"></td>
                </tr>
                <tr>
                    <td>部门名称：</td>
                    <td><input type="text" name="name" value="${dept.name}" required placeholder="请修改部门名称"></td>
                </tr>
                <tr>
                    <td>部门所在地：</td>
                    <td><input type="text"  name="location" value="${dept.location}" required placeholder="请修改部门所在地"></td>
                </tr>
                <tr>
                    <td colspan=2>
                        <input type="submit" value="确定">
                    </td>
                </tr>
            </table>
            <input type="hidden" name="id" required="required" value="${dept.id}">
        </form>
        <a href="dept">返回部门列表</a>
    </body>
</html>
