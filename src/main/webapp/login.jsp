<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert title here</title>
    </head>
    <body>
        <h1>用户登录</h1>
        <hr/>
        <form action="login" method="post">
            <input type="text" name="username" placeholder="请输入用户名" required="required"/>
            <br/><br/>
            <input type="password" name="password" placeholder="请输入密码" required="required"/>
            <br/><br/>
            <input type="submit" value="登录">
        </form>
    </body>
</html>
