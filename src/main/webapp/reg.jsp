<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>注册</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/login.css"/>
</head>
<body><!-------------------reg-------------------------->
<div class="reg">
    <form action="register" method="post"><h1><a href="index.jsp"><img src="img/temp/logo.png"></a><p>用户注册</p></h1>
        
        <p><input type="text" name="name" value="" placeholder="请输入用户名"></p>
        <p><input type="text" name="passWord" value="" placeholder="请输入密码"></p>
        <p><input type="text" name="repassWord" value="" placeholder="请确认密码"></p>
        <p><input type="submit" name="" value="注册"></p>
        <p class="txtL txt">完成此注册，即表明您同意了我们的<a href="#">
            <使用条款和隐私策略>
        </a></p>
        <p class="txt"><a href="login.jsp"><span></span>已有账号登录</a></p>
        <!--<a href="#" class="off"><img src="img/temp/off.png"></a>--></form>
</div>
</body>
</html>