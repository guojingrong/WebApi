package com.jr.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.jr.model.Positional;

/**
 * 部门岗位关系
 * @author Administrator
 *
 */
public interface DeptPositionMapper {
	public List<Map<String, Object>> getDeptPosition();
	public List<Positional> getPositionByDept(String code);
	public List<Positional> getPosition(HashMap<String, Object> map);
	public int addPosDeptRef();
}
