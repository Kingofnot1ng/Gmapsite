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
 * Servlet implementation class DoUserAdd
 */
@WebServlet("/manage/admin_douseradd")
public class DoUserAdd extends HttpServlet {

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String name=request.getParameter("name");
		String password=request.getParameter("passWord");
		
		GMAPSITE_USER u=new GMAPSITE_USER(name, password);
		
		int count=GMAPSITE_USERDao.insert(u);
		
		if(count>0) {		
			response.sendRedirect("admin_douserselect");
			
		}else {
			PrintWriter out=response.getWriter();
			
			out.write("<script>");
			out.write("alert('用户添加失败！');");
			out.write("location.href='manage/admin_douserselect';");
			out.write("</script>");
		}
	}

}
