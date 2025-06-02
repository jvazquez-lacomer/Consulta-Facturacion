package com.lacomer.factura.service;

import com.lacomer.factura.dto.LoginRequestDTO;
import com.lacomer.factura.dto.LoginResponseDTO;

public interface FacturaLoginService {

	public LoginResponseDTO consultaUsuario(LoginRequestDTO usuario);
    
}
