package com.rest.example;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

@Path("/rest")
//http://localhost:8086/rest-server/rest/rest
public class RestExample extends Application {
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("/text1")
	public String getText() {
        return "Hello World";
    }
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("/text2")
	public String getText2() {
        return "Hello World2";
    }
}
