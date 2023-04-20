package com.GMapsite.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.GMapsite.Dao.Basedao;
import com.GMapsite.entity.GMAPSITE_PICTURE;

public class GMAPSITE_PICTUREDao {
	public static GMAPSITE_PICTURE selectById(String id){
		GMAPSITE_PICTURE p=null;  
		
		ResultSet rs=null;
		
		Connection conn=Basedao.getconn();
		
		PreparedStatement ps=null;
			
		try {				
			String sql="select * from GMAPSITE_PICTURE where PICTURE_ID=?";
			
			ps=conn.prepareStatement(sql);
			ps.setString(1,id);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				p=new GMAPSITE_PICTURE(
						rs.getInt("PICTURE_ID"),
						rs.getString("PICTURE_PATH")								
						);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		return p;
	}
	
	public static ArrayList<GMAPSITE_PICTURE> selectAll(){
		ArrayList<GMAPSITE_PICTURE> list=new ArrayList<GMAPSITE_PICTURE>();
		
		ResultSet rs=null;
		
		Connection conn=Basedao.getconn();
		
		PreparedStatement ps=null;
			
		try {				
			String sql="select * from GMAPSITE_PICTURE order by PICTURE_ID";
			
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				GMAPSITE_PICTURE u=new GMAPSITE_PICTURE(
						rs.getInt("PICTURE_ID"),
						rs.getString("PICTURE_PATH")				
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
	
}
