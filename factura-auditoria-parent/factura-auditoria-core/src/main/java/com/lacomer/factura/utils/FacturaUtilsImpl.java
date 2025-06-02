package com.lacomer.factura.utils;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class FacturaUtilsImpl implements FacturaUtils {

	public ResponseEntity<Object> createSuccessResponse(Object data) {
        Map<String, Object> response = new HashMap<>();
        response.put("estatus", HttpStatus.OK.value());
        response.put("mensaje",  "Operación exitosa");
        response.put("datos", data);
        return ResponseEntity.ok(response);
    }
	
	
	 public  String generarContrasenaTemporal() {
	        
	        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	        int longitud = 10;

		 	SecureRandom random = new SecureRandom();
	        StringBuilder contrasena = new StringBuilder();

	        for (int i = 0; i < longitud; i++) {
	            int index = random.nextInt(caracteres.length());
	            contrasena.append(caracteres.charAt(index));
	        }

	        return contrasena.toString();
	 }
	
}
