package com.GMapsite.entity;

public class GMAPSITE_MESSAGEDATA {
	private int userid;
	private String username;
	private GMAPSITE_PICTUREPOINT[] points;
	private int ditucode;
	
	public GMAPSITE_MESSAGEDATA(int userid, String username, GMAPSITE_PICTUREPOINT[] points, int ditucode) {
		super();
		this.userid = userid;
		this.username = username;
		this.points = points;
		this.ditucode = ditucode;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public GMAPSITE_PICTUREPOINT[] getPoints() {
		return points;
	}
	public void setPoints(GMAPSITE_PICTUREPOINT[] points) {
		this.points = points;
	}
	public int getDitucode() {
		return ditucode;
	}
	public void setDitucode(int ditucode) {
		this.ditucode = ditucode;
	}
	
	
	
}
