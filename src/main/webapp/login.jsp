<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/login.css"/>
</head>
<body><!-------------------login-------------------------->
<div class="login">
    <form action="login" method="post"><h1><a href="index.jsp"><img src="img/temp/logo.png"></a><p>登录</p></h1>
        <p></p>
        <p><input type="text" name="userName" value="" placeholder="账号"></p>
        <p><input type="text" name="passWord" value="" placeholder="密码"></p>
        <p><input type="submit" name="" value="登  录"></p>
        <p>我是管理员：<input type="checkbox" name="ismanager" value="yes" id="ismanagerbtn"/></p>
        <p class="txt"><a class="" href="reg.jsp">免费注册</a><a href="forget.html">忘记密码？</a></p>
    </form>
</div>
</body>
</html>