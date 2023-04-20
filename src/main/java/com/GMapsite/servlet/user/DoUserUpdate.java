package com.GMapsite.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.GMapsite.entity.GMAPSITE_USER;
import com.GMapsite.service.GMAPSITE_USERDao;

/**
 * Servlet implementation class DoUserUpdate
 */
@WebServlet("/manage/admin_douserupdate")
public class DoUserUpdate extends HttpServlet {
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		int username=Integer.parseInt(request.getParameter("userName"));
		String name=request.getParameter("name");
		String password=request.getParameter("passWord");
		
		String keywords=request.getParameter("keywords");
		
		int status=1;
	
		GMAPSITE_USER u=new GMAPSITE_USER(username, name, password);
		
		int count=GMAPSITE_USERDao.update(u);
		
		if(count>0) {	
			if(keywords!=null) {
				response.sendRedirect("admin_douserselect?cp="+request.getParameter("cpage")+"&keywords="+keywords);
			}else {
				response.sendRedirect("admin_douserselect?cp="+request.getParameter("cpage"));
			}
			
			
		}else {
			PrintWriter out=response.getWriter();
			
			out.write("<script>");
			out.write("alert('用户修改失败！');");
			out.write("location.href='manage/admin_touserupdate?id="+username+"';");
			out.write("</script>");
		}
	}

}
