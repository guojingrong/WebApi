package com.jr.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.jr.Common.AuthUser;
import com.jr.domain.ChartImp;
import com.jr.model.ReturnInfo;

@Path("/chart")
@AuthUser
public class Chart {
	private ChartImp chartImp=new ChartImp();
	
	@GET
	@Path("/age")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ReturnInfo getSumChartForAge() {
		try {
			Object object = chartImp.sumChartForAge();
			return new ReturnInfo(true,null,object);
		} catch (Exception e) {
			// TODO: handle exception
			return new ReturnInfo(false,e.getMessage(),null);
		}
	}
}
