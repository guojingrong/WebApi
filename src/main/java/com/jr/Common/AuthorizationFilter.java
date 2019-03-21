package com.jr.Common;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;

import com.jr.domain.EmployeeImp;
import com.jr.model.EmpBaseInfo;
import com.mysql.cj.util.StringUtils;

import io.jsonwebtoken.Claims;

@Provider
public class AuthorizationFilter implements ContainerRequestFilter  {

	@Context
	private ResourceInfo resourceInfo;
	
	private EmployeeImp empImp=new EmployeeImp();
	
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		// TODO Auto-generated method stub
		List<Annotation> annotations=new ArrayList<Annotation>();
		Annotation classAuthzSpec =
	            resourceInfo.getResourceClass().getAnnotation(AuthUser.class);
		Annotation methodAuthzSpec =
	            resourceInfo.getResourceMethod().getAnnotation(AuthUser.class);
		
		if(classAuthzSpec!=null) annotations.add(classAuthzSpec);
		if(methodAuthzSpec!=null) annotations.add(methodAuthzSpec);
		
		if(!annotations.isEmpty()) {
			//获取客户端Header中提交的token
			String token=requestContext.getHeaderString("Authorization");
			if(StringUtils.isNullOrEmpty(token)) {
				// TODO :拦截请求 无权限 401
				requestContext.abortWith(Response.status(Status.UNAUTHORIZED)
						.build());
			}
			else {
				//TODO 判断用户是否登录
				Claims claims=JwtUtil.parseToken(token.split(" ")[1]);
				EmpBaseInfo empBaseInfo = empImp.getEmpById(claims.get("sub").toString());
				if(empBaseInfo==null) {
					requestContext.abortWith(Response.status(Status.UNAUTHORIZED)
							.build());
				}
			}
		}
	}

}
