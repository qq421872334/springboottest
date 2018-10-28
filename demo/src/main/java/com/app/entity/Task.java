package com.app.entity;

import java.util.Date;

import javax.validation.constraints.NotNull;


public class Task {
	
	@NotNull
	public int ID;
    /// <summary>
    /// 任务名称
    /// </summary>
    public String Name;
    /// <summary>
    /// 内容
    /// </summary>
    public String Content;
    /// <summary>
    /// 开始时间
    /// </summary>
    public Date StartDate;
    /// <summary>
    /// 结束时间
    /// </summary>
    public Date EndDate;
     
    public Task(int id,String name,String Content,Date StartDate,Date EndDate) {
    	this.ID=id;
    	this.Name=name;
    	this.Content=Content;
    	this.StartDate=StartDate;
    	this.EndDate=EndDate;
    }
    
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public Date getStartDate() {
		return StartDate;
	}
	public void setStartDate(Date startDate) {
		StartDate = startDate;
	}
	public Date getEndDate() {
		return EndDate;
	}
	public void setEndDate(Date endDate) {
		EndDate = endDate;
	}
     
     
}
