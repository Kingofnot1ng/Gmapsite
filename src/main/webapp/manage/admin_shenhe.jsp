<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="admin_menu.jsp" %>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="admin_index.jsp">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">用户管理</span></div>
        </div>
        <div class="search-wrap">
            <div class="search-content">
                <form action="#" method="get">
                    <table class="search-tab">
                        <tr>
                            <th width="70">关键字:</th>
                            <td><input class="common-text" placeholder="关键字" name="keywords" value="${param.keywords}" id="" type="text"></td>
                            <td><input class="btn btn-primary btn2" value="查询" type="submit"></td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
        <div class="result-wrap">
            <form name="myform" id="myform" action="admin_domessagedel" method="post">
                <input type="hidden" name="cpage" value="${cpage==null?1:cpage}">
                <input type="hidden" name="keywords" value="${keywords}">
                <div class="result-title">
                    <div class="result-list">
                        <a id="batchDel" href="javascript:delmore('你确定要删除这些信息吗？','myform')"><i class="icon-font"></i>批量删除</a>
                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="100%">
                        <tr>
                            <th class="tc" width="5%"><input class="allChoose" onclick="javascript:selectall(this)" name="" type="checkbox"></th>
                            <th>ID</th>
                            <th>时间</th>
                            <th>数据</th>
                            <th>操作</th>
                        </tr>
                        <c:forEach var="m" items="${messagelist}">
                        	<tr>
                            	<td class="tc"><input name="id[]" value="${m.MESSAGE_ID}" type="checkbox"></td>
                            	<td>${m.MESSAGE_ID}</td>
                            	<td>${m.MESSAGE_TIME}<p></p></td>
                            	<td style="width:400px;"><p style="width:300px;heigth:80px;overflow:hidden;white-space:nowrap;text-overflow:ellipsis">${m.MESSAGE_DATA}</p></td>
                            	<td>
                                	<a class="link-update" href="admin_domessageupload?id=${m.MESSAGE_ID}&cpage=${param.cp==null?1:param.cp}&keywords=${param.keywords==null?'':param.keywords}">通过</a>
                                	<a class="link-update" href="admin_domessagecheck?id=${m.MESSAGE_ID}&cpage=${param.cp==null?1:param.cp}&keywords=${param.keywords==null?'':param.keywords}">查看</a>
                                	<a class="link-del" href="javascript:Delete('你确定要删除信息【${m.MESSAGE_ID}】吗？','admin_domessagedel?id=${m.MESSAGE_ID}&cpage=${param.cp==null?1:param.cp}&keywords=${param.keywords==null?'':param.keywords}')">删除</a>
                            	</td>
                        	</tr>
                        </c:forEach>
                        
                        <script>
                        	function Delete(mess,url){
                        		if(confirm(mess)){
                        			location.href=url;
                        		}
                        	}
                        	function selectall(o){
                        		var a=document.getElementsByName('id[]');
                        		
                        		for(var i=0;i<a.length;i++){
                        			a[i].checked=o.checked;
                        		}
                        	}
                        	function delmore(mess,formname){
                        		if(confirm(mess)){
                        			var form=document.getElementById(formname);
                        			form.submit();
                        		}
                        	}
                        </script>
                        
                    </table>
                    <div class="list-page"> 
                    	共${tsum}条，${cpage==null?1:cpage}/${tpage}页
                    	<a href="admin_domessageselect?cp=1${searchParams}">首页</a>
                    	<a href="admin_domessageselect?cp=${cpage==null?1:(cpage-1<=0?1:cpage-1)}${searchParams}">上一页</a>
                    	<a href="admin_domessageselect?cp=${cpage==null?2:(cpage+1>tpage?tpage:cpage+1)}${searchParams}">下一页</a>
                    	<a href="admin_domessageselect?cp=${tpage}${searchParams}">尾页</a>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <!--/main-->
</div>
</body>
</html>