package com.app.entity;

import java.util.Date;
/**
 * 
 * @author 胡可
 * @see 一条排班的信息
 * 
 * tableid protect.t_dutydetail
 */
public class DutyDetail {
	private String id;
	private String classs;//班次 夜班 白班 XX班
	private String username;//值班人员 用逗号隔开
	private String usercode;//值班人员 用逗号隔开
	Date dutydate;//日期
	private String seq;//所属
	private String isuse;//是否使用
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getClasss() {
		return classs;
	}
	public void setClasss(String classs) {
		this.classs = classs;
	}
	public String getUsercode() {
		return usercode;
	}
	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getDutydate() {
		return dutydate;
	}
	public void setDutydate(Date dutydate) {
		this.dutydate = dutydate;
	}
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getIsuse() {
		return isuse;
	}
	public void setIsuse(String isuse) {
		this.isuse = isuse;
	}
	
	
}
