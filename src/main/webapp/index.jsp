<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title>GMap</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/index.css"/>
    <link rel="stylesheet" type="text/css" media="screen" href="css/jquery-ui-1.8.16.custom.css"/>
	<link rel="stylesheet" type="text/css" media="screen" href="css/jQuery.iPicture.css"/>
	<script type="text/javascript" src="js/jquery-1.6.2.min.js"></script>
	<script type="text/javascript" src="js/jquery-ui-1.8.16.custom.min.js"></script>
	<script type="text/javascript" src="js/jQuery.iPicture.js"></script>
	<script type="text/javascript" src="js/jQuery.getUrlParam.js"></script>
	<script type="text/javascript" src="js/jquery.cookie.js"></script>
</head>
<body>
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
</div>
<!------------------------------head------------------------------>

<div class="gotop" >
	<button id="submitbtn">提交</button>
	<button id="addbtn">添加</button>
	<button id="deletebtn">删除</button>
</div>
<div style="width: 1200px; heigth:800px;padding: 20px; margin:0 auto">
	<div id="iPicture">
    	<div class="slide">
			<div id="picture1" style="background: url('images/dituset/ditu1.jpeg') no-repeat scroll 0 0 #ffffff;background-size:100% 100%; width: 1000px; height: 600px;position: relative; margin:0 auto;"></div>
		</div>
	</div>
</div>
<!-------------------------body--------------------------->


<div class="footer">
    <p class="dibu">
    	GMap！<br/>
        与其他玩家分享你的发现
    </p>
</div>
<!-- foot -->


