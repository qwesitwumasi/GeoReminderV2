package com.g6.georeminderv2;



public class Places {
	
	int pid;
	String pname;
	long plat;
	long plong;
	
	
	public Places() {

	}
	public Places(String pname) {
		this.pname = pname;
		
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public long getPlat() {
		return plat;
	}
	public void setPlat(long plat) {
		this.plat = plat;
	}
	public long getPlong() {
		return plong;
	}
	public void setPlong(long plong) {
		this.plong = plong;
	}
	
	

}
