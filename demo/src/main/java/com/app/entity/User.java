package com.app.entity;

import javax.validation.constraints.NotNull;

public class User {
	@NotNull
	private String stationid;
	private String num;
	public String getStationid() {
		return stationid;
	}
	public void setStationid(String stationid) {
		this.stationid = stationid;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	
	private User() {
		
	}
}
