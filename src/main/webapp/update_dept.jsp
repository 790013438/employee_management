<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>更改部门</title>
    </head>
    <body>
        <h1>更改部门</h1>
        <hr>
        <c:if test="not empty hint">
            <span style="color:red; font-size: 12px;">${hint}</span>
        </c:if>

        <c:set var="actionPath" value="${pageContext.request.contextPath}/updateDept"/>
        <form action="${actionPath}" method="post">
            <input type="number" name="no" value="${dept.no}" required placeholder="请修改部门编号">
            //TODO modify
            <br><br>
            <input type="text" name="name" value="${dept.name}" required placeholder="请修改部门名称">
            <br><br>
            <input type="text"  name="location" value="${dept.location}" required placeholder="请修改部门所在地">
            <br><br>
            <input type="hidden" name="id" required="required" value="${dept.id}">
            <input type="submit" value="确定">
        </form>
        <a href="dept">返回部门列表</a>
    </body>
</html>
