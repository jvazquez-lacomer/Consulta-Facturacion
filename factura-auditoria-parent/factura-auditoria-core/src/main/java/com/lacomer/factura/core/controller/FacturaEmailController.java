package com.lacomer.factura.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lacomer.factura.service.FacturaEmailService;
import com.lacomer.factura.utils.FacturaUtils;

@RestController
@RequestMapping("/lacomer")
public class FacturaEmailController {
	
	@Autowired
	private FacturaEmailService service;
	
	@Autowired
    private FacturaUtils utils;
	
    @GetMapping("/email")
    public ResponseEntity<Object> reenviaEmail(@RequestParam(required = false) String usuario,
            @RequestParam(required = false) String correo) {
    	
    	String mensaje = service.reenviaEmail(usuario, correo);
    
    	return utils.createSuccessResponse(mensaje);
    }
}
