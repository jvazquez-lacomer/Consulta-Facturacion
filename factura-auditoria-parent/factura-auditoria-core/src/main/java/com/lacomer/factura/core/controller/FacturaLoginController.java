package com.lacomer.factura.core.controller;

import javax.validation.Valid;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lacomer.factura.dto.LoginRequestDTO;
import com.lacomer.factura.dto.LoginResponseDTO;
import com.lacomer.factura.service.FacturaLoginService;
import com.lacomer.factura.utils.FacturaUtils;

@RestController
@RequestMapping("/lacomer")
public class FacturaLoginController {

    @Autowired
    private FacturaUtils utils;

    @Autowired
    private FacturaLoginService service;

    @PostMapping("/login")
    public ResponseEntity<Object> login(@Valid @RequestBody LoginRequestDTO user, HttpServletResponse response) {
        LoginResponseDTO usuarioRespuesta = service.consultaUsuario(user);

        // Genera la cookie HTTP-only con el token
        Cookie cookie = new Cookie("authToken", usuarioRespuesta.getToken());
        cookie.setHttpOnly(true); // No accesible desde JavaScript
        cookie.setSecure(true); // Solo se envía en conexiones HTTPS
        cookie.setPath("/"); // Disponible para toda la aplicación
        cookie.setMaxAge(6000); // Expira en 1 MINUTO
        response.addCookie(cookie);

        // Elimina el token del cuerpo de la respuesta para mayor seguridad
        usuarioRespuesta.setToken(null);

        return utils.createSuccessResponse(usuarioRespuesta);
    }
    
    @GetMapping("/protected-endpoint")
    public ResponseEntity<Map<String, String>> getProtectedEndpoint() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Acceso permitido al endpoint protegido");
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/logout")
    public ResponseEntity<Object> cerrarSesion(HttpServletResponse response) {
    	Cookie cookie = new Cookie("authToken", null);
        cookie.setHttpOnly(true); // No accesible desde JavaScript
        cookie.setSecure(true); // Solo se envía en conexiones HTTPS
        cookie.setPath("/"); // Disponible para toda la aplicación
        cookie.setMaxAge(0); 
        response.addCookie(cookie);
        return utils.createSuccessResponse("La sesión fue finalizada");
    }
    
}