package com.GMapsite.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.GMapsite.Dao.Basedao;
import com.GMapsite.entity.GMAPSITE_MANAGER;
import com.GMapsite.entity.GMAPSITE_USER;

public class GMAPSITE_MANAGERDao {
	public static int login(int id,String password) { 
		int count=0;
		ResultSet rs=null;
		
		Connection conn=Basedao.getconn();
		
		PreparedStatement ps=null;
			
		try {				
			String sql="select count(*) from GMAPSITE_MANAGER where MANAGER_ID=? and MANAGER_PASSWORD=?";
			
			ps=conn.prepareStatement(sql);
			ps.setInt(1,id);
			ps.setString(2,password);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				count=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		return count;	
	}
	public static GMAPSITE_MANAGER selectById(String id){
		GMAPSITE_MANAGER m=null;  
		
		ResultSet rs=null;
		
		Connection conn=Basedao.getconn();
		
		PreparedStatement ps=null;
			
		try {				
			String sql="select * from GMAPSITE_MANAGER where MANAGER_ID=?";
			
			ps=conn.prepareStatement(sql);
			ps.setString(1,id);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				m=new GMAPSITE_MANAGER(
						rs.getInt("MANAGER_ID"),
						rs.getString("MANAGER_NAME"),
						rs.getString("MANAGER_PASSWORD")									
						);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		return m;
	}
	
	
}
