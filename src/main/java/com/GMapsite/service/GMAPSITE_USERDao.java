package com.GMapsite.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.GMapsite.Dao.Basedao;
import com.GMapsite.entity.GMAPSITE_USER;

public class GMAPSITE_USERDao {
	public static int update(GMAPSITE_USER u) {
		String sql="update GMAPSITE_USER set USER_NAME=?, "
				+ "USER_PASSWORD=? where USER_ID= ?";
		Object[] params = {			
				u.getUSER_NAME(),
				u.getUSER_PASSWORD(),
				u.getUSER_ID()
		};
		return Basedao.exectuIUD(sql, params);
	}
	public static int insert(GMAPSITE_USER u) {
		if(u.getUSER_ID()==-1) {			
			String sql="insert into GMAPSITE_USER values(null,?,?)";
			Object[] params = {
					u.getUSER_NAME(),
					u.getUSER_PASSWORD(),
			};
			return Basedao.exectuIUD(sql, params);
		}else {
			String sql="insert into GMAPSITE_USER values(?,?,?)";
			Object[] params = {
					u.getUSER_ID(),
					u.getUSER_NAME(),
					u.getUSER_PASSWORD(),
			};
			return Basedao.exectuIUD(sql, params);
		}
		
	}
	public static String _insert(GMAPSITE_USER _u) {		
			String sql="insert into GMAPSITE_USER values(null,?,?)";
			Object[] params = {
					_u.getUSER_NAME(),
					_u.getUSER_PASSWORD(),
			};
			Basedao.exectuIUD(sql, params);
			
			String uid=null;  
			
			ResultSet rs=null;
			
			Connection conn=Basedao.getconn();
			
			PreparedStatement ps=null;
				
			try {				
				sql="select * from GMAPSITE_USER where USER_NAME=? and USER_PASSWORD=? order by USER_ID desc limit 0,1";
				
				ps=conn.prepareStatement(sql);
				ps.setString(1,_u.getUSER_NAME());
				ps.setString(2,_u.getUSER_PASSWORD());
				rs=ps.executeQuery();
				
				while(rs.next()) {
					uid=String.valueOf(rs.getInt("USER_ID"));
					System.out.println("...");
					System.out.println(uid);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				Basedao.closeall(rs, ps, conn);
			}
			
			return uid;				
	}
	public static int del(String id) {
		String sql="delete from GMAPSITE_USER where USER_ID=?";
		Object[] params= {id};
		return Basedao.exectuIUD(sql, params);
	}
	public static int[] totalPage(int count) {
		int[] arr= {0,1};
		
		Connection conn=Basedao.getconn();
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		
		try {
			String sql="select count(*) from GMAPSITE_USER";
			ps=conn.prepareStatement(sql);
			
			rs=ps.executeQuery();
			while(rs.next()) {
				arr[0]=rs.getInt(1);
				
				if(arr[0]%count==0) {
					arr[1]=arr[0]/count;
				}else {
					arr[1]=arr[0]/count+1;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Basedao.closeall(rs, ps, conn);
		}
		return arr;
		
	}
	public static int[] totalPage(int count,String keyword) {
		int[] arr= {0,1};
		
		Connection conn=Basedao.getconn();
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		
		try {
			String sql="select count(*) from GMAPSITE_USER where USER_NAME like ? or USER_ID like ?";
			ps=conn.prepareStatement(sql);
			ps.setString(1,"%"+keyword+"%");
			ps.setString(2,keyword);
			
			rs=ps.executeQuery();
			while(rs.next()) {
				arr[0]=rs.getInt(1);
				
				if(arr[0]%count==0) {
					arr[1]=arr[0]/count;
				}else {
					arr[1]=arr[0]/count+1;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Basedao.closeall(rs, ps, conn);
		}
		return arr;
		
	}
	public static ArrayList<GMAPSITE_USER> selectAll(){
		ArrayList<GMAPSITE_USER> list=new ArrayList<GMAPSITE_USER>();
		
		ResultSet rs=null;
		
		Connection conn=Basedao.getconn();
		
		PreparedStatement ps=null;
			
		try {				
			String sql="select * from GMAPSITE_USER order by USER_ID";
			
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				GMAPSITE_USER u=new GMAPSITE_USER(
						rs.getInt("USER_ID"),
						rs.getString("USER_NAME"),
						rs.getString("USER_PASSWORD")				
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
	public static ArrayList<GMAPSITE_USER> selectAll(int cpage,int count){
		ArrayList<GMAPSITE_USER> list=new ArrayList<GMAPSITE_USER>();
		
		ResultSet rs=null;
		
		Connection conn=Basedao.getconn();
		
		PreparedStatement ps=null;
			
		try {				
			String sql="select * from GMAPSITE_USER order by USER_ID desc limit ?,?";			
			ps=conn.prepareStatement(sql);
			
			ps.setInt(1, (cpage-1)*count);
			ps.setInt(2, count);
			
			rs=ps.executeQuery();
			
			while(rs.next()) {
				GMAPSITE_USER u=new GMAPSITE_USER(
						rs.getInt("USER_ID"),
						rs.getString("USER_NAME"),
						rs.getString("USER_PASSWORD")							
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
	public static ArrayList<GMAPSITE_USER> selectAll(int cpage,int count,String keyword){
		ArrayList<GMAPSITE_USER> list=new ArrayList<GMAPSITE_USER>();
		
		ResultSet rs=null;
		
		Connection conn=Basedao.getconn();
		
		PreparedStatement ps=null;
			
		try {				
			String sql="select * from GMAPSITE_USER where USER_NAME like ? or USER_ID like ? order by USER_ID desc limit ?,?";			
			ps=conn.prepareStatement(sql);
			
			ps.setString(1,"%"+keyword+"%");
			ps.setString(2,keyword);
			ps.setInt(3, (cpage-1)*count);
			ps.setInt(4, count);
			
			rs=ps.executeQuery();
			
			while(rs.next()) {
				GMAPSITE_USER u=new GMAPSITE_USER(
						rs.getInt("USER_ID"),
						rs.getString("USER_NAME"),
						rs.getString("USER_PASSWORD")									
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
	public static GMAPSITE_USER selectById(String id){
		GMAPSITE_USER u=null;  
		
		ResultSet rs=null;
		
		Connection conn=Basedao.getconn();
		
		PreparedStatement ps=null;
			
		try {				
			String sql="select * from GMAPSITE_USER where USER_ID=?";
			
			ps=conn.prepareStatement(sql);
			ps.setString(1,id);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				u=new GMAPSITE_USER(
						rs.getInt("USER_ID"),
						rs.getString("USER_NAME"),
						rs.getString("USER_PASSWORD")									
						);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		return u;
	}
	public static int login(int id,String password) { 
		int count=0;
		ResultSet rs=null;
		
		Connection conn=Basedao.getconn();
		
		PreparedStatement ps=null;
			
		try {				
			String sql="select count(*) from GMAPSITE_USER where USER_ID=? and USER_PASSWORD=?";
			
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
}
