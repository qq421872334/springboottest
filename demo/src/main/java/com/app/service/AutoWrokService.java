package com.app.service;

import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Classs;
import com.app.entity.DutyDetail;
import com.app.mapper.DutyMapper;
import com.app.mapper.UserMapper;

@Service
public class AutoWrokService {
	//TODO:传入的日期不能小于 初始排班的日期
	
	@Autowired
	private DutyMapper dutyMapper;
	
	int x;//设周期为6
	int endyear;//结束排班年
	int endmonth;//结束排班月
	int endday;//结束排班日
	//负载均衡下的班次
	private  List<Classs> classs;
	
	//负载均衡下的排班
	private Map<String,List<DutyDetail>> workShifts;
	//初始化
	
	@PostConstruct
	private void init(){
		x=dutyMapper.getLength();
		if(x!=0) {
			String ymd=dutyMapper.getMaxDate();
			endyear=Integer.parseInt(ymd.split("-")[0]);
			endmonth=Integer.parseInt(ymd.split("-")[1]);
			endday=Integer.parseInt(ymd.split("-")[2]);
			classs=dutyMapper.getAllclasss();
			List<DutyDetail> temp=dutyMapper.getAllworkShifts();
			workShifts=new HashMap<String,List<DutyDetail>>();
			for(Classs tempc: classs) {
				workShifts.put(tempc.getClasss(), temp.stream().filter(e->e.getClasss().equals(tempc.getClasss())).collect(Collectors.toList()));
			}
		}
	}
	
	public static void main(String[] args) {
		AutoWrokService a=new AutoWrokService();
		if(a.x==0) return;
		
		for(Classs temp: a.classs) {
			System.out.println(a.getThisMonthData(2019,3,temp.getClasss()));
		}
		
	}
	
	public String a() {
		return dutyMapper.getMinDate();
	}
	
	@SuppressWarnings("unused")
	public  int maxDay(int year,int month){
			Calendar calendar=Calendar.getInstance(TimeZone.getTimeZone("GMT-8:00"));
			calendar.clear();
			calendar.set(Calendar.YEAR,year);
			calendar.set(Calendar.MONTH,month-1);//默认1月为0月  
			int day=calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
			System.out.println(year+"年"+month+"月"+"的最大天数是："+day);
			calendar=null;
			return day;
		}
	
	/**
	 * 递归法获得某月的起始排班日期
	 * @param year
	 * @param month
	 * @return
	 */
	@SuppressWarnings("unused")
	private  int getStartday(int year,int month) {
		int startday=0;
		
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT-8:00"));
		calendar.set(Calendar.YEAR,year);
		calendar.set(Calendar.MONTH,month);//默认1月为0月  
		
		//上三行或许可以设置为全局
		
		calendar.add(Calendar.MONTH, -1);
		System.out.println("上月的时间是："+calendar.get(Calendar.YEAR)+"::"+calendar.get(Calendar.MONTH));
		startday=x-getPreLast(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH));
		
		return startday;//(startday取值范围是1~x,所以下个月开始时间是2~x+1)
	}
	
	private  int getPreLast(int year,int premonth) {
		int maxday=maxDay(year,premonth);
		
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT-8:00"));
		calendar.set(Calendar.YEAR,year);
		calendar.set(Calendar.MONTH,premonth-1);//默认1月为0月  
		
		//递归结束口 
		//TODO:假设传入参数为2019年1月2日 结束排班     
		if(year==endyear&&premonth==endmonth) {
			int lastday=maxDay(endyear,endmonth)-endday;
			return lastday%x;
		}
		
		int startday=x-getPreLast(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH));
		
		return (maxday-startday)%x;
	}
	
	public  List<DutyDetail> getThisMonthData(int year,int month,String classs) {
		int endday=getStartday(year,month)+1;//在轮班长度X=10以内不会出错
		int starday;
		if(endday==x) {
			starday=1;
		}else {
			starday=endday+1;
		}
		//从轮班中查出 当前月初到endday 的数据
		List<DutyDetail> res=new LinkedList<>();
		List<DutyDetail> data=workShifts.get(classs);
		List<DutyDetail> data2=workShifts.get(classs).subList(starday-1, data.size());
		res.addAll(data2);
		//从轮班中 starday 开始查出 轮次TIME的数据
		int time=(maxDay(year,month)-endday)/x;//轮次
		while(time>0) {
			res.addAll(data);
			time--;
		}
		int isok=(maxDay(year,month)-endday)%x;
		if(isok!=0) {
			//再加上 轮班中 isok 余数的 数据
			res.addAll(workShifts.get(classs).subList(0, isok));
		}else {
			return res;
		}
		
		return res;
	}
}
