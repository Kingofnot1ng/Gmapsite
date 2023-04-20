package com.GMapsite.servlet.message;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.GMapsite.service.GMAPSITE_MESSAGEDao;

/**
 * Servlet implementation class DoMessageDel
 */
@WebServlet("/manage/admin_domessagedel")
public class DoMessageDel extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String id=request.getParameter("id");
		String cp=request.getParameter("cpage");
		String keywords=request.getParameter("keywords");
		
		int count=GMAPSITE_MESSAGEDao.del(id);
		
		
		if(count>0) {			
			if(keywords!=null&&keywords.length()>0) {
				response.sendRedirect("admin_domessageselect?cp="+cp+"&keywords="+keywords);
			}else {
				response.sendRedirect("admin_domessageselect?cp="+cp);
			}			
		}else {
			PrintWriter out=response.getWriter();
			
			out.write("<script>");
			out.write("alert('用户删除失败！')");
			if(keywords!=null&&keywords.length()>0) {
				out.write("location.href='manage/admin_domessageselect?cp="+cp+"&keywords="+keywords+"'");
			}else {
				out.write("location.href='manage/admin_domessageselect?cp="+cp+"'");
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
			count*=GMAPSITE_MESSAGEDao.del(ids[i]);
		}
		
		if(count>0) {			
			if(keywords!=null&&keywords.length()>0) {
				response.sendRedirect("admin_domessageselect?cp="+cp+"&keywords="+keywords);
			}else {
				response.sendRedirect("admin_domessageselect?cp="+cp);
			}			
		}else {
			PrintWriter out=response.getWriter();
			
			out.write("<script>");
			out.write("alert('用户删除失败！')");
			if(keywords!=null&&keywords.length()>0) {
				out.write("location.href='manage/admin_domessageselect?cp="+cp+"&keywords="+keywords+"'");
			}else {
				out.write("location.href='manage/admin_domessageselect?cp="+cp+"'");
			}
			out.write("</script>");
		}
	}

}
