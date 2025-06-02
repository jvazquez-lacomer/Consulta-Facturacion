package com.lacomer.factura.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.lacomer.factura.dto.UserActualizaPwdRequestDTO;
import com.lacomer.factura.dto.UserAltaOrBajaRequestDTO;
import com.lacomer.factura.dto.UserBusquedaRequestDTO;
import com.lacomer.factura.dto.UserRequestDTO;
import com.lacomer.factura.dto.UserResponseDTO;
import com.lacomer.factura.smt.entity.UsuarioEntity;

public interface FacturaUserService {
	

	public UserResponseDTO crearUsuario(UserRequestDTO usuario);

	public UserResponseDTO altaOrBajaUsuario(UserAltaOrBajaRequestDTO usuario);

	public Page<UsuarioEntity> consultaUsuarios(UserBusquedaRequestDTO usuario, Pageable pageable);
	
	public String actualizaPWD(UserActualizaPwdRequestDTO usuario);
    
}
