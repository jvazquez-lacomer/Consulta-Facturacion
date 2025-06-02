package com.lacomer.factura.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lacomer.factura.service.FacturaArticuloService;
import com.lacomer.factura.utils.FacturaUtils;

@RestController
@RequestMapping("/lacomer")
public class FacturaArticuloController {
	
	@Autowired
	private FacturaArticuloService service;

	@Autowired
	private FacturaUtils utils;
	
    @GetMapping("/articulos")
    public ResponseEntity<Object> buscarPoveedor(
        @RequestParam(required = false) Long codigoBarras,
        @RequestParam(required = false) String articuloDescripcion
    ) {
    	return utils.createSuccessResponse(service.buscarArticulo(codigoBarras, articuloDescripcion));
        
    }
}
