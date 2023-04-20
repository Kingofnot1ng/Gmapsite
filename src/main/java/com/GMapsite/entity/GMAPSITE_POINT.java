package com.GMapsite.entity;

public class GMAPSITE_POINT {
	private int POINT_ID;
	private String POINT_DESC;
	private String POINT_PICTUREID;
	private int x,y;
	public GMAPSITE_POINT(int pOINT_ID, String pOINT_DESC, String pOINT_PICTUREID, int x, int y) {
		super();
		POINT_ID = pOINT_ID;
		POINT_DESC = pOINT_DESC;
		POINT_PICTUREID = pOINT_PICTUREID;
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getPOINT_ID() {
		return POINT_ID;
	}
	public void setPOINT_ID(int pOINT_ID) {
		POINT_ID = pOINT_ID;
	}
	public String getPOINT_DESC() {
		return POINT_DESC;
	}
	public void setPOINT_DESC(String pOINT_DESC) {
		POINT_DESC = pOINT_DESC;
	}
	public String getPOINT_PICTUREID() {
		return POINT_PICTUREID;
	}
	public void setPOINT_PICTUREID(String pOINT_PICTUREID) {
		POINT_PICTUREID = pOINT_PICTUREID;
	}
	@Override
	public String toString() {
		return "{\"id\":\"p"+POINT_ID+"\",\"X\":\""+x+"px\",\"Y\":\""+y+"px\",\"description\":\""+POINT_DESC+"\"},";
	}
	
}
