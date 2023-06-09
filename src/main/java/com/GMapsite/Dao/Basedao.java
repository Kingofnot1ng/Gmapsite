package com.GMapsite.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ArrayList;

import com.GMapsite.entity.GMAPSITE_USER;

public class Basedao {
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection getconn() {
		Connection conn=null;
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/gmapsite?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true","root","215321yao");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	public static int exectuIUD(String sql,Object[] params) {
		int count=0;
		Connection conn=Basedao.getconn();
		
		PreparedStatement ps=null;
		
		try {
			ps=conn.prepareStatement(sql);
			for(int i=0;i<params.length;i++) {
				ps.setObject(i+1,params[i]);
			}
			count=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Basedao.closeall(null, ps, conn);
		}
		return count;
	}
	
	public static void closeall(ResultSet rs,PreparedStatement ps,Connection conn) {
		try {
			if(rs!=null)
				rs.close();
			if(ps!=null)
				ps.close();
			if(conn!=null)
				conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
