package com.app.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.app.entity.User;

public interface UserMapper {
	@Select("select * from protect.t_remotesync where num = #{name}")
	User findByNum(@Param("name") String name);
	
	@Select("select * from protect.t_remotesync")
	List<User> findAll(int page,int pageSize);

}
