package com.GMapsite.entity;

public class GMAPSITE_MESSAGE {
	private int MESSAGE_ID;
	private int MESSAGE_CODE;
	private String MESSAGE_STATUS;
	private String MESSAGE_TIME;
	private String MESSAGE_DATA;
	
	public GMAPSITE_MESSAGE(int mESSAGE_ID, int mESSAGE_CODE, String mESSAGE_STATUS, String mESSAGE_TIME,
			String mESSAGE_DATA) {
		super();
		MESSAGE_ID = mESSAGE_ID;
		MESSAGE_CODE = mESSAGE_CODE;
		MESSAGE_STATUS = mESSAGE_STATUS;
		MESSAGE_TIME = mESSAGE_TIME;
		MESSAGE_DATA = mESSAGE_DATA;
	}
	
	public GMAPSITE_MESSAGE(int mESSAGE_CODE, String mESSAGE_STATUS, String mESSAGE_TIME, String mESSAGE_DATA) {
		super();
		MESSAGE_ID =-1;
		MESSAGE_CODE = mESSAGE_CODE;
		MESSAGE_STATUS = mESSAGE_STATUS;
		MESSAGE_TIME = mESSAGE_TIME;
		MESSAGE_DATA = mESSAGE_DATA;
	}

	public int getMESSAGE_ID() {
		return MESSAGE_ID;
	}
	public void setMESSAGE_ID(int mESSAGE_ID) {
		MESSAGE_ID = mESSAGE_ID;
	}
	public int getMESSAGE_CODE() {
		return MESSAGE_CODE;
	}
	public void setMESSAGE_CODE(int mESSAGE_CODE) {
		MESSAGE_CODE = mESSAGE_CODE;
	}
	public String getMESSAGE_STATUS() {
		return MESSAGE_STATUS;
	}
	public void setMESSAGE_STATUS(String mESSAGE_STATUS) {
		MESSAGE_STATUS = mESSAGE_STATUS;
	}
	public String getMESSAGE_TIME() {
		return MESSAGE_TIME;
	}
	public void setMESSAGE_TIME(String mESSAGE_TIME) {
		MESSAGE_TIME = mESSAGE_TIME;
	}
	public String getMESSAGE_DATA() {
		return MESSAGE_DATA;
	}
	public void setMESSAGE_DATA(String mESSAGE_DATA) {
		MESSAGE_DATA = mESSAGE_DATA;
	}
	
}
