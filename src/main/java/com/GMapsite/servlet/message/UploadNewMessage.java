package com.GMapsite.servlet.message;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.GMapsite.entity.GMAPSITE_MESSAGE;
import com.GMapsite.service.GMAPSITE_MESSAGEDao;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


/**
 * Servlet implementation class UploadNewMessage
 */
@WebServlet("/uploadNewMessage")
public class UploadNewMessage extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String pid=request.getParameter("pid");
		String message=request.getParameter("message");
		int mid=-1;
			
		
		GsonBuilder builder = new GsonBuilder(); 
	    builder.setPrettyPrinting(); 
	    Gson gson = builder.create(); 
	    GMAPSITE_MESSAGE m = gson.fromJson(URLDecoder.decode(message), GMAPSITE_MESSAGE.class); 

	    mid=GMAPSITE_MESSAGEDao.uploadNew(m);
		response.sendRedirect("index.jsp?mode=1&ditucode="+pid+"&mid="+mid);
		//GMAPSITE_USER u=new GMAPSITE_USER(name, password);
		
		//int count=GMAPSITE_USERDao.insert(u);
		
		//if(count>0) {		
			//response.sendRedirect("admin_douserselect");
			
		//}else {
			//PrintWriter out=response.getWriter();
			
			//out.write("<script>");
			//out.write("alert('用户添加失败！');");
			//out.write("location.href='manage/admin_douserselect';");
			//out.write("</script>");
		//}
	}

}
