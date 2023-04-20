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

@WebServlet("/register")
public class Register extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String name=request.getParameter("name");
		String password=request.getParameter("passWord");
		
		GMAPSITE_USER u=new GMAPSITE_USER(name, password);
		
		String id=GMAPSITE_USERDao._insert(u);
		
		if(Integer.parseInt(id)>0) {			
			request.setAttribute("userName",id);			
			request.setAttribute("passWord", password);			
			
			request.getRequestDispatcher("/login").forward(request, response);
			
		}else {
			PrintWriter out=response.getWriter();
			
			out.write("<script>");
			out.write("alert('用户添加失败！');");
			out.write("location.href='reg.jsp';");
			out.write("</script>");
		}
		
			
			
		
	}
}
