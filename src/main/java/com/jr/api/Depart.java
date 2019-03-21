package com.jr.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.jr.Common.AuthUser;
import com.jr.domain.DepartmentImp;
import com.jr.domain.DeptPositionImp;
import com.jr.model.DepartmentInfo;
import com.jr.model.Positional;
import com.jr.model.ReturnInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONObject;

@Path("/depart")
@AuthUser
@Api(value="�������ݴ���ӿ�")
public class Depart {

	private DepartmentImp deptImp = new DepartmentImp();
	private DeptPositionImp dpImp=new DeptPositionImp();

	@GET
	@Path("/{code}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value="���ݲ���code���ز�����Ϣ",response=ReturnInfo.class)
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
	@ApiOperation(value="�������в���",response=DepartmentInfo.class)
	public List<DepartmentInfo> getDeptList() {
		return deptImp.getDeptList();
	}

	@POST
	@Path("/pagelist")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value="������ѯ������Ϣ",response=ReturnInfo.class)
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
	@Path("/insertdept")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value="��Ӳ���",response=ReturnInfo.class)
	public ReturnInfo insertDept(DepartmentInfo depart) {
		String idString = "";
		try {
			DepartmentInfo deptInfo = deptImp.getDeptByCode(depart.getDeptCode());
			if (deptInfo == null) {
				idString = deptImp.insertDept(depart);
				return new ReturnInfo(true, null, idString);
			} else {
				return new ReturnInfo(false, "�������Ѿ����ڣ�", null);
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
	@ApiOperation(value="���ݲ���ID���ز�����Ϣ",response=ReturnInfo.class)
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
	@ApiOperation(value="����IDɾ������",response=ReturnInfo.class)
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
	@Path("/deptpos")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value="���ز��Ÿ�λ�б�",response=ReturnInfo.class)
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
	@Path("/position/{code}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value="���ݲ���code���ض�Ӧ�ĸ�λ",response=ReturnInfo.class)
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
	@Path("/position")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value="���ظ�λ��Ϣ",response=ReturnInfo.class)
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

//	@GET
//	@Produces("text/plain;charset=UTF-8")
//	public String Show() {
//		return "��ӭ����";
//	}
//
//	@GET
//	@Path("/show")
//	@Produces("text/plain;charset=UTF-8")
//	public String Show2(@QueryParam("name") String name) {
//		return String.format("GoodAfternoon! %s", name);
//	}

	
}
