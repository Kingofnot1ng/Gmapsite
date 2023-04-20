package com.GMapsite.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.GMapsite.Dao.Basedao;
import com.GMapsite.entity.GMAPSITE_MESSAGE;

public class GMAPSITE_MESSAGEDao {
	public static int insert(GMAPSITE_MESSAGE m) {
		if(m.getMESSAGE_ID()<=0) {			
			String sql="insert into GMAPSITE_MESSAGE values(null,?,?,?,?)";
			Object[] params = {
					m.getMESSAGE_CODE(),
					m.getMESSAGE_STATUS(),
					m.getMESSAGE_TIME(),
					m.getMESSAGE_DATA()
			};
			return Basedao.exectuIUD(sql, params);
		}else {
			String sql="insert into GMAPSITE_MESSAGE values(?,?,?,?,?)";
			Object[] params = {
					m.getMESSAGE_ID(),
					m.getMESSAGE_CODE(),
					m.getMESSAGE_STATUS(),
					m.getMESSAGE_TIME(),
					m.getMESSAGE_DATA()
			};
			return Basedao.exectuIUD(sql, params);
		}
		
	}
	public static int update(GMAPSITE_MESSAGE m) {
		String sql="update GMAPSITE_MESSAGE set MESSAGE_TIME=?, "
				+ "MESSAGE_DATA=? where MESSAGE_ID()= ?";
		Object[] params = {			
				m.getMESSAGE_TIME(),
				m.getMESSAGE_DATA(),
				m.getMESSAGE_ID()
		};
		return Basedao.exectuIUD(sql, params);
	}
	public static int uploadNew(GMAPSITE_MESSAGE m) {
		GMAPSITE_MESSAGEDao.insert(m); 
		
		int mid=-1;
		
		ResultSet rs=null;
		
		Connection conn=Basedao.getconn();
		
		PreparedStatement ps=null;
			
		System.out.println("???");
		try {				
			String sql="select * from GMAPSITE_MESSAGE where MESSAGE_TIME=? and MESSAGE_DATA=?";
			
			ps=conn.prepareStatement(sql);
			ps.setString(1,m.getMESSAGE_TIME());
			ps.setString(2,m.getMESSAGE_DATA());
			rs=ps.executeQuery();
			
			while(rs.next()) {
				mid=rs.getInt("MESSAGE_ID");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		return mid;
	}
	public static int[] totalPage(int count) {
		int[] arr= {0,1};
		
		Connection conn=Basedao.getconn();
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		
		try {
			String sql="select count(*) from GMAPSITE_MESSAGE";
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
			String sql="select count(*) from GMAPSITE_MESSAGE where MESSAGE_ID=? or MESSAGE_TIME=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1,keyword);
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
	public static ArrayList<GMAPSITE_MESSAGE> selectAll(){
		ArrayList<GMAPSITE_MESSAGE> list=new ArrayList<GMAPSITE_MESSAGE>();
		
		ResultSet rs=null;
		
		Connection conn=Basedao.getconn();
		
		PreparedStatement ps=null;
			
		try {				
			String sql="select * from GMAPSITE_MESSAGE order by MESSAGE_ID";
			
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				GMAPSITE_MESSAGE u=new GMAPSITE_MESSAGE(
						rs.getInt("MESSAGE_ID"),
						rs.getInt("MESSAGE_CODE"),
						rs.getString("MESSAGE_STATUS"),
						rs.getString("MESSAGE_TIME"),
						rs.getString("MESSAGE_DATA")
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
	public static ArrayList<GMAPSITE_MESSAGE> selectAll(int cpage,int count){
		ArrayList<GMAPSITE_MESSAGE> list=new ArrayList<GMAPSITE_MESSAGE>();
		
		ResultSet rs=null;
		
		Connection conn=Basedao.getconn();
		
		PreparedStatement ps=null;
			
		try {				
			String sql="select * from GMAPSITE_MESSAGE order by MESSAGE_ID desc limit ?,?";			
			ps=conn.prepareStatement(sql);
			
			ps.setInt(1, (cpage-1)*count);
			ps.setInt(2, count);
			
			rs=ps.executeQuery();
			
			while(rs.next()) {
				GMAPSITE_MESSAGE u=new GMAPSITE_MESSAGE(
						rs.getInt("MESSAGE_ID"),
						rs.getInt("MESSAGE_CODE"),
						rs.getString("MESSAGE_STATUS"),
						rs.getString("MESSAGE_TIME"),
						rs.getString("MESSAGE_DATA")
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
	public static ArrayList<GMAPSITE_MESSAGE> selectAll(int cpage,int count,String keyword){
		ArrayList<GMAPSITE_MESSAGE> list=new ArrayList<GMAPSITE_MESSAGE>();
		
		ResultSet rs=null;
		
		Connection conn=Basedao.getconn();
		
		PreparedStatement ps=null;
			
		try {				
			String sql="select * from GMAPSITE_MESSAGE where MESSAGE_ID=? or MESSAGE_TIME=? order by MESSAGE_ID desc limit ?,?";			
			ps=conn.prepareStatement(sql);
			
			ps.setString(1,keyword);
			ps.setString(2,keyword);			
			ps.setInt(3, (cpage-1)*count);
			ps.setInt(4, count);
			
			rs=ps.executeQuery();
			
			while(rs.next()) {
				GMAPSITE_MESSAGE u=new GMAPSITE_MESSAGE(
						rs.getInt("MESSAGE_ID"),
						rs.getInt("MESSAGE_CODE"),
						rs.getString("MESSAGE_STATUS"),
						rs.getString("MESSAGE_TIME"),
						rs.getString("MESSAGE_DATA")
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
	public static int del(String id) {
		String sql="delete from GMAPSITE_MESSAGE where MESSAGE_ID=?";
		Object[] params= {Integer.parseInt(id)};
		return Basedao.exectuIUD(sql, params);
	}
	public static GMAPSITE_MESSAGE selectById(String id){
		GMAPSITE_MESSAGE u=null;  
		
		ResultSet rs=null;
		
		Connection conn=Basedao.getconn();
		
		PreparedStatement ps=null;
			
		try {				
			String sql="select * from GMAPSITE_MESSAGE where MESSAGE_ID=?";
			
			ps=conn.prepareStatement(sql);
			ps.setString(1,id);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				u=new GMAPSITE_MESSAGE(
						rs.getInt("MESSAGE_ID"),
						rs.getInt("MESSAGE_CODE"),
						rs.getString("MESSAGE_STATUS"),
						rs.getString("MESSAGE_TIME"),
						rs.getString("MESSAGE_DATA")
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
}
