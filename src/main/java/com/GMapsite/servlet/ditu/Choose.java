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

import com.GMapsite.entity.GMAPSITE_PICTURE;
import com.GMapsite.service.GMAPSITE_PICTUREDao;

/**
 * Servlet implementation class Choose
 */
@WebServlet("/choose")
public class Choose extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		ArrayList<GMAPSITE_PICTURE> pictures=null;
		String json="[";
		pictures=GMAPSITE_PICTUREDao.selectAll();
		if(pictures!=null) {
			
			for(GMAPSITE_PICTURE picture : pictures){
				json+=picture.toString();
			}
			json+="]";
			response.sendRedirect("idea.jsp?pictures="+URLEncoder.encode(json,"UTF-8"));
		}else {
			PrintWriter out=response.getWriter();
			
			out.write("<script>");
			out.write("alert('初始化失败！');");
			out.write("location.href='index.jsp';");
			out.write("</script>");
		}
	}
}
