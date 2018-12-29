package com.liuchao.dubbo.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/person")
@Produces(MediaType.APPLICATION_JSON)
public interface PersonInfoService {
	
	@Path("/all")
	@GET
	String queryPersonInfoAll();
	
	@Path("/one/{personNumber}")
	@GET
	String queryPersonInfoByNumber(@PathParam(value = "personNumber") String personNumber);

}
