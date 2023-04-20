package com.GMapsite.entity;

public class GMAPSITE_PICTUREPOINT {
	private String id;
	private String X;
	private String Y;
	private String description;
	public GMAPSITE_PICTUREPOINT(String id, String x, String y, String description) {
		super();
		this.id = id;
		X = x;
		Y = y;
		this.description = description;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getX() {
		return X;
	}
	public void setX(String x) {
		X = x;
	}
	public String getY() {
		return Y;
	}
	public void setY(String y) {
		Y = y;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
