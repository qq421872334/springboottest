package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.entity.TRemoteinfomanage;
import com.app.entity.User;
import com.app.service.ProtectService;
import com.app.service.Userservice;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class ProtectController {
	@Autowired
	private Userservice userService;
	
	@Autowired
	private ProtectService protectService;
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/testt")
	@ResponseBody
	public User index2(String name) {
		return userService.findByNum(name);
	}
	
	/*@RequestMapping("/pagetest")
	@ResponseBody
	public PageInfo<User> index3(int page,int pagesize) {
		return userService.findAll(page,pagesize);
	}*/

	@RequestMapping("/user")
	@ResponseBody
	public String index4(@Valid User a,BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			System.out.println(bindingResult.getFieldError().getDefaultMessage());
			return bindingResult.getFieldError().getField();
		}
		return a.toString();
	}
	
	@RequestMapping("/mgbtest")
	@ResponseBody
	public TRemoteinfomanage index5(@RequestParam("id") String infoId) {
		return protectService.findOne(infoId);
	}
	
	@RequestMapping("/pagetest")
	@ResponseBody
	public PageInfo<TRemoteinfomanage> index6(@RequestParam("page") int pageNum,@RequestParam("pagesize")int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<TRemoteinfomanage> a=protectService.findAll();
		PageInfo<TRemoteinfomanage> res=new PageInfo<TRemoteinfomanage>(a);
		return res;
	}
}
