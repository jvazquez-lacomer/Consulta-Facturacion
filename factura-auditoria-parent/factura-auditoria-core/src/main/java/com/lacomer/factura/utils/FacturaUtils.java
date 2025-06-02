package com.lacomer.factura.utils;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public interface FacturaUtils {

	public ResponseEntity<Object> createSuccessResponse(Object data);
	
	public String generarContrasenaTemporal(); 
	       
	
}
