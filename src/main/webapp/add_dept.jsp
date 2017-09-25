<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>新增部门</title>
    </head>
    <body>
        <h1>新增部门</h1>
        <hr>
        <div style="color:red; font-size: 12px;">${hint}</div>
        <form action="addDept" method="post">
            <input type="number" max="99" name="no" placeholder="请输入部门编号" required="required"/>
            <br><br>
            <input type="text" name="name" placeholder="请输入部门名称" required="required"/>
            <br><br>
            <input type="text"  name="location" placeholder="请输入部门所在地" required="required">
            <br><br>
            <input type="submit" value="确定">
        </form>
        <a href="dept">返回部门列表</a>
    </body>
</html>
