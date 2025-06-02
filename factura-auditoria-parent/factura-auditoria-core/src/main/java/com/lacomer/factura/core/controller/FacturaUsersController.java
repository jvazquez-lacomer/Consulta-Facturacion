package com.lacomer.factura.core.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
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

import com.lacomer.factura.dto.UserActualizaPwdRequestDTO;
import com.lacomer.factura.dto.UserAltaOrBajaRequestDTO;
import com.lacomer.factura.dto.UserBusquedaRequestDTO;
import com.lacomer.factura.dto.UserRequestDTO;
import com.lacomer.factura.dto.UserResponseDTO;
import com.lacomer.factura.service.FacturaUserService;
import com.lacomer.factura.smt.entity.UsuarioEntity;
import com.lacomer.factura.utils.FacturaUtils;

@RestController
@RequestMapping("/lacomer")
public class FacturaUsersController {

	@Autowired
	private FacturaUtils utils;

	@Autowired
	private FacturaUserService service;
	
	@PostMapping("/user")
    public ResponseEntity<Object> crearUsuario(@Valid @RequestBody UserRequestDTO user, HttpServletResponse response) {
		
		UserResponseDTO usuarioRespuesta = service.crearUsuario(user);
		
		return utils.createSuccessResponse(usuarioRespuesta);
	}
	
	@PutMapping("/user")
    public ResponseEntity<Object> altaOrBajaUsuario(@Valid @RequestBody UserAltaOrBajaRequestDTO user, HttpServletResponse response) {
		
		UserResponseDTO usuarioRespuesta = service.altaOrBajaUsuario(user);
		
		return utils.createSuccessResponse(usuarioRespuesta);
	}
	
	@PostMapping("/user/get")
	public ResponseEntity<Object> consultaUsuarios(
	        @Valid @RequestBody UserBusquedaRequestDTO user,
	        @RequestParam(defaultValue = "0") int page, // Página actual (por defecto 0)
	        @RequestParam(defaultValue = "10") int size // Tamaño de la página (por defecto 10)
	) {
	    
	    if(page >0 ) {
	    	page = page-1;
	    }
	    // Llama al servicio con los parámetros de paginación
	    Page<UsuarioEntity> usuarioRespuesta = service.consultaUsuarios(user, PageRequest.of(page, size));
	    // Construye la respuesta con la información de paginación
	    Map<String, Object> response = new HashMap<>();
	    response.put("usuarios", usuarioRespuesta.getContent()); // Datos de la página actual
	    response.put("currentPage", usuarioRespuesta.getNumber()); // Página actual
	    response.put("totalItems", usuarioRespuesta.getTotalElements()); // Total de registros
	    response.put("totalPages", usuarioRespuesta.getTotalPages()); // Total de páginas

	    return utils.createSuccessResponse(response);
	    
	}
	
	@PutMapping("/user/password")
    public ResponseEntity<Object> actualizaPWD(@Valid @RequestBody UserActualizaPwdRequestDTO request) {
		
		String mensaje = service.actualizaPWD(request);
		
		return utils.createSuccessResponse(mensaje);
	}

}
