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
 * Jwt ������
 * 
 * @author Administrator
 *
 */
public class JwtUtil {
	private static final long EXPIRE_TIME = 365 * 24 * 60 * 60 * 1000;
	// �����ʮ��ǰ���Լ�˵�����ٰ�ҹ��
	private static final String SECRET_KEY = "SSB3YW50IHRvIHNheSB0byBteXNlbGYgdGVuIHllYXJzIGFnbzogRG9uJ3Qgc3RheSB1cCBsYXRlIGFnYWluIQ";// ˽Կ

	/**
	 * ����ǩ��
	 * 
	 * @param of
	 * @return
	 */
	public static String signToken(TokenOf of) {
		// Token ����ʱ��
		Date expDate = new Date(System.currentTimeMillis() + EXPIRE_TIME);
		try {
			// ָ��ǩ����ʱ��ʹ�õ�ǩ���㷨��Ҳ����header�ǲ��֣�jjwt�Ѿ����ⲿ�����ݷ�װ����
			SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
			// ����payload��˽�������������ض���ҵ����Ҫ��ӣ����Ҫ���������֤��һ������Ҫ��jwt�Ľ��շ���ǰ��ͨ����֤��ʽ�ģ�
			Map<String, Object> claims = new HashMap<String, Object>();
			claims.put("username", of.getUsername());
			claims.put("password", of.getPassword());
			claims.put("role", of.getRole());

			return Jwts.builder()
					// �����˽��������һ��Ҫ����������Լ�������˽�е�����������Ǹ�builder��claim��ֵ��һ��д�ڱ�׼��������ֵ֮�󣬾��Ǹ�������Щ��׼��������
					.setClaims(claims).setId(UUID.randomUUID().toString())
					// ���÷���ʱ��
					.setIssuedAt(new Date())
					// ���÷�����
					.setIssuer(of.getUsername())
					// ��������
					.setSubject(of.getUserId())
					// ���ù���ʱ��
					.setExpiration(expDate)
					// ����ǩ��ʹ�õ�ǩ���㷨��ǩ��ʹ�õ���Կ
					.signWith(signatureAlgorithm, SECRET_KEY).compact();

		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	/**
	 * Token ����
	 * 
	 * @param token
	 * @param of
	 * @return
	 */
	public static Claims parseToken(String token) {
		return Jwts.parser()
				// ����ǩ������Կ
				.setSigningKey(SECRET_KEY)
				// ������Ҫ������jwt
				.parseClaimsJws(token).getBody();
	}

	/**
	 * У��token
	 */

}
