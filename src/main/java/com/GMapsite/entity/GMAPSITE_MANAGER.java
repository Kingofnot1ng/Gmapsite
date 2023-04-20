package com.GMapsite.entity;

public class GMAPSITE_MANAGER {
	private int MANAGER_ID;
	private String MANAGER_NAME;
	private String MANAGER_PASSWORD;
	
	public GMAPSITE_MANAGER(int mANAGER_ID, String mANAGER_NAME, String mANAGER_PASSWORD) {
		super();
		MANAGER_ID = mANAGER_ID;
		MANAGER_NAME = mANAGER_NAME;
		MANAGER_PASSWORD = mANAGER_PASSWORD;
	}
	public GMAPSITE_MANAGER(String mANAGER_NAME, String mANAGER_PASSWORD) {
		super();
		MANAGER_ID = -1;
		MANAGER_NAME = mANAGER_NAME;
		MANAGER_PASSWORD = mANAGER_PASSWORD;
	}
	public int getMANAGER_ID() {
		return MANAGER_ID;
	}
	public void setMANAGER_ID(int mANAGER_ID) {
		MANAGER_ID = mANAGER_ID;
	}
	
	public String getMANAGER_NAME() {
		return MANAGER_NAME;
	}
	
	public void setMANAGER_NAME(String mANAGER_NAME) {
		MANAGER_NAME = mANAGER_NAME;
	}
	
	public String getMANAGER_PASSWORD() {
		return MANAGER_PASSWORD;
	}
	public void setMANAGER_PASSWORD(String mANAGER_PASSWORD) {
		MANAGER_PASSWORD = mANAGER_PASSWORD;
	}
	
}
