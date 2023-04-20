<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="admin_menu.jsp" %>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="admin_index.jsp">首页</a><span class="crumb-step">&gt;</span><a class="crumb-name" href="admin_douserselect">用户管理</a><span class="crumb-step">&gt;</span><span>修改用户</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form action="admin_douserupdate" method="post" id="myform" name="myform" >
                <input type="hidden" name="cpage" value="${cpage}">
                <input type="hidden" name="keywords" value="${keywords}">
                    <table class="insert-tab" width="100%">
                        <tbody>
                            <tr>
                                <th><i class="require-red">*</i>用户id：</th>
                                <td>
                                    <input class="common-text required"  name="userName" size="50" value="${user.USER_ID}" type="text" readonly="readonly">
                                </td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>用户名：</th>
                                <td>
                                    <input class="common-text required"  name="name" size="50" value="${user.USER_NAME}" type="text">
                                </td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>密码：</th>
                                <td>
                                    <input class="common-text required" type="password"  name="passWord" size="50" value="${user.USER_PASSWORD}" type="text">
                                </td>
                            </tr>
                            <tr>
                                <th></th>
                                <td>
                                    <input class="btn btn-primary btn6 mr10" value="提交" type="submit">
                                    <input class="btn btn6" onClick="history.go(-1)" value="返回" type="button">
                                </td>
                            </tr>
                        </tbody></table>
                </form>
            </div>
        </div>

    </div>
    <!--/main-->
</div>
</body>
</html>