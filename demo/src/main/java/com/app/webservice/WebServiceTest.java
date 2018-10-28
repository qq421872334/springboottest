package com.app.webservice;

import javax.jws.WebParam;
import javax.jws.WebService;
import com.app.entity.User;

@WebService
public interface WebServiceTest {
    String sayHi(@WebParam(name="text") String text);
	String sayhi(@WebParam(name="user") User user);
	/*@XmlJavaTypeAdapter(IntegerUserMapAdapter.class)
	Map<Integer, User> getUsers();*/
	
}
