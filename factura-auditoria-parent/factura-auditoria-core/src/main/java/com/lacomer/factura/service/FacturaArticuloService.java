package com.lacomer.factura.service;

import java.util.List;

import com.lacomer.factura.dto.ArticuloDTO;

public interface FacturaArticuloService {

	public List<ArticuloDTO> buscarArticulo(Long idArticulo, String articuloDescripcion);
    
}
