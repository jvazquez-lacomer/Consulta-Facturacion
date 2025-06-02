package com.lacomer.factura.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lacomer.factura.service.FacturaProveedorService;
import com.lacomer.factura.utils.FacturaUtils;

@RestController
@RequestMapping("/lacomer")
public class FacturaProveedorController {
	
	@Autowired
	private FacturaProveedorService service;
	
	@Autowired
	private FacturaUtils utils;

    @GetMapping("/proveedores")
    public ResponseEntity<Object> buscarPoveedor(
        @RequestParam(required = false) Long idProveedor,
        @RequestParam(required = false) String proDescripcion
    ) 
    {
    	return utils.createSuccessResponse(service.buscarProveedor(idProveedor, proDescripcion));
    }
}
