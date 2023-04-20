package com.GMapsite.entity;

public class GMAPSITE_PICTURE {
	private int PICTURE_ID;
	private String PICTURE_PATH;
	public GMAPSITE_PICTURE(int pICTURE_ID, String pICTURE_PATH) {
		super();
		PICTURE_ID = pICTURE_ID;
		PICTURE_PATH = pICTURE_PATH;
	}
	public int getPICTURE_ID() {
		return PICTURE_ID;
	}
	public void setPICTURE_ID(int pICTURE_ID) {
		PICTURE_ID = pICTURE_ID;
	}
	public String getPICTURE_PATH() {
		return PICTURE_PATH;
	}
	public void setPICTURE_PATH(String pICTURE_PATH) {
		PICTURE_PATH = pICTURE_PATH;
	}
	@Override
	public String toString() {
		return "{\"id\":\""+PICTURE_ID+"\",\"path\":\""+PICTURE_PATH+"\"},";
	}
}
