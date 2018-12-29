package com.liuchao.dubbo.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/person")
public interface PersonInfoService {
	
	@Path("/all")
	@GET
	String queryPersonInfoAll();
	
	@Path("/one/{personNumber}")
	@GET
	String queryPersonInfoByNumber(@PathParam(value = "personNumber") String personNumber);

}
