package com.lacomer.factura.security;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.lacomer.factura.utils.FacturaConstants;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;

public class AuthorizationFilter extends OncePerRequestFilter {
      
    private final String SECRET_KEY = "igY9YK0WBFWxhkKViLLqaDW7pCAVRUmr";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        try {
            String token = getTokenFromCookies(request);
            if (token != null) {
                Claims claims = validateToken(token);
                if (claims.get("authorities") != null) {
                    setUpSpringAuthentication(claims);
                } else {
                    SecurityContextHolder.clearContext();
                }
            } else {
                SecurityContextHolder.clearContext();
            }
            chain.doFilter(request, response);
        } catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException e) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.sendError(HttpServletResponse.SC_FORBIDDEN, e.getMessage());
            Cookie cookie = new Cookie("authToken", null);
            cookie.setHttpOnly(true); // No accesible desde JavaScript
            cookie.setSecure(true); // Solo se envía en conexiones HTTPS
            cookie.setPath("/"); // Disponible para toda la aplicación
            cookie.setMaxAge(0); // Expira en 1 MINUTO
            response.addCookie(cookie);
        }
    }

    private String getTokenFromCookies(HttpServletRequest request) {
        if (request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {
                if ("authToken".equals(cookie.getName())) { // Asegúrate de que el nombre coincida con el de la cookie
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

    private Claims validateToken(String token) {
        try {
            // Elimina el prefijo "LaComer-" antes de validar el token
            String jwtToken = token.replace(FacturaConstants.TAG_LACOMER, "");

            // Valida el token JWT
            return Jwts.parser()
                       .setSigningKey(SECRET_KEY.getBytes()) // Usa la clave secreta para validar
                       .parseClaimsJws(jwtToken) // Decodifica y valida el token
                       .getBody(); // Devuelve las Claims (información del token)
        } catch (Exception e) {
            throw e; // Lanza la excepción para que se registre en los logs
        }
    }

    private void setUpSpringAuthentication(Claims claims) {
        @SuppressWarnings("unchecked")
        List<String> authorities = (List<String>) claims.get("authorities");

        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(claims.getSubject(), null,
                authorities.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
        SecurityContextHolder.getContext().setAuthentication(auth);
    }
}