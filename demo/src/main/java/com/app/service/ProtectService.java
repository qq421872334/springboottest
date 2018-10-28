package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.TRemoteinfomanage;
import com.app.mapper.TRemoteinfomanageMapper;

@Service
public class ProtectService {

	@Autowired
	TRemoteinfomanageMapper remoteMapper;
	
	public TRemoteinfomanage findOne(String infoId){
		return remoteMapper.selectByPrimaryKey(infoId);
	}
	
	public List<TRemoteinfomanage> findAll(){
		return remoteMapper.findAll();
	}
}
