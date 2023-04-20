<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title>GMap</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/idea.css"/>
</head>
<body><!------------------------------head------------------------------>
<div class="head">
    <div class="wrapper clearfix">
        <div class="clearfix" id="top">
        	<h1 class="fl">
        		<a href="index.jsp"><img src="img/logo.png"/></a> 		 
        	</h1> 
        	<h1 class="fl">
        	 	<p>欢迎来到GMap</p>
        	</h1> 	
            <div class="fr clearfix" id="top1">
            	
            	<p class="fl">
            		<a href="#" id="hello"></a>
            		<a href="login.jsp" id="login">登录</a>
            		<a href="reg.jsp" id="reg">注册</a>
            	</p>
                <form action="#" method="get" class="fl">
                	<input type="text" placeholder=""/>
                	<input type="button"/>
                </form>
                <div class="btn fl clearfix">
                	<a href="mygxin.jsp"  id="grzxbtn"><img src="img/grzx.png"/></a>
                    <p>
                    	<a href="#"><img src="img/smewm.png"/></a>
                    </p>
                </div>
            </div> 	
        </div>
        <ul class="clearfix" id="bott">
            <li><a id="viewbtn" href="index.jsp?mode=0&pid=${param.pid==null?(param.ditucode==null?1:param.ditucode):param.pid}&ditucode=${param.ditucode==null?(param.pid==null?1:param.pid):param.ditucode}">查看</a></li>
            <li><a id="editbtn" href="index.jsp?mode=1&pid=${param.pid==null?(param.ditucode==null?1:param.ditucode):param.pid}&ditucode=${param.ditucode==null?(param.pid==null?1:param.pid):param.ditucode}">编辑</a></li>
            <li><a id="viewbtn" href="idea.jsp" >选择地图</a></li>
            <li><a id="managerbtn" href="manage/admin_index.jsp" style="display:none">返回后台</a></li>
        </ul>
    </div>
</div><!------------------------------idea------------------------------>
<div class="address">
    <div class="wrapper clearfix"><a href="index.jsp" class="fl">首页</a><span>/</span><a href="idea.jsp" class="on">选择地图</a>
    </div>
</div><!------------------------------imgList1------------------------------>
<div class="imgList1">
    <div class="wrapper">
        <div class="box1"><a></a>
            <ul>              
            </ul>    
        </div>
        <div class="box2"><a></a>
            <ul>             
            </ul>    
        </div>
        <div class="box3"><a></a>
            <ul>             
            </ul>    
        </div>
        <div class="box4"><a></a>
            <ul>             
            </ul>    
        </div>
        <div class="box5"><a></a>
            <ul>             
            </ul>    
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
</a><a href="mygxin.html">
    <dl>
        <dt><img src="img/gt3.png"/></dt>
        <dd>个人<br/>中心</dd>
    </dl>
</a><a href="#" class="toptop" style="display: none;">
    <dl>
        <dt><img src="img/gt4.png"/></dt>
        <dd>返回<br/>顶部</dd>
    </dl>
</a>
    <p>400-800-8200</p></div><!--footer-->
<div class="footer">
    <p class="dibu">
    	GMap！<br/>
        与其他玩家分享你的发现
    </p>
</div>
<script src="js/jquery-1.12.4.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/public.js" type="text/javascript" charset="utf-8"></script>
<script src="js/nav.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" src="js/jquery.cookie.js"></script>
<script type="text/javascript" src="js/jQuery.getUrlParam.js"></script>
<script>
	
	
	var name=$.cookie('name')
	var position=$.cookie('position');

	var list;
	
	function toJson(str){
		var res=eval('('+str+')');
		return res;
	}
	localStorage.removeItem("points");
	if(name!="undefined"){
		$("#hello").text("你好，"+name);
		$("#login").hide();
		$("#reg").hide();
	}else{
	}
	if(position=="manager"){
		$("#managerbtn").attr("style","display:block");
	}
	
	if($.getUrlParam('pictures')==null){
		console.log("?");	
		window.location.href="choose";
		console.log("!");		
	}else{
		list=toJson(decodeURIComponent($.getUrlParam('pictures')));
		console.log(list)
		let j=1;
		for(let i=0;i<list.length;i++){
			$(".box"+j+">ul").append("<li><a href=\"index.jsp?ditucode="+list[i].id+"\"><dl><dt><img src=\""+list[i].path+"\"/></dt><dd>游戏地图"+list[i].id+"</dd><dd>介绍"+list[i].id+"</dd></dl></a></li>");
			if(i%3==2){
				j++;
			}
		}
	}

				
		
</script>
</body>
</html>