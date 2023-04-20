package com.GMapsite.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.GMapsite.Dao.Basedao;
import com.GMapsite.entity.GMAPSITE_PICTURE;
import com.GMapsite.entity.GMAPSITE_POINT;

public class GMAPSITE_POINTDao {
	public static void updateAll(ArrayList<GMAPSITE_POINT> points,int ditucode) {
		ArrayList<GMAPSITE_POINT> list=new ArrayList<GMAPSITE_POINT>();
		
		ResultSet rs=null;
		
		Connection conn=Basedao.getconn();
		
		PreparedStatement ps=null;
			
		try {				
			String sql="select * from GMAPSITE_POINT where POINT_PICTURE=? order by POINT_ID";
			
			ps=conn.prepareStatement(sql);
			ps.setString(1,String.valueOf(ditucode));
			rs=ps.executeQuery();
			
			while(rs.next()) {
				GMAPSITE_POINT u=new GMAPSITE_POINT(
						rs.getInt("POINT_ID"),
						rs.getString("POINT_DESC"),
						rs.getString("POINT_PICTURE"),						
						rs.getInt("POINT_X"),
						rs.getInt("POINT_Y")
						);
				list.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		String sql;
		
		for(GMAPSITE_POINT _p:list) {
			int flag=0;
			for(GMAPSITE_POINT p:points) {
				if(_p.getPOINT_ID()==p.getPOINT_ID()) {
					flag=1;
					sql="update GMAPSITE_POINT set POINT_DESC=? where POINT_ID= ?";
					Object[] params1= {
							p.getPOINT_DESC(),
							p.getPOINT_ID()
						};	
					Basedao.exectuIUD(sql, params1);
				}				
			}
			if(flag==0) {
				sql="delete from GMAPSITE_POINT where POINT_ID=?";
				Object[] params2= {
						_p.getPOINT_ID()
					};	
				Basedao.exectuIUD(sql, params2);
			}
		}
		for(GMAPSITE_POINT p:points) {
			if(p.getPOINT_ID()==-1) {
				sql="insert into GMAPSITE_POINT values(null,?,?,?,?)";
				Object[] params3= {
						p.getX(),
						p.getY(),
						p.getPOINT_PICTUREID(),
						p.getPOINT_DESC()
					};	
				Basedao.exectuIUD(sql, params3);
			}				
		}
		
	}
	
	public static ArrayList<GMAPSITE_POINT> selectByPicture(String pictureid){
		ArrayList<GMAPSITE_POINT> list=new ArrayList<GMAPSITE_POINT>();
		
		ResultSet rs=null;
		
		Connection conn=Basedao.getconn();
		
		PreparedStatement ps=null;
			
		try {				
			String sql="select * from GMAPSITE_POINT where POINT_PICTURE=? order by POINT_ID";
			
			ps=conn.prepareStatement(sql);
			ps.setString(1,pictureid);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				GMAPSITE_POINT u=new GMAPSITE_POINT(
						rs.getInt("POINT_ID"),
						rs.getString("POINT_DESC"),
						rs.getString("POINT_PICTURE"),						
						rs.getInt("POINT_X"),
						rs.getInt("POINT_Y")
						);
				list.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		return list;
	}
	public static int getId(GMAPSITE_POINT p) {
		int id=-1;
		
		ResultSet rs=null;
		
		Connection conn=Basedao.getconn();
		
		PreparedStatement ps=null;
			
		try {				
			String sql="select * from GMAPSITE_POINT where POINT_X=? and POINT_Y=? and POINT_PICTURE=? and POINT_DESC=? order by POINT_ID";
			
			ps=conn.prepareStatement(sql);
			ps.setInt(1,p.getX());
			ps.setInt(2,p.getY());
			ps.setString(3,p.getPOINT_PICTUREID());
			ps.setString(4,p.getPOINT_DESC());
			rs=ps.executeQuery();
			
			while(rs.next()) {
				id=rs.getInt("POINT_ID");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		return id;
	}
}
