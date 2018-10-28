package com.app.webservice;

import javax.xml.ws.Endpoint;

public class Test {
	protected  Test() throws Exception {
        // START SNIPPET: publish
        System.out.println("Starting Server");
        WebServiceImp implementor = new WebServiceImp();
        String address = "http://localhost:9001/HelloWorld";
        Endpoint.publish(address, implementor);
        // END SNIPPET: publish
    }
 
    public static void main(String args[]) throws Exception {
        new Test();
        System.out.println("Server ready...");
 
        Thread.sleep(5 * 60 * 1000);
        System.out.println("Server exiting");
        System.exit(0);

    }
}