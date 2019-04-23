package com.jr.api;

import java.util.HashMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.jr.common.AuthUser;
import com.jr.domain.EmployeeImp;
import com.jr.model.EmpBaseInfo;
import com.jr.model.ReturnInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONObject;

@Path("/emp")
@AuthUser
@Api(value="员工数据处理接口")
public class Employee {
	
	private EmployeeImp employeeImp=new EmployeeImp();
	
	@POST
	@Path("/pagelist")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value="返回员工列表",response=Object.class)
	public ReturnInfo getEmpListByPage(JSONObject obj) {
		try {
			HashMap<String, Object> map=new HashMap<String, Object>();
//			map.put("code", obj.getString("code"));
			map.put("key", obj.getString("key"));
			map.put("status", obj.getInt("status"));
			map.put("skipNum", (obj.getInt("index") - 1) * obj.getInt("size"));
			map.put("pageSize", obj.getInt("size"));
			return new ReturnInfo(true,null,employeeImp.getEmpListByPage(map));
		} catch (Exception e) {
			// TODO: handle exception
			return new ReturnInfo(false,e.getMessage(),null);
		}
	}
	
	@POST
	@Path("/insert")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value="添加员工",response=ReturnInfo.class)
	public ReturnInfo insertEmployeeInfo(EmpBaseInfo emp) {
		try {
			boolean v=employeeImp.judgeIsExists(emp.getAccount());
			if(v) return new ReturnInfo(false,"该账号已经存在！请重新输入",null);
			String empIdString  = employeeImp.insertEmployee(emp);
			return new ReturnInfo(true,null,empIdString);
		} catch (Exception e) {
			// TODO: handle exception
			return new ReturnInfo(false,e.getMessage(),null);
		}
	}
	
	@POST
	@Path("/modify")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value="修改员工",response=ReturnInfo.class)
	public ReturnInfo modifyEmployeeInfo(EmpBaseInfo emp) {
		try {
			int count=employeeImp.modifyEmployee(emp);
			return new ReturnInfo(true,null,count);
		} catch (Exception e) {
			// TODO: handle exception
			return new ReturnInfo(false,e.getMessage(),null);
		}
	}
	
	@GET
	@Path("/code")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value="获取员工编号",response=ReturnInfo.class)
	public ReturnInfo getEmpCode() {
		try {
			String code=employeeImp.getEmpCode();
			return new ReturnInfo(true,null,code);
		} catch (Exception e) {
			// TODO: handle exception
			return new ReturnInfo(false,e.getMessage(),null);
		}
	}
	
	@GET
	@Path("/getby/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value="根据员工ID返回员工信息",response=ReturnInfo.class)
	public ReturnInfo getEmpById(@PathParam("id") String id) {
		try {
			EmpBaseInfo empBaseInfo=employeeImp.getEmpById(id);
			return new ReturnInfo(true,null,empBaseInfo);
		} catch (Exception e) {
			// TODO: handle exception
			return new ReturnInfo(false,e.getMessage(),null);
		}
	}
}
