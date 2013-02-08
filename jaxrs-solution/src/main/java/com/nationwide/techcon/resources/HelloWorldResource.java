package com.nationwide.techcon.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/hello")
public class HelloWorldResource {
	
	@GET
	public String getMsg() {
		return "Hello World!";
	}

}
