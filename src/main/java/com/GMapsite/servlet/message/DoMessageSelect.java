package com.GMapsite.servlet.message;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.GMapsite.entity.GMAPSITE_MESSAGE;
import com.GMapsite.service.GMAPSITE_MESSAGEDao;

/**
 * Servlet implementation class DoMessageSelect
 */
@WebServlet("/manage/admin_domessageselect")
public class DoMessageSelect extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cpage=1;
		int count=10;
		
		String cp=request.getParameter("cp");
		String keyword=request.getParameter("keywords");
		
		if(cp!=null) {
			cpage=Integer.parseInt(cp);
		}
			
		
		ArrayList<GMAPSITE_MESSAGE> list=null;
		int arr[];
		if(keyword!=null) {
			arr=GMAPSITE_MESSAGEDao.totalPage(count,keyword);
			list=GMAPSITE_MESSAGEDao.selectAll(cpage,count,keyword);
			request.setAttribute("searchParams", "&keywords="+keyword);
		}else {
			arr=GMAPSITE_MESSAGEDao.totalPage(count);
			list=GMAPSITE_MESSAGEDao.selectAll(cpage,count);
		}
		
		
		request.setAttribute("messagelist", list);
		request.setAttribute("tsum", arr[0]);
		request.setAttribute("tpage", arr[1]);
		request.setAttribute("cpage", cp);
		
		request.getRequestDispatcher("admin_shenhe.jsp").forward(request, response);
	}
	
}
