package com.app.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.DutyDetail;
import com.app.entity.Task;
import com.app.service.AutoWrokService;
import com.app.service.Userservice;

import sun.util.resources.cldr.CalendarData;

@RestController
public class AutoWrokController {
	@Autowired
	private AutoWrokService autoWrokService;
	
	@RequestMapping("/DateHandle/ViewData")
	public List<Map<String, Object>> viewDate(){
			
		List<Task> tasks = new LinkedList<Task>();
		Calendar cal=Calendar.getInstance();
		cal.set(2018, 9, 20, 2, 4);
		Task temp=new Task(1,"任务1","修复远动模块bug",new Date(),cal.getTime());
		tasks.add(temp);
		temp=new Task(2,"任务2","测试bug",cal.getTime(),cal.getTime());
		cal.clear();
		cal.set(2018, 9, 19, 2, 4);
		temp.setEndDate(cal.getTime());
		tasks.add(temp);
		
		/*temp=new Task(3,"任务3","修复远动模块bug",new Date(2018, 10, 19, 2, 4),new Date(2018, 10, 20, 2, 4));
		tasks.add(temp);*/
		
		List<Map<String,Object>> data=new LinkedList<Map<String, Object>>();
		//List<Object> data=new LinkedList<Object>();
		//data=tasks.stream().map(this::toMap).collect(Collectors.toList());
		for(Task temps:tasks) {
			data.add(this.toMap(temps));
		}
		System.out.println(data);
		return data;
		
	}
	
	private Map<String,Object> toMap(Task task){
		Map<String,Object> temp2= new HashMap<String,Object>();
		 temp2.put("id", task.getID());
		 temp2.put("title", task.getName());
		 temp2.put("start", task.getStartDate());
		 temp2.put("end", task.getEndDate());
        //鼠标悬浮上展现的是这个属性信息，可以自己设置
		 temp2.put("fullname", task.getName());
		 temp2.put("allDay", false); 
		return temp2;
	}
	
	@RequestMapping("/paibantest")
	public List<Map<String, Object>> getdata() {
		 List<DutyDetail> temp=autoWrokService.getThisMonthData(2018, 12, "日班");
		 int i=1;
		 List<Map<String,Object>>tempp= temp.stream().map(e->{
			 Map<String,Object> temp2= new HashMap<String,Object>();
			 temp2.put("id", e.getId());
			 temp2.put("title", e.getUsername());
			 //temp2.put("start", e.getStartDate());
			// temp2.put("end", e.getEndDate());
	        //鼠标悬浮上展现的是这个属性信息，可以自己设置
			 temp2.put("fullname", e.getUsername());
			 temp2.put("allDay", false); 
			return temp2;
		 }).collect(Collectors.toList());
		 temp=null;
		 Calendar calendar=Calendar.getInstance(TimeZone.getTimeZone("GMT-8:00"));
		 int j=1;
		 for(Map<String,Object> o : tempp) {
			 calendar.clear();
			 calendar.set(Calendar.YEAR,2018);//2018为也年传过的参数
			 calendar.set(Calendar.MONTH,11);
			 calendar.set(Calendar.DAY_OF_MONTH,j);
			 o.put("start", calendar.getTime());
			 o.put("end", calendar.getTime());
			 j++;
		 }
		 return tempp;
	}
	
	@RequestMapping("/iszhuru")
	public String getdata2() {
		 String temp=autoWrokService.a();
		 return temp;
	}
}
