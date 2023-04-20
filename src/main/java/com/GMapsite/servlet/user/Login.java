package com.GMapsite.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.GMapsite.entity.GMAPSITE_MANAGER;
import com.GMapsite.entity.GMAPSITE_USER;
import com.GMapsite.service.GMAPSITE_MANAGERDao;
import com.GMapsite.service.GMAPSITE_USERDao;

@WebServlet("/login")
public class Login extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		int username;
		String password;
		String ismananger=null;
		if(request.getParameter("userName")==null) {
			username=Integer.parseInt((String)request.getAttribute("userName"));
			password=(String)request.getAttribute("passWord");
		}else {
			username=Integer.parseInt(request.getParameter("userName"));
			password=request.getParameter("passWord");
			ismananger=request.getParameter("ismanager");
		}
		if(ismananger==null) {
			int count=GMAPSITE_USERDao.login(username,password);
			if(count>0) {	
				
				Cookie c1 = new Cookie("id",String.valueOf(username));
				c1.setMaxAge(60*60*24);
				response.addCookie(c1);
				
				GMAPSITE_USER u=GMAPSITE_USERDao.selectById(String.valueOf(username));				
				Cookie c2 = new Cookie("name",u.getUSER_NAME());
				c2.setMaxAge(60*60*24);
				response.addCookie(c2);
				
				Cookie c3 = new Cookie("password",password);
				c3.setMaxAge(60*60*24);
				response.addCookie(c3);
				
				Cookie c4 = new Cookie("position","user");
				c4.setMaxAge(60*60*24);
				response.addCookie(c4);
				
				response.sendRedirect("index.jsp");					
			}else {
				PrintWriter out=response.getWriter();			
				out.print("<script>");
				out.print("alert('用户登录失败！');");
				out.print("location.href='login.jsp';");
				out.print("</script>");
			}
		}else {
			int count=GMAPSITE_MANAGERDao.login(username,password);
			if(count>0) {	
				
				Cookie c1 = new Cookie("id",String.valueOf(username));
				c1.setMaxAge(60*60*24);
				response.addCookie(c1);
				
				
				GMAPSITE_MANAGER m=GMAPSITE_MANAGERDao.selectById(request.getParameter("userName"));
				Cookie c2 = new Cookie("name",m.getMANAGER_NAME());
				c2.setMaxAge(60*60*24);
				response.addCookie(c2);
				
				Cookie c3 = new Cookie("password",password);
				c3.setMaxAge(60*60*24);
				response.addCookie(c3);
				
				Cookie c4 = new Cookie("position","manager");
				c4.setMaxAge(60*60*24);
				response.addCookie(c4);
				
				response.sendRedirect("manage/admin_index.jsp");					
			}else {
				PrintWriter out=response.getWriter();			
				out.print("<script>");
				out.print("alert('用户登录失败！!!!');");
				out.print("location.href='login.jsp';");
				out.print("</script>");
			}
		}
		
		
		
	}
}
