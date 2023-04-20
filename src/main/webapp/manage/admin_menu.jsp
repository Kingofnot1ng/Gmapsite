<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>后台管理</title>
    <link rel="stylesheet" type="text/css" href="css/common.css"/>
    <link rel="stylesheet" type="text/css" href="css/main.css"/>
    <script src="js/jquery-1.12.4.min.js" type="text/javascript" charset="utf-8"></script>
    <script type="text/javascript" src="js/jquery.cookie.js"></script>
</head>
<body>
<div class="topbar-wrap white">
    <div class="topbar-inner clearfix">
        <div class="topbar-logo-wrap clearfix">
            <h1 class="topbar-logo none"><a href="index.html" class="navbar-brand">后台管理</a></h1>
            <ul class="navbar-list clearfix">
                <li><a class="on" href="admin_index.jsp">首页</a></li>
                <li><a href="../index.jsp" target="_blank">网站首页</a></li>
            </ul>
        </div>
        <div class="top-info-wrap">
            <ul class="top-info-list clearfix">
            	<li><p class="namebox"></p></li>
                <li><a href="#">管理员</a></li>
                <li><a href="#">修改密码</a></li>
                <li><a href="javascript:void(0)" onclick="out()">退出</a></li>
            </ul>
        </div>
    </div>
</div>
<div class="container clearfix">
    <div class="sidebar-wrap">
        <div class="sidebar-title">
            <h1>菜单</h1>
        </div>
        <div class="sidebar-content">
            <ul class="sidebar-list">
                <li>
                    <a href="#"><i class="icon-font">&#xe003;</i>常用操作</a>
                    <ul class="sub-menu">
                        <li><a href="admin_douserselect"><i class="icon-font">&#xe008;</i>用户管理</a></li>
                        <li><a href="#"><i class="icon-font">&#xe005;</i>查看管理员</a></li>
                        <li><a href="#"><i class="icon-font">&#xe006;</i>添加地图</a></li>
                        <li><a href="admin_domessageselect"><i class="icon-font">&#xe004;</i>审核消息</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#"><i class="icon-font">&#xe018;</i>系统管理</a>
                    <ul class="sub-menu">
                        <li><a href="system.jsp"><i class="icon-font">&#xe017;</i>系统设置</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>

<script>
	var name=$.cookie('name')
	if(name!="undefined"){
		$(".namebox").text("你好，"+name);
	}
	function out(){	
		$.cookie('test', '123');
		console.log("?");
		$.removeCookie('id', { path: '/GMapsite' });
		$.removeCookie('name', { path: '/GMapsite' });
		$.removeCookie('password', { path: '/GMapsite' });
		$.removeCookie('position', { path: '/GMapsite' });
		window.location.href="../index.jsp";
	};
</script>
</body>
</html>  
   