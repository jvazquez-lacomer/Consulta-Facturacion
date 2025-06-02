package com.lacomer.factura.service;

import java.util.List;

import com.lacomer.factura.dto.ProveedorDTO;

public interface FacturaProveedorService {

	public List<ProveedorDTO> buscarProveedor(Long idProveedor, String proDescripcion);
    
}
