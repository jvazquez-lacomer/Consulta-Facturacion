package com.lacomer.factura.utils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class FacturaLoginUtilsImpl implements FacturaLoginUtils {
	
	@Value("${jwt.secret}")
	private String secretKey;
	
	
	@Override
	public String getJWTToken(String username) {
	    Map<String, Object> extra = new HashMap<>();
	    extra.put(FacturaConstants.TAG_USUARIO, username);
	    extra.put("authorities", List.of("ROLE_USER")); // Incluye las autoridades necesarias

	    String token = Jwts
	            .builder()
	            .setSubject(username)
	            .addClaims(extra)
	            .setIssuedAt(new Date(System.currentTimeMillis()))
	            .setExpiration(new Date(System.currentTimeMillis() + 6000000)) // Expira en 1 minutos
	            .signWith(SignatureAlgorithm.HS512, secretKey.getBytes())
	            .compact();

	    return FacturaConstants.TAG_LACOMER + token;
	}
	
}
