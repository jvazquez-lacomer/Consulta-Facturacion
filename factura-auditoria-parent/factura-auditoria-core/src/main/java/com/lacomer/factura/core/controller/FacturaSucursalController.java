package com.lacomer.factura.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lacomer.factura.service.FacturaSucursalService;
import com.lacomer.factura.utils.FacturaUtils;

@RestController
@RequestMapping("/lacomer")
public class FacturaSucursalController {
	
	@Autowired
	private FacturaSucursalService service;
	
	@Autowired
	private FacturaUtils utils;

    @GetMapping("/sucursales")
    public ResponseEntity<Object> buscarSucursales() 
    {
    	return utils.createSuccessResponse(service.obtenerSucursales());
    }
}
