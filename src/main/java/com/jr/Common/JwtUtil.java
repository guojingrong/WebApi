package com.jr.Common;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.jr.model.TokenOf;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import net.sf.json.JSON;
import net.sf.json.JSONObject;

/**
 * Jwt 工具类
 * 
 * @author Administrator
 *
 */
public class JwtUtil {
	private static final long EXPIRE_TIME = 365 * 24 * 60 * 60 * 1000;
	// 我想对十年前的自己说：别再熬夜！
	private static final String SECRET_KEY = "SSB3YW50IHRvIHNheSB0byBteXNlbGYgdGVuIHllYXJzIGFnbzogRG9uJ3Qgc3RheSB1cCBsYXRlIGFnYWluIQ";// 私钥

	/**
	 * 生成签名
	 * 
	 * @param of
	 * @return
	 */
	public static String signToken(TokenOf of) {
		// Token 过期时间
		Date expDate = new Date(System.currentTimeMillis() + EXPIRE_TIME);
		try {
			// 指定签名的时候使用的签名算法，也就是header那部分，jjwt已经将这部分内容封装好了
			SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
			// 创建payload的私有声明（根据特定的业务需要添加，如果要拿这个做验证，一般是需要和jwt的接收方提前沟通好验证方式的）
			Map<String, Object> claims = new HashMap<String, Object>();
			claims.put("username", of.getUsername());
			claims.put("password", of.getPassword());
			claims.put("role", of.getRole());

			return Jwts.builder()
					// 如果有私有声明，一定要先设置这个自己创建的私有的声明，这个是给builder的claim赋值，一旦写在标准的声明赋值之后，就是覆盖了那些标准的声明的
					.setClaims(claims).setId(UUID.randomUUID().toString())
					// 设置发行时间
					.setIssuedAt(new Date())
					// 设置发行人
					.setIssuer(of.getUsername())
					// 设置主题
					.setSubject(of.getUserId())
					// 设置过期时间
					.setExpiration(expDate)
					// 设置签名使用的签名算法和签名使用的秘钥
					.signWith(signatureAlgorithm, SECRET_KEY).compact();

		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	/**
	 * Token 解密
	 * 
	 * @param token
	 * @param of
	 * @return
	 */
	public static Claims parseToken(String token) {
		return Jwts.parser()
				// 设置签名的秘钥
				.setSigningKey(SECRET_KEY)
				// 设置需要解析的jwt
				.parseClaimsJws(token).getBody();
	}

	/**
	 * 校验token
	 */

}
