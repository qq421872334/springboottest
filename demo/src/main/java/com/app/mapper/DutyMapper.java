package com.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.app.entity.Classs;
import com.app.entity.DutyDetail;
import com.app.entity.User;

public interface DutyMapper {
	@Select("select * from protect.t_remotesync")
	List<User> findAll(int page,int pageSize);
	
	
	@Select("select * from protect.t_dutydetail where isuse='1'")
	List<DutyDetail> getAllworkShifts(/*@Param("seq") String seq*/);

	@Select("select * from protect.t_dutyclasss ")
	List<Classs> getAllclasss();


	@Select("select * from (select count(classs) from protect.t_dutydetail group by classs) where rownum=1" )
	int getLength();
	
	@Select("SELECT to_char(MAX(DUTYDATE),'yyyy-MM-dd') FROM PROTECT.T_DUTYDETAIL WHERE isuse ='1'")
	String getMaxDate();
	
	@Select("SELECT to_char(MIN(DUTYDATE),'yyyy-MM-dd') FROM PROTECT.T_DUTYDETAIL WHERE isuse ='1'")
	String getMinDate();
}
