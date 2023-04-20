<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title>个人信息</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/mygxin.css"/>
</head>
<body><!------------------------------head------------------------------>
<%@ include file="head.jsp" %>
<!------------------------------idea------------------------------>
<div class="address mt" id="add">
    <div class="wrapper clearfix"><a href="index.jsp" class="fl">首页</a><span>/</span><a href="mygxin.jsp" class="on">个人中心</a>
    </div>
</div><!------------------------------Bott------------------------------>
<div class="Bott">
    <div class="wrapper clearfix">
        <%@ include file="left.jsp" %>
        <div class="you fl">
            <div class="tx clearfix">
                <div class="fl clearfix"><a href="#" class="fl"><img src="img/tx.png"/></a>
                    <p class="fl"><span class="namebox">123</span><a href="mygrxx.jsp">修改个人信息></a></p></div>
                <div class="fr"></div>
            </div>
        </div>
    </div>
</div><!--返回顶部-->
<div class="gotop"><a href="cart.html">
    <dl>
        <dt><img src="img/gt1.png"/></dt>
        <dd>去购<br/>物车</dd>
    </dl>
</a><a href="#" class="dh">
    <dl>
        <dt><img src="img/gt2.png"/></dt>
        <dd>联系<br/>客服</dd>
    </dl>
</a><a href="mygxin.jsp">
    <dl>
        <dt><img src="img/gt3.png"/></dt>
        <dd>个人<br/>中心</dd>
    </dl>
</a><a href="#" class="toptop" style="display: none">
    <dl>
        <dt><img src="img/gt4.png"/></dt>
        <dd>返回<br/>顶部</dd>
    </dl>
</a>
    <p>400-800-8200</p></div>
<div class="footer">
    <p class="dibu">
    	GMap！<br/>
        与其他玩家分享你的发现
    </p></div>
<script src="js/jquery-1.12.4.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/public.js" type="text/javascript" charset="utf-8"></script>
<script src="js/user.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" src="js/jquery.cookie.js"></script>
<script>
	var name=$.cookie('name')
	if(name!="undefined"){
		$(".namebox").text(name);
	}
	$("#logoutbutton").on("click" , function(){	
		console.log("?");
		$.removeCookie('id');
		$.removeCookie('name');
		$.removeCookie('password');
		$.removeCookie('position');
		window.location.href="index.jsp";
	});
</script>
</body>
</html>