package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.User;
import com.app.mapper.UserMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class Userservice {
	@Autowired
	private UserMapper userMapper;
	
	public User findByNum(String name) {
		return userMapper.findByNum(name);
		
	}
	
	public PageInfo<User> findAll(int page,int pageSize) {
		PageHelper.startPage(page,pageSize);
		List<User> listUser=userMapper.findAll(page, pageSize);
		PageInfo<User> list=new PageInfo<User>(listUser);
		return list;		
	}
}
