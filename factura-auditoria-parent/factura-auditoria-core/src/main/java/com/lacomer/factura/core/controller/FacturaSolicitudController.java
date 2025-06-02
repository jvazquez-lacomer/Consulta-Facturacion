package com.lacomer.factura.core.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lacomer.factura.dto.FacturasAprobacionRequestDTO;
import com.lacomer.factura.dto.FacturasAprobacionResponseDTO;
import com.lacomer.factura.dto.SolicitudFacturaAprOrRechRequestDTO;
import com.lacomer.factura.dto.SolicitudFacturaRequestDTO;
import com.lacomer.factura.dto.SolicitudFacturasUsuarioRequestDTO;
import com.lacomer.factura.service.FacturaSolicitudService;
import com.lacomer.factura.smt.entity.SolicitudFacturasEntity;
import com.lacomer.factura.utils.FacturaUtils;

@RestController
@RequestMapping("/lacomer/solicitudes")
public class FacturaSolicitudController {

	@Autowired
	private FacturaSolicitudService service;
	
	@Autowired
	private FacturaUtils utils;

	@PostMapping("/aprobacion/get")
	public ResponseEntity<Object> consultarSolicitudesAprobacion(@RequestBody FacturasAprobacionRequestDTO request,
			@RequestParam() int page, 
	        @RequestParam() int size ) {

		if(page >0 ) {
	    	page = page-1;
	    }
		
		Page<FacturasAprobacionResponseDTO> solicitudes = service.consultarSolicitudesAprobar(request,PageRequest.of(page, size));
		Map<String, Object> response = new HashMap<>();
	    response.put("usuarios", solicitudes.getContent()); // Datos de la página actual
	    response.put("currentPage", solicitudes.getNumber()); // Página actual
	    response.put("totalItems", solicitudes.getTotalElements()); // Total de registros
	    response.put("totalPages", solicitudes.getTotalPages()); // Total de páginas
		
		return utils.createSuccessResponse(response);

	}
	
	@PostMapping("/usuario/get")
	public ResponseEntity<Object> consultarSolicitudesUsuario(@Valid @RequestBody SolicitudFacturasUsuarioRequestDTO request,
			@RequestParam() int page, 
	        @RequestParam() int size ) {

		if(page >0 ) {
	    	page = page-1;
	    }
		
		Page<SolicitudFacturasEntity> solicitudes = service.consultarSolicitudesUsuario(request,PageRequest.of(page, size));
		
		Map<String, Object> response = new HashMap<>();
	    response.put("usuarios", solicitudes.getContent()); // Datos de la página actual
	    response.put("currentPage", solicitudes.getNumber()); // Página actual
	    response.put("totalItems", solicitudes.getTotalElements()); // Total de registros
	    response.put("totalPages", solicitudes.getTotalPages()); // Total de páginas
		
		return utils.createSuccessResponse(response);

	}
	
	@PutMapping("/usuario")
	public ResponseEntity<Object> actualizaEstadoSolicitud(@Valid @RequestBody SolicitudFacturaAprOrRechRequestDTO request) {

		String solicitudes = service.actualizaEstadoSolicitud(request);
		
		return utils.createSuccessResponse(solicitudes);
	}
	
	@PostMapping("/crear")
    public ResponseEntity<Object> crearSolicitud(@RequestBody SolicitudFacturaRequestDTO request) {
        // Puedes validar aquí los campos si lo deseas
        String folio = service.crearSolicitudFactura(request);
        
        return utils.createSuccessResponse("Se genero el folio: " + folio);
    }

}
