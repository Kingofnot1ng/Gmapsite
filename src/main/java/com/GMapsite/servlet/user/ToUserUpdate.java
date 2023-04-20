package com.GMapsite.servlet.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.GMapsite.entity.GMAPSITE_USER;
import com.GMapsite.service.GMAPSITE_USERDao;

/**
 * Servlet implementation class ToUserUpdate
 */
@WebServlet("/manage/admin_touserupdate")
public class ToUserUpdate extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String id=request.getParameter("id");
		String keywords=request.getParameter("keywords");
		
		GMAPSITE_USER user =GMAPSITE_USERDao.selectById(id);
		
		request.setAttribute("user", user);
		
		request.setAttribute("cpage", request.getParameter("cpage"));
		
		if(keywords.length()!=0) {
			request.setAttribute("keywords", keywords);
		}
		
		request.getRequestDispatcher("admin_usermodify.jsp").forward(request, response);
	}

}
