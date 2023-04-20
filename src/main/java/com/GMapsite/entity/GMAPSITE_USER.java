package com.GMapsite.entity;

import org.eclipse.jdt.annotation.Nullable;

public class GMAPSITE_USER {
	private int USER_ID;
	private String USER_NAME;
	private String USER_PASSWORD;
	
	public GMAPSITE_USER(int uSER_ID, String uSER_NAME, String uSER_PASSWORD) {
		super();
		USER_ID = uSER_ID;
		USER_NAME = uSER_NAME;
		USER_PASSWORD = uSER_PASSWORD;
	}
	public GMAPSITE_USER(String uSER_NAME, String uSER_PASSWORD) {
		super();
		USER_ID = -1;
		USER_NAME = uSER_NAME;
		USER_PASSWORD = uSER_PASSWORD;
	}
	
	public int getUSER_ID() {
		return USER_ID;
	}

	public void setUSER_ID(int uSER_ID) {
		USER_ID = uSER_ID;
	}

	public String getUSER_NAME() {
		return USER_NAME;
	}

	public void setUSER_NAME(String uSER_NAME) {
		USER_NAME = uSER_NAME;
	}

	public String getUSER_PASSWORD() {
		return USER_PASSWORD;
	}

	public void setUSER_PASSWORD(String uSER_PASSWORD) {
		USER_PASSWORD = uSER_PASSWORD;
	}

	
}