<script>
		var modecode=$.getUrlParam('mode');
		var ditucode=$.getUrlParam('ditucode');
		var pid=$.getUrlParam('pid');
		var position=$.cookie('position');
		
		var name=$.cookie('name')
		var storage = window.localStorage;
		
		document.getElementById("iPicture").scrollIntoView();
		if(name!="undefined"){
			$("#hello").text("你好，"+name);
			$("#login").hide();
			$("#reg").hide();
		}else{
			$("#grzxbtn").attr("disabled",true).css("pointer-events","none");
			$("#tjbtn").attr("disabled",true).css("pointer-events","none");
			$("#submitbtn").attr("disabled",true).css("pointer-events","none");
		}
		if(ditucode!=null){			
			$("#picture1").css("background-image","url(images/dituset/ditu"+ditucode+".jpeg)");
		}else{
			ditucode=1;
			$("#picture1").css("background-image","url(images/dituset/ditu1.jpeg)");
		}
		if(position=="manager"){
			$("#managerbtn").attr("style","display:block");
		}
		//bianjimoshi
		if(modecode==1)$(".gotop button").css("visibility","visible");
		function deleteElement(obj){
			points.splice(points.findIndex((item)=>{return item.id==obj.id;}),1);	
			storage.setItem("points",JSON.stringify(points));
			window.location.href="index.jsp?mode=1&pid="+(pid==null?ditucode:pid)+"&ditucode="+(ditucode==null?pid:ditucode);
			obj.remove();
		}
		function getId(){
			let i=1;
			while(i<=1000){
				if($("#p"+i).length==0){
					return i;
				}
				i++;
			}
			return i;
		}
		function Focus(o){
		}
		function Blur(o){
			let id=$(o).parent().parent().parent()[0].id;
			points.find((item)=>{return item.id==id;}).description=o.value;
			storage.setItem("points",JSON.stringify(points));
		}
		function toJson(str){
			var res=eval('('+str+')');
			return res;
		}
		
		document.oncontextmenu = function(e){
	 		e.preventDefault()
		}
		document.onmouseup = function(e){
			if(e.button == 2){
				$("#iPicture").css('cursor','auto');
				$("#picture1>div").attr("onclick","javascript:void(0)");
				$("#iPicture").attr("onclick","javascript:void(0)");
			}
		}
		$("#viewbtn").click(()=>{
			$(".gotop button").css("visibility","hidden");
		})
		$("#editbtn").click(()=>{
			$(".gotop button").css("visibility","visible");
		})
    	
		
  			
  		var points;
  		var data=storage.getItem("points");
  		if(data==null||data=="null"){
  			if(ditucode!=null){
  				window.location.href="init?pid="+ditucode;
  			}else{
  				window.location.href="init?pid=1";
  			}
  			storage.setItem("my",decodeURIComponent($.getUrlParam('points')));
  			storage.setItem("points",JSON.stringify(toJson(decodeURIComponent($.getUrlParam('points')))));
  			points=JSON.parse(storage.getItem("points"));
  		}else{
  			points=JSON.parse(data);
  		}
    	
    	var Infos={"picture1":[]};
    	for(let i=0;i<points.length;i++){
    		let x=points[i].X;
    		let y=points[i].Y;
    		let descr=points[i].description;
    		let id=points[i].id;
    		Infos.picture1.push({"id":id,"descr":"<div><input type=\"text\" value=\""+descr+"\" onfocus=\"Focus(this)\" onblur=\"Blur(this)\" readonly=\"true\"></div>","top":y,"left":x});
    	}  	
    	$("#iPicture").iPicture({
    		animation: true,
    		animationBg: "bgblack",
    		animationType: "ltr-slide",
    		pictures: ["picture1"],
    		button: "moreblack",
    		moreInfos:Infos,
    	});
    	
    	if(modecode==1)$("#iPicture input").attr("readonly",false);
    	
    	
    	$("#submitbtn").click(()=>{
    		let date=new Date();
    		
    		let data={"userid":$.cookie('id'),"username":$.cookie('name'),"points":JSON.parse(storage.getItem("points")),"ditucode":ditucode};
    		let message={"MESSAGE_CODE":"1","MESSAGE_STATUS":"WAIT","MESSAGE_TIME":date.toLocaleString(),"MESSAGE_DATA":JSON.stringify(data)};
    		window.location.href="uploadNewMessage?mode=1&pid="+(pid==null?ditucode:pid)+"&ditucode="+(ditucode==null?pid:ditucode)+"&message="+encodeURIComponent(JSON.stringify(message));
    		let messages=JSON.parse(storage.getItem("messages"));
    		if(messages==null){
    			messages=[message];
    			storage.setItem("messages",JSON.stringify(messages));
    		}else{
    			messages.push(message);
    			storage.setItem("messages",JSON.stringify(messages));
    		}
    		
    		
    	})
    	$("#addbtn").click(()=>{
    		$("#iPicture").css('cursor','url(images/moreblack/button.png),pointer');
    		let div1 = document.getElementById("iPicture");	
    		let x,y;
    		let id;
    		div1.onclick=function(e){
        		x=e.offsetX;
        		y=e.offsetY;
        		id=getId();
        		//$("#picture1").append("<div id='p"+id+"' class='more more32 ltr-slide bgblack' style='top: "+y+"px; left: "+x+"px;'><div class='imgButton moreblack'></div><span class='descr'><div><input type='text' value='请输入' readonly='false'></div></span></div>");
        		points.push({"id":"p"+id,"X":x+"px","Y":y+"px","description":"请输入"});
        		points.sort((obj1, obj2)=>{return Number(obj1.id.toString().slice(1))-Number(obj2.id.toString().slice(1));});
        		storage.setItem("points",JSON.stringify(points));       		
        		window.location.href="index.jsp?mode=1&pid="+(pid==null?ditucode:pid)+"&ditucode="+(ditucode==null?pid:ditucode);
        	}	
    	})
    	
    	$("#deletebtn").click(()=>{
    		$("#iPicture").css('cursor','url(images/delete.jpeg),pointer');
    		$("#picture1>div").attr("onclick","deleteElement(this)");
    	})
    	
</script>
</body>
</html>