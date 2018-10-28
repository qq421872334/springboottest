package com.app.webservice;

import javax.jws.WebService;

import com.app.entity.User;

@WebService(endpointInterface="com.app.webservice.WebServiceTest",serviceName="HelloWorld")
public class WebServiceImp implements WebServiceTest{

	/*@Override*/
	public String sayHi(String text) {
		// TODO Auto-generated method stub
		return "hello"+text;
	}

	/*@Override*/
	public String sayhi(User user) {
		return "hello"+user.getNum();
	}

}
