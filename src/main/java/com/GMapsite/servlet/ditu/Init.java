package com.GMapsite.servlet.ditu;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.GMapsite.entity.GMAPSITE_USER;
import com.GMapsite.service.GMAPSITE_POINTDao;
import com.GMapsite.service.GMAPSITE_USERDao;
import com.google.gson.Gson;
import com.GMapsite.entity.GMAPSITE_PICTURE;
import com.GMapsite.entity.GMAPSITE_POINT;

/**
 * Servlet implementation class Init
 */
@WebServlet("/init")
public class Init extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String pid=request.getParameter("pid");
		ArrayList<GMAPSITE_POINT> points=null;
		String json="[";
		if(pid!=null) {
			points=GMAPSITE_POINTDao.selectByPicture(pid);
			for(GMAPSITE_POINT point : points){
				json+=point.toString();
			}
			json+="]";
			response.sendRedirect("index.jsp?points="+URLEncoder.encode(json,"UTF-8")+"&ditucode="+request.getParameter("pid"));
		}else {
			PrintWriter out=response.getWriter();
			
			out.write("<script>");
			out.write("alert('初始化失败！');");
			out.write("location.href='index.jsp';");
			out.write("</script>");
		}
		
	}


}
