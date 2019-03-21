package com.jr.test;


import java.util.Date;

import org.junit.Test;

import com.jr.Common.JwtUtil;
import com.jr.model.TokenOf;

import io.jsonwebtoken.Claims;

public class TokenTest {
	@Test
	public void test1() {
		TokenOf of=new TokenOf();
		of.setUsername("ycguo");
		of.setUserId("5b952c71447211e98c94e86a645dd955");
		of.setPassword("1q2w3e4r");
		of.setRole("1009");
		String tokenString  = JwtUtil.signToken(of);
		System.out.println(tokenString);
	}
	
	@Test
	public void test2() {
		String  token="eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1Yjk1MmM3MTQ0NzIxMWU5OGM5NGU4NmE2NDVkZDk1NSIsInBhc3N3b3JkIjoiMXEydzNlNHIiLCJyb2xlIjoiMTAwOSIsImlzcyI6InljZ3VvIiwiZXhwIjoxNTU0NTU5MzAwLCJpYXQiOjE1NTMwODgwNzIsImp0aSI6ImUyMmFkNzdlLTE4YmQtNDVmNC1hNjlkLTQwMjc1NzM5MmUyMiIsInVzZXJuYW1lIjoieWNndW8ifQ.N25NyFYw02AAskjeL_PwInkgeWhPY1E3MkXv1TGIabM";
		Claims claims =JwtUtil.parseToken(token);
		System.out.println(claims.get("username")+"****"+claims.getExpiration());
	}
	@Test
	public void test3() {
		
	}
}
