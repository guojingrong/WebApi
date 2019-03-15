package com.jr.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.Null;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import com.jr.domain.DepartmentImp;
import com.jr.domain.DeptPositionImp;
import com.jr.model.DepartmentInfo;
import com.jr.model.Positional;
import com.jr.model.ReturnInfo;

import net.sf.json.JSONObject;

@Path("/depart")
public class Depart {

	private DepartmentImp deptImp = new DepartmentImp();
	private DeptPositionImp dpImp=new DeptPositionImp();

	@GET
	@Path("/{code}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ReturnInfo getDeptByCode(@PathParam("code") String code) {
		try {
			return new ReturnInfo(true, null, deptImp.getDeptByCode(code));
		} catch (Exception e) {
			// TODO: handle exception
			return new ReturnInfo(false, e.getMessage(), null);
		}
	}

	@GET
	@Path("/list")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<DepartmentInfo> getDeptList() {
		return deptImp.getDeptList();
	}

	@POST
	@Path("pagelist")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ReturnInfo getDeptListByCondition(JSONObject obj) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		try {
			map.put("deptCode", obj.getString("deptCode"));
			map.put("status", obj.getInt("status"));
			map.put("skipNum", (obj.getInt("index") - 1) * obj.getInt("size"));
			map.put("pageSize", obj.getInt("size"));
			return new ReturnInfo(true, "", deptImp.getDeptListByPage(map));
		} catch (Exception e) {
			// TODO: handle exception
			return new ReturnInfo(false, e.getMessage(), null);
		}
	}

	@POST
	@Path("insertdept")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ReturnInfo insertDept(DepartmentInfo depart) {
		String idString = "";
		try {
			DepartmentInfo deptInfo = deptImp.getDeptByCode(depart.getDeptCode());
			if (deptInfo == null) {
				idString = deptImp.insertDept(depart);
				return new ReturnInfo(true, null, idString);
			} else {
				return new ReturnInfo(false, "该数据已经存在！", null);
			}
		} catch (Exception e) {
			// TODO: handle exception
			return new ReturnInfo(false, e.getMessage(), null);
		}
	}

	@GET
	@Path("/getby")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ReturnInfo getDeptById(@QueryParam("id") String id) {
		try {
			return new ReturnInfo(true, null, deptImp.getDeptById(id));
		} catch (Exception e) {
			// TODO: handle exception
			return new ReturnInfo(false, e.getMessage(), null);
		}
	}

	@GET
	@Path("/remove/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ReturnInfo delDepart(@PathParam("id") String id) {
		try {
			Integer count = deptImp.modifyStatus(id);
			return new ReturnInfo(true, null, count);
		} catch (Exception e) {
			// TODO: handle exception
			return new ReturnInfo(false, e.getMessage(), null);
		}
	}
	
	@GET
	@Path("deptpos")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ReturnInfo getDeptPosition() {
		try {
			List<Map<String, Object>> list  =dpImp.getDeptPosition();
			return new ReturnInfo(true,null,list);
		} catch (Exception e) {
			// TODO: handle exception
			return new ReturnInfo(false,e.getMessage(),null);
		}
	}
	
	@GET
	@Path("position/{code}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ReturnInfo getPositionByDept(@PathParam("code") String code) {
		try {
			List<Positional> list  =dpImp.getPositionByDept(code);
			return new ReturnInfo(true,null,list);
		} catch (Exception e) {
			// TODO: handle exception
			return new ReturnInfo(false,e.getMessage(),null);
		}
	}
	@GET
	@Path("position")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ReturnInfo getPosition(@QueryParam("key") String key) {
		try {
			HashMap<String, Object> map=new HashMap<String, Object>();
			map.put("key", key);
			List<Positional> list  =dpImp.getPosition(map);
			return new ReturnInfo(true,null,list);
		} catch (Exception e) {
			// TODO: handle exception
			return new ReturnInfo(false,e.getMessage(),null);
		}
	}

	@GET
	@Produces("text/plain;charset=UTF-8")
	public String Show() {
		return "欢迎光临";
	}

	@GET
	@Path("/show")
	@Produces("text/plain;charset=UTF-8")
	public String Show2(@QueryParam("name") String name) {
		return String.format("GoodAfternoon! %s", name);
	}

	
}
