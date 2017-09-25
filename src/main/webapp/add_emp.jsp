<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert title here</title>
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
            <input type="date" name="hiredate">
            <input type="file" name="photo">
            <br><br>
            <input type="tel" name="tel" placeholder="请输入员工电话">
            <input type="hidden" name="dno" value="${param.dno}">
            <input type="submit" value="确定">
        </form>
        <a href="dept">返回部门列表</a>
    </body>
</html>
