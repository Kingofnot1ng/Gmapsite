package com.GMapsite.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.GMapsite.Dao.Basedao;
import com.GMapsite.entity.GMAPSITE_USER;
import com.GMapsite.service.GMAPSITE_USERDao;

/**
 * Servlet implementation class DoUserDel
 */
@WebServlet("/manage/admin_douserdel")
public class DoUserDel extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String id=request.getParameter("id");
		String cp=request.getParameter("cpage");
		String keywords=request.getParameter("keywords");
		
		int count=GMAPSITE_USERDao.del(id);
		
		if(count>0) {			
			if(keywords!=null&&keywords.length()>0) {
				response.sendRedirect("admin_douserselect?cp="+cp+"&keywords="+keywords);
			}else {
				response.sendRedirect("admin_douserselect?cp="+cp);
			}			
		}else {
			PrintWriter out=response.getWriter();
			
			out.write("<script>");
			out.write("alert('用户删除失败！')");
			if(keywords!=null&&keywords.length()>0) {
				out.write("location.href='manage/admin_douserselect?cp="+cp+"&keywords="+keywords+"'");
			}else {
				out.write("location.href='manage/admin_douserselect?cp="+cp+"'");
			}
			out.write("</script>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String ids[]=request.getParameterValues("id[]");
		String cp=request.getParameter("cpage");
		String keywords=request.getParameter("keywords");
		
		int count=1;
		for(int i=0;i<ids.length;i++) {
			count*=GMAPSITE_USERDao.del(ids[i]);
		}
		
		if(count>0) {			
			if(keywords!=null&&keywords.length()>0) {
				response.sendRedirect("admin_douserselect?cp="+cp+"&keywords="+keywords);
			}else {
				response.sendRedirect("admin_douserselect?cp="+cp);
			}			
		}else {
			PrintWriter out=response.getWriter();
			
			out.write("<script>");
			out.write("alert('用户删除失败！')");
			if(keywords!=null&&keywords.length()>0) {
				out.write("location.href='manage/admin_douserselect?cp="+cp+"&keywords="+keywords+"'");
			}else {
				out.write("location.href='manage/admin_douserselect?cp="+cp+"'");
			}
			out.write("</script>");
		}
	}

}
