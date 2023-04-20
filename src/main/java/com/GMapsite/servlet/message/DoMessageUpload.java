package com.GMapsite.servlet.message;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.GMapsite.entity.GMAPSITE_MESSAGE;
import com.GMapsite.entity.GMAPSITE_MESSAGEDATA;
import com.GMapsite.entity.GMAPSITE_PICTUREPOINT;
import com.GMapsite.entity.GMAPSITE_POINT;
import com.GMapsite.service.GMAPSITE_MESSAGEDao;
import com.GMapsite.service.GMAPSITE_POINTDao;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class DoMessageUpload
 */
@WebServlet("/manage/admin_domessageupload")
public class DoMessageUpload extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String mid=request.getParameter("id");
		String cp=request.getParameter("cpage");
		String keywords=request.getParameter("keywords");
		GMAPSITE_MESSAGE m=GMAPSITE_MESSAGEDao.selectById(mid);
		
		GsonBuilder builder = new GsonBuilder(); 
	    builder.setPrettyPrinting(); 
	    Gson gson = builder.create(); 
	    GMAPSITE_MESSAGEDATA d = gson.fromJson(m.getMESSAGE_DATA(), GMAPSITE_MESSAGEDATA.class);
	    GMAPSITE_PICTUREPOINT[] pp=d.getPoints();
	    ArrayList<GMAPSITE_POINT> points=new ArrayList<GMAPSITE_POINT>();
	    
	    for(GMAPSITE_PICTUREPOINT p : pp) {
	    	GMAPSITE_POINT tp=new GMAPSITE_POINT(
	    			Integer.parseInt(p.getId().substring(1)),
	    			p.getDescription(),
	    			String.valueOf(d.getDitucode()),
	    			Integer.parseInt(p.getX().substring(0,p.getX().length()-2)),
	    			Integer.parseInt(p.getY().substring(0,p.getY().length()-2))
	    			);
	    	tp.setPOINT_ID(GMAPSITE_POINTDao.getId(tp));
	    	points.add(tp);
	    		    	
	    }
	    GMAPSITE_POINTDao.updateAll(points,d.getDitucode());
	    
	    response.sendRedirect("admin_domessagedel?id="+mid+"&cpage="+cp+"&keywords="+keywords);
	}

}
