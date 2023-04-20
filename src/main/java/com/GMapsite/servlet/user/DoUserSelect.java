package com.GMapsite.servlet.user;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.GMapsite.entity.GMAPSITE_USER;
import com.GMapsite.service.GMAPSITE_USERDao;

/**
 * Servlet implementation class DoUserSelect
 */
@WebServlet("/manage/admin_douserselect")
public class DoUserSelect extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cpage=1;
		int count=10;
		
		String cp=request.getParameter("cp");
		String keyword=request.getParameter("keywords");
		
		if(cp!=null) {
			cpage=Integer.parseInt(cp);
		}
			
		
		ArrayList<GMAPSITE_USER> list=null;
		int arr[];
		if(keyword!=null) {
			arr=GMAPSITE_USERDao.totalPage(count,keyword);
			list=GMAPSITE_USERDao.selectAll(cpage,count,keyword);
			request.setAttribute("searchParams", "&keywords="+keyword);
		}else {
			arr=GMAPSITE_USERDao.totalPage(count);
			list=GMAPSITE_USERDao.selectAll(cpage,count);
		}
		
		
		request.setAttribute("userlist", list);
		request.setAttribute("tsum", arr[0]);
		request.setAttribute("tpage", arr[1]);
		request.setAttribute("cpage", cp);
		
		request.getRequestDispatcher("admin_user.jsp").forward(request, response);
	}

}
